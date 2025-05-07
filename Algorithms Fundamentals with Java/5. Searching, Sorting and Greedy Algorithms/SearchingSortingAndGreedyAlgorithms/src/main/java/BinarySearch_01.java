import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] arr = Arrays.stream(scanner.nextLine()
                .split(" "))
                .mapToInt(Integer::parseInt).toArray();

        int key = Integer.parseInt(scanner.nextLine());


        System.out.println(getIndex(arr, key));
    }

    public static int getIndex(int[] arr, int key) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int midle = (start + end) / 2;

            if (key < arr[midle]) {
                end = midle - 1;
            } else if (key > arr[midle]) {
                start = midle + 1;
            } else {
                return midle;
            }
        }

        return -1;
    }
}
