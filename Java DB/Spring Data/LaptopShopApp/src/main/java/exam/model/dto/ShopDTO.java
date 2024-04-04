package exam.model.dto;

import javax.persistence.Column;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;

@XmlRootElement(name = "shop")
@XmlAccessorType(XmlAccessType.FIELD)
public class ShopDTO {

    @XmlElement
    @NotNull
    @Size(min = 4)
    private String address;

    @XmlElement(name = "employee-count")
    @NotNull
    @DecimalMin(value = "1")
    @DecimalMax(value = "50")
    private Integer employeeCount;

    @XmlElement
    @NotNull
    @DecimalMin(value = "20000")
    private BigDecimal income;

    @XmlElement
    @NotNull
    @Size(min = 4)
    private String name;

    @XmlElement(name = "shop-area")
    @NotNull
    @DecimalMin(value = "150")
    private Integer shopArea;

    @XmlElement
    @NotNull
    private TownBasicDTO town;

    public ShopDTO() {
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getEmployeeCount() {
        return employeeCount;
    }

    public void setEmployeeCount(Integer employeeCount) {
        this.employeeCount = employeeCount;
    }

    public BigDecimal getIncome() {
        return income;
    }

    public void setIncome(BigDecimal income) {
        this.income = income;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getShopArea() {
        return shopArea;
    }

    public void setShopArea(Integer shopArea) {
        this.shopArea = shopArea;
    }

    public TownBasicDTO getTown() {
        return town;
    }

    public void setTown(TownBasicDTO town) {
        this.town = town;
    }
}
