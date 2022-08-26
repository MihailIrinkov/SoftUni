import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class SoftUniParking_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, String> register = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String command = scanner.nextLine();
            String action = command.split(" ")[0];
            String userName = command.split(" ")[1];
            if (action.equals("register")) {

                if (!register.containsKey(userName)) {
                    String licensePlateNumber = command.split(" ")[2];
                    register.put(userName, licensePlateNumber);
                    System.out.printf("%s registered %s successfully%n"
                            , userName, licensePlateNumber);
                } else {
                    System.out.printf("ERROR: already registered with plate number %s%n",
                            register.get(userName));
                }
            } else if (action.equals("unregister")) {
                if (!register.containsKey(userName)) {
                    System.out.printf("ERROR: user %s not found%n", userName);
                } else {
                    register.remove(userName);
                    System.out.printf("%s unregistered successfully%n", userName);
                }
            }
        }

        for (Map.Entry<String, String> entry : register.entrySet()) {
            System.out.printf("%s => %s%n", entry.getKey(), entry.getValue());
        }
    }
}
