package CodingTracker_05;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Tracker {
    @Author(name = "Peter")
    public static void printMethodsByAuthor(Class<?> cl) {
        Map<String, List<String>> methodByAuthor = new HashMap<>();

        Method[] methods = cl.getDeclaredMethods();

        for (Method m : methods) {
            Author annotation = m.getAnnotation(Author.class);

            if (annotation != null) {
                methodByAuthor.putIfAbsent(annotation.name(), new ArrayList<>());
                methodByAuthor.get(annotation.name()).add(m.getName() + "()");
            }
        }


    }

    public static void print(Map<String, List<String>> map) {
        map.entrySet().forEach(entry -> System.out.println(entry.getValue()));
    }

}
