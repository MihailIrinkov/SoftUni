import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class AMinerTask_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        Map<String, Integer> map = new LinkedHashMap<>();

        while (!input.equals("stop")) {
            int quantity = Integer.parseInt(scanner.nextLine());
            if (!map.containsKey(input)) {
                map.put(input, quantity);
            } else {

                int currentQty = map.get(input);
                int totalValue = quantity + currentQty;
                map.put(input, totalValue);
            }

            input = scanner.nextLine();
        }

        for (Map.Entry<String, Integer> inp : map.entrySet()) {

            System.out.printf("%s -> %d%n", inp.getKey(), inp.getValue());
        }
    }
}
