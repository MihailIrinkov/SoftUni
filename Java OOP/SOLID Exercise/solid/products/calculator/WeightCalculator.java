package solid.products.calculator;

import solid.Calculator;
import solid.products.Product;

import java.util.List;

public class WeightCalculator implements Calculator {

    public double total(List<Product> products) {
        return products.stream().mapToDouble(p -> p.getKilograms()).sum();
    }

    public double average(List<Product> products) {

        return total(products) / products.size();
    }
}
