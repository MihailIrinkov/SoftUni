import java.io.*;

public class CountCharacterTypes_04 {
    public static void main(String[] args) throws IOException {

        FileReader inputStream = new FileReader(".idea/resources/04. Java-Advanced-Files-and-Streams-Exercises-Resources/input.txt");

        PrintWriter pw = new PrintWriter(new PrintWriter("output.txt"));

        int bytes = inputStream.read();

        int vowel = 0;
        int otherSymbol = 0;
        int punctuation = 0;

        while (bytes >= 0) {

            char symbol = (char) bytes;

            if (symbolIsVowelsVowelsVowel(symbol)) {
                vowel++;
            } else if (isPunctuation(symbol)) {
                punctuation++;
            } else if (!Character.isWhitespace(symbol)) {
                otherSymbol++;
            }
            bytes = inputStream.read();
        }
        inputStream.close();

        pw.println("Vowels: " + vowel);
        pw.println("Other symbols: " + otherSymbol);
        pw.println("Punctuation: " + punctuation);

        pw.close();

    }

    private static boolean symbolIsVowelsVowelsVowel(char symbol) {
        return symbol == 'a' || symbol == 'e' || symbol == 'i' || symbol == 'o' || symbol == 'u';
    }

    private static boolean isPunctuation(char symbol) {
        return symbol == '!' || symbol == ',' || symbol == '.' || symbol == '?';
    }

}
