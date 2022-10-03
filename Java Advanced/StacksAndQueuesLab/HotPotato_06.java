import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class HotPotato_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String names = scanner.nextLine();

        ArrayDeque<String> que = Arrays.stream(names.split(" "))
                .collect(Collectors.toCollection(ArrayDeque::new));

        int n = Integer.parseInt(scanner.nextLine());

        while (que.size() > 1) {

            for (int i = 1; i < n; i++) {

                que.offer(que.poll());
            }
            System.out.println("Removed " + que.poll());
        }

        System.out.println("Last is " + que.peek());
    }
}
