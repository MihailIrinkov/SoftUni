package softuni.exam.models.dto;

import softuni.exam.models.entity.StarType;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class StarDTO {

    @Size(min = 6)
    @NotNull
    private String description;

    @Positive
    @NotNull
    private Double lightYears;

    @NotNull
    @Size(min = 2, max = 30)
    private String name;

    @NotNull
    private StarType starType;

    private Integer constellation;

    public StarDTO() {
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

    public Double getLightYears() {
        return lightYears;
    }

    public void setLightYears(Double lightYears) {
        this.lightYears = lightYears;
    }

    public StarType getStarType() {
        return starType;
    }

    public void setStarType(StarType starType) {
        this.starType = starType;
    }

    public Integer getConstellation() {
        return constellation;
    }

    public void setConstellation(Integer constellation) {
        this.constellation = constellation;
    }
}
