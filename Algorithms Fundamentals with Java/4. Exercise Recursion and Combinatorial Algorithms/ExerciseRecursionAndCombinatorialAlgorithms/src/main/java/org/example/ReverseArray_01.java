package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReverseArray_01 {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] elements = reader.readLine().split("\\s+");

        printReverseArray(elements, elements.length - 1);

    }

    private static void printReverseArray(String[] elements, int index) {
        if (index < 0) {
            return;
        }

        System.out.print(elements[index] + " ");
        printReverseArray(elements, index - 1);
    }
}
