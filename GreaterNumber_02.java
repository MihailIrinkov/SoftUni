import java.util.Scanner;

public class GreaterNumber_02 {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        int firstNumebr = Integer.parseInt(scanner.nextLine());
        int secondNumer = Integer.parseInt(scanner.nextLine());
        if (firstNumebr > secondNumer) {
            System.out.println(firstNumebr);

        } else{
            System.out.println(secondNumer);
        }
    }
}
