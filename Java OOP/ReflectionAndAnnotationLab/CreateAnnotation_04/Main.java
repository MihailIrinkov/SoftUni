package CreateAnnotation_04;

import java.lang.annotation.Annotation;

public class Main {
    public static void main(String[] args) {


        Class a = Reflection.class;

        Annotation[] annotations = a.getAnnotations();

        Annotation annotation = a.getAnnotation(Subject.class);

        System.out.println();
    }
}
