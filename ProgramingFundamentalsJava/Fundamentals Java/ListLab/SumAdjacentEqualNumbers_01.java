import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SumAdjacentEqualNumbers_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Double> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Double::parseDouble).collect(Collectors.toList());

        for (int i = 0; i < numbers.size() - 1; i++) {
            double firstNum = numbers.get(i);
            double secondNum = numbers.get(i + 1);
            if (firstNum == secondNum) {
                numbers.set(i, firstNum + secondNum);
                numbers.remove(i + 1);
                i = -1;
            }
        }
        System.out.println(joinElementsByDelimiter(numbers, " "));

    }

    public static String joinElementsByDelimiter(List<Double> list, String delimiter) {
        String result = "";
        for (Double num : list) {
            DecimalFormat df = new DecimalFormat("0.#");
            String numFormat = df.format(num) + delimiter;
            result = result + numFormat;
        }
        return result;
    }
}
