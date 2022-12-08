package university;

import java.util.ArrayList;
import java.util.List;

public class University {
    public int capacity;
    public List<Student> students;

    public University(int capacity) {
        this.capacity = capacity;
        this.students = new ArrayList<>();
    }

    public int getCapacity() {
        return capacity;
    }

    public List<Student> getStudents() {
        return students;
    }

    public int getStudentCount() {
        return students.size();
    }

    public String registerStudent(Student student) {
//        if (capacity > getStudentCount() && !students.contains(student)) {
//            students.add(student);
//            return "Added student " + student.firstName + " " + student.lastName;
//        } else if (students.contains(student)) {
//            return "Student is already in the university";
//        } else if (capacity <= getStudentCount()) {
//            return "No seats in the university";
//        }
//        return null;

//        if (students.contains(student)) {
//            return "Student is already in the university";
//        } else if (capacity <= getStudentCount()) {
//            return "No seats in the university";
//        }
        String result = null;

        if (capacity <= getStudentCount()) {
            result = "No seats in the university";
        }

        for (Student s : students) {
            if (s.getFirstName().equals(student.getFirstName())
                    && s.getLastName().equals(student.getLastName())) {
                result = "Student is already in the university";
            }
        }
        if (result == null) {
            students.add(student);
            result = "Added student " + student.getFirstName() + " " + student.getLastName();
        }
        return result;
    }

    public String dismissStudent(Student student) {
        String dismissed = null;
//        if (!students.contains(student)) {
//            return "Student not found";
//        } else {
//            students.remove(student);
//        }
//        return null;
//      2  for (Student stud : students) {
//            if (stud.getFirstName().equals(student.getFirstName())
//                    && stud.getLastName().equals(student.getLastName())) {
//                dismissed = "Removed student" + " " + stud.getFirstName() + " " + stud.getLastName();
//                students.remove(student);
//                return dismissed;
//            }
//        }
//        return "Student not found";

//
//       3 for (Student student1 : students) {
//            if (student1.getFirstName().equals(student.getFirstName())
//                    && student1.getLastName().equals(student.getLastName())) {
//                dismissed = "Removed student" + " " + student1.getFirstName() + " " + student1.getLastName();
////                students.remove(student);
//            }



        for (Student s : students) {
            if (s.getFirstName().equals(student.getFirstName())
                    && s.getLastName().equals(student.getLastName())) {
                dismissed = "Removed student" + " " + s.getFirstName() + " " + s.getLastName();
            }
        }


            if (dismissed != null) {
                students.remove(student);
            }

            if (dismissed == null) {
                dismissed = "Student not found";
            }

        return dismissed;
        }


    public Student getStudent(String firstName, String lastName) {
        //return firstName + lastName;
        for (Student s : students) {
            if (s.getFirstName().equals(firstName) && s.getLastName().equals(lastName)) {
                return s;
            }
        }
        return null;
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        for (Student st : students) {
            //==Student: First Name = {firstName}, Last Name = {lastName}, Best Subject = {bestSubject}
            sb.append(String.format
                    ("==Student: First Name = %s, Last Name = %s, Best Subject = %s%n"
                            , st.firstName, st.lastName, st.bestSubject));

        }
        return sb.toString();
    }
}
