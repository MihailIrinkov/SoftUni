package softuni.exam.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.domain.dto.TeamDTO;
import softuni.exam.domain.dto.TeamRootDTO;
import softuni.exam.domain.entities.Picture;
import softuni.exam.domain.entities.Team;
import softuni.exam.repository.PictureRepository;
import softuni.exam.repository.TeamRepository;
import softuni.exam.util.ValidatorUtilImpl;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TeamServiceImpl implements TeamService {

    private static String TEAM_FILE_PATH = "src/main/resources/files/xml/teams.xml";
    private final TeamRepository teamRepository;
    private final PictureRepository pictureRepository;
    private final XmlParser xmlParser;
    private final ModelMapper modelMapper;
    private final ValidatorUtilImpl validatorUtil;

    public TeamServiceImpl(TeamRepository teamRepository,
                           PictureRepository pictureRepository,
                           XmlParser xmlParser,
                           ModelMapper modelMapper,
                           ValidatorUtilImpl validatorUtil) {
        this.teamRepository = teamRepository;
        this.pictureRepository = pictureRepository;
        this.xmlParser = xmlParser;
        this.modelMapper = modelMapper;
        this.validatorUtil = validatorUtil;
    }

    @Override
    public String importTeams() throws JAXBException, FileNotFoundException {
        StringBuilder sb = new StringBuilder();

        List<TeamDTO> teams = xmlParser.fromFile(Path.of(TEAM_FILE_PATH).toFile(), TeamRootDTO.class)
                .getTeams().stream().collect(Collectors.toList());

        for (TeamDTO t : teams) {
            Optional<Picture> exists = this.pictureRepository.findByUrl(t.getPicture().getUrl());
            if (exists.isEmpty() || !validatorUtil.isValid(t)) {
                sb.append("Invalid team");
                sb.append(System.lineSeparator());

                continue;
            }

            Team teamToSave = modelMapper.map(t, Team.class);
            teamToSave.setPicture(this.pictureRepository.findByUrl(t.getPicture().getUrl()).get());
            this.teamRepository.save(teamToSave);

            sb.append(String.format("Successfully imported - %s%n",
                    teamToSave.getName()));
        }

        return sb.toString().trim();
    }

    @Override
    public boolean areImported() {
        return this.teamRepository.count() > 0;
    }

    @Override
    public String readTeamsXmlFile() throws IOException {
        return Files.readString(Path.of(TEAM_FILE_PATH));
    }
}
