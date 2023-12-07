import jakarta.xml.bind.annotation.*;

import java.io.Serializable;


@XmlRootElement(name = "address")
@XmlAccessorType(XmlAccessType.FIELD)
public class AddressDto implements Serializable {

    @XmlAttribute
    private int population;

    @XmlElement(name = "country")
    private String country;

    private String city;

    public AddressDto() {
    }

    public AddressDto(int population, String country, String city) {
        this.population = population;
        this.country = country;
        this.city = city;
    }

    @Override
    public String toString() {
        return "AddressDto{" +
                "population=" + population +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
