import java.util.ArrayDeque;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class AutumnCocktails_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] bucket = scanner.nextLine().split(" ");
        String[] freshnessLevel = scanner.nextLine().split(" ");

        ArrayDeque<Integer> bucketQue = new ArrayDeque<>();
        ArrayDeque<Integer> freshnessLevelStack = new ArrayDeque<>();

        for (int i = 0; i < bucket.length; i++) {
            bucketQue.offer(Integer.parseInt(bucket[i]));
        }

        for (int i = 0; i < freshnessLevel.length; i++) {
            freshnessLevelStack.push(Integer.parseInt(freshnessLevel[i]));
        }

        Map<String, Integer> cocktails = new TreeMap<>();

        while (!bucketQue.isEmpty() && !freshnessLevelStack.isEmpty()) {

            int currentB = bucketQue.poll();
            if (currentB == 0) {
                continue;
            }
            int currentF = freshnessLevelStack.pop();





//            if (currentB == 0 && (bucketQue.size() > 1)) {
//                bucketQue.poll();
//                currentB = bucketQue.peek();
//            } else if (bucketQue.size() == 1 && currentB == 0) {
//                break;
//            }

//            if (currentF == 0 && (freshnessLevelStack.size() > 1)) {
//                freshnessLevelStack.pop();
//                currentF = freshnessLevelStack.peek();
//            } else if (freshnessLevelStack.size() == 1 && currentF == 0) {
//                break;
//            }

            if (currentB * currentF == 150) {

                if (!cocktails.containsKey("Pear Sour")) {

                    cocktails.put("Pear Sour", 1);
                } else {
                    int current = cocktails.get("Pear Sour") + 1;
                    cocktails.put("Pear Sour", current);
                }


            } else if (currentB * currentF == 250) {

                if (!cocktails.containsKey("The Harvest")) {
                    cocktails.put("The Harvest", 1);
                } else {
                    int current = cocktails.get("The Harvest") + 1;
                    cocktails.put("The Harvest", current);
                }


            } else if (currentB * currentF == 300) {

                if (!cocktails.containsKey("Apple Hinny")) {
                    cocktails.put("Apple Hinny", 1);
                } else {
                    int current = cocktails.get("Apple Hinny") + 1;
                    cocktails.put("Apple Hinny", current);
                }

            } else if (currentB * currentF == 400) {

                if (!cocktails.containsKey("High Fashion")) {
                    cocktails.put("High Fashion", 1);
                } else {
                    int current = cocktails.get("High Fashion") + 1;
                    cocktails.put("High Fashion", current);
                }
            } else {
                int newValue = currentB + 5;
                bucketQue.offer(newValue);
            }
        }

        int sum = 0;

        if (cocktails.size() == 4) {
//            if (cocktails.get("Pear Sour") >= 4 && cocktails.get("The Harvest") >= 4
//                    && cocktails.get("Apple Hinny") >= 4 && cocktails.get("High Fashion") >= 4) {

            System.out.println("It's party time! The cocktails are ready!");

            if (!bucketQue.isEmpty()) {

                for (int b : bucketQue) {
                    sum += b;
                }
            }


//            if (!freshnessLevelStack.isEmpty()) {
//                for (int f : freshnessLevelStack) {
//                    sum += freshnessLevelStack.pop();
//                }
//            }

//                    for (int i = 0; i < bucketQue.size(); i++) {
//                        sum += bucketQue.poll();
//                    }
//                    for (int i = 0; i < freshnessLevelStack.size(); i++) {
//                        sum += freshnessLevelStack.pop();
//                    }

            if (sum > 0) {
                System.out.printf("Ingredients left: %d%n", sum);
            }
        }
        //}
        else {
            System.out.println("What a pity! You didn't manage to prepare all cocktails.");
            if (!bucketQue.isEmpty()) {

                for (int b : bucketQue) {
                    sum += b;
                }
            }

//            if (!freshnessLevelStack.isEmpty()) {
//                for (int f : freshnessLevelStack) {
//                    sum += freshnessLevelStack.pop();
//                }
//            }

//                for (int i = 0; i <= bucketQue.size(); i++) {
//                    sum += bucketQue.poll();
//                }
//                for (int i = 0; i <= freshnessLevelStack.size(); i++) {
//                    sum += freshnessLevelStack.peek();
//                }

            if (sum > 0) {
                System.out.printf("Ingredients left: %d%n", sum);
            }

            }

        if (cocktails.size() > 0) {
            for (Map.Entry<String, Integer> e : cocktails.entrySet()) {

                System.out.println("# " + e.getKey() + " --> " + e.getValue());
            }
        }
    }
}
