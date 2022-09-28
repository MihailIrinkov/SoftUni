import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HouseParty_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String guestList = "";
        List<String> names = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            String command = scanner.nextLine();
            String guest = command.split(" ")[0];

            if (command.contains("not")) {

                if (!names.contains(guest)) {
                    System.out.printf("%s is not in the list!%n", guest);
                } else {
                    names.remove(guest);
                }


            } else {
                if (names.contains(guest)) {
                    System.out.printf("%s is already in the list!%n", guest);
                } else {
                    names.add(guest);
                }
            }
        }

        for (String name : names) {
            System.out.println(name);
        }
    }
}
