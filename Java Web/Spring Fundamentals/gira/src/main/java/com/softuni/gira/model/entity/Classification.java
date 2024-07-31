package com.softuni.gira.model.entity;

import com.softuni.gira.model.ClassificaionName;
import jakarta.persistence.*;

@Entity
@Table
public class Classification extends BaseEntity{

    @Column(unique = true)
    @Enumerated(EnumType.STRING)
    private ClassificaionName classificaionName;

    @Column
    private String description;

    public Classification() {
    }

    public ClassificaionName getClassificaionName() {
        return classificaionName;
    }

    public Classification setClassificaionName(ClassificaionName classificaionName) {
        this.classificaionName = classificaionName;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Classification setDescription(String description) {
        this.description = description;
        return this;
    }
}
