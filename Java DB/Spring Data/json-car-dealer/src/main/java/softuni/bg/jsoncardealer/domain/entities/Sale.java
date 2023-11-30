package softuni.bg.jsoncardealer.domain.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "sales")
public class Sale extends BaseEntity{

    @ManyToOne(fetch = FetchType.EAGER)
    private Car car;

    @ManyToOne(fetch = FetchType.EAGER)
    private Customer customer;

    @Column
    private Double discountPercentage;

    public Sale() {
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Double getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(Double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }
}
