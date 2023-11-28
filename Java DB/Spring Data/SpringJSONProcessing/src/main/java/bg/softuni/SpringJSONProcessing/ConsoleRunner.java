package bg.softuni.SpringJSONProcessing;

import bg.softuni.SpringJSONProcessing.dto.StudentDTO;
import bg.softuni.SpringJSONProcessing.services.CourseServiceImpl;
import bg.softuni.SpringJSONProcessing.services.StudentServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ConsoleRunner implements CommandLineRunner {

    private StudentServiceImpl studentServiceImpl;
    private CourseServiceImpl courseService;

    public ConsoleRunner(StudentServiceImpl studentServiceImpl, CourseServiceImpl courseService) {
        this.studentServiceImpl = studentServiceImpl;
        this.courseService = courseService;
    }

    @Override
    public void run(String... args) throws Exception {

        new StudentDTO(
                "First",
                20,
                false,
                List.of("Math", "Biology"));

        String studentJson = """
                {
                "firstName": "first",
                "age": 22,
                "isGraduated": false,
                "coursesTaken": [
                "Math", "Biology"
                ]
                }
                """;

        studentServiceImpl.create(studentJson);

        String courseJson = """
                {
                "name": "Math",
                "lengthInWeeks": 12
                }
                """;

        courseService.createCourse(courseJson);
    }
}
