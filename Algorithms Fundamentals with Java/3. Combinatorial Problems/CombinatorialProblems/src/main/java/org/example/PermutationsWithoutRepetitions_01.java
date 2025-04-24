package org.example;

import java.util.Scanner;

public class PermutationsWithoutRepetitions_01 {
    public static String[] elements;
    public static String[] permutes;
    public static boolean[] used;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        elements = scanner.nextLine().split("\\s+");

        permutes = new String[elements.length];
        used = new boolean[elements.length];

        permute(0);
    }

    private static void permute(int index) {
        if (index == elements.length) {
            print(elements);
            return;
        }
//        for (int i = 0; i < elements.length; i++) {
//            if (!used[i]) {
//                used[i] = true;
//                permutes[index] = elements[i];
//                permute(index + 1);
//                used[i] = false;
//            }
//        }

        permute(index + 1);
        for (int i = index + 1; i < elements.length; i++) {
            swap(elements, index, i);
            permute(index + 1);
            swap(elements, index, i);
        }
    }

    private static void swap(String[] arr, int first, int second) {
        String temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    private static void print(String[] arr) {
        System.out.println(String.join(" ", arr));
    }

}
