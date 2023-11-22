package bg.softuni.SpringDataAutoMappingObjects.dtos;

import java.util.List;

public class ManagerDto extends BasicDto{

    private List<EmployeeDto> subordinates;

    public ManagerDto() {
    }

    public ManagerDto(List<EmployeeDto> subordinates) {
        this.subordinates = subordinates;
    }
}
