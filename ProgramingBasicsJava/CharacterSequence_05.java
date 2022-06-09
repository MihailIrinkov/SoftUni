import java.util.Scanner;

public class CharacterSequence_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        int length =text.length();
        for(int textlenght = 0; textlenght <= length - 1; textlenght ++){
            char symbol = text.charAt(textlenght);
            System.out.println(symbol);
        }
    }
}
