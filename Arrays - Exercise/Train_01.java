import java.util.Scanner;

public class Train_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[] people = new int[n];
        int sum = 0;

        for (int i = 0; i < n; i++) {
            int peopleNumber = Integer.parseInt(scanner.nextLine());
            people[i] = peopleNumber;
            sum += peopleNumber;

        }
        for (int num : people) {
            System.out.print(num + " ");
        }
        System.out.println();
        System.out.println(sum);
    }
}
