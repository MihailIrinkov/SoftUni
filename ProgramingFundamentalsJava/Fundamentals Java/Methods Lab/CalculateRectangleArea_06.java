import java.util.Scanner;

public class CalculateRectangleArea_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int width = Integer.parseInt(scanner.nextLine());
        int length = Integer.parseInt(scanner.nextLine());

        System.out.println(rectangleArea(width, length));


    }

    public static int rectangleArea(int widthInput, int lengthInput) {
        int area = widthInput * lengthInput;
        return area;

    }
}
