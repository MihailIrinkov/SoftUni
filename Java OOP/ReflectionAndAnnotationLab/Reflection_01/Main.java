package Reflection_01;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        Class reflection = Reflection.class;
        System.out.println(reflection);
        System.out.println(reflection.getSuperclass());
        Class superClass = reflection.getSuperclass();
       // System.out.println(superClass);

        Class[] interfaces = reflection.getInterfaces();
        Arrays.stream(interfaces).forEach(System.out::println);

        Object reflectionObject = reflection.getDeclaredConstructor().newInstance();

        System.out.println(reflectionObject);
    }
}
