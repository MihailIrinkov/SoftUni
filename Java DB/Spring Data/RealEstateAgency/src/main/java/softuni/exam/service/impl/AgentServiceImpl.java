package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.AgentDTO;
import softuni.exam.models.entity.Agent;
import softuni.exam.repository.AgentRepository;
import softuni.exam.repository.TownRepository;
import softuni.exam.service.AgentService;
import softuni.exam.util.ValidationUtilsImpl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class AgentServiceImpl implements AgentService {

    private static String AGENT_FILE_PATH = "src/main/resources/files/json/agents.json";
    private final AgentRepository agentRepository;
    private final TownRepository townRepository;
    private final Gson gson;
    private final ModelMapper modelMapper;
    private final ValidationUtilsImpl validationUtils;

    public AgentServiceImpl(AgentRepository agentRepository,
                            TownRepository townRepository,
                            Gson gson,
                            ModelMapper modelMapper,
                            ValidationUtilsImpl validationUtils) {
        this.agentRepository = agentRepository;
        this.townRepository = townRepository;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.validationUtils = validationUtils;
    }

    @Override
    public boolean areImported() {
        return this.agentRepository.count() > 0;
    }

    @Override
    public String readAgentsFromFile() throws IOException {
        return Files.readString(Path.of(AGENT_FILE_PATH));
    }

    @Override
    public String importAgents() throws IOException {
        StringBuilder sb = new StringBuilder();

        List<AgentDTO> agents = Arrays.stream(gson.fromJson(readAgentsFromFile(), AgentDTO[].class))
                .toList();

        for (AgentDTO a : agents) {
            Optional<Agent> existByFirstName = this.agentRepository.findByFirstName(a.getFirstName());
            Optional<Agent> existByEmail = this.agentRepository.findByEmail(a.getEmail());

            if (existByFirstName.isPresent() || existByEmail.isPresent() || !validationUtils.isValid(a)) {
                sb.append("Invalid agent");
                sb.append(System.lineSeparator());

                continue;
            }

            Agent agentToSave = modelMapper.map(a, Agent.class);
            agentToSave.setTown(this.townRepository.findByTownName(a.getTown()).get());
            this.agentRepository.save(agentToSave);
            sb.append(String.format("Successfully imported agent - %s %s%n",
                    agentToSave.getFirstName(), agentToSave.getLastName()));
        }

        return sb.toString().trim();
    }
}
