import java.util.Scanner;

public class OnTimeForTheExam_08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int examHour = Integer.parseInt(scanner.nextLine());
        int examMinutes = Integer.parseInt(scanner.nextLine());
        int hourOfArrival = Integer.parseInt(scanner.nextLine());
        int minOfArrival = Integer.parseInt(scanner.nextLine());

        int examTime = (examHour * 60) + examMinutes;
        int arrivalTime = (hourOfArrival * 60) + minOfArrival;
        int diffTime = Math.abs(examTime - arrivalTime);

        if(arrivalTime > examTime){
            System.out.println("Late");

        } else if(arrivalTime == examTime || diffTime <= 30){
            System.out.println("On time");

        } else if (diffTime > 30){
            System.out.println("Early");
        }
int diffHour = diffTime / 60;
        int diffMinutes = diffTime % 60;
        if (examTime != arrivalTime){
            if (examTime > arrivalTime && diffTime < 60){
                System.out.printf("%d minutes before the start", diffTime);
            } else if (examTime >  arrivalTime && diffTime >= 60){

                System.out.printf("%d:%02d hours before the start", diffHour, diffMinutes);
            } else if (examTime < arrivalTime && diffTime < 60){
                System.out.printf("%d minutes after the start", diffTime);
            } else if (examTime < arrivalTime && diffTime >= 60){
                System.out.printf("%d:%02d hours after the start", diffHour, diffMinutes);
            }
        }
    }
}
