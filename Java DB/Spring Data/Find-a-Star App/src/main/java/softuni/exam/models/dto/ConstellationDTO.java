package softuni.exam.models.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ConstellationDTO {

    @Size(min = 3, max = 20)
    @NotNull
    private String name;

    @Size(min = 5)
    @NotNull
    private String description;

    public ConstellationDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
