import java.util.Scanner;

public class VowelsSum_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        int sum = 0;
        for (int position = 0; position <= text.length() - 1; position ++){
            char symbol = text.charAt(position);

            switch(symbol){
                case 'a':
                    sum = sum + 1;
                    break;
                case 'e':
                    sum +=2;
                    break;
                case 'i':
                    sum +=3;
                    break;
                case 'o':
                    sum +=4;
                    break;
                case 'u':
                    sum += 5;
                    break;
            }

        } System.out.println(sum);
    }
}
