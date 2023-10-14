package entities;

import javax.persistence.*;
import java.sql.Blob;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "patients")
public class Patient extends BaseEntity{

    @Column(nullable = false, length = 50)
    private String firstName;

    @Column(nullable = false, length = 60)
    private String lastName;

    @Column
    private String address;

    @Column(unique = true)
    private String email;

    @Column
    private Date birthDate;

    @Column
    private String picture;

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    @Column()
    private Boolean haveMedicalInsurance;

    @OneToMany
    @JoinColumn
    private Set<Medicament> medicaments;

    @OneToMany
    @JoinColumn
    private Set<Visitation> visitations;

    @OneToMany
    @JoinColumn
    private Set<Diagnose> diagnoses;


    public Patient() {
    }

    public Patient(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Boolean getHaveMedicalInsurance() {
        return haveMedicalInsurance;
    }

    public void setHaveMedicalInsurance(Boolean haveMedicalInsurance) {
        this.haveMedicalInsurance = haveMedicalInsurance;
    }
}
