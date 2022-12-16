import java.util.*;

public class Exam14December2022 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] food = scanner.nextLine().split(", ");
        String[] stamina = scanner.nextLine().split(", ");

        ArrayDeque<Integer> foodStack = new ArrayDeque<>();
        ArrayDeque<Integer> staminaQue = new ArrayDeque<>();

        for (int i = 0; i < food.length; i++) {
            int current = Integer.parseInt(food[i]);
            foodStack.push(current);
        }

        for (int i = 0; i < stamina.length; i++) {
            int current1 = Integer.parseInt(stamina[i]);
            staminaQue.offer(current1);
        }

//        Map<String, Integer> peaks = new LinkedHashMap<>();
//        peaks.put("Vihren", 80);
//        peaks.put("Kutelo", 90);
//        peaks.put("Banski Suhodol", 100);
//        peaks.put("Polezhan", 60);
//        peaks.put("Kamenitza", 70);

//        List<String> peaks = new ArrayList<>();
//        peaks.add("Vihren");
//        peaks.add("Kutelo");
//        peaks.add("Banski Suhodol");
//        peaks.add("Polezhan");
//        peaks.add("Kamenitza");


        ArrayDeque<String> peaks = new ArrayDeque<>();
        peaks.offer("Vihren");
        peaks.offer("Kutelo");
        peaks.offer("Banski Suhodol");
        peaks.offer("Polezhan");
        peaks.offer("Kamenitza");

        Set<String> conqueredPeaks = new LinkedHashSet<>();

        int days = 7;

        while (!peaks.isEmpty() && days > 0 && !foodStack.isEmpty() && !staminaQue.isEmpty()) {
            int vihrenC = 0;
            int kutletoC = 0;
            int banskiC = 0;
            int polezhanC = 0;
            int kamanitzaC = 0;

            int sum = foodStack.peek() + staminaQue.peek();

            String currentPeak = peaks.peek();

            if (currentPeak.equals("Vihren")) {
                if (sum >= 80 && vihrenC < 2) {
                    peaks.poll();
                    foodStack.pop();
                    staminaQue.poll();
                    conqueredPeaks.add("Vihren");
                } else if (sum < 80 && vihrenC < 2) {

                    foodStack.pop();
                    staminaQue.poll();
                    vihrenC++;

                } else if (vihrenC > 1) {
                    String unPeak = peaks.poll();
                    peaks.offer(unPeak);

                    foodStack.pop();
                    staminaQue.poll();

                }
            } else if (currentPeak.equals("Kutelo")) {
                if (sum >= 90 && kutletoC < 2) {
                    peaks.poll();
                    foodStack.pop();
                    staminaQue.poll();
                    conqueredPeaks.add("Kutelo");
                } else if (sum < 90 && kutletoC < 2) {

                    foodStack.pop();
                    staminaQue.poll();
                    kutletoC++;

                } else if (kutletoC > 1) {
                    String unPeak = peaks.poll();
                    peaks.offer(unPeak);

                    foodStack.pop();
                    staminaQue.poll();

                }

            } else if (currentPeak.equals("Banski Suhodol")) {

                if (sum >= 100) {
                    peaks.poll();
                    foodStack.pop();
                    staminaQue.poll();
                    conqueredPeaks.add("Banski Suhodol");
                } else if (sum < 100 && banskiC < 2) {

                    foodStack.pop();
                    staminaQue.poll();
                    banskiC++;

                } else if (banskiC > 1) {
                    String unPeak = peaks.poll();
                    peaks.offer(unPeak);

                    foodStack.pop();
                    staminaQue.poll();

                }

            } else if (currentPeak.equals("Polezhan")) {

                if (sum >= 60) {
                    peaks.poll();
                    foodStack.pop();
                    staminaQue.poll();
                    conqueredPeaks.add("Polezhan");
                } else if (sum < 60 && polezhanC < 2) {

                    foodStack.pop();
                    staminaQue.poll();
                    polezhanC++;

                } else if (polezhanC > 1) {
                    String unPeak = peaks.poll();
                    peaks.offer(unPeak);

                    foodStack.pop();
                    staminaQue.poll();

                }

            } else if (currentPeak.equals("Kamenitza")) {

                if (sum >= 70) {
                    peaks.poll();
                    foodStack.pop();
                    staminaQue.poll();
                    conqueredPeaks.add("Kamenitza");
                } else if (sum < 70 && kamanitzaC < 2) {

                    foodStack.pop();
                    staminaQue.poll();
                    kamanitzaC++;

                } else if (kamanitzaC > 1) {
                    String unPeak = peaks.poll();
                    peaks.offer(unPeak);

                    foodStack.pop();
                    staminaQue.poll();

                }


                days--;
            }

        }

        if (conqueredPeaks.size() == 5) {
            System.out.println("Alex did it! He climbed all top five Pirin peaks in one week -> @FIVEinAWEEK");
            System.out.println("Conquered peaks:");

            for (String s : conqueredPeaks) {
                System.out.println(s);
            }

        } else {
            System.out.println("Alex failed! He has to organize his journey better next time -> @PIRINWINS");

            if (conqueredPeaks.size() > 0) {

                System.out.println("Conquered peaks:");

                for (String s : conqueredPeaks) {
                    System.out.println(s);
                }
            }
        }

    }
}
