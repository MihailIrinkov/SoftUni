package entities.inheritance;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class TransportationVehicle extends Vehicle{

    @Column(name = "number_of_containers")
    private int numberOfContainers;

    protected TransportationVehicle() {
        super();
    }

    protected TransportationVehicle(String type, int numberOfContainers) {
        super(type);

        this.numberOfContainers = numberOfContainers;
    }

    public int getNumberOfContainers() {
        return numberOfContainers;
    }

    public void setNumberOfContainers(int numberOfContainers) {
        this.numberOfContainers = numberOfContainers;
    }
}
