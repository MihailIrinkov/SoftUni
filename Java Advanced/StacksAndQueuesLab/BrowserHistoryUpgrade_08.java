import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistoryUpgrade_08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        ArrayDeque<String> forwardStack = new ArrayDeque<>();
        ArrayDeque<String> backStack = new ArrayDeque<>();

        String currentUrl = null;

        while (!input.equals("Home")) {

            if (input.equals("forward")) {
                if (forwardStack.isEmpty()) {
                    System.out.println("no next URLs");

                } else {
                    currentUrl = forwardStack.pop();
                    backStack.push(currentUrl);
                    System.out.println(currentUrl);
                }

            } else if (input.equals("back")) {
                if (backStack.size() > 1) {
                    currentUrl = backStack.pop();
                    forwardStack.push(currentUrl);
                    System.out.println(backStack.peek());

                } else {
                    System.out.println("no previous URLs");
                }
            } else {
                currentUrl = input;
                backStack.push(currentUrl);
                System.out.println(currentUrl);
                forwardStack.clear();

            }
            input = scanner.nextLine();
        }
    }
}
