import java.util.Scanner;

public class TennisRanklist_08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int countTours = Integer.parseInt(scanner.nextLine());
        int startPoints = Integer.parseInt(scanner.nextLine());
        int points = 0;
        int countWins = 0;
        for (int i = 1; i <= countTours; i++) {
            String type = scanner.nextLine();
            switch (type){
                case "W":
                    points = points + 2000;
                    countWins += 1;
                    break;
                case "F":
                    points = points + 1200;
                    break;
                case "SF":
                    points = points + 720;
                    break;
            }
        }
        int finalPoints = points + startPoints;
        System.out.printf("Final points: %d", finalPoints);
        System.out.println();
        System.out.printf("Average points: %d", points / countTours);
        System.out.println();
        System.out.printf("%.2f%%", countWins * 1.00 / countTours * 100);
    }
}
