package softuni.exam.models.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "astronomers")
@XmlAccessorType(XmlAccessType.FIELD)
public class AstronomersRootDTO {

    @XmlElement(name = "astronomer")
    private List<AstronomerDTO> astronomers;

    public AstronomersRootDTO() {
    }

    public List<AstronomerDTO> getAstronomers() {
        return astronomers;
    }

    public void setAstronomers(List<AstronomerDTO> astronomers) {
        this.astronomers = astronomers;
    }
}
