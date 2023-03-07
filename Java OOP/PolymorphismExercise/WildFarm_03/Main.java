package WildFarm_03;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        List<Animal> animals = new ArrayList<>();

        while (!input.equals("End")) {

            String[] animalData = input.split(" ");
            String[] foodData = scanner.nextLine().split("\\s+");

            Animal animal = createAnimal(animalData);
            Food food = getFood(foodData);

            animal.makeSound();

            try {
                animal.eat(food);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

            animals.add(animal);
            input = scanner.nextLine();
        }

        animals.forEach(System.out::println);

    }

    public static Food getFood(String[] foodData) {
        String foodType = foodData[0];
        Integer foodQty = Integer.parseInt(foodData[1]);

        switch (foodType) {
            case "Vegetable":
                return new Vegetable(foodQty);
            case "Meat":
                return new Meat(foodQty);
            default:
                throw new IllegalArgumentException("No such food");
        }

    }

    public static Animal createAnimal(String[] animalData) {

        String animalType = animalData[0];
        String animalName = animalData[1];
        double animalWeight = Double.parseDouble(animalData[2]);
        String animalLivReg = animalData[3];


        switch (animalType) {
            case "Mouse":
                return new Mouse(animalName, animalType, animalWeight, animalLivReg);
            case "Zebra":
                return new Zebra(animalName, animalType, animalWeight, animalLivReg);
            case "Tiger":
                return new Tiger(animalName, animalType, animalWeight, animalLivReg);
            case "Cat":
                return new Cat(animalName, animalType, animalWeight, animalLivReg, animalData[4]);
            default:
                throw new IllegalArgumentException("No such animal");
        }
    }
}
