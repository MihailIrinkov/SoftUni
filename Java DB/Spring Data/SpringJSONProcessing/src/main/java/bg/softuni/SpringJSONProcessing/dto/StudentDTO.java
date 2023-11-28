package bg.softuni.SpringJSONProcessing.dto;

import java.util.List;

public class StudentDTO {
    private String firstName;
    private int age;
    private boolean isGraduated;
    private List<String> coursesTaken;

    public StudentDTO(String firstName, int age, boolean isGraduated, List<String> coursesTaken) {
        this.firstName = firstName;
        this.age = age;
        this.isGraduated = isGraduated;
        this.coursesTaken = coursesTaken;
    }

    @Override
    public String toString() {
        return "StudentDTO{" +
                "firstName='" + firstName + '\'' +
                ", age=" + age +
                ", isGraduated=" + isGraduated +
                ", coursesTaken=" + coursesTaken +
                '}';
    }
}
