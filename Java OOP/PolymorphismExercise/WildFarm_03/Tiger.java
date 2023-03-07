package WildFarm_03;

public class Tiger extends Felime{

    public Tiger(String animalName, String animalType,
                 Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("ROAAR!!!");
    }

    public void eat(Food food) {
        if(food instanceof Meat) {
            super.eat(food);
        } else {
            throw new IllegalArgumentException("Tigers are not eating that type of food!");
        }
    }
}
