import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static java.lang.Integer.parseInt;

public class PokemonDoNotGo_09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> distances = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int removedElements = 0;
        while (distances.size() > 0) {
            int index = Integer.parseInt(scanner.nextLine());
            if (index < 0) {
                int firstElement = distances.get(0);
                removedElements += firstElement;
                int lastElement = distances.get(distances.size() - 1);
                distances.set(0, lastElement);


                modifyElement(distances, firstElement);

            } else if (index > distances.size() - 1) {
                int lastElement = distances.get(distances.size() - 1);
                int firstElement = distances.get(0);
                removedElements += lastElement;
                distances.set(distances.size() - 1, firstElement);

                modifyElement(distances, lastElement);


            } else if (index >= 0 && index <= distances.size() - 1) {
                int removedElementC = distances.get(index);
                removedElements += removedElementC;
                distances.remove(index);

                modifyElement(distances, removedElementC);

            }
        }
        System.out.println(removedElements);

    }



    public static void modifyElement (List<Integer> element, int removedElement) {
        for (int i = 0; i < element.size(); i++) {
            int currentElement = element.get(i);
            if (currentElement <= removedElement) {
                currentElement += removedElement;
            } else {
                currentElement -= removedElement;
            }
            element.set(i, currentElement);
        }
    }
}
