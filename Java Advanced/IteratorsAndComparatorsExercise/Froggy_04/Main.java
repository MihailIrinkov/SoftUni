package Froggy_04;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] stones = Arrays.stream(scanner.nextLine().split(", +"))
                .mapToInt(Integer::parseInt).toArray();

        Lake lake = new Lake(stones);

        StringBuilder sb = new StringBuilder();

        for (Integer integer : lake) {
            sb.append(integer).append(", ");
        }

        System.out.println(sb.toString().substring(0, sb.toString().lastIndexOf(",")));
    }
}
