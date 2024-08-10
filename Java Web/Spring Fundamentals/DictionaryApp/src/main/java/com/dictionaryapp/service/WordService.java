package com.dictionaryapp.service;

import com.dictionaryapp.model.dto.AddWordBindingModel;
import com.dictionaryapp.model.dto.HomeViewDTO;

public interface WordService {

    HomeViewDTO getAll();

    void addWord(AddWordBindingModel addWordBindingModel);

    void delete(Long id);

    void deleteAll();
}
