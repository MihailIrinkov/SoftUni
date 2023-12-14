package softuni.exam.models.dto;

import java.io.Serializable;

public class CityImportDto implements Serializable {

    private String cityName;
    private String description;
    private int population;
    private long country;

    public CityImportDto() {
    }

    public boolean validate() {
        if (cityName.length() < 2 || cityName.length() > 60) {
            return false;
        }

        if (description.length() < 2) {
            return false;
        }
        if(country < 0) {
            return false;
        }

        return true;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public long getCountry() {
        return country;
    }

    public void setCountry(long country) {
        this.country = country;
    }
}
