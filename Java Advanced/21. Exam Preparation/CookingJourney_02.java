import java.util.Scanner;

public class CookingJourney_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[size][size];

        for (int i = 0; i < size; i++) {
            matrix[i] = scanner.nextLine().toCharArray();
        }

        int positionRow = -1;
        int positionCol = -1;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                if (matrix[row][col] == 'S') {
                    positionRow = row;
                    positionCol = col;
                }
            }
        }

        int sum = 0;
        String command = scanner.nextLine();

        while (sum < 50) {

            matrix[positionRow][positionCol] = '-';

            if (command.equals("up")) {

                if ((positionRow - 1) >= 0) {
                    if (matrix[positionRow - 1][positionCol] != 'P'
                            && matrix[positionRow - 1][positionCol] != '-') {
                        String price = Character.toString(matrix[positionRow - 1][positionCol]);
                        sum += Integer.parseInt(price);
                        positionRow = positionRow - 1;
                        matrix[positionRow][positionCol] = 'S';

                        if (sum >= 50) {
                            break;
                        }

                    } else if (matrix[positionRow - 1][positionCol] == 'P') {
                        matrix[positionRow - 1][positionCol] = '-';

                        for (int row = 0; row < matrix.length; row++) {
                            for (int col = 0; col < matrix.length; col++) {
                                if (matrix[row][col] == 'P') {
                                    matrix[row][col] = 'S';
                                    positionRow = row;
                                    positionCol = col;
                                }
                            }
                        }

                    } else {
                        positionRow = positionRow - 1;
                        matrix[positionRow][positionCol]  = 'S';
                    }
                } else {
                    System.out.println("Bad news! You are out of the pastry shop.");
                    break;
                }
            } else if (command.equals("down")) {
                if ((positionRow + 1) < matrix.length) {

                    positionRow = positionRow + 1;

                    if (matrix[positionRow][positionCol] != 'P' &&
                    matrix[positionRow][positionCol] != '-') {
                        String price = Character.toString(matrix[positionRow][positionCol]);
                        sum += Integer.parseInt(price);

                        matrix[positionRow][positionCol] = 'S';

                        if (sum >= 50) {
                            break;
                        }

                    } else if (matrix[positionRow][positionCol] == 'P') {

                        matrix[positionRow][positionCol] = '-';
                        for (int row = 0; row < matrix.length; row++) {
                            for (int col = 0; col < matrix.length; col++) {
                                if (matrix[row][col] == 'P') {
                                    matrix[row][col] = 'S';
                                    positionRow = row;
                                    positionCol = col;
                                }
                            }
                        }

                    } else {
                        matrix[positionRow][positionCol] = 'S';
                    }

                } else {
                    System.out.println("Bad news! You are out of the pastry shop.");
                    break;
                }
            } else if (command.equals("left")) {

                if ((positionCol - 1) >= 0) {

                    positionCol = positionCol -1;

                    if (matrix[positionRow][positionCol] != '-'
                    && matrix[positionRow][positionCol] != 'P') {

                        String price = Character.toString(matrix[positionRow][positionCol]);
                        sum += Integer.parseInt(price);
                        matrix[positionRow][positionCol] = 'S';

                        if (sum >= 50) {
                            break;
                        }

                    } else if (matrix[positionRow][positionCol] == 'P') {

                        matrix[positionRow][positionCol] = '-';

                        for (int row = 0; row < matrix.length; row++) {
                            for (int col = 0; col < matrix.length; col++) {
                                if (matrix[row][col] == 'P') {
                                    matrix[row][col] = 'S';
                                    positionRow = row;
                                    positionCol = col;
                                }
                            }
                        }

                    } else {
                        matrix[positionRow][positionCol] = 'S';
                    }

                } else {
                    System.out.println("Bad news! You are out of the pastry shop.");
                    break;
                }

            } else if (command.equals("right")) {

                if (positionCol + 1 < matrix.length) {

                    positionCol = positionCol + 1;

                    if (matrix[positionRow][positionCol] != '-'
                    && matrix[positionRow][positionCol] != 'P') {

                        String price = Character.toString(matrix[positionRow][positionCol]);
                        sum += Integer.parseInt(price);
                        matrix[positionRow][positionCol] = 'S';

                        if (sum >= 50) {
                            break;
                        }

                    } else if (matrix[positionRow][positionCol] == 'P') {

                        matrix[positionRow][positionCol] = '-';

                        for (int row = 0; row < matrix.length; row++) {
                            for (int col = 0; col < matrix.length; col++) {
                                if (matrix[row][col] == 'P') {
                                    matrix[row][col] = 'S';
                                    positionRow = row;
                                    positionCol = col;
                                }
                            }
                        }

                    } else {
                        matrix[positionRow][positionCol] = 'S';
                    }

                } else {
                    System.out.println("Bad news! You are out of the pastry shop.");
                    break;
                }

            }

                command = scanner.nextLine();
        }

        if (sum >= 50) {
            System.out.println("Good news! You succeeded in collecting enough money!");
        }

        System.out.printf("Money: %d%n", sum);

        printMatrix(matrix);

    }

    private static void findSecondP(char[][] matrix, int positionRow, int positionCol) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                if (matrix[row][col] == 'P') {
                    matrix[row][col] = 'S';
                    positionRow = row;
                    positionCol = col;
                }
            }
        }
    }

    public static void printMatrix(char[][] matrix) {
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix.length; c++) {
                System.out.print(matrix[r][c]);
            }
            System.out.println();
        }
    }
}
