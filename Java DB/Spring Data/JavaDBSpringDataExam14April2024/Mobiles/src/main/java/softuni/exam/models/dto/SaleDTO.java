package softuni.exam.models.dto;

import javax.validation.constraints.NotNull;

public class SaleDTO {

    private Boolean discounted;

    @NotNull
    private String number;

    @NotNull
    private String saleDate;


    private Long seller;

    public SaleDTO() {
    }

    public Boolean getDiscounted() {
        return discounted;
    }

    public void setDiscounted(Boolean discounted) {
        this.discounted = discounted;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(String saleDate) {
        this.saleDate = saleDate;
    }

    public Long getSeller() {
        return seller;
    }

    public void setSeller(Long seller) {
        this.seller = seller;
    }
}
