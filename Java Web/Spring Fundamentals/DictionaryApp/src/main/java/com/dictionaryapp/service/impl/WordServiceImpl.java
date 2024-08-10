package com.dictionaryapp.service.impl;

import com.dictionaryapp.model.dto.AddWordBindingModel;
import com.dictionaryapp.model.dto.HomeViewDTO;
import com.dictionaryapp.model.dto.WordDTO;
import com.dictionaryapp.model.entity.Language;
import com.dictionaryapp.model.entity.User;
import com.dictionaryapp.model.entity.Word;
import com.dictionaryapp.model.enums.LanguageName;
import com.dictionaryapp.repo.LanguageRepository;
import com.dictionaryapp.repo.UserRepository;
import com.dictionaryapp.repo.WordRepository;
import com.dictionaryapp.service.LoggedUser;
import com.dictionaryapp.service.WordService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WordServiceImpl implements WordService {

    private final WordRepository wordRepository;
    private final UserRepository userRepository;
    private final LanguageRepository languageRepository;
    private final LoggedUser loggedUser;

    public WordServiceImpl(WordRepository wordRepository,
                           UserRepository userRepository,
                           LanguageRepository languageRepository,
                           LoggedUser loggedUser) {
        this.wordRepository = wordRepository;
        this.userRepository = userRepository;
        this.languageRepository = languageRepository;
        this.loggedUser = loggedUser;
    }


    @Override
    public HomeViewDTO getAll() {

        HomeViewDTO homeViewDTO = new HomeViewDTO();

        List<Word> germanWords = this.wordRepository.findAllByLanguageName(LanguageName.GERMAN);
        homeViewDTO.setGermanWords(extractedWords(germanWords));

        List<Word> spanishWords = this.wordRepository.findAllByLanguageName(LanguageName.SPANISH);
        homeViewDTO.setSpanishWords(extractedWords(spanishWords));

        List<Word> frenchWords = this.wordRepository.findAllByLanguageName(LanguageName.FRENCH);
        homeViewDTO.setFrenchWords(extractedWords(frenchWords));

        List<Word> italianWords = this.wordRepository.findAllByLanguageName(LanguageName.ITALIAN);
        homeViewDTO.setItalianWords(extractedWords(italianWords));

//        User user = this.userRepository.findByUsername(loggedUser.getUsername()).get();
//
//        List<Word> words = user.getAddedWords();
//
//        for (Word w : words) {
//            if (w.getLanguage().getName().toString().equals("GERMAN")) {
//                WordDTO wordDTO = new WordDTO()
//                        .setAddedBy(user)
//                        .setExample(w.getExample())
//                        .setTerm(w.getTerm())
//                        .setTranslation(w.getTranslation())
//                        .setInputDate(w.getInputDate());
//                homeViewDTO.getGermanWords().add(wordDTO);
//            } else if (w.getLanguage().getName().toString().equals("SPANISH")) {
//                WordDTO wordDTO = new WordDTO()
//                        .setAddedBy(user)
//                        .setExample(w.getExample())
//                        .setTerm(w.getTerm())
//                        .setTranslation(w.getTranslation())
//                        .setInputDate(w.getInputDate());
//                homeViewDTO.getSpanishWords().add(wordDTO);
//            } else if (w.getLanguage().getName().toString().equals("FRENCH")) {
//                WordDTO wordDTO = new WordDTO()
//                        .setAddedBy(user)
//                        .setExample(w.getExample())
//                        .setTerm(w.getTerm())
//                        .setTranslation(w.getTranslation())
//                        .setInputDate(w.getInputDate());
//                homeViewDTO.getFrenchWords().add(wordDTO);
//            } else if (w.getLanguage().getName().toString().equals("ITALIAN")) {
//                WordDTO wordDTO = new WordDTO()
//                        .setAddedBy(user)
//                        .setExample(w.getExample())
//                        .setTerm(w.getTerm())
//                        .setTranslation(w.getTranslation())
//                        .setInputDate(w.getInputDate());
//                homeViewDTO.getItalianWords().add(wordDTO);
//            }
//        }

        return homeViewDTO;
    }

    @Override
    public void addWord(AddWordBindingModel addWordBindingModel) {

        User user = this.userRepository.findByUsername(loggedUser.getUsername()).get();
        Language language = this.languageRepository
                .findByName(LanguageName.valueOf(addWordBindingModel.getLanguage())).get();

        Word wordToSave = new Word()
                .setAddedBy(user)
                .setExample(addWordBindingModel.getExample())
                .setTerm(addWordBindingModel.getTerm())
                .setInputDate(addWordBindingModel.getInputDate())
                .setTranslation(addWordBindingModel.getTranslation())
                .setLanguage(language);

        this.wordRepository.save(wordToSave);

    }

    @Override
    public void delete(Long id) {
        this.wordRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        this.wordRepository.deleteAll();
    }

    private List<WordDTO> extractedWords(List<Word> wordsList) {
        List<WordDTO> wordDTOS = new ArrayList<>();
        for (Word w : wordsList) {
            User user = this.userRepository.findById(w.getAddedBy().getId()).get();
            WordDTO wordDTO = new WordDTO()
                    .setId(w.getId())
                    .setAddedBy(user)
                    .setExample(w.getExample())
                    .setTerm(w.getTerm())
                    .setTranslation(w.getTranslation())
                    .setInputDate(w.getInputDate());
            wordDTOS.add(wordDTO);
        }
        return wordDTOS;
    }
}
