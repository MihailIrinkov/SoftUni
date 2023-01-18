package PointInRectangle_02;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] input = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer :: parseInt).toArray();

        int bottomLeftX = input[0];
        int bottomLeftY = input[1];
        int topRightX = input[2];
        int topRightY = input[3];

        int n = Integer.parseInt(scanner.nextLine());

        Point bottomLeft = new Point(bottomLeftX, bottomLeftY);
        Point topRight = new Point(topRightX, topRightY);

        Rectangle rectangle = new Rectangle(bottomLeft, topRight);

        for (int i = 0; i < n; i++) {

            int[] coordinatesPoints = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer :: parseInt).toArray();

            int x = coordinatesPoints[0];
            int y = coordinatesPoints[1];

            Point checkPoint = new Point(x, y);

            System.out.println(rectangle.contains(checkPoint));
        }


    }
}
