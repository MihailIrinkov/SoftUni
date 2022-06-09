//Начин 1
import java.util.Scanner;

public class SumOfTwoNumbers_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //x1 -> [startInterval; endInterval]
        //x2 -> [startInterval; endInterval]
        int startInterval = Integer.parseInt(scanner.nextLine());
        int endInterval = Integer.parseInt(scanner.nextLine());
        int magicNumber = Integer.parseInt(scanner.nextLine());

        int count = 0; //брой на комбинациите
        //1. всички комбинации от 2 числа (х1 и х2)
        for (int x1 = startInterval; x1 <= endInterval; x1++) {
            for (int x2 = startInterval; x2 <= endInterval; x2++) {
                count++;
                //2. сумата от генерираната комбинация
                int sum = x1 + x2;
                //3. проверка дали комбинацията е валидна -> прекратявам програмата
                if (sum == magicNumber) {
                    System.out.printf("Combination N:%d (%d + %d = %d)", count, x1, x2, sum);
                    return; //прекратява изпълнението на цялата програма
                }
            }
        }

        //не е намерена комбинация
        System.out.printf("%d combinations - neither equals %d", count, magicNumber);
    }
}

//Начин 2
import java.util.Scanner;

public class SumOfTwoNumbers_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //x1 -> [startInterval; endInterval]
        //x2 -> [startInterval; endInterval]
        int startInterval = Integer.parseInt(scanner.nextLine());
        int endInterval = Integer.parseInt(scanner.nextLine());
        int magicNumber = Integer.parseInt(scanner.nextLine());

        int count = 0; //брой на комбинациите
        boolean isFound = false;
        //isFound = false -> не е открита комбинация
        //isFound = true -> открита комбинация
        //1. всички комбинации от 2 числа (х1 и х2)
        for (int x1 = startInterval; x1 <= endInterval; x1++) {
            for (int x2 = startInterval; x2 <= endInterval; x2++) {
                count++;
                //2. сумата от генерираната комбинация
                int sum = x1 + x2;
                //3. проверка дали комбинацията е валидна -> прекратявам програмата
                if (sum == magicNumber) {
                    isFound = true;
                    System.out.printf("Combination N:%d (%d + %d = %d)", count, x1, x2, sum);
                    break; //прекратява цикъла, в който се намира
                }
            }
            if (isFound) {
                break;
            }
        }

        //не е намерена комбинация -> isFound = false
        if (!isFound) { //isFound == false
            System.out.printf("%d combinations - neither equals %d", count, magicNumber);
        }
    }
}