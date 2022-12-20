import java.util.Scanner;

public class NavyBattle_02_14_12_Exam {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[size][size];

        for (int i = 0; i < size; i++) {
            char[] input = scanner.nextLine().toCharArray();
            matrix[i] = input;
        }

        int subRow = -1;
        int subCol = -1;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                if (matrix[row][col] == 'S') {
                    subRow = row;
                    subCol = col;
                }
            }
        }

        String command = scanner.nextLine();

        int destroyedCruisers = 0;
        int minesHits = 0;

        while (destroyedCruisers < 3 && minesHits < 3) {

            matrix[subRow][subCol] = '-';

            if (command.equals("up")) {

                subRow = subRow - 1;

                if (matrix[subRow][subCol] == '*') {
                    matrix[subRow][subCol] = 'S';
                    minesHits++;
                } else if (matrix[subRow][subCol] == 'C') {
                    matrix[subRow][subCol] = 'S';
                    destroyedCruisers++;
                }

            } else if (command.equals("down")) {

                subRow = subRow + 1;

                if (matrix[subRow][subCol] == '*') {
                    matrix[subRow][subCol] = 'S';
                    minesHits++;
                } else if (matrix[subRow][subCol] == 'C') {
                    matrix[subRow][subCol] = 'S';
                    destroyedCruisers++;
                }

            } else if (command.equals("left")) {

                subCol = subCol - 1;

                if (matrix[subRow][subCol] == '*') {
                    matrix[subRow][subCol] = 'S';
                    minesHits++;
                } else if (matrix[subRow][subCol] == 'C') {
                    matrix[subRow][subCol] = 'S';
                    destroyedCruisers++;
                }


            } else if (command.equals("right")) {
                subCol = subCol + 1;

                if (matrix[subRow][subCol] == '*') {
                    matrix[subRow][subCol] = 'S';
                    minesHits++;
                } else if (matrix[subRow][subCol] == 'C') {
                    matrix[subRow][subCol] = 'S';
                    destroyedCruisers++;
                }

            }

            if (destroyedCruisers == 3 || minesHits == 3) {
                break;
            }

            command = scanner.nextLine();
        }

        if (destroyedCruisers == 3) {
            System.out.println("Mission accomplished, U-9 has destroyed all battle cruisers of the enemy!");
        } else if (minesHits == 3) {
            System.out.printf("Mission failed, U-9 disappeared! Last known coordinates [%d, %d]!%n", subRow, subCol);
        }












        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix.length; c++) {
                System.out.print(matrix[r][c]);
            }
            System.out.println();
        }
    }
}
