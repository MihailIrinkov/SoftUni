import java.util.Scanner;

public class PrintingTriangle_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.next());

        triangle(n);


    }

    public static void triangle(int number) {
        for (int i = 1; i <= number; i++) {
            printLine(1, i);

        }

        for (int i = number - 1; i >= 1; i--) {
            printLine(1, i);
        }
    }

    public static void printLine(int start, int end) {
        for (int i = start; i <= end; i++) {
            System.out.print(i + " ");

        }
        System.out.println();

    }

//    public static void reverseTriangle(int n) {
//        for (int i = 1; i <= n - 1; i++) {
//            System.out.print(i + " ");
//        }
//    }
}
