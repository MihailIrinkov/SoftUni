package WildFarm_03;

import java.text.DecimalFormat;

public abstract class Mammal extends Animal{
    private String livingRegion;

    public Mammal(String animalName, String animalType,
                  Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight);
        this.livingRegion = livingRegion;
    }

    public String getLivingRegion() {
        return livingRegion;
    }

    public void setLivingRegion(String livingRegion) {
        this.livingRegion = livingRegion;
    }
    @Override
    public String toString() {
        //"{AnimalType} [{AnimalName}, {AnimalWeight}, {AnimalLivingRegion}, {FoodEaten}]".

        DecimalFormat df = new DecimalFormat("##.##");

        return String.format("%s [%s, %s, %s, %d].", getAnimalType(), getAnimalName(),
                df.format(getAnimalWeight()), this.livingRegion, getFoodEaten());
    }
}
