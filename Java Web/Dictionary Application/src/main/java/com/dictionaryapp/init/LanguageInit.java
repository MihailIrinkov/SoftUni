package com.dictionaryapp.init;

import com.dictionaryapp.enums.LanguageNameEnum;
import com.dictionaryapp.model.entity.Language;
import com.dictionaryapp.repo.LanguageRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class LanguageInit implements CommandLineRunner {

    private final LanguageRepository languageRepository;

    public LanguageInit(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        List<Language> languages = new ArrayList<>();
        if(languageRepository.count() == 0) {
            Arrays.stream(LanguageNameEnum.values())
                    .forEach(languageNameEnum -> {
                        Language language = new Language();
                        language.setLanguageName(languageNameEnum);
                        languages.add(language);
                    });
        }

        languageRepository.saveAll(languages);
    }
}
