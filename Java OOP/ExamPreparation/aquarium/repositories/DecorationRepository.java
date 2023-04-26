package aquarium.repositories;

import aquarium.entities.decorations.Decoration;

import java.util.*;

public class DecorationRepository implements Repository{
    private List<Decoration> decorations;

    public DecorationRepository() {
        this.decorations = new ArrayList<>();
    }

    @Override
    public void add(Decoration decoration) {
        decorations.add(decoration);
    }

    @Override
    public boolean remove(Decoration decoration) {
        return decorations.removeIf(d -> d.getComfort() == decoration.getComfort()
        && d.getPrice() == decoration.getPrice());
    }

    @Override
    public Decoration findByType(String type) {
        return decorations.stream().filter(d -> d.getClass().getSimpleName()
                .equals(type)).findFirst().orElse(null);
    }
}
