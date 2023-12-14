package softuni.exam.models.dto;

import java.io.Serializable;

public class CountryImportDto implements Serializable {
    private String countryName;
    private String currency;

    public CountryImportDto() {
    }


    public boolean validate() {
        if (countryName.length() > 60 || this.countryName.length() < 2) {
            return false;
        }
        if (currency.length() < 2 || currency.length() >= 20) {
            return false;
        }
        return true;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
