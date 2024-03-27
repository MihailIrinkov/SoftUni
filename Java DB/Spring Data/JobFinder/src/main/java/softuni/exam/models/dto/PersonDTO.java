package softuni.exam.models.dto;

import softuni.exam.models.entity.Country;
import softuni.exam.models.entity.StatusType;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class PersonDTO {

    @NotNull
    @Email
    private String email;

    @NotNull
    @Size(min = 2, max = 30)
    private String firstName;

    @NotNull
    @Size(min = 2, max = 30)
    private String lastName;

    @Size(min = 2, max = 13)
    private String phone;

    @NotNull
    private StatusType statusType;

    private Integer country;

    public PersonDTO() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public StatusType getStatusType() {
        return statusType;
    }

    public void setStatusType(StatusType statusType) {
        this.statusType = statusType;
    }

    public Integer getCountry() {
        return country;
    }

    public void setCountry(Integer countryId) {
        this.country = countryId;
    }
}
