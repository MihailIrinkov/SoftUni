package org.example;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] arr = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }

        System.out.println("Iteration sum: " + sum);

        int recursionSum = recursionSumNumber(arr, 0);

        System.out.println("Recursion sum: " + recursionSum);

    }

    public static int recursionSumNumber(int[] numbers, int index) {
        if (index >= numbers.length) {
            return 0;
        }

        return numbers[index] + recursionSumNumber(numbers, index + 1);
    }
}