import java.util.Scanner;

public class Vacation_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberPeople = Integer.parseInt(scanner.nextLine());
        String typePeople = scanner.nextLine();
        String day = scanner.nextLine();
        double price = 0;

        switch (typePeople) {
            case "Students":
                if (day.equals("Friday") && numberPeople >= 30) {
                    price = (numberPeople * 8.45) * 0.85;
                } else if (day.equals("Friday") && numberPeople < 30) {
                    price = numberPeople * 8.45;
                } else if (day.equals("Saturday") && numberPeople >= 30) {
                    price = (numberPeople * 9.80) * 0.85;
                } else if ((day.equals("Saturday") && numberPeople < 30)) {
                    price = numberPeople * 9.80;
                } else if (day.equals("Sunday") && numberPeople >= 30) {
                    price = (numberPeople * 10.46) * 0.85;
                } else if (day.equals("Sunday") && numberPeople < 30) {
                    price = numberPeople * 10.46;
                }

                break;
                case "Business":


                    if (day.equals("Friday") && numberPeople >= 100) {
                        price = (numberPeople - 10) * 10.90;
                    } else if (day.equals("Friday") && numberPeople < 100) {
                        price = numberPeople * 10.90;
                    } else if (day.equals("Saturday") && numberPeople >= 100) {
                        price = (numberPeople - 10) * 15.60;
                    } else if ((day.equals("Saturday") && numberPeople < 100)) {
                        price = numberPeople * 15.60;
                    } else if (day.equals("Sunday") && numberPeople >= 100) {
                        price = (numberPeople - 10) * 16;
                    } else if (day.equals("Sunday") && numberPeople < 100) {
                        price = numberPeople * 16;
                    }


                    break;
            case "Regular":


                if (day.equals("Friday") && numberPeople >= 10 && numberPeople <= 20) {
                    price = (numberPeople * 15) * 0.95;
                } else if (day.equals("Friday")) {
                    price = numberPeople * 15;
                } else if (day.equals("Saturday") && numberPeople >= 10 && numberPeople <= 20) {
                    price = (numberPeople * 20) * 0.95;
                } else if (day.equals("Saturday")) {
                    price = numberPeople * 20;
                } else if (day.equals("Sunday") && numberPeople >= 10 && numberPeople <= 20) {
                    price = (numberPeople * 22.50) * 0.95;
                } else if (day.equals("Sunday")) {
                    price = numberPeople * 22.50;
                }


                break;
        }
        System.out.printf("Total price: %.2f", price);
    }
}
