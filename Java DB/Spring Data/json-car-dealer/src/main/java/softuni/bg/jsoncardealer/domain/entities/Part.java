package softuni.bg.jsoncardealer.domain.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "parts")
public class Part extends BaseEntity{

    @Column
    private String name;

    @Column
    private BigDecimal price;

    @Column
    private Integer quantity;

    @ManyToMany(targetEntity = Car.class, mappedBy = "parts", fetch = FetchType.EAGER)
    private List<Car> cars;

//    @ManyToOne(targetEntity = Supplier.class, fetch = FetchType.EAGER)
//    @JoinTable(name = "supplier_parts", joinColumns = @JoinColumn(name = "part_id",
//            referencedColumnName = "id"),
//            inverseJoinColumns = @JoinColumn(name = "supplier_id", referencedColumnName = "id"))
    @ManyToOne(fetch = FetchType.EAGER)
    private Supplier supplier;

    public Part() {
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    @Override
    public String toString() {
        return "Part{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", cars=" + cars +
                ", supplier=" + supplier +
                '}';
    }
}
