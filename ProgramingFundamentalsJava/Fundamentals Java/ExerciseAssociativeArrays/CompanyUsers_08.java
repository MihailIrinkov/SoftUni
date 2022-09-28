import java.util.*;

public class CompanyUsers_08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, List<String>> data = new LinkedHashMap<>();

        while (!input.equals("End")) {
            String companyName = input.split(" -> ")[0];
            String user = input.split(" -> ")[1];

            if (!data.containsKey(companyName)) {
                data.put(companyName, new ArrayList<>());
            }

            if (!data.get(companyName).contains(user)) {
                List<String> currentUser = data.get(companyName);
                currentUser.add(user);
                data.put(companyName, currentUser);
            }

            input = scanner.nextLine();
        }

        data.entrySet().forEach(entry -> {
            System.out.println(entry.getKey());
            entry.getValue().forEach(user -> System.out.println("-- " + user));
        });


    }
}
