package com.example.football.service.impl;

import com.example.football.models.dto.PlayerDTO;
import com.example.football.models.dto.PlayerRootDTO;
import com.example.football.models.entity.Player;
import com.example.football.repository.PlayerRepository;
import com.example.football.repository.StatRepository;
import com.example.football.repository.TeamRepository;
import com.example.football.repository.TownRepository;
import com.example.football.service.PlayerService;
import com.example.football.util.ValidationUtilsImpl;
import com.example.football.util.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

//ToDo - Implement all methods

@Service
public class PlayerServiceImpl implements PlayerService {

    private static String PLAYER_FILE_PATH = "src\\main\\resources\\files\\xml\\players.xml";
    private final PlayerRepository playerRepository;
    private final TownRepository townRepository;
    private final StatRepository statRepository;
    private final TeamRepository teamRepository;
    private final XmlParser xmlParser;
    private final ModelMapper modelMapper;
    private final ValidationUtilsImpl validationUtils;

    public PlayerServiceImpl(PlayerRepository playerRepository,
                             TownRepository townRepository,
                             StatRepository statRepository,
                             TeamRepository teamRepository,
                             XmlParser xmlParser,
                             ModelMapper modelMapper,
                             ValidationUtilsImpl validationUtils) {
        this.playerRepository = playerRepository;
        this.townRepository = townRepository;
        this.statRepository = statRepository;
        this.teamRepository = teamRepository;
        this.xmlParser = xmlParser;
        this.modelMapper = modelMapper;
        this.validationUtils = validationUtils;
    }

    @Override
    public boolean areImported() {
        return this.playerRepository.count() > 0;
    }

    @Override
    public String readPlayersFileContent() throws IOException {
        return Files.readString(Path.of(PLAYER_FILE_PATH));
    }

    @Override
    public String importPlayers() throws JAXBException, FileNotFoundException {
        StringBuilder sb = new StringBuilder();

        List<PlayerDTO> players = xmlParser.fromFile(Path.of(PLAYER_FILE_PATH).toFile(), PlayerRootDTO.class)
                .getPlayers().stream().toList();

        for (PlayerDTO p : players) {
            Optional<Player> exist = this.playerRepository.findByEmail(p.getEmail());
            if (exist.isPresent() || !validationUtils.isValid(p)) {
                sb.append("Invalid Player");
                sb.append(System.lineSeparator());

                continue;
            }

            Player playerToSave = modelMapper.map(p, Player.class);
            playerToSave.setTown(this.townRepository.findByName(p.getTown().getName()).get());
            playerToSave.setStat(this.statRepository.getById(p.getStat().getId()));
            playerToSave.setTeam(this.teamRepository.findByName(p.getTeam().getName()).get());

            this.playerRepository.save(playerToSave);
            sb.append(String.format("Successfully imported Player %s %s - %s%n",
                    playerToSave.getFirstName(),
                    playerToSave.getLastName(),
                    playerToSave.getPosition().toString()));
        }

        return sb.toString().trim();
    }

    @Override
    public String exportBestPlayers() {
        StringBuilder sb = new StringBuilder();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date1 = LocalDate.parse("01/01/1995", formatter);
        LocalDate date2 = LocalDate.parse("01/01/2003", formatter);

        List<Player> selectedPlayers = this.playerRepository
                .findByBirthDateBetweenOrderByStat_ShootingDescStat_PassingDescStat_EnduranceDescLastName(date1, date2);

        for (Player p : selectedPlayers) {
            sb.append(String.format("Player - %s %s\n" +
                            "\tPosition - %s\n" +
                            "\tTeam - %s\n" +
                            "\tStadium - %s\n",
                    p.getFirstName(),
                    p.getLastName(),
                    p.getPosition().toString(),
                    p.getTeam().getName(),
                    p.getTeam().getStadiumName()));
        }

        return sb.toString().trim();
    }
}
