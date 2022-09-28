import java.util.Scanner;

public class NxNMatrix_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            nMatrix(n);

        }
    }

    public static void nMatrix(int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(n + " ");

        }
        System.out.println();
    }
}