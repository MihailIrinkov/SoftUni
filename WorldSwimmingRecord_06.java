import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

public class WorldSwimmingRecord_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double record = Double.parseDouble(scanner.nextLine());
        double distance = Double.parseDouble(scanner.nextLine());
        double timeSecOneMeter = Double.parseDouble(scanner.nextLine());

        double timeIvanDistance = distance * timeSecOneMeter;
        double resistance = Math.floor(distance / 15) * 12.5;
        double timeIvanDistanceTotal = resistance + timeIvanDistance;
        double timeToRecord = timeIvanDistanceTotal - record;
        if (record > timeIvanDistanceTotal) {
            System.out.printf("Yes, he succeeded! The new world record is %.2f seconds.", timeIvanDistanceTotal);
        } else {
                System.out.printf("No, he failed! He was %.2f seconds slower.", timeIvanDistanceTotal - record);
        }





    }


}
