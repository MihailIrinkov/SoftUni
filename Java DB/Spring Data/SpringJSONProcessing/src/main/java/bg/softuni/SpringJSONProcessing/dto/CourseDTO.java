package bg.softuni.SpringJSONProcessing.dto;

public class CourseDTO {

    private String name;
    private int lengthInWeeks;

    public CourseDTO(String name, int lengthInWeeks) {
        this.name = name;
        this.lengthInWeeks = lengthInWeeks;
    }

    @Override
    public String toString() {
        return "CourseDTO{" +
                "name='" + name + '\'' +
                ", lengthInWeeks=" + lengthInWeeks +
                '}';
    }
}
