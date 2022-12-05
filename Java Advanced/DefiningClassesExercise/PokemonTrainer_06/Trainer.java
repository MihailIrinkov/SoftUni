package PokemonTrainer_06;

import java.util.ArrayList;
import java.util.List;

public class Trainer {
    private String name;
    private int numberOfBadges = 0;
    private List<Pokemon> pokemons;

    public Trainer(String name, int numberOfBadges, List<Pokemon> pokemons) {
        this.name = name;
        this.numberOfBadges = numberOfBadges;
        this.pokemons = new ArrayList<>();
        this.pokemons.addAll(pokemons);
    }

    public Trainer(String name, List<Pokemon> pokemons) {
        this.name = name;
        this.pokemons = new ArrayList<>();
        this.pokemons.addAll(pokemons);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setNumberOfBadges(int numberOfBadges) {
        this.numberOfBadges = numberOfBadges;
    }

    public int getNumberOfBadges() {
        return this.numberOfBadges;
    }

    public void setPokemons(List<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }

    public List<Pokemon> getPokemons() {
        return this.pokemons;
    }
}

