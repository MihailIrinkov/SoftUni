package com.example.spotifyplaylistapp.init;

import com.example.spotifyplaylistapp.model.entity.Style;
import com.example.spotifyplaylistapp.model.entity.StyleName;
import com.example.spotifyplaylistapp.repository.StyleRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class SeedStyles implements CommandLineRunner {

    private final StyleRepo styleRepo;

    public SeedStyles(StyleRepo styleRepo) {
        this.styleRepo = styleRepo;
    }

    @Override
    public void run(String... args) throws Exception {

        if (this.styleRepo.count() == 0) {
            List<Style> styles = new ArrayList<>();

            Arrays.stream(StyleName.values()).forEach(styleName -> {
                Style style = new Style();
                style.setStyleName(styleName);
                styles.add(style);
            });
            this.styleRepo.saveAll(styles);
        }

    }
}
