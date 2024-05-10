package com.dictionaryapp.model.dto.word;

import java.util.ArrayList;
import java.util.List;

public class WordHomeViewModel {

    List<WordDTO> germanWords;
    List<WordDTO> frenchWords;
    List<WordDTO> spanishWords;
    List<WordDTO> italianWords;

//    public WordHomeViewModel() {
//        this.germanWords = new ArrayList<>();
//        this.frenchWords = new ArrayList<>();
//        this.spanishWords = new ArrayList<>();
//        this.italianWords = new ArrayList<>();
//    }


    public WordHomeViewModel() {
    }

    public WordHomeViewModel(List<WordDTO> germanWords, List<WordDTO> frenchWords, List<WordDTO> spanishWords, List<WordDTO> italianWords) {
        this.germanWords = germanWords;
        this.frenchWords = frenchWords;
        this.spanishWords = spanishWords;
        this.italianWords = italianWords;
    }

    public List<WordDTO> getGermanWords() {
        return germanWords;
    }

    public void setGermanWords(List<WordDTO> germanWords) {
        this.germanWords = germanWords;
    }

    public List<WordDTO> getFrenchWords() {
        return frenchWords;
    }

    public void setFrenchWords(List<WordDTO> frenchWords) {
        this.frenchWords = frenchWords;
    }

    public List<WordDTO> getSpanishWords() {
        return spanishWords;
    }

    public void setSpanishWords(List<WordDTO> spanishWords) {
        this.spanishWords = spanishWords;
    }

    public List<WordDTO> getItalianWords() {
        return italianWords;
    }

    public void setItalianWords(List<WordDTO> italianWords) {
        this.italianWords = italianWords;
    }


    public Integer getTotalCount() {
        return this.germanWords.size()
                + this.frenchWords.size()
                + this.spanishWords.size()
                + this.italianWords.size();
    }

}
