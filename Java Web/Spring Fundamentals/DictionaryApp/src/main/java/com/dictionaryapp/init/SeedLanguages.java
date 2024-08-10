package com.dictionaryapp.init;

import com.dictionaryapp.model.entity.Language;
import com.dictionaryapp.model.enums.LanguageName;
import com.dictionaryapp.repo.LanguageRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class SeedLanguages implements CommandLineRunner {

    private final LanguageRepository languageRepository;

    public SeedLanguages(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        if (languageRepository.count() == 0) {

            List<Language> languages = Arrays.stream(LanguageName.values())
                    .map(languageName -> new Language().setName(languageName))
                    .collect(Collectors.toList());

            for (Language l : languages) {
                if (l.getName().toString().equals("GERMAN")) {
                    l.setDescription("A West Germanic language, is spoken by over 90 million people " +
                            "worldwide. Known for its complex grammar and compound words, " +
                            "it's the official language of Germany and widely used in Europe.");
                } else if (l.getName().toString().equals("SPANISH")) {
                    l.setDescription("A Romance language, is spoken by over 460 million people worldwide. " +
                            "It boasts a rich history, diverse dialects, " +
                            "and is known for its melodious sound, making it a global cultural treasure.");
                } else if (l.getName().toString().equals("FRENCH")) {
                    l.setDescription("A Romance language spoken worldwide, " +
                            "known for its elegance and cultural richness. " +
                            "It's the official language of France and numerous nations, " +
                            "famed for its cuisine, art, and literature.");
                } else if (l.getName().toString().equals("ITALIAN")) {
                    l.setDescription("A Romance language spoken in Italy and parts of Switzerland, " +
                            "with rich cultural heritage. Known for its melodious sounds, " +
                            "it's a gateway to Italian art, cuisine, and history.");
                }
            }
            this.languageRepository.saveAll(languages);
        }
    }
}
