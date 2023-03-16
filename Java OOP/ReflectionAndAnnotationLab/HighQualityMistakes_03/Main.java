package HighQualityMistakes_03;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {

        Field[] fields = Reflection.class.getDeclaredFields();

        Arrays.stream(fields)
                .filter(f -> !Modifier.isPrivate(f.getModifiers()))
                .sorted(Comparator.comparing(Field -> Field.getName()))
                .forEach(f -> System.out.printf("%s must be private!%n", f.getName()));

        Method[] methods = Reflection.class.getDeclaredMethods();

        Arrays.stream(methods).filter(g -> g.getName().startsWith("get")
        && g.getParameterCount() == 0).filter(g -> !Modifier.isPublic(g.getModifiers()))
                .sorted(Comparator.comparing(Method::getName))
                .forEach(g -> System.out.printf("%s have to be public!%n", g.getName()));

        Arrays.stream(methods).filter(s -> s.getName().startsWith("set")
        && s.getParameterCount() == 1).filter(s -> !Modifier.isPrivate(s.getModifiers()))
                .sorted(Comparator.comparing(Method::getName))
                .forEach(s -> System.out.printf("%s have to be private!%n", s.getName()));
    }
}
