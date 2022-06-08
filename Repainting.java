import java.util.Scanner;

public class Repainting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        int nylon = Integer.parseInt(scanner.nextLine());
        int paintLitr = Integer.parseInt(scanner.nextLine());
        int razer = Integer.parseInt(scanner.nextLine());
        int workersTime = Integer.parseInt(scanner.nextLine());

        Double sumNylon = (nylon + 2) * 1.50;
        Double sumPaint = (paintLitr * 1.10) * 14.50;
        Double sumRazer = razer * 5.00;
        Double bags = 0.40;
        Double sumMaterials = sumNylon + sumPaint + sumRazer + bags;
        Double sumWorkers = (sumMaterials * 0.30) * workersTime;
        Double sumTotal = sumMaterials + sumWorkers;

        System.out.println(sumTotal);


    }


}
