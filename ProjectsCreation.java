import java.util.Scanner;

public class ProjectsCreation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //The architect George will need 12 hours to complete 4 project/s.
        String name = scanner.nextLine();
        int projectCount = Integer.parseInt(scanner.nextLine());
        int allTime = 3 * projectCount;
        System.out.printf("The architect %s will need %d hours %n to complete %d project/s.", name, allTime, projectCount);
    }
}
