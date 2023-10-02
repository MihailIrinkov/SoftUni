package entities;

import javax.persistence.*;

@Entity
@Table(name = "planes")
public class Plane extends Vehicle{

    @Column
    private int passengerCapacity;

    @Column
    private String airline;

    @ManyToOne
    private Company company;

    public Plane() {
    }

    public Plane(int passengerCapacity, String airline) {
        this.passengerCapacity = passengerCapacity;
        this.airline = airline;
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public void setPassengerCapacity(int passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }
}
