package bg.softuni.SpringDataAutoMappingObjects.services;

import bg.softuni.SpringDataAutoMappingObjects.dtos.AddressDto;
import bg.softuni.SpringDataAutoMappingObjects.entities.Address;
import bg.softuni.SpringDataAutoMappingObjects.repositories.AddressRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;

    @Autowired
    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }


    @Override
    public Address createAddress(AddressDto addressDto) {
        ModelMapper modelMapper = new ModelMapper();

        Address address = modelMapper
                .map(addressDto, Address.class);

        address = addressRepository.save(address);
        return address;
    }
}
