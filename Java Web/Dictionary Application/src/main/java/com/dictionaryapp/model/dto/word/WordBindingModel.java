package com.dictionaryapp.model.dto.word;

import com.dictionaryapp.enums.LanguageNameEnum;
import com.dictionaryapp.model.entity.Language;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class WordBindingModel {

    private Long id;
    @NotNull
    @Size(min = 2, max = 40, message = "The term length must be between 2 and 40 characters!")
    private String term;


    @NotNull
    @Size(min = 2, max = 80, message = "The translation length must be between 2 and 80 characters!")
    private String translation;

    @Size(min = 2, max = 200, message = "The example length must be between 2 and 200 characters!")
    private String example;

    @NotNull(message = "The input date must be in the past or present!")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @PastOrPresent(message = "The input date must be in the past or present!")
    private LocalDate inputDate;


    @NotNull(message = "You must select a language!")
    private LanguageNameEnum language;

    public WordBindingModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public LanguageNameEnum getLanguage() {
        return language;
    }

    public void setLanguage(LanguageNameEnum language) {
        this.language = language;
    }
}
