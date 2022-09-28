import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Race_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> racersNames = Arrays.stream(scanner.nextLine().split(", "))
                .collect(Collectors.toList());
        Map<String, Integer> racersDistances = new LinkedHashMap<>();
        racersNames.forEach(name -> racersDistances.put(name, 0));
        String regexLetter = "[A-Za-z]+";
        Pattern patternLetter = Pattern.compile(regexLetter);

        String regexDigit = "[0-9]";
        Pattern patternDigit = Pattern.compile(regexDigit);


        String input = scanner.nextLine();


        while (!input.equals("end of race")) {
            StringBuilder nameBuilder = new StringBuilder();
            Matcher matcherLetter = patternLetter.matcher(input);
            while (matcherLetter.find()) {
                nameBuilder.append(matcherLetter.group());
            }

            int distance = 0;
            Matcher matcherDigit = patternDigit.matcher(input);
            while (matcherDigit.find()) {
                distance = distance + Integer.parseInt(matcherDigit.group());
            }

            String racerName = nameBuilder.toString();
            if (racersDistances.containsKey(racerName)) {
                int currentDistance = racersDistances.get(racerName);
                racersDistances.put(racerName, distance + currentDistance);
            }


            input = scanner.nextLine();
        }

        List<String> nameOfFirstThree = racersDistances.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(3)
                .map(entry -> entry.getKey())
                .collect(Collectors.toList());

        System.out.printf("1st place: %s%n", nameOfFirstThree.get(0));
        System.out.printf("2nd place: %s%n", nameOfFirstThree.get(1));
        System.out.printf("3rd place: %s%n", nameOfFirstThree.get(2));
    }
}
