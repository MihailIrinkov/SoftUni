import java.util.Arrays;
import java.util.Scanner;

public class ArrayModifier_09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        String command = scanner.nextLine();
        while (!command.equals("end")) {
            String[] commandParts = command.split(" ");
            String commandType = commandParts[0];

            switch (commandType) {
                case "swap":
                    int index1 = Integer.parseInt(commandParts[1]);
                    int element1 = numbers[index1];
                    int index2 = Integer.parseInt(commandParts[2]);
                    int element2 = numbers[index2];
                    numbers[index1] = element2;
                    numbers[index2] = element1;
                    break;
                case "multiply":
                    int multiplyIndex1 = Integer.parseInt(commandParts[1]);
                    int multiplyElement1 = numbers[multiplyIndex1];
                    int multiplyIndex2 = Integer.parseInt(commandParts[2]);
                    int multiplyElement2 = numbers[multiplyIndex2];
                    int product = multiplyElement1 * multiplyElement2;
                    numbers[multiplyIndex1] = product;
                    break;
                case "decrease":
                    for (int i = 0; i <= numbers.length - 1; i++) {
                        numbers[i] = numbers[i] - 1;
                    }
                    break;
            }
            command = scanner.nextLine();
        }
        for (int i = 0; i <= numbers.length - 1; i++) {

if (i != numbers.length - 1){
    System.out.print(numbers[i] + ", ");
} else {
    System.out.println(numbers[i]);
}
        }
    }
}
