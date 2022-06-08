import java.util.Scanner;

public class Numbers1ToNwithStep_3_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        for (int number = 1; n >= number; number+= 3){
            System.out.println(number);
        }
    }
}
