package com.dictionaryapp.model.entity;

import com.dictionaryapp.enums.LanguageNameEnum;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "languages")
public class Language extends BaseEntity{

    @Column(unique = true, nullable = false)
    @Enumerated(EnumType.STRING)
    private LanguageNameEnum languageName;

    @Column
    private String description;

    @OneToMany(mappedBy = "language")
    private List<Word> words;

    public Language() {
    }

    public LanguageNameEnum getLanguageName() {
        return languageName;
    }

    public void setLanguageName(LanguageNameEnum languageName) {
        this.languageName = languageName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Word> getWords() {
        return words;
    }

    public void setWords(List<Word> words) {
        this.words = words;
    }
}
