package softuni.exam.models.dto;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;
import java.time.LocalDate;

@XmlRootElement(name = "offer")
@XmlAccessorType(XmlAccessType.FIELD)
public class OfferDTO {

    @Positive
    @NotNull
    @XmlElement
    private BigDecimal price;

    @XmlElement(name = "agent")
    private AgentXmlDTO agent;

    @XmlElement(name = "apartment")
    private ApartmentXmlDTO apartment;

    @NotNull
    @XmlElement
    private String publishedOn;

    public OfferDTO() {
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public AgentXmlDTO getAgent() {
        return agent;
    }

    public void setAgent(AgentXmlDTO agent) {
        this.agent = agent;
    }

    public ApartmentXmlDTO getApartment() {
        return apartment;
    }

    public void setApartment(ApartmentXmlDTO apartment) {
        this.apartment = apartment;
    }

    public String getPublishedOn() {
        return publishedOn;
    }

    public void setPublishedOn(String publishedOn) {
        this.publishedOn = publishedOn;
    }
}
