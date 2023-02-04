package PizzaCalories_04;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String pizzaData = scanner.nextLine();
        String name = pizzaData.split(" ")[1];
        int numberOfToppings = Integer
                .parseInt(pizzaData.split(" ")[2]);

        Pizza pizza = new Pizza(name, numberOfToppings);

        String doughData = scanner.nextLine();
        String flourType = doughData.split(" ")[1];
        String bakingTechnique = doughData.split(" ")[2];
        double weight = Double.parseDouble(doughData.split(" ")[3]);

        Dough dough = new Dough(flourType, bakingTechnique, weight);

        pizza.setDough(dough);

        String toppingData = scanner.nextLine();

        while (!toppingData.equals("END")) {

            String toppingType = toppingData.split(" ")[1];
            double weightT = Double.parseDouble(toppingData.split(" ")[2]);

            Topping topping = new Topping(toppingType, weightT);

            pizza.addTopping(topping);

            toppingData = scanner.nextLine();
        }

        System.out.printf("%s - %.2f", pizza.getName(), pizza.getOverallCalories());
    }
}
