package softuni.exam.service;


import softuni.exam.models.entity.Country;

import java.io.IOException;
import java.util.Optional;

// TODO: Implement all methods
public interface CountryService {


    Optional<Country> getByCountryName(String countryName);
    boolean areImported();

    String readCountriesFromFile() throws IOException;
	
	String importCountries() throws IOException;
}
