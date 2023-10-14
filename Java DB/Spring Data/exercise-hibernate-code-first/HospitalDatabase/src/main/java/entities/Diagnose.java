package entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "diagnoses")
public class Diagnose extends BaseEntity{

    @Column
    private String diagnoseName;

    @Column
    private String comments;

//    @OneToMany
//    @JoinColumn
//    private Set<Patient> patients;

    @ManyToOne
    private Patient patient;


    public Diagnose(String diagnoseName) {
        this.diagnoseName = diagnoseName;
    }

    public String getDiagnoseName() {
        return diagnoseName;
    }

    public void setDiagnoseName(String diagnoseName) {
        this.diagnoseName = diagnoseName;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
