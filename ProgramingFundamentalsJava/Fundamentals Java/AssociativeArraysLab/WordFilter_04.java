import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class WordFilter_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] wordsArr = Arrays.stream(scanner.nextLine().split(" "))
                .filter(e -> e.length() % 2 == 0)
                .toArray(String[] :: new);
        System.out.println(String.join(System.lineSeparator(), wordsArr));


//        String[] wordsArr = scanner.nextLine().split(" ");
//        List<String> evenL = new ArrayList<>();
//        for (int i = 0; i < wordsArr.length; i++) {
//            int length = wordsArr[i].length();
//            if (length % 2 == 0) {
//                evenL.add(wordsArr[i]);
//            }
//
//        }
//
//        for (String even : evenL) {
//            System.out.println(even);
//        }
    }
}
