package Telephony_05;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<String> numbers = new ArrayList<>();
        List<String> urls = new ArrayList<>();

        String[] inputNumbers = scanner.nextLine().split(" ");
        String[] inputUrls = scanner.nextLine().split(" ");

        for (int i = 0; i < inputNumbers.length; i++) {
            numbers.add(inputNumbers[i]);
        }

        for (int i = 0; i < inputUrls.length; i++) {
            urls.add(inputUrls[i]);
        }

        Smartphone smartphone = new Smartphone(numbers, urls);
        System.out.println(smartphone.call());
        System.out.println(smartphone.browse());
    }
}
