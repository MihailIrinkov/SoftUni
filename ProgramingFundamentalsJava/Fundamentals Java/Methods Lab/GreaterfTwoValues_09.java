import java.util.Scanner;

public class GreaterfTwoValues_09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        switch (input) {
            case "int":
                int num1 = Integer.parseInt(scanner.nextLine());
                int num2 = Integer.parseInt(scanner.nextLine());
                System.out.println(getMax(num1, num2));
                break;
            case "char":
                char sym1 = scanner.nextLine().charAt(0);
                char sym2 = scanner.nextLine().charAt(0);
                System.out.println(getMax(sym1, sym2));
                break;
            case "string":
                String string1 = scanner.nextLine();
                String string2 = scanner.nextLine();
                System.out.println(getMax(string1, string2));
                break;
        }
    }

    public static int getMax(int n1, int n2) {
        if (n1 > n2) {
            return n1;
        } else {
            return n2;
        }
    }

    public static char getMax(char char1, char char2) {
        if (char1 > char2) {
            return char1;
        } else {
            return char2;
        }
    }

    public static String getMax(String string1, String string2) {
        String result = "";
        if (string1.compareTo(string1) > 0) {
            result = string1;
        } else {
            result = string2;
        }
        return result;

    }
}
