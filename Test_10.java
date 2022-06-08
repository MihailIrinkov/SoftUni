import java.util.Scanner;

public class Test_10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 1; i <= n; i++){
            int number1 = Integer.parseInt(scanner.nextLine());
            if (i % 2 ==0){
                sum1 += number1;
            } else {
                sum2 += number1;
            }
        }
    }
}
