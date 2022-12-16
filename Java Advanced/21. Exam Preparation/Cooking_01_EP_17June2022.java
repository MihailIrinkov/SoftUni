import java.util.*;

public class Cooking_01_EP_17June2022 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input1 = scanner.nextLine().split("\\s++");

        ArrayDeque<Integer> liquidsQue = new ArrayDeque<>();
        for (int i = 0; i < input1.length; i++) {
            int current = Integer.parseInt(input1[i]);
            liquidsQue.offer(current);
        }

        String[] input2 = scanner.nextLine().split("\\s+");
        ArrayDeque<Integer> ingredientsStack = new ArrayDeque<>();
        for (int i = 0; i < input2.length; i++) {
            int current2 = Integer.parseInt(input2[i]);
            ingredientsStack.push(current2);
        }

        Map<String, Integer> foods = new HashMap<>();
        foods.put("Bread", 0);
        foods.put("Cake", 0);
        foods.put("Pastry", 0);
        foods.put("FruitPie", 0);

        while (!liquidsQue.isEmpty() || !ingredientsStack.isEmpty()) {

            if (liquidsQue.isEmpty() || ingredientsStack.isEmpty()) {
                break;
            }

            if ((liquidsQue.peek() + ingredientsStack.peek() == 25)) {
                int newValue = foods.get("Bread") + 1;
                foods.put("Bread", newValue);
                liquidsQue.poll();
                ingredientsStack.pop();
            } else if ((liquidsQue.peek() + ingredientsStack.peek() == 50)) {
                int newValue = foods.get("Cake") + 1;
                foods.put("Cake", newValue);
                liquidsQue.poll();
                ingredientsStack.pop();
            } else if ((liquidsQue.peek() + ingredientsStack.peek() == 75)) {
                int newValue = foods.get("Pastry") + 1;
                foods.put("Pastry", newValue);
                liquidsQue.poll();
                ingredientsStack.pop();
            } else if ((liquidsQue.peek() + ingredientsStack.peek() == 100)) {
                int newValue = foods.get("FruitPie") + 1;
                foods.put("FruitPie", newValue);
                liquidsQue.poll();
                ingredientsStack.pop();
            } else {
                int increase = ingredientsStack.peek() + 3;
                ingredientsStack.pop();
                ingredientsStack.push(increase);
                liquidsQue.poll();
            }

        }

        if (!foods.containsValue(0)) {
            System.out.println("Wohoo! You succeeded in cooking all the food!");
        } else {
            System.out.println
                    ("Ugh, what a pity! You didn't have enough materials to cook everything.");
        }

        if (liquidsQue.isEmpty()) {
            System.out.println("Liquids left: none");
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("Liquids left: ");
            while (!liquidsQue.isEmpty()) {
                sb.append(liquidsQue.poll() + ", ");
            }
            sb.replace(sb.length() - 2, sb.length() - 1, "");
            System.out.println(sb.toString());
        }

        if (ingredientsStack.isEmpty()) {
            System.out.println("Ingredients left: none");
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("Ingredients left: ");
            while (!ingredientsStack.isEmpty()) {
                sb.append(ingredientsStack.pop() + ", ");
            }
            sb.replace(sb.length() - 2, sb.length() - 1, "");
            System.out.println(sb.toString());
        }

        System.out.printf("Bread: %d%n", foods.get("Bread"));
        System.out.printf("Cake: %d%n", foods.get("Cake"));
        System.out.printf("Fruit Pie: %d%n", foods.get("FruitPie"));
        System.out.printf("Pastry: %d%n", foods.get("Pastry"));
    }
}
