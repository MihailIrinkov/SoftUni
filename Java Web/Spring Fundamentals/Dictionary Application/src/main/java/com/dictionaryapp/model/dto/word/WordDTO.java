package com.dictionaryapp.model.dto.word;

import com.dictionaryapp.model.entity.Language;
import com.dictionaryapp.model.entity.User;
import com.dictionaryapp.model.entity.Word;

import java.time.LocalDate;

public class WordDTO {

    private Long id;
    private String term;

    private String translation;

    private String example;

    private LocalDate inputDate;

    private Language language;

    private User addedBy;

    public WordDTO() {
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

    public static WordDTO createFromWord(Word word) {
        WordDTO wordDTO = new WordDTO();

        wordDTO.setId(word.getId());
        wordDTO.setTerm(word.getTerm());
        wordDTO.setTranslation(word.getTranslation());
        wordDTO.setExample(word.getExample());
        wordDTO.setInputDate(word.getInputDate());
        wordDTO.setLanguage(word.getLanguage());
        wordDTO.setAddedBy(word.getAddedBy());

        return wordDTO;
    }
}
