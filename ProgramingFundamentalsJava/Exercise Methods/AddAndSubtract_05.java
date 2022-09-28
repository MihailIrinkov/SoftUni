import java.util.Scanner;

public class AddAndSubtract_05 {
    public static void main(String[] args) {
        Scanner scannerm = new Scanner(System.in);
        int firstNum = Integer.parseInt(scannerm.nextLine());
        int secondNum = Integer.parseInt(scannerm.nextLine());
        int thirdNum = Integer.parseInt(scannerm.nextLine());

        int subtractNum = sum(firstNum, secondNum);
        System.out.println(subtractNum - thirdNum);

    }

    public static int sum(int first, int second) {
        int sumOfInt = first + second;
        return sumOfInt;
    }
}
