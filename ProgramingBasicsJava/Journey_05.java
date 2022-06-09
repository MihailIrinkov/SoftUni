import java.util.Scanner;

public class Journey_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double budget = Double.parseDouble(scanner.nextLine());
        String season = scanner.nextLine();
        String location = "";
        String place = "";


        if (budget <= 100){
            location = "Bulgaria";


        }else if (budget <= 1000) {
            location = "Balkans";
        } else if (budget > 1000){
            location = "Europe";
        }
        System.out.printf("Somewhere in %s %n", location);
        if(season.equals("summer") && location.equals("Bulgaria")){
            place = "Camp";
            budget = budget * 0.30;

        } else if(season.equals("winter") && location.equals("Bulgaria")) {
            place = "Hotel";
            budget = budget * 0.70;

        }else if(season.equals("summer") && location.equals("Balkans")){
            place ="Camp";
            budget = budget * 0.40;
        } else if(season.equals("winter") && location.equals("Balkans")) {
            place = "Hotel";
            budget = budget * 0.80;
        } else {
            place = "Hotel";
            budget = budget * 0.90;
        }

        System.out.printf("%s - %.2f", place, budget);
    }
}
