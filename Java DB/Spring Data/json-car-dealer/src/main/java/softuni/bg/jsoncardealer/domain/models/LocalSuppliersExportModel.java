package softuni.bg.jsoncardealer.domain.models;

import com.google.gson.annotations.Expose;
import softuni.bg.jsoncardealer.domain.entities.Part;

import java.util.List;

public class LocalSuppliersExportModel {

    @Expose
    private Long id;

    @Expose
    private String name;

    private List<Part> parts;

    @Expose
    private int partsCount;

    public LocalSuppliersExportModel() {

    }

    public LocalSuppliersExportModel(Long id, String name, List<Part> parts) {
        this.id = id;
        this.name = name;
        this.parts = parts;
        this.partsCount = parts.size();
    }

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

    public List<Part> getParts() {
        return parts;
    }

    public void setParts(List<Part> parts) {
        this.parts = parts;
    }

    public int getPartsCount() {
        return partsCount;
    }

    public void setPartsCount(int partsCount) {
        this.partsCount = partsCount;
    }
}
