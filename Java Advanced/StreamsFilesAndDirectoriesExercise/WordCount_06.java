import java.io.*;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Scanner;

public class WordCount_06 {
    public static void main(String[] args) throws IOException {

        Scanner fileReader = new Scanner(new FileReader(".idea/resources/04. Java-Advanced-Files-and-Streams-Exercises-Resources/words.txt"));

        String[] words = fileReader.nextLine().split(" ");
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();

        for (String word : words) {
            map.put(word, 0);
        }

        Scanner textReader = new Scanner( new FileReader(".idea/resources/04. Java-Advanced-Files-and-Streams-Exercises-Resources/text.txt"));
        String singleWord = textReader.next().toLowerCase(Locale.ROOT);

        while (textReader.hasNext()){

            if (map.containsKey(singleWord)) {

                int count = map.get(singleWord) + 1;

                map.put(singleWord, count);
            }


            singleWord = textReader.next();
        }

        PrintWriter pw = new PrintWriter(new FileWriter("results.txt"));

        map.entrySet().stream()
                .sorted((f, s) -> s.getValue() - f.getValue())
                .forEach(e ->
                        pw.printf("%s - %d%n", e.getKey(), e.getValue())
                );

        pw.close();
    }
}
