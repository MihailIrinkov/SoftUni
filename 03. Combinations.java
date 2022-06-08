import java.util.Scanner;

public class Combinations_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        //всички комбинации от 3 числа
        //x1 -> 0 до n
        //x2 -> 0 до n
        //x3 -> 0 до n
        int count = 0; //брой на валидни комбинация (x1 + x2 + x3 == n)
        for (int x1 = 0; x1 <= n; x1++) {
            for (int x2 = 0; x2 <= n; x2++) {
                for (int x3 = 0; x3 <= n; x3++) {
                    //комбинация от числата x1, x2, x3
                    if (x1 + x2 + x3 == n) {
                        //валидна
                        count++;
                    }
                }
            }
        }

        System.out.println(count);
    }
}