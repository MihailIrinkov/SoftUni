package BlackBoxInteger_02.blackBoxInteger;

import java.lang.reflect.*;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {

        Scanner scanner = new Scanner(System.in);

        Class<BlackBoxInt> clazz = BlackBoxInt.class;

        String input = scanner.nextLine();

        Constructor<BlackBoxInt> constructor = clazz.getDeclaredConstructor();
        constructor.setAccessible(true);
        BlackBoxInt blackBoxInt = constructor.newInstance();
        Field innerValue = clazz.getDeclaredField("innerValue");

        while (!input.equals("END")) {
            String commandName = input.split("_")[0];
            int number = Integer.parseInt(input.split("_")[1]);

            switch (commandName) {
                case "add":
                    extracted(clazz, blackBoxInt, innerValue, number, "add");
                    break;
                case "subtract":
                    extracted(clazz, blackBoxInt, innerValue, number, "subtract");
                    break;
                case "divide":
                    extracted(clazz, blackBoxInt, innerValue, number, "divide");
                    break;
                case "multiply":
                    extracted(clazz, blackBoxInt, innerValue, number, "multiply");
                    break;
                case "rightShift":
                    extracted(clazz, blackBoxInt, innerValue, number, "rightShift");
                    break;
                case "leftShift":
                    extracted(clazz, blackBoxInt, innerValue, number, "leftShift");
                    break;
            }


            input = scanner.nextLine();
        }

    }

    private static void extracted(Class<BlackBoxInt> clazz, BlackBoxInt blackBoxInt, Field innerValue, int number, String command) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        List<Method> methods = Arrays.asList(clazz.getDeclaredMethods());
        Method searchedMethod = null;

        for (Method method : methods) {
            if(method.getName().equals(command)) {
                searchedMethod = method;
                break;
            }
        }


        searchedMethod.setAccessible(true);
        searchedMethod.invoke(blackBoxInt, number);
        innerValue.setAccessible(true);
        System.out.println(innerValue.get(blackBoxInt));
    }
}
