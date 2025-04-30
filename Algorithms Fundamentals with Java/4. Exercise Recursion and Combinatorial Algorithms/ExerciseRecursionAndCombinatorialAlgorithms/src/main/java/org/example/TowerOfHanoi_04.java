package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;
import java.util.stream.Collectors;

public class TowerOfHanoi_04 {

    public static Deque<Integer> source = new ArrayDeque<>();
    public static Deque<Integer> spare = new ArrayDeque<>();
    public static Deque<Integer> destination = new ArrayDeque<>();

    public static int steps = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int disc = Integer.parseInt(reader.readLine());

        for (int i = disc; i >= 1 ; i--) {
            source.push(i);
        }

        printRods();
        solve(disc, source, destination, spare);
    }

    private static void solve(int disc, Deque<Integer> source, Deque<Integer> destination, Deque<Integer> spare) {
        if (disc == 1) {
            destination.push(source.pop());
            System.out.println("Step #" + (steps++) + ": Moved disk");
            printRods();
        } else {
            solve(disc - 1, source, spare, destination);
            solve(1, source, destination, spare);
            solve(disc - 1, spare, destination, source);
        }
    }

    public static void printRods() {
        System.out.println(String.format("Source: %s%n" +
                "Destination: %s%n" +
                "Spare: %s%n", formatRod(source), formatRod(destination), formatRod(spare)));
    }

    private static String formatRod(Deque<Integer> stack) {
        return stack.stream()
                .sorted(Comparator.reverseOrder())
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
    }
}
