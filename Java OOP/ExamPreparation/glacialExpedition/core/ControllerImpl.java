package glacialExpedition.core;

import glacialExpedition.common.ConstantMessages;
import glacialExpedition.common.ExceptionMessages;
import glacialExpedition.models.explorers.AnimalExplorer;
import glacialExpedition.models.explorers.Explorer;
import glacialExpedition.models.explorers.GlacierExplorer;
import glacialExpedition.models.explorers.NaturalExplorer;
import glacialExpedition.models.mission.MissionImpl;
import glacialExpedition.models.states.State;
import glacialExpedition.models.states.StateImpl;
import glacialExpedition.repositories.ExplorerRepository;
import glacialExpedition.repositories.StateRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ControllerImpl implements Controller {
    private ExplorerRepository explorerRepository;
    private StateRepository stateRepository;
    private int count;

    public ControllerImpl() {
        this.explorerRepository = new ExplorerRepository();
        this.stateRepository = new StateRepository();
    }

    @Override
    public String addExplorer(String type, String explorerName) {
        Explorer explorer;
        switch (type) {
            case "AnimalExplorer":
                explorer = new AnimalExplorer(explorerName);
                break;
            case "GlacierExplorer":
                explorer = new GlacierExplorer(explorerName);
                break;
            case "NaturalExplorer":
                explorer = new NaturalExplorer(explorerName);
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.EXPLORER_INVALID_TYPE);
        }
        explorerRepository.add(explorer);
        return String.format(ConstantMessages.EXPLORER_ADDED, type, explorerName);
    }

    @Override
    public String addState(String stateName, String... exhibits) {
        State state = new StateImpl(stateName);
        for (String s : exhibits) {
            state.getExhibits().add(s);
        }
        stateRepository.add(state);
        return String.format(ConstantMessages.STATE_ADDED, stateName);
    }

    @Override
    public String retireExplorer(String explorerName) {
        Explorer explorer = explorerRepository.byName(explorerName);
        if (explorer == null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages
                    .EXPLORER_DOES_NOT_EXIST, explorerName));
        }
        explorerRepository.remove(explorer);

        return String.format(ConstantMessages.EXPLORER_RETIRED, explorer.getName());
    }

    @Override
    public String exploreState(String stateName) {
        List<Explorer> explorerList = explorerRepository.getCollection().stream()
                .filter(e -> e.getEnergy() > 50).collect(Collectors.toList());
        if (explorerList.size() <= 0) {
            throw new IllegalArgumentException(ExceptionMessages
                    .STATE_EXPLORERS_DOES_NOT_EXISTS);
        }

        MissionImpl mission = new MissionImpl();
        State stateToExplore = stateRepository.byName(stateName);
        count++;
        mission.explore(stateToExplore, explorerList);

        long retiredExplorers = explorerList
                .stream().filter(e->e.getEnergy() == 0).count();
        return String.format(ConstantMessages.STATE_EXPLORER,
                stateName, retiredExplorers);
    }

    @Override
    public String finalResult() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(ConstantMessages.FINAL_STATE_EXPLORED, count));
        sb.append(System.lineSeparator());
        sb.append(ConstantMessages.FINAL_EXPLORER_INFO);
        sb.append(System.lineSeparator());
        List<Explorer> explorerList = new ArrayList<>(explorerRepository.getCollection());
        for (Explorer e : explorerList) {
            sb.append(String.format(ConstantMessages.FINAL_EXPLORER_NAME,
                    e.getName()));
            sb.append(System.lineSeparator());
            sb.append(String.format(ConstantMessages.FINAL_EXPLORER_ENERGY,
                    e.getEnergy()));
            sb.append(System.lineSeparator());
            if (e.getSuitcase().getExhibits().isEmpty()) {
                sb.append(String.format(ConstantMessages
                        .FINAL_EXPLORER_SUITCASE_EXHIBITS, "None"));
                sb.append(System.lineSeparator());
            } else {
                String allExhibits = String.join(ConstantMessages
                                .FINAL_EXPLORER_SUITCASE_EXHIBITS_DELIMITER,
                        e.getSuitcase().getExhibits());
                sb.append(String.format(ConstantMessages.FINAL_EXPLORER_SUITCASE_EXHIBITS,
                        allExhibits));
                sb.append(System.lineSeparator());
            }
        }
        return sb.toString().trim();
    }
}
