package com.example.football.service.impl;

import com.example.football.models.dto.StatDTO;
import com.example.football.models.dto.StatRootDTO;
import com.example.football.models.entity.Stat;
import com.example.football.repository.StatRepository;
import com.example.football.service.StatService;
import com.example.football.util.ValidationUtilsImpl;
import com.example.football.util.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

//ToDo - Implement all methods
@Service
public class StatServiceImpl implements StatService {

    private static String STAT_FILE_PATH = "src\\main\\resources\\files\\xml\\stats.xml";
    private final StatRepository statRepository;
    private final XmlParser xmlParser;
    private final ModelMapper modelMapper;
    private final ValidationUtilsImpl validationUtils;

    public StatServiceImpl(StatRepository statRepository,
                           XmlParser xmlParser,
                           ModelMapper modelMapper,
                           ValidationUtilsImpl validationUtils) {
        this.statRepository = statRepository;
        this.xmlParser = xmlParser;
        this.modelMapper = modelMapper;
        this.validationUtils = validationUtils;
    }

    @Override
    public boolean areImported() {
        return this.statRepository.count() > 0;
    }

    @Override
    public String readStatsFileContent() throws IOException {
        return Files.readString(Path.of(STAT_FILE_PATH));
    }

    @Override
    public String importStats() throws JAXBException, FileNotFoundException {
        StringBuilder sb = new StringBuilder();

        List<StatDTO> stats = xmlParser.fromFile(Path.of(STAT_FILE_PATH).toFile(), StatRootDTO.class)
                .getStats().stream().toList();

        for (StatDTO s : stats) {
//            Optional<Stat> existPassing = this.statRepository.findByPassing(s.getPassing());
//            Optional<Stat> existShooting = this.statRepository.findByShooting()
            Optional<Stat> exist = this.statRepository.findByPassingOrShootingOrEndurance(
                    s.getPassing(), s.getShooting(), s.getEndurance());

            if (exist.isPresent() || !validationUtils.isValid(s)) {
                sb.append("Invalid Stat");
                sb.append(System.lineSeparator());

                continue;
            }

            Stat statToSave = modelMapper.map(s, Stat.class);
            this.statRepository.save(statToSave);
            sb.append(String.format("Successfully imported Stat %.2f - %.2f - %.2f%n",
                    statToSave.getPassing(), statToSave.getShooting(), statToSave.getEndurance()));
        }

        return sb.toString().trim();

    }
}
