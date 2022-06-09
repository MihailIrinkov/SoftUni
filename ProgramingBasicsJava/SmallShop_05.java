import java.util.Scanner;

public class SmallShop_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String product = scanner.nextLine();
        String city = scanner.nextLine();
        Double quantity = Double.parseDouble(scanner.nextLine());

        if (city.equals("Sofia")) {
            switch (product) {
                case "coffee":
                    System.out.println(0.50 * quantity);
                    break;
                case "water":
                    System.out.println(0.80* quantity);
                    break;
                case "beer":
                    System.out.println(1.20* quantity);
                    break;
                case "sweets":
                    System.out.println(1.45* quantity);
                    break;
                case "peanuts":
                    System.out.println(1.60* quantity);
                    break;

            }
        } else if (city.equals("Plovdiv")) {
            switch (product) {
                case "coffee":
                    System.out.println(0.40* quantity);
                    break;
                case "water":
                    System.out.println(0.70* quantity);
                    break;
                case "beer":
                    System.out.println(1.15* quantity);
                    break;
                case "sweets":
                    System.out.println(1.30* quantity);
                    break;
                case "peanuts":
                    System.out.println(1.50* quantity);
                    break;

            }
        } else if (city.equals("Varna")){
            switch (product){
                case "coffee":
                    System.out.println(0.45* quantity);
                    break;
                case "water":
                    System.out.println(0.70* quantity);
                    break;
                case "beer":
                    System.out.println(1.10* quantity);
                    break;
                case "sweets":
                    System.out.println(1.35* quantity);
                    break;
                case "peanuts":
                    System.out.println(1.55* quantity);
                    break;
            }

        }
    }
}
