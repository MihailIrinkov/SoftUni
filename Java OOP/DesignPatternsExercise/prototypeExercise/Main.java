package prototypeExercise;

public class Main {
    public static void main(String[] args) {

        EmployeeRecord employeeRecord1 = new EmployeeRecord(1,  "Pesho", "007", 750.0, "Sf");
        EmployeeRecord employeeRecord2 = employeeRecord1.getClone();
        employeeRecord1.setId(777);
        employeeRecord1.showRecord();
        employeeRecord2.showRecord();

        System.out.println(employeeRecord1.hashCode());
        System.out.println(employeeRecord2.hashCode());

    }
}
