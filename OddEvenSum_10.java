import java.util.Scanner;

public class OddEvenSum_10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int sumOdd = 0;
        int sumEven = 0;
        for (int number = 1; number <= n; number++){
            int number1 = Integer.parseInt(scanner.nextLine());

            if(number % 2 ==0){
                sumEven += number1;
            } else {sumOdd += number1;}

        }
        int diff = Math.abs(sumEven - sumOdd);
        if (sumEven == sumOdd){
            System.out.println("Yes");
            System.out.println("Sum = " + sumEven);
        } else {
            System.out.println("No");
            System.out.println("Diff = " + diff);
        }
    }
}
