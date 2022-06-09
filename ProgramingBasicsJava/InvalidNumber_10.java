import java.util.Arrays;
import java.util.Scanner;

public class InvalidNumber_10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());
        boolean result = (number >=100 && number <= 200) || number == 0;
        if(!result){
            System.out.println("invalid");
        }else {
            System.out.println("valid");
        }

    }

}
