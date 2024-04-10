package softuni.exam.instagraphlite.models.dto;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

public class PictureDTO {

    @NotNull
    private String path;

    @NotNull
    @DecimalMin(value = "500")
    @DecimalMax(value = "60000")
    private Double size;

    public PictureDTO() {
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Double getSize() {
        return size;
    }

    public void setSize(Double size) {
        this.size = size;
    }
}
