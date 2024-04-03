package com.example.football.service.impl;

import com.example.football.models.dto.TeamDTO;
import com.example.football.models.entity.Team;
import com.example.football.repository.TeamRepository;
import com.example.football.repository.TownRepository;
import com.example.football.service.TeamService;
import com.example.football.util.ValidationUtilsImpl;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

//ToDo - Implement all methods
@Service
public class TeamServiceImpl implements TeamService {

    private static String TEAM_FILE_PATH = "src\\main\\resources\\files\\json\\teams.json";
    private final TeamRepository teamRepository;
    private final TownRepository townRepository;
    private final Gson gson;
    private final ModelMapper modelMapper;
    private final ValidationUtilsImpl validationUtils;

    public TeamServiceImpl(TeamRepository teamRepository,
                           TownRepository townRepository,
                           Gson gson,
                           ModelMapper modelMapper,
                           ValidationUtilsImpl validationUtils) {
        this.teamRepository = teamRepository;
        this.townRepository = townRepository;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.validationUtils = validationUtils;
    }

    @Override
    public boolean areImported() {
        return this.teamRepository.count() > 0;
    }

    @Override
    public String readTeamsFileContent() throws IOException {
        return Files.readString(Path.of(TEAM_FILE_PATH));
    }

    @Override
    public String importTeams() throws IOException {
        StringBuilder sb = new StringBuilder();

        List<TeamDTO> teams = Arrays.stream(gson.fromJson(readTeamsFileContent(), TeamDTO[].class))
                .toList();

        for (TeamDTO t : teams) {
            Optional<Team> exist = this.teamRepository.findByName(t.getName());

            if (exist.isPresent() || !validationUtils.isValid(t)) {
                sb.append("Invalid Team");
                sb.append(System.lineSeparator());

                continue;
            }

            Team teamToSave = modelMapper.map(t, Team.class);
            teamToSave.setTown(this.townRepository.findByName(t.getTownName()).get());
            this.teamRepository.save(teamToSave);
            sb.append(String.format("Successfully imported Team %s - %d%n",
                    teamToSave.getName(), teamToSave.getFanBase()));
        }

        return sb.toString().trim();
    }
}
