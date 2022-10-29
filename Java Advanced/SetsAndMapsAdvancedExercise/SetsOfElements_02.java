import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class SetsOfElements_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] size = scanner.nextLine().split(" ");

        int first = Integer.parseInt(size[0]);
        int second = Integer.parseInt(size[1]);

        Set<String> firstSet = new LinkedHashSet<>();
        Set<String> secondSet = new LinkedHashSet<>();

        for (int i = 0; i < first; i++) {
            String input = scanner.nextLine();

            firstSet.add(input);
        }

        for (int i = 0; i < second; i++) {
            String input = scanner.nextLine();

            secondSet.add(input);
        }


//        for (String i : firstSet) {
//            if (secondSet.contains(i)) {
//                System.out.print(i + " ");
//            }
//        }

        firstSet.retainAll(secondSet);
        for (String n : firstSet) {
            System.out.print(n + " ");
        }

    }
}
