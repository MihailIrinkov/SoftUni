import java.util.Scanner;

public class ArrayRotation_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] array = scanner.nextLine().split(" ");

        int rotaionNumber = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= rotaionNumber; i++) {
            String number = array[0];

            for (int j = 0; j < array.length - 1; j++) {
                array[j] = array[j + 1];
            }
            array[array.length - 1] = number;
        }
        for (String index : array) {
            System.out.print(index + " ");
        }
    }
}
