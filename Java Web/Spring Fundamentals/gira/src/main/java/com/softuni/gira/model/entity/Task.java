package com.softuni.gira.model.entity;

import com.softuni.gira.model.Progress;
import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;

@Entity
@Table(name = "tasks")
public class Task extends BaseEntity{

    @Column(unique = true)
    @Length(min = 3, max = 20)
    private String name;

    @Column
    @Length(min = 5)
    private String description;

    @Column
    @Enumerated(EnumType.STRING)
    private Progress progress;

    @Column
    @FutureOrPresent
    private LocalDate dueDate;

    @ManyToOne
    @NotNull
    private Classification classification;

    @ManyToOne
    @NotNull
    private User user;

    public Task() {
    }

    public String getName() {
        return name;
    }

    public Task setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Task setDescription(String description) {
        this.description = description;
        return this;
    }

    public Progress getProgress() {
        return progress;
    }

    public Task setProgress(Progress progress) {
        this.progress = progress;
        return this;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public Task setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
        return this;
    }

    public Classification getClassification() {
        return classification;
    }

    public Task setClassification(Classification classification) {
        this.classification = classification;
        return this;
    }

    public User getUser() {
        return user;
    }

    public Task setUser(User user) {
        this.user = user;
        return this;
    }
}
