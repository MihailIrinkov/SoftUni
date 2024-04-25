package softuni.exam.service;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.domain.dto.PlayerDTO;
import softuni.exam.domain.entities.Picture;
import softuni.exam.domain.entities.Player;
import softuni.exam.domain.entities.Team;
import softuni.exam.repository.PictureRepository;
import softuni.exam.repository.PlayerRepository;
import softuni.exam.repository.TeamRepository;
import softuni.exam.util.ValidatorUtilImpl;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PlayerServiceImpl implements PlayerService {

    private static String PLAYER_FILE_PATH = "src/main/resources/files/json/players.json";
    private final PlayerRepository playerRepository;
    private final TeamRepository teamRepository;
    private final PictureRepository pictureRepository;
    private final Gson gson;
    private final ModelMapper modelMapper;
    private final ValidatorUtilImpl validatorUtil;

    public PlayerServiceImpl(PlayerRepository playerRepository,
                             TeamRepository teamRepository,
                             PictureRepository pictureRepository,
                             Gson gson,
                             ModelMapper modelMapper,
                             ValidatorUtilImpl validatorUtil) {
        this.playerRepository = playerRepository;
        this.teamRepository = teamRepository;
        this.pictureRepository = pictureRepository;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.validatorUtil = validatorUtil;
    }

    @Override
    public boolean areImported() {
        return this.playerRepository.count() > 0;
    }

    @Override
    public String readPlayersJsonFile() throws IOException {
        return Files.readString(Path.of(PLAYER_FILE_PATH));
    }

    @Override
    public String importPlayers() throws IOException {
        StringBuilder sb = new StringBuilder();

        List<PlayerDTO> players = Arrays.stream(gson.fromJson(readPlayersJsonFile(), PlayerDTO[].class))
                .collect(Collectors.toList());

        for (PlayerDTO p : players) {
            Optional<Team> teamExists = this.teamRepository.findByName(p.getTeam().getName());
            Optional<Picture> pictureExists = this.pictureRepository.findByUrl(p.getPicture().getUrl());

            if (teamExists.isEmpty() || pictureExists.isEmpty() || !validatorUtil.isValid(p)) {
                sb.append("Invalid player");
                sb.append(System.lineSeparator());

                continue;
            }

            Player playerToSave = modelMapper.map(p, Player.class);
            playerToSave.setTeam(teamExists.get());
            playerToSave.setPicture(pictureExists.get());
            this.playerRepository.save(playerToSave);
            sb.append(String.format("Successfully imported player: %s %s%n",
                    playerToSave.getFirstName(), playerToSave.getLastName()));
        }

        return sb.toString().trim();
    }

    @Override
    public String exportPlayersWhereSalaryBiggerThan() {
        StringBuilder sb = new StringBuilder();

        List<Player> playersBySalary = this.playerRepository
                .findAllBySalaryGreaterThanOrderBySalaryDesc(BigDecimal.valueOf(100000));

        for (Player p : playersBySalary) {
            sb.append(String.format("Player name: %s %s \n" +
                            "Number: %d\n" +
                            "Salary: %s\n" +
                            "Team: %s\n",
                    p.getFirstName(),
                    p.getLastName(),
                    p.getNumber(),
                    p.getSalary(),
                    p.getTeam().getName()));
        }

        return sb.toString().trim();
    }

    @Override
    public String exportPlayersInATeam() {
        StringBuilder sb = new StringBuilder();

        List<Player> playersByClub =
                this.playerRepository.findAllByTeam_NameOrderById("North Hub");

        for (Player p : playersByClub) {
            sb.append(String.format("Team: %s\n" +
                            "Player name: %s %s - %s\n" +
                            "Number: %d\n",
                    p.getTeam().getName(),
                    p.getFirstName(),
                    p.getLastName(),
                    p.getPosition(),
                    p.getNumber()));
        }


        return sb.toString().trim();
    }
}
