package glacialExpedition.models.mission;

import glacialExpedition.models.explorers.Explorer;
import glacialExpedition.models.states.State;
import glacialExpedition.models.states.StateImpl;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class MissionImpl implements Mission{
    @Override
    public void explore(State state, Collection<Explorer> explorers) {
        //ArrayDeque<Explorer> explorersQu = new ArrayDeque<>(explorers);
        Collection<String> exhibits = state.getExhibits();

        //Explorer currentExplorer = explorersQu.poll();
//        int index = 0;

//        while (!explorersQu.isEmpty() && !exhibits.isEmpty()) {
//            if (currentExplorer.getEnergy() > 0) {
//                currentExplorer.search();
//                currentExplorer.getSuitcase().getExhibits().add(currentExhibit);
//                exhibits.remove(index);
//                index++;
//            } else {
//                currentExplorer = explorersQu.poll();
//            }
//        }

        for (Explorer currentExplorer : explorers) {
            while (currentExplorer.canSearch() && exhibits.iterator().hasNext()) {
                currentExplorer.search();
                String currentExhibit = exhibits.iterator().next();
                currentExplorer.getSuitcase().getExhibits().add(currentExhibit);
                exhibits.remove(currentExhibit);
            }
        }

    }
}
