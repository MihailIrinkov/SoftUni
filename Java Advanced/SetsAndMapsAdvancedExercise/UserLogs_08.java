import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class UserLogs_08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();

        Map<String, LinkedHashMap<String, Integer>> users = new TreeMap<>();

        while (!command.equals("end")) {
            String[] input = command.split(" ");

            String ipAd = input[0].substring(3);
            String userName = input[2].substring(5);

            if (!users.containsKey(userName)) {
                users.put(userName, new LinkedHashMap<>());
                users.get(userName).put(ipAd, 1);
            } else if (users.containsKey(userName)) {

                LinkedHashMap<String, Integer> currentMap = users.get(userName);

                if (!currentMap.containsKey(ipAd)) {
                    users.get(userName).put(ipAd, 1);
                } else {
                    users.get(userName).put(ipAd, currentMap.get(ipAd) + 1);
                }

            }


            command = scanner.nextLine();
        }

        users.entrySet().stream().forEach(e ->{
            System.out.printf("%s:%n", e.getKey());
            StringBuilder sb = new StringBuilder();
            e.getValue().entrySet().stream().forEach(eIn -> {

                sb.append(String.format("%s => %d,\n", eIn.getKey(), eIn.getValue()));

//                System.out.printf("%s => %d,%n", eIn.getKey(), eIn.getValue());
            });
            String finalOutput = sb.substring(0, sb.length() -2);
            System.out.println(finalOutput.toString() + ".");
        });
    }
}
