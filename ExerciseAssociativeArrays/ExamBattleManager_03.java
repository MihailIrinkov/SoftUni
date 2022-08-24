import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class ExamBattleManager_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, Integer> health = new LinkedHashMap<>();
        Map<String, Integer> energy = new LinkedHashMap<>();

        while (!input.equals("Results")) {

            String personName = input.split(":")[1];
//            int currentHealth = Integer.parseInt(input.split(":")[2]);
//            int currentEnergy = Integer.parseInt(input.split(":")[3]);

            if (input.contains("Add")) {

                int currentHealth = Integer.parseInt(input.split(":")[2]);
                int currentEnergy = Integer.parseInt(input.split(":")[3]);



                if (!health.containsKey(personName)) {
                    health.put(personName, currentHealth);
                    energy.put(personName, currentEnergy);
                } else {
                    int newHealth = currentHealth + health.get(personName);
                    health.put(personName, newHealth);
                }


            } else if (input.contains("Attack")) {

                String attackerName = input.split(":")[1];
                String defenderName = input.split(":")[2];
                int damage = Integer.parseInt(input.split(":")[3]);


                if (health.containsKey(attackerName) && health.containsKey(defenderName)) {

                    int reduceHealth = health.get(defenderName) - damage;
                    health.put(defenderName, reduceHealth);
                    int reduceEnergy = energy.get(attackerName) - 1;
                    energy.put(attackerName, reduceEnergy);

                    if (health.get(defenderName) <= 0) {
//                        String defenderName = input.split(" : ")[2];
                        System.out.printf("%s was disqualified!%n", defenderName);
                        health.remove(defenderName);
                        energy.remove(defenderName);


                    }
                    if (energy.get(attackerName) <= 0) {

                        System.out.printf("%s was disqualified!%n", attackerName);
                        health.remove(attackerName);
                        energy.remove(attackerName);

                    }
                }

            } else if (input.contains("Delete")) {

                String userToDelete = input.split(":")[1];
                if (health.containsKey(userToDelete)) {
                    health.remove(userToDelete);
                    energy.remove(userToDelete);

                } else if (userToDelete.equals("All")) {
                    health.clear();
                    energy.clear();
                }
            }

            input = scanner.nextLine();
        }
        int peopleCount = health.size();
        System.out.printf("People count: %d%n", peopleCount);


//        health.entrySet().forEach(entry -> {
//            System.out.println(entry.getKey() + ": " + entry.getValue().size());
//            entry.getValue().forEach(studentName -> System.out.println("-- " + studentName));
//        });


//        {NPersonName} - {health} - {energy}"

        for (Map.Entry<String, Integer> entry : health.entrySet()) {
            String name = entry.getKey();
            int health1 = entry.getValue();


            int energy1 = energy.get(name);
            System.out.printf("%s - %d - %d%n", name, health1, energy1);


//            System.out.printf("%s - %d - %d", name, health1, energy1);

        }


    }
}
