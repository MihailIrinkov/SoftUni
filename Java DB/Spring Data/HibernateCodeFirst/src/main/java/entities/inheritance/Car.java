package entities.inheritance;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "cars")
public class Car extends Vehicle{
    private final static String TYPE = "CAR";

    @Column(name = "seat_count")
    private int seatCount;

    public Car() {
        super(TYPE);
    }

    public int getSeatCount() {
        return seatCount;
    }

    public void setSeatCount(int seatCount) {
        this.seatCount = seatCount;
    }
}
