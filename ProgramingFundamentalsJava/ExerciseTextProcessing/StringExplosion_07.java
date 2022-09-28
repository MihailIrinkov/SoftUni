import java.util.Scanner;

public class StringExplosion_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        StringBuilder sb = new StringBuilder(input);

        int totalPower = 0;

        for (int i = 0; i < sb.length(); i++) {
            char currentChar = sb.charAt(i);

            if (currentChar == '>') {
                int currentPower = Integer.parseInt(sb.charAt(i + 1) + "");
                totalPower += currentPower;
            } else if (currentChar != '>' && totalPower > 0) {
                sb.deleteCharAt(i);
                totalPower--;
                i--;
            }
        }

        System.out.println(sb);

    }
}
