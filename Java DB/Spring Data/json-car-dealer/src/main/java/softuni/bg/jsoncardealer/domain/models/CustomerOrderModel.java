package softuni.bg.jsoncardealer.domain.models;

import softuni.bg.jsoncardealer.domain.entities.Sale;

import java.util.List;

public class CustomerOrderModel {

    private Long id;

    private String name;

    private String birthDate;

    private boolean isYoungDriver;

    private List<Sale> sales;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public boolean isYoungDriver() {
        return isYoungDriver;
    }

    public void setYoungDriver(boolean youngDriver) {
        isYoungDriver = youngDriver;
    }

    public List<Sale> getSales() {
        return sales;
    }

    public void setSales(List<Sale> sales) {
        this.sales = sales;
    }


    //       "Id": 29,
//               "Name": "Louann Holzworth",
//               "BirthDate": " 1960-10-01T00:00:00",
//               "IsYoungDriver": false,
//               "Sales": [],

}
