package softuni.exam.models.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "apartments")
@XmlAccessorType(XmlAccessType.FIELD)
public class ApartmentRootDTO {

    @XmlElement(name = "apartment")
    private List<ApartmentDTO> apartments;

    public ApartmentRootDTO() {
    }

    public List<ApartmentDTO> getApartments() {
        return apartments;
    }

    public void setApartments(List<ApartmentDTO> apartments) {
        this.apartments = apartments;
    }
}
