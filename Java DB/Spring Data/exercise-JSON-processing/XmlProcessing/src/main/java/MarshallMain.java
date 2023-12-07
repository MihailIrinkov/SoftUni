import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

import java.util.ArrayList;
import java.util.List;

public class MarshallMain {

    public static void main(String[] args) throws JAXBException {
        final JAXBContext jaxbContext = JAXBContext.newInstance(AddressDto.class);

        AddressDto addressDto = new AddressDto(10000, "BG", "Sofia");

        final Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        marshaller.marshal(addressDto, System.out);


        final JAXBContext listJaxbContext = JAXBContext.newInstance(AddressesDto.class);

        List<AddressDto> addressDtoList = new ArrayList<>();

        addressDtoList.add(addressDto);
        addressDtoList.add(addressDto);

        AddressesDto addressesDto = new AddressesDto(addressDtoList);

        final Marshaller listMarshaller = listJaxbContext.createMarshaller();

        listMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        listMarshaller.marshal(addressesDto, System.out);
    }
}
