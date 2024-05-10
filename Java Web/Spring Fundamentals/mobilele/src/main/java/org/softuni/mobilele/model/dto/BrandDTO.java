package org.softuni.mobilele.model.dto;

import org.softuni.mobilele.model.entity.Model;

import java.util.ArrayList;
import java.util.List;

public class BrandDTO {

    private String name;

    private List<ModelDTO> models;

    public BrandDTO() {
        this.models = new ArrayList<>();
    }

    public BrandDTO(String name, List<ModelDTO> models) {
        this.name = name;
        this.models = models;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ModelDTO> getModels() {
        return models;
    }

    public void setModels(List<ModelDTO> models) {
        this.models = models;
    }
}
