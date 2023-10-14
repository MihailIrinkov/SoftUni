package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "medicaments")
public class Medicament extends BaseEntity{

    @Column(nullable = false)
    private String medicamentName;


    public Medicament() {
    }

    public String getMedicamentName() {
        return medicamentName;
    }

    public void setMedicamentName(String medicamentName) {
        this.medicamentName = medicamentName;
    }
}
