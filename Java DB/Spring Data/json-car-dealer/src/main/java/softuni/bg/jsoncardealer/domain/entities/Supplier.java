package softuni.bg.jsoncardealer.domain.entities;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "suppliers")
public class Supplier extends BaseEntity{

    @Column
    private String name;

    @Column
    private boolean isImporter;

    @OneToMany(fetch = FetchType.EAGER)
//    @JoinTable(name = "supplier_parts", joinColumns = @JoinColumn(name = "supplier_id",
//            referencedColumnName = "id"),
//            inverseJoinColumns = @JoinColumn(name = "part_id", referencedColumnName = "id"))
//@JoinColumn(name = "part_id")
//    @Column
    private List<Part> parts;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Supplier supplier = (Supplier) o;
        return isImporter == supplier.isImporter
                && Objects.equals(name, supplier.name)
                && Objects.equals(getId(), supplier.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, getId());
    }

    public Supplier() {
    }

    public List<Part> getParts() {
        return parts;
    }

    public void setParts(List<Part> parts) {
        this.parts = parts;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isImporter() {
        return isImporter;
    }

    public void setImporter(boolean importer) {
        this.isImporter = importer;
    }
}
