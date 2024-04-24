package softuni.exam.models.dto;

import javax.persistence.ManyToOne;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;

@XmlRootElement(name = "offer")
@XmlAccessorType(XmlAccessType.FIELD)
public class OfferDTO {

    @Positive
    @XmlElement
    private BigDecimal price;

    @Size(min = 5)
    @XmlElement
    private String description;

    @XmlElement(name = "has-gold-status")
    private Boolean hasGoldStatus;

    @XmlElement(name = "added-on")
    private String addedOn;

    @ManyToOne
    private CarBasicDTO car;

    @ManyToOne
    private SellerBasicDTO seller;

    public OfferDTO() {
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getHasGoldStatus() {
        return hasGoldStatus;
    }

    public void setHasGoldStatus(Boolean hasGoldStatus) {
        this.hasGoldStatus = hasGoldStatus;
    }

    public String getAddedOn() {
        return addedOn;
    }

    public void setAddedOn(String addedOn) {
        this.addedOn = addedOn;
    }

    public CarBasicDTO getCar() {
        return car;
    }

    public void setCar(CarBasicDTO car) {
        this.car = car;
    }

    public SellerBasicDTO getSeller() {
        return seller;
    }

    public void setSeller(SellerBasicDTO seller) {
        this.seller = seller;
    }
}
