package MathForKids;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import static java.lang.System.out;

public class MathForKids {

    public static void main(String[] args) throws FileNotFoundException {

        Random random = new Random();

        int one = random.nextInt(20);

        int two = random.nextInt(20);

//        String inputFile = "C:\\Users\\HP\\Desktop\\Java OPP\\IntelliJOPP\\ReflectionAndAnnotationExercise\\src\\MathForKids";
//        //String outputFile = "C:\\Users\\HP\\Desktop\\Java OPP\\IntelliJOPP\\ReflectionAndAnnotationExercise\\src\\MathForKidsOutput";
//
//        Scanner reader = new Scanner(new FileInputStream(inputFile));
//        String currentRead = reader.toString();
//        Integer sumOfTasks = Integer.parseInt(currentRead);


//        int oneByte = 0;
//        while ((oneByte = inputFile.read()) >= 0) {
//            if (oneByte == 10 || oneByte == 32) {
//                out.write(oneByte);
//            } else {
//                String digits = String.valueOf(oneByte);
//                for (int i = 0; i < digits.length(); i++)
//                    out.write(digits.charAt(i));
//            }
//        }



        if ((one - two) >= 0) {

            out.println(one + " - " + two + " = ?");

        } else {

            out.println(one + " + " + two + " = ?");

        }

//        System.out.println("Решени задачи " + sumOfTasks);
//
//
//
//        sumOfTasks++;
//
//        PrintWriter printWriter = new PrintWriter(inputFile);

    }
}
