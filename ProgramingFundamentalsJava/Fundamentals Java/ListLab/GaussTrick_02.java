import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class GaussTrick_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
        int sizeList = numbers.size() / 2;

        for (int i = 0; i < sizeList; i++) {
            int firstNum = numbers.get(i);
            int secondNum = numbers.get(numbers.size() - 1);
            int result = firstNum + secondNum;
            numbers.set(i, result);
            numbers.remove(numbers.size() - 1);

        }

        for (int num : numbers) {
            System.out.print(num + " ");
        }
    }
}
