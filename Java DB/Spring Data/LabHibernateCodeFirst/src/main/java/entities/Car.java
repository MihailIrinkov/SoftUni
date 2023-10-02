package entities;

import javax.persistence.*;

@Entity
@Table(name = "cars")
public class Car extends Vehicle{
//    private static final String TYPE = "Car";

    @Column
    private int Seats;

    @OneToOne
    private PlateNumber plateNumber;

    public Car() {
    }

    public Car(int seats) {
        Seats = seats;
    }

    public int getSeats() {
        return Seats;
    }

    public void setSeats(int seats) {
        Seats = seats;
    }
}
