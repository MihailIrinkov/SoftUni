import java.util.ArrayDeque;
import java.util.Scanner;

public class PrinterQueue_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        ArrayDeque<String> printQ = new ArrayDeque<>();

        while (!input.equals("print")) {

            if (!input.equals("cancel")) {
                printQ.offer(input);
            } else if (input.equals("cancel")) {

                if (printQ.isEmpty()) {
                    System.out.println("Printer is on standby");

                } else {

                    System.out.println("Canceled" + " " + printQ.peek());

                    printQ.poll();
                }


            }

            input = scanner.nextLine();
        }
        for (String s : printQ) {
            System.out.println(s);

        }
    }
}
