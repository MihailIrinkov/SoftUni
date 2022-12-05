package PokemonTrainer_06;

import java.util.List;

public class Pokemon {
    private String name;
    private String element;
    int health;

    public Pokemon(String name, String element, int health){
        this.name = name;
        this.element = element;
        this.health = health;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public void setElement(){
        this.element = element;
    }
    public String getElement(){
        return this.element;
    }
    public void setHealth(int health){
        this.health = health;
    }
    public int getHealth(){
        return this.health;
    }
}
