package com.softuni.gira.model.dto;

import com.softuni.gira.model.Progress;

import java.time.LocalDate;

public class TaskDTO {

    private String name;

    private UserDTO user;

    private String classification;

    private LocalDate dueDate;

    private Progress progress;

    public TaskDTO() {
    }

    public String getName() {
        return name;
    }

    public TaskDTO setName(String name) {
        this.name = name;
        return this;
    }

    public UserDTO getUser() {
        return user;
    }

    public TaskDTO setUser(UserDTO user) {
        this.user = user;
        return this;
    }

    public String getClassification() {
        return classification;
    }

    public TaskDTO setClassification(String classification) {
        this.classification = classification;
        return this;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public TaskDTO setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
        return this;
    }

    public Progress getProgress() {
        return progress;
    }

    public TaskDTO setProgress(Progress progress) {
        this.progress = progress;
        return this;
    }
}
