package softuni.exam.models.dto;

import softuni.exam.models.entity.DeviceType;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "device")
@XmlAccessorType(XmlAccessType.FIELD)
public class DeviceDTO {

    @NotNull
    @Size(min = 2, max = 20)
    @XmlElement
    private String brand;

    @XmlElement(name = "device_type")
    private DeviceType deviceType;


    @NotNull
    @Size(min = 1, max = 20)
    @XmlElement
    private String model;

    @Positive
    @XmlElement
    private Double price;

    @Positive
    @XmlElement
    private Integer storage;

    @XmlElement(name = "sale_id")
    private Long saleId;

    public DeviceDTO() {
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public DeviceType getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(DeviceType deviceType) {
        this.deviceType = deviceType;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getStorage() {
        return storage;
    }

    public void setStorage(Integer storage) {
        this.storage = storage;
    }

    public Long getSaleId() {
        return saleId;
    }

    public void setSaleId(Long saleId) {
        this.saleId = saleId;
    }
}
