package aquarium.core;

import aquarium.common.ConstantMessages;
import aquarium.common.ExceptionMessages;
import aquarium.entities.aquariums.Aquarium;
import aquarium.entities.aquariums.BaseAquarium;
import aquarium.entities.aquariums.FreshwaterAquarium;
import aquarium.entities.aquariums.SaltwaterAquarium;
import aquarium.entities.decorations.Decoration;
import aquarium.entities.decorations.Ornament;
import aquarium.entities.decorations.Plant;
import aquarium.entities.fish.Fish;
import aquarium.entities.fish.FreshwaterFish;
import aquarium.entities.fish.SaltwaterFish;
import aquarium.repositories.DecorationRepository;

import java.util.LinkedHashMap;
import java.util.Map;

public class ControllerImpl implements Controller{
    private DecorationRepository decorations;
    private Map<String, Aquarium> aquariums;

    public ControllerImpl() {
        this.decorations = new DecorationRepository();
        this.aquariums = new LinkedHashMap<>();
    }

    @Override
    public String addAquarium(String aquariumType, String aquariumName) {
        Aquarium aquarium;
        switch (aquariumName) {
            case "FreshwaterAquarium":
                aquarium = new FreshwaterAquarium(aquariumName);
                break;
            case "SaltwaterAquarium":
                aquarium = new SaltwaterAquarium(aquariumName);
                break;
            default:
                throw new NullPointerException(ExceptionMessages.INVALID_AQUARIUM_TYPE);
        }
        aquariums.put(aquariumName, aquarium);
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_AQUARIUM_TYPE, aquariumType);
    }

    @Override
    public String addDecoration(String type) {
        Decoration decoration;
        switch (type) {
            case "Plant":
                decoration = new Plant();
                break;
            case "Ornament":
                decoration = new Ornament();
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.INVALID_DECORATION_TYPE);
        }
        decorations.add(decoration);
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_DECORATION_TYPE, type);
    }

    @Override
    public String insertDecoration(String aquariumName, String decorationType) {
        if (decorations.findByType(decorationType) == null) {
            throw new IllegalArgumentException(
                    String.format(ExceptionMessages.NO_DECORATION_FOUND, decorationType));
        }
        Decoration decorationToAdd = decorations.findByType(decorationType);
        aquariums.get(aquariumName).addDecoration(decorationToAdd);
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_DECORATION_IN_AQUARIUM,
                decorationType, aquariumName);
    }

    @Override
    public String addFish(String aquariumName, String fishType, String fishName, String fishSpecies, double price) {

        Fish fish;
        switch (fishType) {
            case "SaltwaterFish":
                fish = new SaltwaterFish(fishName, fishSpecies, price);
                break;
            case "FreshwaterFish":
                fish = new FreshwaterFish(fishName, fishSpecies, price);
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.INVALID_FISH_TYPE);
        }

        String massage = null;
        Aquarium currentAquarium = aquariums.get(aquariumName);
        boolean capacityIsEnough = false;
        if (currentAquarium.getClass().getSimpleName().equals("SaltwaterAquarium") &&
                currentAquarium.getFish().size() >= 25) {
            massage = ConstantMessages.NOT_ENOUGH_CAPACITY;
        } else if (currentAquarium.getClass().getSimpleName().equals("FreshwaterAquarium") &&
                currentAquarium.getFish().size() >= 50) {
            massage = ConstantMessages.NOT_ENOUGH_CAPACITY;
        } else if (currentAquarium.getClass().getSimpleName().equals("SaltwaterAquarium")
        && !fishType.equals("SweetwaterFish")) {
            massage = ConstantMessages.WATER_NOT_SUITABLE;
        } else if (currentAquarium.getClass().getSimpleName().equals("FreshwaterAquarium")
                && fishType.equals("SaltwaterFish")) {
            massage = ConstantMessages.WATER_NOT_SUITABLE;
        } else {
            massage = String.format(ConstantMessages.SUCCESSFULLY_ADDED_FISH_IN_AQUARIUM,
                    fishType, aquariumName);
            aquariums.get(aquariumName).addFish(fish);
        }

        return massage;

    }

    @Override
    public String feedFish(String aquariumName) {
        return null;
    }

    @Override
    public String calculateValue(String aquariumName) {
        return null;
    }

    @Override
    public String report() {
        return null;
    }
}
