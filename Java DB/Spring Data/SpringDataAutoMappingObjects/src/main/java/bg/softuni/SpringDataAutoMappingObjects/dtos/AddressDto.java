package bg.softuni.SpringDataAutoMappingObjects.dtos;

import jakarta.persistence.Column;

public class AddressDto {

    private String country;

    private String city;

    public AddressDto() {
    }

    public AddressDto(String country, String city) {
        this.country = country;
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "AddressDto{" +
                "country='" + country + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
