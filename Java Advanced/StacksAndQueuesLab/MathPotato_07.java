import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MathPotato_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String names = scanner.nextLine();

        ArrayDeque<String> queue = Arrays.stream(names.split(" "))
                .collect(Collectors.toCollection(ArrayDeque::new));

        int n = Integer.parseInt(scanner.nextLine());

        int cycle = 1;

        while (queue.size() > 1) {

            for (int i = 1; i < n; i++) {
                queue.offer(queue.poll());
            }
            if (isPrime(cycle)) {
                System.out.println("Prime " + queue.peek());
            } else {
                System.out.println("Removed " + queue.poll());
            }
            cycle++;
        }
        System.out.println("Last is " + queue.peek());
    }


    private static boolean isPrime(int number) {
        if (number <= 1) return false;
        for (int i = 2; i < number / 2 + 1; i++) {
            if (number % i == 0) return false;
        }
        return true;
    }

}
