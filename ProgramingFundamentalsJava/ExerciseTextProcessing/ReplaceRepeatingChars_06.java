import java.util.Scanner;

public class ReplaceRepeatingChars_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            char currentSymbol = input.charAt(i);

            if ((i + 1) < input.length()) {
                char nextChar = input.charAt(i + 1);


                if (currentSymbol != nextChar) {
                    sb.append(currentSymbol);
                }
            } else if (i == input.length() - 1) {
                char theLastButOne = input.charAt(i - 1);
                char last = input.charAt(i);
                if (theLastButOne == last) {
                    sb.append(last);
                } else if (theLastButOne != last) {
                    sb.append(last);
//                    sb.append(theLastButOne);
                }
            }


//            String replacedText = input.replace(currentSymbol, currentSymbol);
//            System.out.println(replacedText);
        }
        System.out.println(sb);
    }
}
