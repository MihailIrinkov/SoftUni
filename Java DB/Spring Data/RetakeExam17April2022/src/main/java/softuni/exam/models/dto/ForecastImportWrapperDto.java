package softuni.exam.models.dto;


import softuni.exam.models.entity.Forecast;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "forecasts")
@XmlAccessorType(XmlAccessType.FIELD)
public class ForecastImportWrapperDto {

    @XmlElement(name = "forecast")
    private List<ForecastImportDto> forecasts;

    public ForecastImportWrapperDto() {
    }

    public List<ForecastImportDto> getForecasts() {
        return forecasts;
    }

    public void setForecasts(List<ForecastImportDto> forecasts) {
        this.forecasts = forecasts;
    }
}
