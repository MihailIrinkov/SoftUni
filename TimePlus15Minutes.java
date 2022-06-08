import java.util.Scanner;

public class TimePlus15Minutes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int inHours = Integer.parseInt(scanner.nextLine());
        int inMinets = Integer.parseInt(scanner.nextLine());
        int hours = (inHours * 60);
        int hoursTotal = (hours + inMinets + 15) / 60;
        int minetsTotal = (hours + inMinets + 15) % 60;
        if (hoursTotal >23){
            hoursTotal = 0;
        }

        System.out.printf("%d:%02d", hoursTotal, minetsTotal);

    }
}
