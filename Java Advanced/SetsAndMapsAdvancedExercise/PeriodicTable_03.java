import java.util.Collections;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class PeriodicTable_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Set<String> compounds = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");

            for (String s : input) {
                compounds.add(s);
            }

//            for (int j = 0; j < input.length; j++) {
//                compounds.add(input[j]);
//            }
        }

        String print = String.join(" ", compounds);
        System.out.println(print);

//        for (String s : compounds) {
//            System.out.print(s + " ");
//        }

    }
}
