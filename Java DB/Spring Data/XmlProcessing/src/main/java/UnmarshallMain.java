import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;

import java.io.InputStream;

public class UnmarshallMain {

    public static void main(String[] args) throws JAXBException {

        final JAXBContext jaxbContext = JAXBContext.newInstance(AddressDto.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
//
//        AddressDto addressDto = (AddressDto) unmarshaller.unmarshal(System.in);
//
//        System.out.println(addressDto);


        final JAXBContext jaxbContextList = JAXBContext.newInstance(AddressesDto.class);
        Unmarshaller unmarshallerList = jaxbContextList.createUnmarshaller();
//        AddressesDto addressesDto = (AddressesDto) unmarshallerList.unmarshal(System.in);
//
//        System.out.println(addressesDto);

        final InputStream resourceAsStream =
                UnmarshallMain.class.getResourceAsStream("simple.xml");

        AddressesDto fromFIle = (AddressesDto) unmarshallerList.unmarshal(resourceAsStream);

        System.out.println(fromFIle);
    }
}
