package softuni.exam.models.dto;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "astronomer")
@XmlAccessorType(XmlAccessType.FIELD)
public class AstronomerDTO {

    @NotNull
    @DecimalMin(value = "500")
    @XmlElement(name = "average_observation_hours")
    private Double averageObservationHours;

    @XmlElement(name = "birthday")
    private String birthday;

    @NotNull
    @Size(min = 2, max = 30)
    @XmlElement(name = "first_name")
    private String firstName;

    @NotNull
    @Size(min = 2, max = 30)
    @XmlElement(name = "last_name")
    private String lastName;

    @NotNull
    @DecimalMin(value = "15000")
    @XmlElement(name = "salary")
    private Double salary;

    @XmlElement(name = "observing_star_id")
    private Integer observingStarId;

    public AstronomerDTO() {
    }

    public Double getAverageObservationHours() {
        return averageObservationHours;
    }

    public void setAverageObservationHours(Double averageObservationHours) {
        this.averageObservationHours = averageObservationHours;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
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

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Integer getObservingStarId() {
        return observingStarId;
    }

    public void setObservingStarId(Integer observingStarId) {
        this.observingStarId = observingStarId;
    }
}
