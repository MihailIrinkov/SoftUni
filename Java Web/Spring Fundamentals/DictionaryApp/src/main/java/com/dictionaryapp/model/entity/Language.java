package com.dictionaryapp.model.entity;

import com.dictionaryapp.model.enums.LanguageName;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "languages")
public class Language extends BaseEntity{

    @Column(nullable = false, unique = true)
    @Enumerated(EnumType.STRING)
    private LanguageName name;

    @Column(nullable = false)
    private String description;

    @OneToMany
    private List<Word> words;

    public Language() {
        words = new ArrayList<>();
    }

    public LanguageName getName() {
        return name;
    }

    public Language setName(LanguageName name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Language setDescription(String description) {
        this.description = description;
        return this;
    }

    public List<Word> getWords() {
        return words;
    }

    public Language setWords(List<Word> words) {
        this.words = words;
        return this;
    }
}
