import java.util.Scanner;

public interface HalfSumElement_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int numMax = Integer.MIN_VALUE;
        int sum = 0;

        for (int i = 1; i <= n; i++){
int currentNumber = Integer.parseInt(scanner.nextLine());
sum = currentNumber + sum;
if (numMax < currentNumber){
    numMax = currentNumber;
}
        }
        int sumWithoutMaxNum = sum - numMax;
        if (sumWithoutMaxNum == numMax){
            System.out.println("Yes");
            System.out.printf("Sum = %d", sumWithoutMaxNum);
        } else{
            int diff = Math.abs((sum - numMax) - numMax);
            System.out.println("No");
            System.out.printf("Diff = %d", sumWithoutMaxNum);
        }

    }
}
