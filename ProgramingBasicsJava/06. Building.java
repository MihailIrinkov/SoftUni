import java.util.Scanner;

public class Building_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int floors = Integer.parseInt(scanner.nextLine()); //брой етажи
        int rooms = Integer.parseInt(scanner.nextLine()); //брой на стаите на всеки етаж

        //за всеки етаж от последния към първия -> повтарям: обхождаме всички стаи на етажа
        for (int floor = floors; floor >= 1 ; floor--) { //номер на етажа
            //всички стаи: 0 до rooms - 1 -> повтарям: името на стаята
            for (int room = 0; room <= rooms - 1; room++) { //номер на стая
                //проверка на етажа
                //последен
                if (floor == floors) {
                    System.out.print("L" + floor + room + " ");
                }
                //четен
                else if (floor % 2 == 0) {
                    System.out.print("O" + floor + room + " ");
                }
                //нечетен
                else {
                    System.out.print("A" + floor + room + " ");
                }
            }
            System.out.println();
        }
    }
}