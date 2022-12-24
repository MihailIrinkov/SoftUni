import java.util.Scanner;

public class Selling_02_Feb2022 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[size][size];

        for (int i = 0; i < size; i++) {
            matrix[i] = scanner.nextLine().toCharArray();
        }

        int positionR = -1;
        int positionC = -1;

        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix.length; c++) {
                if (matrix[r][c] == 'S') {
                    positionR = r;
                    positionC = c;
                }
            }
        }

        String command = scanner.nextLine();
        int sum = 0;

        while (sum < 50) {
            matrix[positionR][positionC] = '-';

            if (command.equals("up")) {
                if ((positionR - 1) >= 0) {

                    if (matrix[positionR - 1][positionC] != 'O'
                            && matrix[positionR - 1][positionC] != '-') {
                        String client = Character.toString(matrix[positionR - 1][positionC]);
                        sum += Integer.parseInt(client);
                        positionR = positionR - 1;
                        matrix[positionR][positionC] = 'S';

                        if (sum >= 50) {
                            break;
                        }

                    } else if (matrix[positionR - 1][positionC] == 'O') {

                        matrix[positionR - 1][positionC] = '-';

                        int rowO = -1;
                        int colO = -1;

                        for (int r = 0; r < matrix.length; r++) {
                            for (int c = 0; c < matrix.length; c++) {
                                if (matrix[r][c] == 'O') {
                                    rowO = r;
                                    colO = c;
                                }
                            }
                        }

                        matrix[rowO][colO] = 'S';

                        positionR = rowO;
                        positionC = colO;

                    } else {
                        positionR = positionR - 1;
                        matrix[positionR][positionC] = 'S';
                    }
                } else {
                    break;
                }
            } else if (command.equals("down")) {
                if ((positionR + 1) < matrix.length) {

                    if (matrix[positionR + 1][positionC] != 'O'
                            && matrix[positionR + 1][positionC] != '-') {
                        String client = Character.toString(matrix[positionR + 1][positionC]);
                        sum += Integer.parseInt(client);
                        positionR = positionR + 1;
                        matrix[positionR][positionC] = 'S';

                        if (sum >= 50) {
                            break;
                        }

                    } else if (matrix[positionR + 1][positionC] == 'O') {

                        matrix[positionR + 1][positionC] = '-';

                        int rowO = -1;
                        int colO = -1;

                        for (int r = 0; r < matrix.length; r++) {
                            for (int c = 0; c < matrix.length; c++) {
                                if (matrix[r][c] == 'O') {
                                    rowO = r;
                                    colO = c;
                                }
                            }
                        }

                        matrix[rowO][colO] = 'S';

                        positionR = rowO;
                        positionC = colO;

                    } else {
                        positionR = positionR + 1;
                        matrix[positionR][positionC] = 'S';
                    }
                } else {
                    break;
                }
            } else if (command.equals("left")) {

                if ((positionC - 1) >= 0) {

                    if (matrix[positionR][positionC - 1] != 'O'
                            && matrix[positionR][positionC - 1] != '-') {
                        String client = Character.toString(matrix[positionR][positionC - 1]);
                        sum += Integer.parseInt(client);
                        positionC = positionC - 1;
                        matrix[positionR][positionC] = 'S';

                        if (sum >= 50) {
                            break;
                        }

                    } else if (matrix[positionR][positionC - 1] == 'O') {

                        matrix[positionR][positionC - 1] = '-';

                        int rowO = -1;
                        int colO = -1;

                        for (int r = 0; r < matrix.length; r++) {
                            for (int c = 0; c < matrix.length; c++) {
                                if (matrix[r][c] == 'O') {
                                    rowO = r;
                                    colO = c;
                                }
                            }
                        }

                        matrix[rowO][colO] = 'S';

                        positionR = rowO;
                        positionC = colO;

                    } else {
                        positionC = positionC - 1;
                        matrix[positionR][positionC] = 'S';
                    }
                } else {
                    break;
                }

            } else if (command.equals("right")) {

                if ((positionC + 1) >= matrix.length) {
                    break;
                }

                if ((positionC + 1) < matrix.length) {

                    if (matrix[positionR][positionC + 1] != 'O'
                            && matrix[positionR][positionC + 1] != '-') {
                        String client = Character.toString(matrix[positionR][positionC + 1]);
                        sum += Integer.parseInt(client);
                        positionC = positionC + 1;
                        matrix[positionR][positionC] = 'S';

                        if (sum >= 50) {
                            break;
                        }

                    } else if (matrix[positionR][positionC + 1] == 'O') {

                        matrix[positionR][positionC + 1] = '-';

                        int rowO = -1;
                        int colO = -1;

                        for (int r = 0; r < matrix.length; r++) {
                            for (int c = 0; c < matrix.length; c++) {
                                if (matrix[r][c] == 'O') {
                                    rowO = r;
                                    colO = c;
                                }
                            }
                        }

                        matrix[rowO][colO] = 'S';

                        positionR = rowO;
                        positionC = colO;

                    } else {
                        positionC = positionC + 1;
                        matrix[positionR][positionC] = 'S';
                    }
                }
            }

            command = scanner.nextLine();
        }

        if (sum >= 50) {
            System.out.println("Good news! You succeeded in collecting enough money!");
            System.out.printf("Money: %d%n", sum);
        } else {
            System.out.println("Bad news, you are out of the bakery.");
            System.out.printf("Money: %d%n", sum);
        }
        printMatrix(matrix);
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
