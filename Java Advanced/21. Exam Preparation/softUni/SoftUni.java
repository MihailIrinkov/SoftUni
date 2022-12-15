package softUni;

import guild.Player;

import java.util.ArrayList;
import java.util.List;

public class SoftUni {
    private int capacity;
    private List<Student> students;

    public SoftUni(int capacity) {
        this.capacity = capacity;
        this.students = new ArrayList<>();
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public int getCount() {
        return students.size();
    }


    public String insert(Student student) {

        if (students.size() == 0) {

            students.add(student);

            return String.format
                    ("Added student %s %s", student.getFirstName(), student.getLastName());

        }

        if (capacity > students.size()) {
            for (Student s : students) {
                if (!s.getFirstName().equals(student.getFirstName())
                        && !s.getLastName().equals(student.getLastName())) {
                    students.add(student);

                    return String.format
                            ("Added student %s %s", s.getFirstName(), s.getLastName());
                } else {
                    return String.format("Student is already in the hall.");

                }
            }
        }
        return String.format("The hall is full.");
    }


    public String remove(Student student) {
        
        for (Student s : students) {
            if (s.getFirstName().equals(student.getFirstName())
                    && s.getLastName().equals(student.getLastName())) {
                students.remove(student);

                return String.format
                        ("Removed student  %s %s", s.getFirstName(), s.getLastName());
            }
        }
        return String.format("Student not found.");
    }


    public Student getStudent(String firstName, String lastName) {

        Student searchedStudent = null;

        for (Student s : students) {
            if (s.getFirstName().equals(firstName)
                    && s.getLastName().equals(lastName)) {
                searchedStudent = s;
            }
        }

        return searchedStudent;
    }


    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Hall size: %d", students.size()));

        for (Student s : students) {
//            sb.append("Student: ");
//            sb.append(String.format("%s %s, Best Course = %s", ))
//            sb.append("\n");

            sb.append(s.toString()).append(System.lineSeparator());
        }

        return sb.toString();
    }
}
