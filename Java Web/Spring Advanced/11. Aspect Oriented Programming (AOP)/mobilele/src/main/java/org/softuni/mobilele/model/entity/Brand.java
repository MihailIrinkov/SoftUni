package org.softuni.mobilele.model.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "brands")
@NamedEntityGraph(
        name = "brandsWithModels",
        attributeNodes = @NamedAttributeNode("models")
)
public class Brand extends BaseEntity{

    @Column(unique = true, nullable = false)
    private String name;

    @OneToMany(
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            mappedBy = "brand"
    )
    private List<Model> models;

    public Brand() {
    }

    public List<Model> getModels() {
        return models;
    }

    public void setModels(List<Model> models) {
        this.models = models;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
