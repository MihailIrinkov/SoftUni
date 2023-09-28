package entities.inheritance;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "truck")
public class Truck extends TransportationVehicle{
    private static final String TYPE = "Truck";

    public Truck() {
    }

    public Truck(int numberOfContainers) {
        super(TYPE, numberOfContainers);
    }
}
