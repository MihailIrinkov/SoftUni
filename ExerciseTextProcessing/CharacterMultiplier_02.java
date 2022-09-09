import java.util.Scanner;

public class CharacterMultiplier_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        String argumentOne = input[0];
        String argumentTwo = input[1];

        int sumTotal = 0;

        if (argumentOne.length() == argumentTwo.length()) {
            for (int i = 0; i < argumentOne.length(); i++) {
                char currentSymbol1 = argumentOne.charAt(i);
                int value1 = (int) currentSymbol1;
                char currentSymbol2 = argumentTwo.charAt(i);
                int value2 = (int) currentSymbol2;
                int sum = value1 * value2;
                sumTotal += sum;
            }
        } else if (argumentOne.length() > argumentTwo.length()) {
            for (int i = 0; i < argumentOne.length(); i++) {
                if (i < argumentTwo.length()) {
                    char currentSymbol1 = argumentOne.charAt(i);
                    int value1 = (int) currentSymbol1;
                    char currentSymbol2 = argumentTwo.charAt(i);
                    int value2 = (int) currentSymbol2;
                    int sum = value1 * value2;
                    sumTotal += sum;
                } else {
                    char currentSymbol1 = argumentOne.charAt(i);
                    int value1 = (int) currentSymbol1;
                    sumTotal += value1;
                }
            }

        } else if (argumentOne.length() < argumentTwo.length()) {
            for (int i = 0; i < argumentTwo.length(); i++) {
                if (i < argumentOne.length()) {
                    char currentSymbol1 = argumentOne.charAt(i);
                    int value1 = (int) currentSymbol1;
                    char currentSymbol2 = argumentTwo.charAt(i);
                    int value2 = (int) currentSymbol2;
                    int sum = value1 * value2;
                    sumTotal += sum;
                } else {
                    char currentSymbol2 = argumentTwo.charAt(i);
                    int value2 = (int) currentSymbol2;
                    sumTotal += value2;
                }
            }
        }

        System.out.println(sumTotal);
    }
}
