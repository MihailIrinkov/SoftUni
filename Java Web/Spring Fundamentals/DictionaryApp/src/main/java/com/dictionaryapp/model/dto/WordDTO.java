package com.dictionaryapp.model.dto;

import com.dictionaryapp.model.entity.User;

import java.time.LocalDate;

public class WordDTO {

    private Long id;

    private String term;

    private String translation;

    private String example;

    private LocalDate inputDate;

    private User addedBy;

    public WordDTO() {
    }

    public Long getId() {
        return id;
    }

    public WordDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getTerm() {
        return term;
    }

    public WordDTO setTerm(String term) {
        this.term = term;
        return this;
    }

    public String getTranslation() {
        return translation;
    }

    public WordDTO setTranslation(String translation) {
        this.translation = translation;
        return this;
    }

    public String getExample() {
        return example;
    }

    public WordDTO setExample(String example) {
        this.example = example;
        return this;
    }

    public LocalDate getInputDate() {
        return inputDate;
    }

    public WordDTO setInputDate(LocalDate inputDate) {
        this.inputDate = inputDate;
        return this;
    }

    public User getAddedBy() {
        return addedBy;
    }

    public WordDTO setAddedBy(User addedBy) {
        this.addedBy = addedBy;
        return this;
    }
}
