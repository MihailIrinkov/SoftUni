package entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "drivers")
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Basic(optional = false)
    private String full_name;

    @ManyToMany(targetEntity = Truck.class, mappedBy = "drivers")
    private List<Truck> truck;

    public Driver() {
    }

    public Driver(String full_name, List<Truck> truck) {
        this.full_name = full_name;
        this.truck = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public List<Truck> getTruck() {
        return truck;
    }

    public void setTruck(List<Truck> truck) {
        this.truck = truck;
    }
}
