package Google_07;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private Company company;
    private List<Pokemon> pokemons;
    private List<Parents> parents;
    private List<Children> children;
    private Car car;

    public Person() {
        this.pokemons = new ArrayList<>();
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
    }

    public Person(String name, Company company, List<Pokemon> pokemon,
                  List<Parents> parents, List<Children> children, Car car) {
        this.company = company;
        this.pokemons = pokemon;
        this.parents = parents;
        this.children = children;
        this.car = car;
    }

    public void setCompany(Company company) {
        this.company = company;
    }


    public List<Pokemon> getPokemons() {
        return this.pokemons;
    }

    public List<Parents> getParents() {
        return this.parents;
    }

    public List<Children> getChildren() {
        return this.children;
    }

    public Car getCar() {
        return this.car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Company:" + "\n");
        if (company != null) {
            stringBuilder.append(company + "\n");
        }
        stringBuilder.append("Car:" + "\n");
        if (car != null) {
            stringBuilder.append(car + "\n");
        }
        stringBuilder.append("Pokemon:" + "\n");

            for (Pokemon pokemon : pokemons) {
                stringBuilder.append(pokemon + "\n");
            }

        stringBuilder.append("Parents:" + "\n");

            for (Parents parents : parents) {
                stringBuilder.append(parents + "\n");
            }

        stringBuilder.append("Children:" + "\n");
        for (Children child : children) {
            stringBuilder.append(child + "\n");
        }
        return stringBuilder.toString();
    }
}
