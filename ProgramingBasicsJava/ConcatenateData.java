import java.sql.SQLOutput;
import java.util.Scanner;

public class ConcatenateData {
    public static void main(String[] args) {
        //"You are <firstName> <lastName>, a <age>-years old person from <town>."
        Scanner scanner = new Scanner(System.in);
        String firstName = scanner.nextLine();
        String lastName = scanner.nextLine();
        double age = Double.parseDouble(scanner.nextLine());
        String town = scanner.nextLine();
        System.out.printf("You are %s %s, a %.3f-years old person from %s.", firstName, lastName, age, town);


    }
}
