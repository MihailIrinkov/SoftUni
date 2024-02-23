package com.dictionaryapp.model.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "words")
public class Word extends BaseEntity {

    @Column(nullable = false)
    private String term;

    @Column(nullable = false)
    private String translation;

    @Column(columnDefinition = "TEXT")
    private String example;

    @Column
    private LocalDate inputDate;

    @ManyToOne
    private Language language;

    @ManyToOne(fetch = FetchType.EAGER)
    private User addedBy;

    public Word() {
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }

    public String getExample() {
        return example;
    }

    public void setExample(String example) {
        this.example = example;
    }

    public LocalDate getInputDate() {
        return inputDate;
    }

    public void setInputDate(LocalDate inputDate) {
        this.inputDate = inputDate;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public User getAddedBy() {
        return addedBy;
    }

    public void setAddedBy(User addedBy) {
        this.addedBy = addedBy;
    }
}
