package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "trucks")
public class Truck extends Vehicle{

    @Column
    private double loadCapacity;

    @ManyToMany
    private List<Driver> drivers;

    public Truck() {
    }

    public Truck(double loadCapacity) {
        this.loadCapacity = loadCapacity;
    }

    public double getLoadCapacity() {
        return loadCapacity;
    }
}
