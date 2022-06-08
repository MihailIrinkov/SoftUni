import java.util.Scanner;

public class BonusScore_02  {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int inNumber = Integer.parseInt(scanner.nextLine());
        double bonus = 0;
        if (inNumber <= 100) {
            bonus =5;
        } else if (inNumber <= 1000) {
            bonus = inNumber * 0.2;
        } else {
            bonus = inNumber * 0.1;
        } if (inNumber % 2 == 0){
            bonus = bonus + 1;
        } else if (inNumber % 10 == 5){
            bonus = bonus + 2;
        }
        double number = inNumber + bonus;

        System.out.printf("%.1f%n", bonus);
        System.out.printf("%.1f", number);
    }

}
