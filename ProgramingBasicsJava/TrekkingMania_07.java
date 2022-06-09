import java.util.Scanner;

public class TrekkingMania_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int groups = Integer.parseInt(scanner.nextLine());

        int musala = 0;
        int montblant = 0;
        int kilimandzharo = 0;
        int k2 = 0;
        int everest = 0;
        int allPeople = 0;
        for (int i = 1; i <= groups; i++) {
            int peopleInGroup = Integer.parseInt(scanner.nextLine());
            allPeople = allPeople + peopleInGroup;
            if (peopleInGroup <= 5){
musala = musala + peopleInGroup;
            } else if (peopleInGroup <= 12){
                montblant = montblant + peopleInGroup;
            } else if (peopleInGroup <= 25){
                kilimandzharo = kilimandzharo + peopleInGroup;
            } else if (peopleInGroup <= 40) {
                k2 = k2 + peopleInGroup;
            } else {
                everest = everest + peopleInGroup;
            }
        }

        System.out.printf("%.2f%%", musala * 1.0 / allPeople * 100);
        System.out.println();
        System.out.printf("%.2f%%", montblant * 1.0 / allPeople * 100);
        System.out.println();
        System.out.printf("%.2f%%", kilimandzharo * 1.0 / allPeople * 100);
        System.out.println();
        System.out.printf("%.2f%%", k2 * 1.0 / allPeople * 100);
        System.out.println();
        System.out.printf("%.2f%%", everest * 1.0 / allPeople * 100);
    }
}
