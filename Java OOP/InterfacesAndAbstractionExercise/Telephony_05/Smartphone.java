package Telephony_05;

import java.util.List;

public class Smartphone implements Callable, Browsable {
    private List<String> numbers;
    private List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }
    @Override
    public String browse() {
        StringBuilder sb = new StringBuilder();

        for (String url : this.urls) {
            if (isDigit(url)) {
                sb.append("Invalid URL!");
                sb.append(System.lineSeparator());
            } else {
                sb.append(String.format("Browsing: %s!%n", url));
            }
        }

        return sb.toString().trim();
    }

    @Override
    public String call() {
        StringBuilder sb = new StringBuilder();

        for (String n : this.numbers) {

            if (isOnlyDigits(n)) {
                sb.append(String.format("Calling... %s%n", n));
            } else {
                sb.append("Invalid number!");
                sb.append(System.lineSeparator());
            }
        }

        return sb.toString().trim();
    }
    public boolean isDigit(String url) {

        for (char c : url.toCharArray()) {
            if (Character.isDigit(c)) {
                return true;
            }
        }

        return false;
    }

    public boolean isOnlyDigits(String number) {

        for (char c : number.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }

        return true;
    }
}
