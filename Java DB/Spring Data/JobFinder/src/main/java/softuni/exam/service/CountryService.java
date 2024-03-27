package softuni.exam.service;


import java.io.IOException;

// TODO: Implement all methods
public interface CountryService {

    boolean areImported();

    String readCountriesFileContent() throws IOException;

    String importCountries() throws IOException;
}
