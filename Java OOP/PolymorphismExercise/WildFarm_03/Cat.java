package WildFarm_03;

import java.text.DecimalFormat;

public class Cat extends Felime {
    private String breed;

    public Cat(String animalName, String animalType, Double animalWeight,
               String livingRegion, String breed) {
        super(animalName, animalType, animalWeight, livingRegion);
        this.breed = breed;
    }

    @Override
    public void makeSound() {
        System.out.println("Meowwww");
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String toString() {
        //"{AnimalType} [{AnimalName}, {AnimalWeight}, {AnimalLivingRegion}, {FoodEaten}]".

        DecimalFormat df = new DecimalFormat("##.##");

        return String.format("%s [%s, %s, %s, %s, %d].", getAnimalType(), getAnimalName(), this.breed,
                df.format(getAnimalWeight()), getLivingRegion(), getFoodEaten());
    }
}
