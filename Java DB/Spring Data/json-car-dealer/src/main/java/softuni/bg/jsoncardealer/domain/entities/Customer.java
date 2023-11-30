package softuni.bg.jsoncardealer.domain.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "customers")
public class Customer extends BaseEntity{

    @Column
    private String name;

    @Column(name = "date_of_birth")
    private String birthDate;

    @Column(name = "young_driver")
    private boolean isYoungDriver;


    @OneToMany(fetch = FetchType.EAGER)
//    @JoinTable(name = "parts_cars", joinColumns = @JoinColumn(name = "car_id",
//            referencedColumnName = "id"),
//            inverseJoinColumns = @JoinColumn(name = "parts_id", referencedColumnName = "id"))
    @JoinTable(name = "customer_cars", joinColumns = @JoinColumn(name = "customer_id",
    referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "cars_id", referencedColumnName = "id"))
    private List<Car> cars;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Sale> sales;

    public Customer() {
    }

    public List<Sale> getSales() {
        return sales;
    }

    public void setSales(List<Sale> sales) {
        this.sales = sales;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public boolean isYoungDriver() {
        return isYoungDriver;
    }

    public void setYoungDriver(boolean youngDriver) {
        this.isYoungDriver = youngDriver;
    }
}
