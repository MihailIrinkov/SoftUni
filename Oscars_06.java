import java.util.Scanner;

public class Oscars_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String actorName = scanner.nextLine();
        double initialPoints = Double.parseDouble(scanner.nextLine());
        int peopleEvaluate = Integer.parseInt(scanner.nextLine());
        double totalPoints = initialPoints;
        for(int i = 1; i <= peopleEvaluate; i++){
            String nameEvaluate = scanner.nextLine();
            double points = Double.parseDouble(scanner.nextLine());
            double currentPoints = (nameEvaluate.length() * points) / 2;
            if (totalPoints < 1250.5){
                totalPoints = totalPoints + currentPoints;
            }

        }
        if (totalPoints >= 1250.5){
            System.out.printf("Congratulations, %s got a nominee for " +
                    "leading role with %.1f!", actorName, totalPoints);
        } else {
            System.out.printf("Sorry, %s you need %.1f more!",
                    actorName, 1250.5 - totalPoints);
        }
    }
}
