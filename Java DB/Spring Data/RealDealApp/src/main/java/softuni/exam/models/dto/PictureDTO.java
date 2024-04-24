package softuni.exam.models.dto;

import javax.validation.constraints.Size;

public class PictureDTO {

    @Size(min = 3, max = 19)
    private String name;

    private String dateAndTime;

    private Long car;

    public PictureDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateAndTime() {
        return dateAndTime;
    }

    public void setDateAndTime(String dateAndTime) {
        this.dateAndTime = dateAndTime;
    }

    public Long getCar() {
        return car;
    }

    public void setCar(Long car) {
        this.car = car;
    }
}
