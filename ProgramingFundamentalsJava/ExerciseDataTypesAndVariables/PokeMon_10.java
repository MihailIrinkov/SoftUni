import java.util.Scanner;

public class PokeMon_10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int distance = Integer.parseInt(scanner.nextLine());
        int exhaustionFactor = Integer.parseInt(scanner.nextLine());
        int counter = 0;
        int pokePower = n;
        while (pokePower >= distance) {
            pokePower -= distance;
            counter++;

            if (pokePower == n * 0.5) {
                if (exhaustionFactor > 0) {
                    pokePower = pokePower / exhaustionFactor;
                }
            }
        }
        System.out.println(pokePower);
        System.out.println(counter);
    }
}
