import java.util.Scanner;

public class MouseAndCheese_02_EP_17June2022 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[size][size];

        for (int i = 0; i < size; i++) {
            char[] input = scanner.nextLine().toCharArray();
            matrix[i] = input;
        }

        int rowMouse = -1;
        int colMouse = -1;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                if (matrix[row][col] == 'M') {
                    rowMouse = row;
                    colMouse = col;
                }
            }
        }

        int eatenCheeses = 0;
        String command = scanner.nextLine();

        while (!command.equals("end")) {

            matrix[rowMouse][colMouse] = '-';

            if (command.equals("up")) {
                if ((rowMouse - 1) < 0) {
                    System.out.println("Where is the mouse?");
                    break;
                } else {
                    rowMouse = rowMouse - 1;
                    if (matrix[rowMouse][colMouse] == 'c') {
                        eatenCheeses++;
                        matrix[rowMouse][colMouse] = 'M';
                    } else if (matrix[rowMouse][colMouse] == 'B') {
                        matrix[rowMouse][colMouse] = '-';
                        rowMouse = rowMouse - 1;
                        if (matrix[rowMouse][colMouse] == 'c') {
                            eatenCheeses++;
                        }
                        matrix[rowMouse][colMouse] = 'M';
                    } else {
                        matrix[rowMouse][colMouse] = 'M';
                    }
                }
            } else if (command.equals("down")) {
                if ((rowMouse + 1) >= matrix.length) {
                    System.out.println("Where is the mouse?");
                    break;
                } else {
                    rowMouse = rowMouse + 1;
                    if (matrix[rowMouse][colMouse] == 'c') {
                        eatenCheeses++;
                        matrix[rowMouse][colMouse] = 'M';
                    } else if (matrix[rowMouse][colMouse] == 'B') {
                        matrix[rowMouse][colMouse] = '-';
                        rowMouse = rowMouse + 1;
                        if (matrix[rowMouse][colMouse] == 'c') {
                            eatenCheeses++;
                            matrix[rowMouse][colMouse] = 'M';
                        }
                        matrix[rowMouse][colMouse] = 'M';
                    } else {
                        matrix[rowMouse][colMouse] = 'M';
                    }
                }
            } else if (command.equals("left")) {
                if ((colMouse - 1) < 0) {
                    System.out.println("Where is the mouse?");
                    break;
                } else {
                    colMouse--;
                    if (matrix[rowMouse][colMouse] == 'c') {
                        eatenCheeses++;
                        matrix[rowMouse][colMouse] = 'M';
                    } else if (matrix[rowMouse][colMouse] == 'B') {
                        matrix[rowMouse][colMouse] = '-';
                        colMouse--;
                        if (matrix[rowMouse][colMouse] == 'c') {
                            eatenCheeses++;
                            matrix[rowMouse][colMouse] = 'M';
                        }
                        matrix[rowMouse][colMouse] = 'M';
                    } else {
                        matrix[rowMouse][colMouse] = 'M';
                    }

                }
            } else if (command.equals("right")) {
                if ((colMouse + 1) >= matrix.length) {
                    System.out.println("Where is the mouse?");
                    break;
                } else {
                    colMouse++;
                    if (matrix[rowMouse][colMouse] == 'c') {
                        eatenCheeses++;
                        matrix[rowMouse][colMouse] = 'M';
                    } else if (matrix[rowMouse][colMouse] == 'B') {
                        matrix[rowMouse][colMouse] = '-';
                        colMouse++;
                        if (matrix[rowMouse][colMouse] == 'c') {
                            eatenCheeses++;
                            matrix[rowMouse][colMouse] = 'M';
                        }
                        matrix[rowMouse][colMouse] = 'M';
                    } else {
                        matrix[rowMouse][colMouse] = 'M';
                    }

                }
            }

            command = scanner.nextLine();
        }

        if (eatenCheeses < 5) {
            System.out.printf
                    ("The mouse couldn't eat the cheeses, she needed %d cheeses more.%n"
                            , 5 - eatenCheeses);
        } else {
            System.out.printf("Great job, the mouse is fed %d cheeses!%n", eatenCheeses);
        }

        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix.length; c++) {
                System.out.print(matrix[r][c]);
            }
            System.out.println();
        }
    }
}
