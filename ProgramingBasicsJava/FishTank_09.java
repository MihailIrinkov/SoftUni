import java.util.Scanner;

public class FishTank_09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int leght = Integer.parseInt(scanner.nextLine());
        int weith = Integer.parseInt(scanner.nextLine());
        int high = Integer.parseInt(scanner.nextLine());
        double percent = Double.parseDouble(scanner.nextLine());
        int volumTank = leght * weith * high;
        double volumTankLitres = volumTank * 0.001;
        double neededLitres = volumTankLitres * ((100.0 - percent) / 100);
        System.out.println(neededLitres);
    }
}
