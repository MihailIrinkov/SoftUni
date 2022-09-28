import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class LegendaryFarming_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        Map<String, Integer> items = new LinkedHashMap<>();
        items.put("shards", 0);
        items.put("fragments", 0);
        items.put("motes", 0);
        Map<String, Integer> junk = new LinkedHashMap<>();
        boolean win = false;
        while (!win) {
            String input = scanner.nextLine();
            String[] inputData = input.split(" ");
            for (int i = 0; i < inputData.length; i += 2) {
                int value = Integer.parseInt(inputData[i]);
                String key = inputData[i + 1].toLowerCase();

                if (key.equals("motes") || key.equals("fragments") || key.equals("shards")) {
                    int currentQty = items.get(key);
                    items.put(key, currentQty + value);
                } else {
                    if (!junk.containsKey(key)) {
                        junk.put(key, value);
                    } else {
                        int current = junk.get(key);
                        junk.put(key, current + value);
                    }
                }


                if (items.get("shards") >= 250) {
                    System.out.println("Shadowmourne obtained!");
                    items.put("shards", items.get("shards") - 250);
                    win = true;
                    break;
                } else if (items.get("fragments") >= 250) {
                    System.out.println("Valanyr obtained!");
                    items.put("fragments", items.get("fragments") - 250);
                    win = true;
                    break;
                } else if (items.get("motes") >= 250) {
                    System.out.println("Dragonwrath obtained!");
                    items.put("motes", items.get("motes") - 250);
                    win = true;
                    break;
                }

            }
            if (win) {
                break;
            }
        }
        for (Map.Entry<String, Integer> entry : items.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        for (Map.Entry<String, Integer> entry : junk.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }


    }
}
