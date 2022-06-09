import java.util.Scanner;

public class AreaofFigures_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String type = scanner.nextLine();
        Double side = Double.parseDouble(scanner.nextLine());

        if (type.equals("square")) {
            Double area1 = side*side;
            System.out.printf("%.3f", area1);
        } else if (type.equals("rectangle")) {
            Double side2 = Double.parseDouble(scanner.nextLine());
            Double area1 = side * side2;
            System.out.printf("%.3f", area1);

        } else if (type.equals("circle")) {
            Double areaC = Math.pow(side, 2) * Math.PI;
            System.out.printf("%.3f", areaC);
        } else if (type.equals("triangle")){
            Double triangleSide = Double.parseDouble(scanner.nextLine());
            Double triangleArea = (triangleSide * side) / 2;
            System.out.printf("%.3f", triangleArea);
        }

    }
}
