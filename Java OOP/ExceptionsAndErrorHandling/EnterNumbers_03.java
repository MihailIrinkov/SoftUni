import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class EnterNumbers_03 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Integer> list = getNumberInRange(scanner, new ArrayList<>());


        //list.stream().forEach(e -> System.out.print(e + ", "));

        System.out.println(list.stream().map(String::valueOf)
                .collect(Collectors.joining(", ")));
    }

    private static List<Integer> getNumberInRange(Scanner scanner, List<Integer> list) {
        int currentNumber = 1;

        while (list.size() < 10) {
            try {
                int n = Integer.parseInt(scanner.nextLine());

                if (n > currentNumber &&
                        n < 100) {
                    currentNumber = n;
                    list.add(currentNumber);
                } else {

                    System.out.printf("Your number is not in range %d - 100!%n", currentNumber);
                }

            } catch (IllegalArgumentException e) {

                System.out.println("Invalid Number!");
            }

        }
        return list;
    }

}

