package bakery;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Bakery {
    private String name;
    private int capacity;
    private List<Employee> employees;

    public Bakery(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        employees = new ArrayList<>();
    }

    public void add(Employee employee) {
        if (employees.size() < capacity) {
            employees.add(employee);
        }
    }

    public boolean remove(String name) {
        Employee searchedName = getEmployee(name);
        if (searchedName != null) {
            employees.remove(searchedName);
            return true;
        }
        return false;

//      if (employees.contains(name)) {
//          employees.remove(name);
//          return true;
//      } else {
//          return false;
//      }
    }

    public Employee getOldestEmployee() {
        return employees.stream()
                .max(Comparator.comparingInt(Employee::getAge)).orElse(null);
    }

    public Employee getEmployee(String name) {
        return employees.stream()
                .filter(e -> e.getName().equals(name))
                .findFirst().orElse(null);
    }

    public int getCapacity() {
        return capacity;
    }

    public int getCount() {
        return employees.size();
    }

    public String report() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("Employees working at Bakery %s:%n", name));
        for (Employee employee : employees) {
            sb.append(employee).append(System.lineSeparator());
        }

//        sb.append(String.format("Employees working at Bakery %s:%n", name));
//        for (Employee e : employees) {
//            sb.append("Employee: " + e.getName() + ", ");
//            sb.append(e.getAge());
//            sb.append(String.format("(%s)", e.getCountry()));
//            sb.append("\n");
//        }
        return sb.toString();
    }
}
