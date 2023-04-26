package aquarium.entities.aquariums;

import aquarium.common.ConstantMessages;
import aquarium.common.ExceptionMessages;
import aquarium.entities.decorations.Decoration;
import aquarium.entities.fish.Fish;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public abstract class BaseAquarium implements Aquarium{
    private String name;
    private int capacity;
    private Map<String, Decoration> decorations;
    private Map<String, Fish> fish;

    public BaseAquarium(String name, int capacity) {
        this.setName(name);
        this.capacity = capacity;
        this.decorations = new LinkedHashMap<>();
        this.fish = new LinkedHashMap<>();
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(ExceptionMessages.AQUARIUM_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public int calculateComfort() {
        int sum = decorations.values().stream().mapToInt(Decoration::getComfort).sum();
        return sum;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void addFish(Fish fishToAdd) {
        if (capacity == this.fish.size()) {
            throw new IllegalArgumentException(ConstantMessages.NOT_ENOUGH_CAPACITY);
        }
        this.fish.put(fishToAdd.getName(), fishToAdd);
    }

    @Override
    public void removeFish(Fish fishToRemove) {
        fish.remove(fishToRemove.getName());
    }

    @Override
    public void addDecoration(Decoration decoration) {
        decorations.put(decoration.getClass().getSimpleName(), decoration);
    }

    @Override
    public void feed() {
        for (Fish f : fish.values()) {
            f.eat();
        }
    }

    @Override
    public String getInfo() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("%s (%s):", getName(), getClass().getSimpleName()));
        sb.append(System.lineSeparator());
        sb.append("Fish: ");
        if (fish.size() == 0) {
            sb.append("none");
            sb.append(System.lineSeparator());
        } else {
          String printFish = fish.values().stream().map(Fish::getName)
                          .collect(Collectors.joining(" ")).trim();
          sb.append(printFish);
            sb.append(System.lineSeparator());
        }
        sb.append(String.format("Decorations: %d", decorations.size()));
        sb.append(System.lineSeparator());
        sb.append(String.format("Comfort: %d", calculateComfort()));

        return sb.toString().trim();
    }

    @Override
    public Collection<Fish> getFish() {
        return fish.values();
    }

    @Override
    public Collection<Decoration> getDecorations() {
        return decorations.values();
    }
}
