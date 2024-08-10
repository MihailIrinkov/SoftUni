package com.dictionaryapp.model.dto;

import java.util.ArrayList;
import java.util.List;

public class HomeViewDTO {

    private List<WordDTO> germanWords;
    private List<WordDTO> spanishWords;
    private List<WordDTO> frenchWords;
    private List<WordDTO> italianWords;

    public HomeViewDTO() {
        germanWords = new ArrayList<>();
        spanishWords = new ArrayList<>();
        frenchWords = new ArrayList<>();
        italianWords = new ArrayList<>();
    }

    public List<WordDTO> getGermanWords() {
        return germanWords;
    }

    public HomeViewDTO setGermanWords(List<WordDTO> germanWords) {
        this.germanWords = germanWords;
        return this;
    }

    public List<WordDTO> getSpanishWords() {
        return spanishWords;
    }

    public HomeViewDTO setSpanishWords(List<WordDTO> spanishWords) {
        this.spanishWords = spanishWords;
        return this;
    }

    public List<WordDTO> getFrenchWords() {
        return frenchWords;
    }

    public HomeViewDTO setFrenchWords(List<WordDTO> frenchWords) {
        this.frenchWords = frenchWords;
        return this;
    }

    public List<WordDTO> getItalianWords() {
        return italianWords;
    }

    public HomeViewDTO setItalianWords(List<WordDTO> italianWords) {
        this.italianWords = italianWords;
        return this;
    }

    public int getCount(List<WordDTO> words) {
        return words.size();
    }

    public int getAllWordsCount () {
        int count = 0;

        count = count + this.germanWords.size();
        count = count + this.spanishWords.size();
        count = count + this.frenchWords.size();
        count = count + this.italianWords.size();

        return count;
    }
}
