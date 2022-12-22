import java.util.Scanner;

public class Python_02_Sep2021 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        String[] commands = scanner.nextLine().split(", ");

        char[][] matrix = new char[size][size];

        int pythonLength = 1;
        int food = 0;
        boolean kBenemy = false;

        for (int i = 0; i < size; i++) {
            String input = scanner.nextLine().replaceAll("\\s+", "");
            matrix[i] = input.toCharArray();
        }

        int pythonRow = -1;
        int pythonCol = - 1;

        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix.length; c++) {

                if (matrix[r][c] == 's') {
                    pythonRow = r;
                    pythonCol = c;
                } else if (matrix[r][c] == 'f') {
                    food++;
                }
            }
        }

        for (int i = 0; i < commands.length; i++) {
           String command = commands[i];

          // matrix[pythonRow][pythonRow] = '*';

           if (command.equals("up")) {
               if ((pythonRow - 1) >= 0) {
                   pythonRow = pythonRow - 1;

                   if (matrix[pythonRow][pythonCol] == 'e') {
                       kBenemy = true;
                       break;
                   } else if (matrix[pythonRow][pythonCol] == '*') {
                       //matrix[pythonRow][pythonCol] = 's';
                   } else if (matrix[pythonRow][pythonCol] == 'f') {
                      // matrix[pythonRow][pythonCol] = 's';
                       pythonLength++;
                       food--;
                   }

               } else {
                   pythonRow = matrix.length - 1;

                   if (matrix[pythonRow][pythonCol] == 'e') {
                       kBenemy = true;
                       break;
                   } else if (matrix[pythonRow][pythonCol] == '*') {
                       //matrix[pythonRow][pythonCol] = 's';
                   } else if (matrix[pythonRow][pythonCol] == 'f') {
                       //matrix[pythonRow][pythonCol] = 's';
                       pythonLength++;
                       food--;
                   }
               }
           } else if (command.equals("down")) {

               if ((pythonRow + 1) < matrix.length) {

                   pythonRow = pythonRow + 1;

                   if (matrix[pythonRow][pythonCol] == 'e') {
                       kBenemy = true;
                       break;
                   } else if (matrix[pythonRow][pythonCol] == '*') {
                       //matrix[pythonRow][pythonCol] = 's';
                   } else if (matrix[pythonRow][pythonCol] == 'f') {
                      // matrix[pythonRow][pythonCol] = 's';
                       pythonLength++;
                       food--;
                   }

               } else {
                   pythonRow = 0;

                   if (matrix[pythonRow][pythonCol] == 'e') {
                       kBenemy = true;
                       break;
                   } else if (matrix[pythonRow][pythonCol] == '*') {
                      // matrix[pythonRow][pythonCol] = 's';
                   } else if (matrix[pythonRow][pythonCol] == 'f') {
                       //matrix[pythonRow][pythonCol] = 's';
                       pythonLength++;
                       food--;
                   }

               }
           } else if (command.equals("left")) {

               if ((pythonCol - 1) >= 0) {

                   pythonCol = pythonCol - 1;

                   if (matrix[pythonRow][pythonCol] == 'e') {
                       kBenemy = true;
                       break;
                   } else if (matrix[pythonRow][pythonCol] == '*') {
                       //matrix[pythonRow][pythonCol] = 's';
                   } else if (matrix[pythonRow][pythonCol] == 'f') {
                       //matrix[pythonRow][pythonCol] = 's';
                       pythonLength++;
                       food--;
                   }

               } else {

                   pythonCol = matrix.length - 1;

                   if (matrix[pythonRow][pythonCol] == 'e') {
                       kBenemy = true;
                       break;
                   } else if (matrix[pythonRow][pythonCol] == '*') {
                      // matrix[pythonRow][pythonCol] = 's';
                   } else if (matrix[pythonRow][pythonCol] == 'f') {
                      // matrix[pythonRow][pythonCol] = 's';
                       pythonLength++;
                       food--;
                   }

               }

           } else if (command.equals("right")) {

               if ((pythonCol + 1) < matrix.length) {

                   pythonCol = pythonCol + 1;

                   if (matrix[pythonRow][pythonCol] == 'e') {
                       kBenemy = true;
                       break;
                   } else if (matrix[pythonRow][pythonCol] == '*') {
                     //  matrix[pythonRow][pythonCol] = 's';
                   } else if (matrix[pythonRow][pythonCol] == 'f') {
                       //matrix[pythonRow][pythonCol] = 's';
                       pythonLength++;
                       food--;
                   }

               } else {

                   pythonCol = 0;

                   if (matrix[pythonRow][pythonCol] == 'e') {
                       kBenemy = true;
                       break;
                   } else if (matrix[pythonRow][pythonCol] == '*') {
                     //  matrix[pythonRow][pythonCol] = 's';
                   } else if (matrix[pythonRow][pythonCol] == 'f') {
                      // matrix[pythonRow][pythonCol] = 's';
                       pythonLength++;
                       food--;
                   }

               }
           }

           if (food == 0) {
               break;
           }

        }

        if (food == 0) {
            System.out.printf("You win! Final python length is %d", pythonLength);
        } else if (food > 0 && !kBenemy) {
            System.out.printf("You lose! There is still %d food to be eaten.", food);
        }

        if (kBenemy) {
            System.out.println("You lose! Killed by an enemy!");
        }

    }
}
