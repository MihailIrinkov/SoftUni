import java.util.Scanner;

public class ReVolt_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        int commandsCount = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[size][size];
        for (int row = 0; row < size; row++) {
            matrix[row] = scanner.nextLine().toCharArray();
        }

        int currentRow = 0;
        int currentCol = 0;

        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                char currentChar = matrix[r][c];
                if (currentChar == 'f') {
                    currentRow = r;
                    currentCol = c;
                }
            }
        }

        boolean flag = false;

        int counter = 0;
        String command = null;

        while (commandsCount > 0) {
            command = scanner.nextLine();
            commandsCount--;

            if (command.equals("up")) {

                if (currentRow - 1 >= 0) {

                    currentRow = currentRow - 1;
                    if (hasWon(matrix, currentRow, currentCol, command, flag, counter)) break;

                    if (matrix[currentRow][currentCol] == 'B') {
                        if (currentRow - 1 >= 0) {
                            currentRow = currentRow - 1;
                            if (hasWon(matrix, currentRow, currentCol, command, flag, counter)) break;

                        } else {
                            matrix[0][currentCol] = '-';
                            currentRow = matrix.length - 1;
                            matrix[currentRow][currentCol] = 'f';

                        }

                    } else if (matrix[currentRow][currentCol] == 'T') {
                        currentRow = currentRow + 1;
                    }


                    matrix[currentRow + 1][currentCol] = '-';
                    matrix[currentRow][currentCol] = 'f';

                } else {
                    matrix[currentRow][currentCol] = '-';
                    currentRow = matrix.length - 1;
                    if (hasWon(matrix, currentRow, currentCol, command, flag, counter)) break;
                    matrix[currentRow][currentCol] = 'f';
                }


            } else if (command.equals("down")) {

                if (currentRow + 1 < matrix.length) {
                    currentRow = currentRow + 1;
                    if (hasWon(matrix, currentRow, currentCol, command, flag, counter)) break;

                    matrix[currentRow - 1][currentCol] = '-';
                    //matrix[currentRow][currentCol] = 'f';


                    if (matrix[currentRow][currentCol] == 'B') {
                        if (currentRow + 1 < matrix.length) {
                            currentRow = currentRow + 1;

                            if (hasWon(matrix, currentRow, currentCol, command, flag, counter)) break;
                            //matrix[currentRow - 1][currentCol] = '-';
                            matrix[currentRow][currentCol] = 'f';
                        }

                    } else if (matrix[currentRow][currentCol] == 'T') {
                        currentRow = currentRow - 1;
                        matrix[currentRow][currentCol] = 'f';
                        matrix[currentRow + 1][currentCol] = '-';

                    } else {
                        matrix[currentRow - 1][currentCol] = '-';
                        matrix[currentRow][currentCol] = 'f';
                    }


                } else {
                    matrix[currentRow][currentCol] = '-';

                    currentRow = 0;
                    matrix[currentRow][currentCol] = 'f';
                    if (hasWon(matrix, currentRow, currentCol, command, flag, counter)) break;
                }


            } else if (command.equals("left")) {
                if (currentCol - 1 >= 0) {
                    currentCol = currentCol - 1;

                    if (hasWon(matrix, currentRow, currentCol, command, flag, counter)) break;

                    if (matrix[currentRow][currentCol] == 'B') {
                        if (currentCol - 1 >= 0) {
                            currentCol = currentCol - 1;

                            if (hasWon(matrix, currentRow, currentCol, command, flag, counter)) break;
                            matrix[currentRow][currentCol + 1] = '-';
                            matrix[currentRow][currentCol] = 'f';
                        } else {
                            matrix[currentRow][currentCol + 1] = '-';
                            currentCol = matrix.length - 1;
                            if (hasWon(matrix, currentRow, currentCol, command, flag, counter)) break;

                            matrix[currentRow][currentCol] = 'f';
                        }

                    } else if (matrix[currentRow][currentCol] == 'T') {
                        currentCol = currentCol + 1;
//                        matrix[currentRow][currentCol] = 'f';
//                        matrix[currentRow][currentCol     ] = '-';

                    } else {
                        matrix[currentRow][currentCol + 1] = '-';
                        matrix[currentRow][currentCol] = 'f';
                    }

//                    matrix[currentRow][currentCol + 1] = '-';
//                    matrix[currentRow][currentCol] = 'f';
                } else {
                    currentCol = matrix.length - 1;
                    if (hasWon(matrix, currentRow, currentCol, command, flag, counter)) break;


                    matrix[currentRow][currentCol] = 'f';
                    matrix[currentRow][0] = '-';

                }


            } else if (command.equals("right")) {

                if (currentCol + 1 < matrix.length) {
                    currentCol = currentCol + 1;

                    if (hasWon(matrix, currentRow, currentCol, command, flag,counter)) break;

                    if (matrix[currentRow][currentCol] == 'B') {
                        if (currentCol + 1 < matrix.length) {
                            currentRow = currentRow + 1;

                            if (hasWon(matrix, currentRow, currentCol, command, flag, counter)) break;
                            matrix[currentRow][currentCol - 1] = '-';
                            matrix[currentRow][currentCol] = 'f';
                        } else {
                            matrix[currentRow][currentCol] = '-';
                            if (hasWon(matrix, currentRow, currentCol, command, flag, counter)) break;
                            currentCol = 0;
                            matrix[currentRow][currentCol] = 'f';
                        }

                    } else if (matrix[currentRow][currentCol] == 'T') {
                        currentCol = currentCol - 1;
//                        matrix[currentRow][currentCol] = 'f';
//                        matrix[currentRow][currentCol     ] = '-';

                    } else {
                        matrix[currentRow][currentCol - 1] = '-';
                        matrix[currentRow][currentCol] = 'f';
                    }

                } else {
                    currentCol = 0;
                    if (hasWon(matrix, currentRow, currentCol, command, flag, counter)) break;


                    matrix[currentRow][currentCol] = 'f';
                    matrix[currentRow][matrix.length - 1] = '-';

                }


            }
        }
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                char currentChar = matrix[r][c];
                if (currentChar == 'F') {
                    counter++;
                }
            }
        }
        if (counter != 0) {
            System.out.println("Player lost!");
            printMatrix(matrix);
        }

    }

    private static boolean hasWon(char[][] matrix, int currentRow, int currentCol, String command, boolean flag, int counter) {
        if (matrix[currentRow][currentCol] == 'F') {
            matrix[currentRow][currentCol] = 'f';
            flag = true;
            counter++;
            switch (command) {
                case "up":
                    if ((currentRow +1) < matrix.length) {
                        matrix[currentRow + 1][currentCol] = '-';
                    } else {
                        matrix[0][currentCol] = '-';
                    }
                    break;
                case "down":
                    if ((currentRow - 1) >= 0) {
                        matrix[currentRow - 1][currentCol] = '-';
                    } else {
                        matrix[0][currentCol] = '-';
                    }

                    break;
                case "left":
                    if ((currentCol - 1) >= 0) {
                        matrix[currentRow][currentCol - 1] = '-';
                    } else {
                        matrix[currentRow][0] = '-';
                    }

                    break;
                case "right":
                    if ((currentCol + 1) < matrix.length) {
                        matrix[currentRow][currentCol + 1] = '-';
                    } else {
                        matrix[currentRow][matrix.length - 1] = '-';
                    }

                    break;
            }
            System.out.println("Player won!");
            printMatrix(matrix);
            return true;
        }
        return false;
    }

    public static void printMatrix(char[][] matrix) {
        for (char[] chars : matrix) {
            for (char c : chars) {
                System.out.print(c);
            }
            System.out.println();
        }
    }
}
