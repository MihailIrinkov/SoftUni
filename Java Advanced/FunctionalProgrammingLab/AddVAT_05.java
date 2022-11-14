import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class AddVAT_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", ");

        Function<String, Double> parsePrice = e -> Double.parseDouble(e);

        UnaryOperator<Double> vat = e -> e * 1.2;

        Consumer<Double> printer = e -> System.out.printf("%.2f%n", e);

        System.out.println("Prices with VAT:");

        Arrays.stream(input)
                .map(parsePrice)
                .map(vat)
                .forEach(printer);

    }
}
