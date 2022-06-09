import java.util.Scanner;

public class Exersise_01 {
    public static <scanner> void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int currentNum = 0;
        boolean flag = false;
        for (int r = 1; r <= n; r++) {
            for (int c = 1; c <= r; c++) {
                currentNum++;

                if (currentNum > n) {
                    flag = true;
                    break;
               }
                System.out.print(currentNum + " ");

                    }
            if (flag) {
                break;
            }
                    System.out.println();
                }

            }
        }


