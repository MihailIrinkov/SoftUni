package org.softuni.mobilele.model.entity;

import jakarta.persistence.*;
import org.softuni.mobilele.enums.ModelCategory;

@Entity
@Table(name = "models")
public class Model extends BaseEntity{

    @Column
    private String name;

    @Enumerated(EnumType.STRING)
    private ModelCategory category;

    @ManyToOne
    private Brand brand;

    public Model() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ModelCategory getCategory() {
        return category;
    }

    public void setCategory(ModelCategory category) {
        this.category = category;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }
}
