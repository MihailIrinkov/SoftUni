package CompanyRoster_02;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Employee> employeeList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String nameInput = input[0];
            double salaryInput = Double.parseDouble(input[1]);
            String positionInput = input[2];
            String departmentInput = input[3];
            if (input.length == 5) {
                if (input[4].contains("@")) {
                    String emailInput = input[4];
                    int ageInput = -1;
                    Employee employee = new Employee(nameInput, salaryInput, positionInput, departmentInput, emailInput, ageInput);
                    employeeList.add(employee);
                } else {
                    String emailInput = "n/a";
                    int ageInput = Integer.parseInt(input[4]);
                    Employee employee = new Employee(nameInput, salaryInput, positionInput, departmentInput, emailInput, ageInput);
                    employeeList.add(employee);
                }
            } else if (input.length == 4) {
                String emailInput = "n/a";
                int ageInput = -1;
                Employee employee = new Employee(nameInput, salaryInput, positionInput, departmentInput, emailInput, ageInput);
                employeeList.add(employee);

            } else if (input.length == 6) {
                String emailInput = input[4];
                int ageInput = Integer.parseInt(input[5]);

                Employee employee = new Employee(nameInput, salaryInput, positionInput, departmentInput, emailInput, ageInput);
                employeeList.add(employee);
            }
        }
        Map<String, Double> mapEmployee = new HashMap<>();
        for (int i = 0; i < employeeList.size(); i++) {
            Employee current = employeeList.get(i);
            double currentSalary = current.getSalary();
            String currentDepartment = current.getDepartment();

            if (mapEmployee.containsKey(currentDepartment)) {
                double salary = currentSalary + mapEmployee.get(currentDepartment);
                mapEmployee.put(currentDepartment, salary);
            } else {

                mapEmployee.put(currentDepartment, currentSalary);
            }
        }

        double maxValueInMap = (Collections.max(mapEmployee.values()));
        String departmentMaxSalary = null;

        for (Map.Entry<String, Double> stringDoubleEntry : mapEmployee.entrySet()) {
            if (stringDoubleEntry.getValue() == maxValueInMap) {
                departmentMaxSalary = stringDoubleEntry.getKey();
            }
        }
        System.out.println("Highest Average Salary: " + departmentMaxSalary);

        List<Employee> result = new ArrayList<>();

        for (int i = 0; i < employeeList.size(); i++) {
            Employee data = employeeList.get(i);

            if (data.getDepartment().equals(departmentMaxSalary)) {
                result.add(data);
            }
        }

        result.stream().sorted((first, second) -> Double.compare(second.getSalary(), (first.getSalary())))
                .forEach(e -> System.out.printf("%s %.2f %s %d%n", e.getName(), e.getSalary(), e.getEmail(), e.getAge()));

    }
}
