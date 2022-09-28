import java.util.*;

public class ForceBook_09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<String, List<String>> map = new LinkedHashMap<>();

        while (!input.equals("Lumpawaroo")) {
            if (input.contains("|")) {
                String team = input.split(" \\| ")[0];
                String player = input.split(" \\| ")[1];
                if (!map.containsKey(team)) {
                    map.put(team, new ArrayList<>());
                }
                boolean isExist = false;
                for (List<String> list : map.values()) {
                    if (list.contains(player)) {
                        isExist = true;
                    }
                }
                if (!isExist) {
                    map.get(team).add(player);
                }
            } else if (input.contains("->")) {
                String team = input.split(" -> ")[1];
                String player = input.split(" -> ")[0];
//                String playerA = input.split(" -> ")[0];
//                String teamA = input.split(" -> ")[1];
                map.entrySet().forEach(entry -> entry.getValue().remove(player));

                if (map.containsKey(team)) {
                    List<String> currentPlayers = map.get(team);
                    currentPlayers.add(player);
                } else {
                    map.put(team, new ArrayList<>());
                    map.get(team).add(player);
                }

                System.out.printf("%s joins the %s side!%n", player, team);

            }

            input = scanner.nextLine();
        }

        map.entrySet().stream().filter(entry -> entry.getValue().size() > 0)
                .forEach(entry -> {
                    System.out.printf("Side: %s, Members: %d%n", entry.getKey(), entry.getValue().
                            size());
                    entry.getValue().forEach(player -> System.out.println("! " + player));
                });

    }
}
