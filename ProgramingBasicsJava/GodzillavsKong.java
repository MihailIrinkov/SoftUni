import java.util.Scanner;

public class GodzillavsKong {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double bugdetMoovi = Double.parseDouble(scanner.nextLine());
        int numberStatics = Integer.parseInt(scanner.nextLine());
        double priceCloudsStatics = Double.parseDouble(scanner.nextLine());
double priceCloudsStaticsAll = priceCloudsStatics * numberStatics;
        //o	"Not enough money!"
        //o	"Wingard needs {парите недостигащи за филма} leva more."
        //o	"Action!"
        //o	"Wingard starts filming with {останалите пари} leva left."
        double decorFilm = bugdetMoovi * 0.1;
        if (numberStatics > 150){
            priceCloudsStaticsAll = priceCloudsStaticsAll  * 0.90;
        }
double sumMoovi = priceCloudsStaticsAll + decorFilm;
        double diff = Math.abs(sumMoovi - bugdetMoovi);
        if (sumMoovi <= bugdetMoovi){
            System.out.println("Action!");
            System.out.printf("Wingard starts filming with %.2f leva left.", diff);
        } else{
            System.out.println("Not enough money!");
            System.out.printf("Wingard needs %.2f leva more.", diff);
        }
    }

}
