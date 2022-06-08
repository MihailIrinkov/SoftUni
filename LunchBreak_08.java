import java.util.Scanner;

public class LunchBreak_08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String nameSerial = scanner.nextLine();
        int durationEpisod = Integer.parseInt(scanner.nextLine());
        int durationBreak = Integer.parseInt(scanner.nextLine());
        // "You have enough time to watch {име на сериал} and left with {останало време} minutes free time."
        // "You don't have enough time to watch {име на сериал}, you need {нужно време} more minutes."
        double lunchTime = durationBreak / 8.0;
        double restTime = durationBreak / 4.0;
        double leftTime = durationBreak - lunchTime - restTime;
        double diffTime = Math.abs(durationEpisod - leftTime);
        if (leftTime >= durationEpisod){
            System.out.printf("You have enough time to watch %s and left with %.0f minutes free time.", nameSerial, Math.ceil(diffTime));
        }else{
            System.out.printf("You don't have enough time to watch %s, you need %.0f more minutes.", nameSerial, Math.ceil(diffTime));
        }
    }
}
