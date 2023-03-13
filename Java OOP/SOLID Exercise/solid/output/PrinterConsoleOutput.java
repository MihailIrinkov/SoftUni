package solid.output;

import solid.Calculator;
import solid.products.Product;

import java.util.List;

public class PrinterConsoleOutput implements Output{
    private Calculator calorieCalculator;
    private static final String SUM = "Sum: %f";
    private static final String AVERAGE = "Average: %f";

    public PrinterConsoleOutput(Calculator calorieCalculator) {
        this.calorieCalculator = calorieCalculator;
    }

    public void outputSum(List<Product> products) {

        System.out.printf((SUM) + "%n", calorieCalculator.total(products));
    }

    public void outputAverage(List<Product> products) {

        System.out.printf((AVERAGE) + "%n",
                calorieCalculator.average(products));
    }

}
