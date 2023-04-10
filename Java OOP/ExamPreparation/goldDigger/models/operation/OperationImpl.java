package goldDigger.models.operation;

import goldDigger.models.disocverer.Discoverer;
import goldDigger.models.spot.Spot;

import java.util.Collection;

public class OperationImpl implements Operation{
    @Override
    public void startOperation(Spot spot, Collection<Discoverer> discoverers) {
        Collection<String> currentExhibits = spot.getExhibits();

        for (Discoverer discoverer: discoverers) {

//            while (discoverer.getEnergy() > 0 && !currentExhibits.isEmpty()) {
//                for (String s : currentExhibits) {
//
//                    discoverer.getMuseum().getExhibits().add(s);
//                    discoverer.dig();
//                    currentExhibits.remove(s);
//                }
//            }

            while (discoverer.canDig() && currentExhibits.iterator().hasNext()) {
                discoverer.dig();
                String currentExhibit = currentExhibits.iterator().next();
                discoverer.getMuseum().getExhibits().add(currentExhibit);
                currentExhibits.remove(currentExhibit);
            }

        }
    }
}
