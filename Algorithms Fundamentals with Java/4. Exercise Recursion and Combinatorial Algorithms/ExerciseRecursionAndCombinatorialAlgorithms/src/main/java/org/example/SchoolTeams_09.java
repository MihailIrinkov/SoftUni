package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SchoolTeams_09 {

    public static String[] girls;
    public static String[] girlsCombination = new String[3];
    public static String[] boys;
    public static String[] boysCombination = new String[2];

    public static List<String> allGirls = new ArrayList<>();
    public static List<String> allBoys = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        girls = scanner.nextLine().split(", ");
        boys = scanner.nextLine().split(", ");

        combineGirls(0, 0);
        combineBoys(0, 0);

        for (String allGirl : allGirls) {
            for (String allBoy : allBoys) {
                System.out.println(allGirl + ", " + allBoy);
            }
        }
    }

    private static void combineGirls(int index, int start) {
        if (index == girlsCombination.length) {
            allGirls.add(String.join(", ", girlsCombination));
        } else {
            for (int i = start; i < girls.length; i++) {
                girlsCombination[index] = girls[i];
                combineGirls(index + 1, i + 1);
            }
        }
    }

    private static void combineBoys(int index, int start) {
        if (index == boysCombination.length) {
            allBoys.add(String.join(", ", boysCombination));
        } else {
            for (int i = start; i < boys.length; i++) {
                boysCombination[index] = boys[i];
                combineBoys(index + 1, i + 1);
            }
        }
    }
}
