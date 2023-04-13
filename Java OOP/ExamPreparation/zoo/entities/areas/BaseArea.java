package zoo.entities.areas;

import zoo.common.ExceptionMessages;
import zoo.entities.animals.Animal;
import zoo.entities.foods.Food;

import java.util.*;
import java.util.stream.Collectors;

public abstract class BaseArea implements Area {
    private String name;
    private int capacity;
    private List<Food> foods;
    private Map<String, Animal> animals;

    public BaseArea(String name, int capacity) {
        this.setName(name);
        this.capacity = capacity;
        this.foods = new ArrayList<>();
        this.animals = new LinkedHashMap<>();
    }


    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(ExceptionMessages.AREA_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setFoods(List<Food> foods) {
        this.foods = foods;
    }

    public void setAnimals(Map<String, Animal> animals) {
        this.animals = animals;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Collection<Animal> getAnimals() {
        return animals.values();
    }

    @Override
    public Collection<Food> getFoods() {
        return foods;
    }

    @Override
    public int sumCalories() {
        int sum = 0;
        for (Food f : foods) {
            sum = sum + f.getCalories();
        }
        return sum;
    }

    @Override
    public void addAnimal(Animal animal) {
        if (animals.size() == capacity) {
            throw new IllegalArgumentException(ExceptionMessages.NOT_ENOUGH_CAPACITY);
        } else {
            animals.put(animal.getName(), animal);
        }
    }

    @Override
    public void removeAnimal(Animal animal) {
        animals.remove(animal.getName());
    }

    @Override
    public void addFood(Food food) {
        foods.add(food);
    }

    @Override
    public void feed() {
        List<Animal> animalList = new ArrayList<>(animals.values());
        for (Animal a : animalList) {
            a.eat();
        }
    }

    @Override
    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append(getName() + " ");
        sb.append(String.format("(%s):",getClass().getSimpleName()));
        sb.append(System.lineSeparator());
        sb.append("Animals: ");
        if (animals.isEmpty()) {
            sb.append("none");
        } else {
            sb.append(animals.values().stream().map(Animal::getName)
                    .collect(Collectors.joining(" ")).trim());
        }
        sb.append(System.lineSeparator());
        sb.append("Foods: ");
        sb.append(foods.size());
        sb.append(System.lineSeparator());
        sb.append("Calories: ");
        sb.append(sumCalories());
        return sb.toString().trim();
    }
}
