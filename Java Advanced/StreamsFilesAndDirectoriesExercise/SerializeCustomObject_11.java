import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class SerializeCustomObject_11 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Course course = new Course();
        course.name = "Java Advance Sep 2022";
        course.numberOfStudents = 250;

        ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(".idea/resources/04. Java-Advanced-Files-and-Streams-Exercises-Resources/Exercises Resources/courses.ser"));
        ObjectInputStream input = new ObjectInputStream(Files.newInputStream(Path.of(".idea/resources/04. Java-Advanced-Files-and-Streams-Exercises-Resources/Exercises Resources/courses.ser")));

        output.writeObject(course);

        Course courseFromFile = (Course) input.readObject();
        System.out.println(courseFromFile.numberOfStudents);
        System.out.println(courseFromFile.name);

    }
}
