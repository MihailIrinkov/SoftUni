package softuni.exam.models.dto;

import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;

@XmlRootElement(name = "ticket")
@XmlAccessorType(XmlAccessType.FIELD)
public class TicketDTO {

    @Size(min = 2)
    @XmlElement(name = "serial-number")
    private String serialNumber;

    @Positive
    @XmlElement
    private BigDecimal price;

    @XmlElement(name = "take-off")
    private String takeoff;

    @XmlElement(name = "from-town")
    private TownFromBasicDTO fromTown;

    @XmlElement(name = "to-town")
    private TownToBasicDTO toTown;

    @XmlElement
    private PassengerBasicDTO passenger;

    @XmlElement
    private PlaneBasicDTO plane;

    public TicketDTO() {
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getTakeoff() {
        return takeoff;
    }

    public void setTakeoff(String takeoff) {
        this.takeoff = takeoff;
    }

    public TownFromBasicDTO getFromTown() {
        return fromTown;
    }

    public void setFromTown(TownFromBasicDTO fromTown) {
        this.fromTown = fromTown;
    }

    public TownToBasicDTO getToTown() {
        return toTown;
    }

    public void setToTown(TownToBasicDTO toTown) {
        this.toTown = toTown;
    }

    public PassengerBasicDTO getPassenger() {
        return passenger;
    }

    public void setPassenger(PassengerBasicDTO passenger) {
        this.passenger = passenger;
    }

    public PlaneBasicDTO getPlane() {
        return plane;
    }

    public void setPlane(PlaneBasicDTO plane) {
        this.plane = plane;
    }
}
