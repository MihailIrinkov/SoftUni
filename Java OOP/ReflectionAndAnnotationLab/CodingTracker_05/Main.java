package CodingTracker_05;

import java.lang.reflect.Method;

public class Main {
    @Author(name = "George")
    public static void main(String[] args) {

        Class clazz = Tracker.class;

        Method[] methods = clazz.getMethods();

        for (Method method : methods) {
            Author annotation = method.getAnnotation(Author.class);

            if(annotation != null) {
                System.out.println(method.getName() + " " + annotation.name());
            }
        }

        Tracker tracker = new Tracker();

        System.out.println(tracker.toString());

    }
}
