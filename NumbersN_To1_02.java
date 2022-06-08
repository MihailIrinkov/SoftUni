import java.util.Scanner;

public class NumbersN_To1_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        for (int number = n; n >= 1; n--){
            System.out.println(n);
        }
    }
}
