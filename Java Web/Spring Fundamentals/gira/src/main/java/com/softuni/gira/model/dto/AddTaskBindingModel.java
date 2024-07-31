package com.softuni.gira.model.dto;

import com.softuni.gira.model.entity.Classification;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class AddTaskBindingModel {

    @Size(min = 3, max = 20)
    private String name;

    @Size(min = 5, message = "Description length must be more than 5 characters!")
    private String description;

    @FutureOrPresent
    private LocalDate dueDate;

    @NotNull
    private String classification;

    public AddTaskBindingModel(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public AddTaskBindingModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public AddTaskBindingModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public AddTaskBindingModel setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
        return this;
    }

    public String getClassification() {
        return classification;
    }

    public AddTaskBindingModel setClassification(String classification) {
        this.classification = classification;
        return this;
    }
}
