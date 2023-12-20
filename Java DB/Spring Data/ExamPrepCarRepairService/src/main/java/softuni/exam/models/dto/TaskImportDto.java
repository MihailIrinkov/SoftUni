package softuni.exam.models.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;

@XmlRootElement(name = "task")
@XmlAccessorType(XmlAccessType.FIELD)
public class TaskImportDto {

    @NotNull
    @XmlElement
    private String date;

    @NotNull
    @Positive
    @XmlElement
    private BigDecimal price;

    @NotNull
    @XmlElement
    private CarBaseImportDto car;

    @NotNull
    @XmlElement
    private MechanicBaseImportDto mechanic;

    @NotNull
    @XmlElement
    private PartBaseImportDto part;

    public TaskImportDto() {
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public CarBaseImportDto getCar() {
        return car;
    }

    public void setCar(CarBaseImportDto car) {
        this.car = car;
    }

    public MechanicBaseImportDto getMechanic() {
        return mechanic;
    }

    public void setMechanic(MechanicBaseImportDto mechanic) {
        this.mechanic = mechanic;
    }

    public PartBaseImportDto getPart() {
        return part;
    }

    public void setPart(PartBaseImportDto part) {
        this.part = part;
    }
}
