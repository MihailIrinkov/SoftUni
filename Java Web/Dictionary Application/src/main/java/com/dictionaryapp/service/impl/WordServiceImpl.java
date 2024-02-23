package com.dictionaryapp.service.impl;

import com.dictionaryapp.enums.LanguageNameEnum;
import com.dictionaryapp.model.dto.word.WordBindingModel;
import com.dictionaryapp.model.dto.word.WordDTO;
import com.dictionaryapp.model.dto.word.WordHomeViewModel;
import com.dictionaryapp.model.entity.Language;
import com.dictionaryapp.model.entity.User;
import com.dictionaryapp.model.entity.Word;
import com.dictionaryapp.repo.LanguageRepository;
import com.dictionaryapp.repo.UserRepository;
import com.dictionaryapp.repo.WordRepository;
import com.dictionaryapp.service.LoggedUser;
import com.dictionaryapp.service.WordService;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class WordServiceImpl implements WordService {

    private final WordRepository wordRepository;
    private final LanguageRepository languageRepository;

    private final UserRepository userRepository;

    private final LoggedUser loggedUser;

    public WordServiceImpl(WordRepository wordRepository, LanguageRepository languageRepository, UserRepository userRepository, LoggedUser loggedUser) {
        this.wordRepository = wordRepository;
        this.languageRepository = languageRepository;
        this.userRepository = userRepository;
        this.loggedUser = loggedUser;
    }

    @Override
    public WordHomeViewModel getWords() {
        String username = loggedUser.getUsername();


        Language german = languageRepository.findByLanguageName(LanguageNameEnum.valueOf("GERMAN"));
        List<WordDTO> germanWords = getWordLangageDTOS(german, username);

        Language french = languageRepository.findByLanguageName(LanguageNameEnum.valueOf("FRENCH"));
        List<WordDTO> frenchWords = getWordLangageDTOS(french, username);

        Language spanish = languageRepository.findByLanguageName(LanguageNameEnum.valueOf("SPANISH"));
        List<WordDTO> spanishWords = getWordLangageDTOS(spanish, username);

        Language italian = languageRepository.findByLanguageName(LanguageNameEnum.valueOf("ITALIAN"));
        List<WordDTO> italianWords = getWordLangageDTOS(italian, username);

        return new WordHomeViewModel(germanWords, frenchWords, spanishWords, italianWords);
    }

    public Long getWordsCount() {
        return this.wordRepository.count();
    }

    @Override
    public boolean addWord(WordBindingModel wordBindingModel) {
        if (!loggedUser.isLogged()) {
            return false;
        }
        User user = userRepository.findAllByUsername(loggedUser.getUsername());
        Language language = languageRepository
                .findByLanguageName(wordBindingModel.getLanguage());

        if (user != null) {
            Word word = new Word();

            word.setAddedBy(user);
            word.setTerm(wordBindingModel.getTerm());
            word.setTranslation(wordBindingModel.getTranslation());
            word.setExample(wordBindingModel.getExample());
            word.setInputDate(wordBindingModel.getInputDate());
            word.setLanguage(language);

            user.getAddedWords().add(word);

            this.wordRepository.save(word);
            this.userRepository.save(user);
            return true;
        }

        return false;
    }

    @Override
    public void removeById(Long id) {
        Optional<Word> wordById = this.wordRepository.findById(id);

        if (wordById.isPresent()) {
            Word wordToRemove = wordById.get();
//            String username = loggedUser.getUsername();
//
//            User user = userRepository.findAllByUsername(username);
//
//            List<Word> addedWords = user.getAddedWords();
//            addedWords.remove(wordToRemove);
//
//            this.userRepository.save(user);
//            this.wordRepository.delete(wordToRemove);

            User addedBy = wordToRemove.getAddedBy();
            List<Word> addedWords = addedBy.getAddedWords();
            addedWords.remove(wordToRemove);

            this.userRepository.save(addedBy);
            this.wordRepository.delete(wordToRemove);
        }

    }

    @Override
    public void removeAll() {
        User user = userRepository.findAllByUsername(loggedUser.getUsername());
        List<Word> addedWords = user.getAddedWords();
        addedWords.clear();
        this.userRepository.save(user);
        this.wordRepository.deleteAll();
    }

    private List<WordDTO> getWordLangageDTOS(Language language, String username) {
        List<WordDTO> wordsByLanguageAndUser =
                this.wordRepository.findByLanguageAndAddedBy_Username(language, username)
                        .stream()
                        .map(word -> WordDTO.createFromWord(word))
                        .collect(Collectors.toList());
        return wordsByLanguageAndUser;
    }
}
