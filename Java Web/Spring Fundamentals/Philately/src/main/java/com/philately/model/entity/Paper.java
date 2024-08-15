package com.philately.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "papers")
public class Paper extends BaseEntity{

    @Column(unique = true, nullable = false)
    @Enumerated(EnumType.STRING)
    private PaperName name;

    @Column(nullable = false)
    private String description;

    public Paper() {
    }

    public PaperName getName() {
        return name;
    }

    public Paper setName(PaperName name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Paper setDescription(String description) {
        this.description = description;
        return this;
    }
}
