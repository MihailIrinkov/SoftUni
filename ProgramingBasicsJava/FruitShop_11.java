import java.util.Arrays;
import java.util.Scanner;

public class FruitShop_11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String fruit = scanner.nextLine();
        String weekday = scanner.nextLine();
        double quantity = Double.parseDouble(scanner.nextLine());
        double sum = 0;
        if (weekday.equals("Monday") || weekday.equals("Tuesday") || weekday.equals("Wednesday") || weekday.equals("Thursday") || weekday.equals("Friday")) {
            if (fruit.equals("banana")) {
                sum = quantity * 2.50;
                System.out.printf("%.2f", sum);
            } else if (fruit.equals("apple")) {
                sum = quantity * 1.20;
                System.out.printf("%.2f, sum");
            }
        }
        if (weekday.equals("Saturday") || weekday.equals("Sunday")) {


            switch (fruit) {

                case "banana":
                    System.out.println(quantity * 2.70);
                    break;
                case "apple":
                    System.out.println(quantity * 1.25);
                    break;
                case "orange":
                    System.out.println(quantity * 0.90);
                    break;
                case "grapefruit":
                    System.out.println(quantity * 1.60);
                    break;
                case "kiwi":
                    System.out.println(quantity * 3.00);
                    break;
                case "pineapple":
                    System.out.println(quantity * 5.60);
                    break;
                case "grapes":
                    System.out.println(quantity * 4.20);
                    break;
                default:
                    System.out.println("error");
                    break;

            }
            }
        }
    }


