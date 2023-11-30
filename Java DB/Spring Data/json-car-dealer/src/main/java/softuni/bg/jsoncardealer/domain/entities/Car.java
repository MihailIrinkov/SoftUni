package softuni.bg.jsoncardealer.domain.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "cars")
public class Car extends BaseEntity{

    @Column
    private String make;

    @Column
    private String model;

    @Column(name = "traveled_distance")
    private Long travelledDistance;

    @ManyToMany(fetch = FetchType.EAGER)
    // targetEntity = Part.class, mappedBy = "cars",
    @JoinTable(name = "parts_cars", joinColumns = @JoinColumn(name = "car_id",
            referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "parts_id", referencedColumnName = "id"))
    private List<Part> parts;

    public Car() {
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Long getTravelledDistance() {
        return travelledDistance;
    }

    public void setTravelledDistance(Long travelledDistance) {
        this.travelledDistance = travelledDistance;
    }

    public List<Part> getParts() {
        return parts;
    }

    public void setParts(List<Part> parts) {
        this.parts = parts;
    }

    @Override
    public String toString() {
        return "Car{" +
                "make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", travelledDistance=" + travelledDistance +
                ", parts=" + parts +
                '}';
    }
}
