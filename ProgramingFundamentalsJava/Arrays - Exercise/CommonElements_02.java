import java.util.Scanner;

public class CommonElements_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String firstRow = scanner.nextLine();
        String secondRow = scanner.nextLine();

        String[] firstArr = firstRow.split(" ");
        String[] secondArr = secondRow.split(" ");

        for (String secondElement : secondArr) {
            for (String firstElement : firstArr) {
                if (firstElement.equals(secondElement)) {
                    System.out.print(firstElement + " ");
                }
            }

        }
    }
}
