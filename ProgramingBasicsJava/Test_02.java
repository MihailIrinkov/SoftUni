import java.util.Scanner;

public class Test_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int numMax = Integer.MIN_VALUE;
        int sum =0;
        for (int i = 1; i <= n; i++) {
            int currentNumber = Integer.parseInt(scanner.nextLine());
            sum = sum + currentNumber;
            if(currentNumber > numMax){
                numMax = currentNumber;
            }
        }
        int sumWithoutMax = sum - numMax;
        if (sumWithoutMax == numMax){
            System.out.println("Yes");
            System.out.printf("Sum = %d", sumWithoutMax);
        }else{

            int diff = Math.abs(sumWithoutMax - numMax);
            System.out.println("No");
            System.out.printf("Diff = %d", diff);
        }
    }
}
