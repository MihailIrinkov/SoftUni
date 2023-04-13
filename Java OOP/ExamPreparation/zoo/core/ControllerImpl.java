package zoo.core;

import zoo.common.ConstantMessages;
import zoo.common.ExceptionMessages;
import zoo.entities.animals.Animal;
import zoo.entities.animals.AquaticAnimal;
import zoo.entities.animals.TerrestrialAnimal;
import zoo.entities.areas.Area;
import zoo.entities.areas.LandArea;
import zoo.entities.areas.WaterArea;
import zoo.entities.foods.Food;
import zoo.entities.foods.Meat;
import zoo.entities.foods.Vegetable;
import zoo.repositories.FoodRepository;
import zoo.repositories.FoodRepositoryImpl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ControllerImpl implements Controller {
    private FoodRepository foodRepository;
    private Map<String, Area> areas;

    public ControllerImpl() {
        this.foodRepository = new FoodRepositoryImpl();
        this.areas = new LinkedHashMap<>();
    }


    @Override
    public String addArea(String areaType, String areaName) {
        Area area;
        switch (areaType) {
            case "WaterArea":
                area = new WaterArea(areaName);
                break;
            case "LandArea":
                area = new LandArea(areaName);
                break;
            default:
                throw new NullPointerException(ExceptionMessages.INVALID_AREA_TYPE);
        }
        areas.put(areaName, area);
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_AREA_TYPE, areaType);
    }

    @Override
    public String buyFood(String foodType) {
        Food food;
        switch (foodType) {
            case "Vegetable":
                food = new Vegetable();
                break;
            case "Meat":
                food = new Meat();
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.INVALID_FOOD_TYPE);
        }
        foodRepository.add(food);
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_FOOD_TYPE, foodType);
    }

    @Override
    public String foodForArea(String areaName, String foodType) {
        Food food = foodRepository.findByType(foodType);
        if (food == null) {
            throw new IllegalArgumentException(
                    String.format(ExceptionMessages.NO_FOOD_FOUND, foodType));
        }

        areas.get(areaName).addFood(food);
        foodRepository.remove(food);
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_FOOD_IN_AREA,
                foodType, areaName);
    }

    @Override
    public String addAnimal(String areaName, String animalType,
                            String animalName, String kind, double price) {
        Animal animal;
        switch (animalType) {
            case "AquaticAnimal":
                animal = new AquaticAnimal(animalName, kind, price);
                break;
            case "TerrestrialAnimal":
                animal = new TerrestrialAnimal(animalName, kind, price);
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.INVALID_ANIMAL_TYPE);
        }

        StringBuilder sb = new StringBuilder();
        switch (animalType) {
            case "AquaticAnimal":
                if (areas.size() >= 10) {
                    sb.append(String.format(ExceptionMessages.NOT_ENOUGH_CAPACITY));
                } else if (!areas.get(areaName).getClass().getSimpleName().equals("WaterArea")) {
                    sb.append(String.format(ConstantMessages.AREA_NOT_SUITABLE));
                } else {
                    areas.get(areaName).addAnimal(animal);
                    sb.append(String.format(ConstantMessages.SUCCESSFULLY_ADDED_ANIMAL_IN_AREA,
                            animalType, areaName));
                }
                break;
            case "TerrestrialAnimal":
                if (areas.size() >= 25) {
                    sb.append(String.format(ExceptionMessages.NOT_ENOUGH_CAPACITY));
                } else if (!areas.get(areaName).getClass().getSimpleName().equals("LandArea")) {
                    sb.append(String.format(ConstantMessages.AREA_NOT_SUITABLE));
                } else {
                    areas.get(areaName).addAnimal(animal);
                    sb.append(String.format(ConstantMessages.SUCCESSFULLY_ADDED_ANIMAL_IN_AREA,
                            animalType, areaName));
                }
                break;
        }

        return sb.toString();
    }



    @Override
    public String feedAnimal(String areaName) {
        List<Animal> animalsToFeed = new ArrayList<>(areas.get(areaName).getAnimals());

        for (Animal a : animalsToFeed) {
            a.eat();
        }
        return String.format(ConstantMessages.ANIMALS_FED, animalsToFeed.size());
    }

    @Override
    public String calculateKg(String areaName) {
        double animalsCalculateKg = areas.get(areaName).getAnimals()
                .stream().mapToDouble(Animal::getKg).sum();
        return String.format(ConstantMessages.KILOGRAMS_AREA, areaName, animalsCalculateKg);
    }

    @Override
    public String getStatistics() {
        List<Area> areaList = new ArrayList<>(areas.values());
        StringBuilder sb = new StringBuilder();

        for (Area a : areaList) {
            sb.append(a.getInfo());
            sb.append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
