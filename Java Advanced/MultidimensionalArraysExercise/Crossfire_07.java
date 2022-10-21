import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Crossfire_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int rows = Integer.parseInt(input.split(" ")[0]);
        int cols = Integer.parseInt(input.split(" ")[0]);

        int num = 1;

        //int[][] matrix = new int[rows][cols];
        List<List<Integer>> matrix = new ArrayList<>();

        for (int row = 0; row < rows; row++) {
            matrix.add(new ArrayList<>());
            for (int col = 0; col < cols; col++) {
                matrix.get(row).add(num++);

            }
        }

        String command = scanner.nextLine();

        while (!command.equals("Nuke it from orbit")) {

            int rowD = Integer.parseInt(command.split(" ")[0]);
            int colD = Integer.parseInt(command.split(" ")[1]);
            int radius = Integer.parseInt(command.split(" ")[2]);

            for (int elementToRemoveR = rowD - radius; elementToRemoveR <= rowD + radius; elementToRemoveR++) {

                if (isValid(matrix, colD, elementToRemoveR)) {

                    matrix.get(elementToRemoveR).remove(colD);

                }
            }

            for (int elementToRemoveC = colD - radius; elementToRemoveC <= colD + radius; elementToRemoveC++) {


                if (isValid(matrix, rowD, elementToRemoveC)) {

                    matrix.get(rowD).remove(elementToRemoveC);

                }

            }

            //List<Integer> list = new ArrayList<>();
//            for (int row = rowD; row < radius; row++) {
//                if (row <= rows){
//
//                    for (int i = 0; i < matrix[row].length; i++) {
//                        list.add(matrix[row]);
//                    }
//                }
//
//                for (int col = colD; col < radius; col++) {
//                    if(col <= cols){
//                        list.remove(col);
//                    } else {
//                        for (int index = colD; index >= 0; index--) {
//                            list.remove(index);
//
//                        }
//                    }
//                }
//
//            }

            matrix.removeIf(List::isEmpty);

            command = scanner.nextLine();

        }

        for (List<Integer> row : matrix) {
            for (int element : row) {
                System.out.print(element + " ");

            }
            System.out.println();

        }

    }

    private static boolean isValid(List<List<Integer>> matrix, int elementToRemoveR, int elementToRemoveC) {
        return elementToRemoveR >= 0 && elementToRemoveR < matrix.size() && elementToRemoveC >= 0 && elementToRemoveC < matrix.get(elementToRemoveR).size();

    }
}
