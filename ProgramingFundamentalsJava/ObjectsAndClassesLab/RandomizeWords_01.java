import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public class RandomizeWords_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> words = Arrays.stream(scanner.nextLine().split(" "))
                        .collect(Collectors.toList());

        // while(!words.isEmpty()) {}
        while (words.size() > 0) {

            Random rnd = new Random();
            int n = rnd.nextInt(words.size());

            System.out.println(words.get(n));

            words.remove(n);


        }
    }
}
