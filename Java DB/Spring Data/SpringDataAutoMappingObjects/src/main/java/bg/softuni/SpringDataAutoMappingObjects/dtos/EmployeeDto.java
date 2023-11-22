package bg.softuni.SpringDataAutoMappingObjects.dtos;

import java.math.BigDecimal;

public class EmployeeDto extends BasicDto{


    private BigDecimal salary;

    public EmployeeDto() {
    }



    public EmployeeDto(BigDecimal salary) {
        this.salary = salary;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }


    @Override
    public String toString() {
        return "EmployeeDto{" +
                "salary=" + salary +
                '}';
    }
}
