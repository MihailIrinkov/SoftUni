package entities.inheritance;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "bike")
public class Bike extends Vehicle{
    private final static String TYPE = "BIKE";

    @Column(name = "wheel_size")
    private int wheelSize;

    public Bike() {
        super(TYPE);
    }

    public int getWheelSize() {
        return wheelSize;
    }

    public void setWheelSize(int wheelSize) {
        this.wheelSize = wheelSize;
    }
}
