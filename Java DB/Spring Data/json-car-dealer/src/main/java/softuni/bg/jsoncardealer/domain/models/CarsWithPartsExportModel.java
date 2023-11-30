package softuni.bg.jsoncardealer.domain.models;

import softuni.bg.jsoncardealer.domain.entities.Part;

import java.util.List;

public class CarsWithPartsExportModel {

    private String make;

    private String model;

    private Long travelledDistance;

    private List<Part> parts;

    public CarsWithPartsExportModel() {
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Long getTravelledDistance() {
        return travelledDistance;
    }

    public void setTravelledDistance(Long travelledDistance) {
        this.travelledDistance = travelledDistance;
    }

    public List<Part> getParts() {
        return parts;
    }

    public void setParts(List<Part> parts) {
        this.parts = parts;
    }
}
