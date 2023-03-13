package solid;

import solid.output.PrinterConsoleOutput;
import solid.products.calculator.CalorieCalculator;

public class Main {

    public static void main(String[] args) {
        CalorieCalculator calorieCalculator = new CalorieCalculator();
        PrinterConsoleOutput printer = new PrinterConsoleOutput(calorieCalculator);



    }
}
