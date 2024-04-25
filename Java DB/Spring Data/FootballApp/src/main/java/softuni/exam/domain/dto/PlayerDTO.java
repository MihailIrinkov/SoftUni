package softuni.exam.domain.dto;

import softuni.exam.domain.entities.Position;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

public class PlayerDTO {

    @NotNull
    private String firstName;

    @NotNull
    @Size(min = 3, max = 15)
    private String lastName;

    @NotNull
    @DecimalMin(value = "1")
    @DecimalMax(value = "99")
    private Integer number;

    @NotNull
    @DecimalMin(value = "0")
    private BigDecimal salary;

    @NotNull
    private Position position;

    @NotNull
    private PictureDTO picture;

    @NotNull
    private TeamDTO team;

    public PlayerDTO() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public PictureDTO getPicture() {
        return picture;
    }

    public void setPicture(PictureDTO picture) {
        this.picture = picture;
    }

    public TeamDTO getTeam() {
        return team;
    }

    public void setTeam(TeamDTO team) {
        this.team = team;
    }
}
