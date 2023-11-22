package bg.softuni.SpringDataAutoMappingObjects.services;

import bg.softuni.SpringDataAutoMappingObjects.dtos.AddressDto;
import bg.softuni.SpringDataAutoMappingObjects.entities.Address;

public interface AddressService {

    Address createAddress(AddressDto addressDto);
}
