package com.dictionaryapp.model.dto;

import com.dictionaryapp.model.entity.Language;
import com.dictionaryapp.model.entity.User;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

public class AddWordBindingModel {

    @NotBlank
    @Size(min = 2, max = 40)
    private String term;

    @NotBlank
    @Size(min = 2, max = 80)
    private String translation;

    @Size(min = 2, max = 200)
    private String example;

    @NotNull
    @PastOrPresent
    private LocalDate inputDate;

    @NotBlank(message = "You must select a language!")
    private String language;

    private User addedBy;

    public AddWordBindingModel() {
    }

    public String getTerm() {
        return term;
    }

    public AddWordBindingModel setTerm(String term) {
        this.term = term;
        return this;
    }

    public String getTranslation() {
        return translation;
    }

    public AddWordBindingModel setTranslation(String translation) {
        this.translation = translation;
        return this;
    }

    public String getExample() {
        return example;
    }

    public AddWordBindingModel setExample(String example) {
        this.example = example;
        return this;
    }

    public LocalDate getInputDate() {
        return inputDate;
    }

    public AddWordBindingModel setInputDate(LocalDate inputDate) {
        this.inputDate = inputDate;
        return this;
    }

    public String getLanguage() {
        return language;
    }

    public AddWordBindingModel setLanguage(String language) {
        this.language = language;
        return this;
    }

    public User getAddedBy() {
        return addedBy;
    }

    public AddWordBindingModel setAddedBy(User addedBy) {
        this.addedBy = addedBy;
        return this;
    }
}
