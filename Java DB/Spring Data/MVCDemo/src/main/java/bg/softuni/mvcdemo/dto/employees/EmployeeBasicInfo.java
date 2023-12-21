package bg.softuni.mvcdemo.dto.employees;

import bg.softuni.mvcdemo.entity.Employee;

public class EmployeeBasicInfo {

    private String name;
    private Integer age;
    private String projectName;

    public EmployeeBasicInfo(String name,
                             Integer age,
                             String projectName) {
        this.name = name;
        this.age = age;
        this.projectName = projectName;
    }

    public static EmployeeBasicInfo fromEmployee(Employee employee) {
        return new EmployeeBasicInfo(employee.getFullName(),
                employee.getAge(),
                employee.getProject().getName());
    }

    @Override
    public String toString() {
        return "Name: " + name + "\n" +
                "   Age: " + age + "\n" +
                "   Project Name: " + projectName;
    }
}
