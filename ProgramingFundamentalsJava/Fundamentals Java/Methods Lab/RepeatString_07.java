import java.util.Scanner;

public class RepeatString_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        int n = Integer.parseInt(scanner.nextLine());

        System.out.println(printText(text, n));

    }

    public static String printText(String input, int num) {
        String textResult = " ";
        for (int i = 0; i < num; i++) {
            textResult += input;
        }
        return textResult;
    }
}
