package softuni.exam.models.dto;

import javax.validation.constraints.*;

public class PartImportDto {
    @NotNull
    @Size(min = 2, max = 19)
    private String partName;

    @NotNull
    @DecimalMin(value = "10")
    @DecimalMax(value = "2000")
    private double price;

    @NotNull
    @Positive
    private int quantity;

    public PartImportDto() {
    }

    public String getPartName() {
        return partName;
    }

    public void setPartName(String partName) {
        this.partName = partName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
