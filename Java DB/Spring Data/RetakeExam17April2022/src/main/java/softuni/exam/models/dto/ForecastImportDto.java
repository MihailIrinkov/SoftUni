package softuni.exam.models.dto;

import softuni.exam.models.entity.DayOfWeek;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "forecast")
@XmlAccessorType(XmlAccessType.FIELD)
public class ForecastImportDto {

    @XmlElement(name = "day_of_week")
    private DayOfWeek dayOfWeek;

    @XmlElement(name = "max_temperature")
    private Double maxTemperature;

    @XmlElement(name = "min_temperature")
    private Double minTemperature;

    @XmlElement(name = "sunrise")
    private String sunrise;

    @XmlElement(name = "sunset")
    private String sunset;

    @XmlElement(name = "city")
    private long city;


    public ForecastImportDto() {
    }

    public boolean validate() {

        if (maxTemperature < -20 || maxTemperature > 60) {
            return false;
        }

        if (minTemperature < -50 || minTemperature > 40) {
            return false;
        }

        return true;
    }

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(DayOfWeek dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    @NotNull
    public Double getMaxTemperature() {
        return maxTemperature;
    }

    public void setMaxTemperature(Double maxTemperature) {
        this.maxTemperature = maxTemperature;
    }

    @NotNull
    public Double getMinTemperature() {
        return minTemperature;
    }

    public void setMinTemperature(Double minTemperature) {
        this.minTemperature = minTemperature;
    }

    public String getSunrise() {
        return sunrise;
    }

    public void setSunrise(String sunrise) {
        this.sunrise = sunrise;
    }

    public String getSunset() {
        return sunset;
    }

    public void setSunset(String sunset) {
        this.sunset = sunset;
    }

    public long getCity() {
        return city;
    }

    public void setCity(long city) {
        this.city = city;
    }
}
