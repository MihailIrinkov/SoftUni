package com.dictionaryapp.service;

import com.dictionaryapp.model.dto.word.WordBindingModel;
import com.dictionaryapp.model.dto.word.WordHomeViewModel;
import com.dictionaryapp.model.entity.Language;

public interface WordService {

    WordHomeViewModel getWords();

    Long getWordsCount();

    boolean addWord(WordBindingModel wordBindingModel);

    void removeById(Long id);

    void removeAll();
}
