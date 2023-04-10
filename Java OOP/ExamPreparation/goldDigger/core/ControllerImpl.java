package goldDigger.core;

import goldDigger.common.ConstantMessages;
import goldDigger.common.ExceptionMessages;
import goldDigger.models.disocverer.Anthropologist;
import goldDigger.models.disocverer.Archaeologist;
import goldDigger.models.disocverer.Discoverer;
import goldDigger.models.disocverer.Geologist;
import goldDigger.models.operation.OperationImpl;
import goldDigger.models.spot.Spot;
import goldDigger.models.spot.SpotImpl;
import goldDigger.repositories.DiscovererRepository;
import goldDigger.repositories.SpotRepository;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.stream.Collectors;

public class ControllerImpl implements Controller {
    private DiscovererRepository discovererRepository;
    private SpotRepository spotRepository;
    private int countInspectedSpots = 0;

    public ControllerImpl() {
        this.discovererRepository = new DiscovererRepository();
        this.spotRepository = new SpotRepository();
    }

    @Override
    public String addDiscoverer(String kind, String discovererName) {
        Discoverer discoverer;
        switch (kind) {
            case "Anthropologist":
                discoverer = new Anthropologist(discovererName);
                break;
            case "Archaeologist":
                discoverer = new Archaeologist(discovererName);
                break;
            case "Geologist":
                discoverer = new Geologist(discovererName);
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages
                        .DISCOVERER_INVALID_KIND);
        }
        discovererRepository.add(discoverer);

        return String.format(ConstantMessages.DISCOVERER_ADDED, kind, discovererName);
    }

    @Override
    public String addSpot(String spotName, String... exhibits) {
        Spot spot = new SpotImpl(spotName);
        for (String s : exhibits) {
            spot.getExhibits().add(s);
        }
        spotRepository.add(spot);
        return String.format(ConstantMessages.SPOT_ADDED, spotName);
    }

    @Override
    public String excludeDiscoverer(String discovererName) {
        Discoverer discovererToExclude = discovererRepository.byName(discovererName);

        if (discovererToExclude == null) {
            String errorMassage = String.format(ExceptionMessages
                    .DISCOVERER_DOES_NOT_EXIST, discovererName);
            throw new IllegalArgumentException(errorMassage);
        }
        discovererRepository.remove(discovererRepository.byName(discovererName));
        return String.format(ConstantMessages.DISCOVERER_EXCLUDE
                , discovererName);
    }

    @Override
    public String inspectSpot(String spotName) {

        List<Discoverer> discovererEnergyAbove45 = discovererRepository
                .getCollection().stream()
                .filter(discoverer -> discoverer.getEnergy() > 45)
                .collect(Collectors.toList());
        if (discovererEnergyAbove45.isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessages
                    .SPOT_DISCOVERERS_DOES_NOT_EXISTS);
        }

        Spot currentSpot = spotRepository.byName(spotName);
        OperationImpl operation = new OperationImpl();
        operation.startOperation(currentSpot, discovererEnergyAbove45);

        long excludedDiscovers = discovererEnergyAbove45.stream()
                .filter(d -> d.getEnergy() < 45).count();
        countInspectedSpots++;
        return String.format(ConstantMessages.INSPECT_SPOT,
                spotName, excludedDiscovers);
    }

    @Override
    public String getStatistics() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format(ConstantMessages.FINAL_SPOT_INSPECT
                , countInspectedSpots));
        sb.append(System.lineSeparator());
        sb.append(ConstantMessages.FINAL_DISCOVERER_INFO);
        sb.append(System.lineSeparator());
        for (Discoverer d : discovererRepository.getCollection()) {

            sb.append(String.format(ConstantMessages.FINAL_DISCOVERER_NAME,
                    d.getName()));
            sb.append(System.lineSeparator());
            sb.append(String.format(ConstantMessages.FINAL_DISCOVERER_ENERGY,
                    d.getEnergy()));
            sb.append(System.lineSeparator());
            if (d.getMuseum().getExhibits().isEmpty()) {
                sb.append("Museum exhibits: ");
                sb.append("None");
                sb.append(System.lineSeparator());
            } else {
                sb.append(String.format(ConstantMessages.FINAL_DISCOVERER_MUSEUM_EXHIBITS,
                        d.getMuseum().getExhibits()
                                .stream().collect(Collectors.joining(ConstantMessages
                                        .FINAL_DISCOVERER_MUSEUM_EXHIBITS_DELIMITER))).trim());
                sb.append(System.lineSeparator());
            }
        }

        return sb.toString().trim();
    }
}
