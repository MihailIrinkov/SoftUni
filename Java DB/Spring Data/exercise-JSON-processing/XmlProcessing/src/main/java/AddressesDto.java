import jakarta.xml.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

@XmlRootElement(name = "addresses")
@XmlAccessorType(XmlAccessType.FIELD)
public class AddressesDto implements Serializable {

//    @XmlElement(name = "222")
    @XmlElementWrapper(name = "Wrap")
    @XmlElement(name = "inner")
    private List<AddressDto> addressesList;

    public AddressesDto() {
    }

    public AddressesDto(List<AddressDto> addresses) {
        this.addressesList = addresses;
    }

    @Override
    public String toString() {
        return "AddressesDto{" +
                "addressesList=" + addressesList +
                '}';
    }
}
