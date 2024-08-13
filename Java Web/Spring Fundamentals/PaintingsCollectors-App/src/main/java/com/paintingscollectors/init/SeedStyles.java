package com.paintingscollectors.init;

import com.paintingscollectors.model.entity.Style;
import com.paintingscollectors.model.entity.StyleName;
import com.paintingscollectors.repository.StyleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SeedStyles implements CommandLineRunner {


    private final StyleRepository styleRepository;

    public SeedStyles(StyleRepository styleRepository) {
        this.styleRepository = styleRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        if (this.styleRepository.count() == 0) {
            List<Style> styles = new ArrayList<>();

            Style styleImpressionism = new Style()
                    .setName(StyleName.IMPRESSIONISM)
                    .setDescription("Impressionism is a painting style most commonly associated with the 19th century " +
                            "where small brush strokes are used to build up a larger picture.");
            styles.add(styleImpressionism);

            Style styleAbstract = new Style()
                    .setName(StyleName.ABSTRACT)
                    .setDescription("Abstract art does not attempt to represent recognizable subjects in a realistic manner.");
            styles.add(styleAbstract);

            Style styleExpressionism = new Style()
                    .setName(StyleName.EXPRESSIONISM)
                    .setDescription("Expressionism is a style of art that doesn't concern itself with realism.");
            styles.add(styleExpressionism);

            Style styleSurrealism = new Style()
                    .setName(StyleName.SURREALISM)
                    .setDescription("Surrealism is characterized by dreamlike, fantastical imagery that often defies logical explanation.");
            styles.add(styleSurrealism);

            Style styleRealism = new Style()
                    .setName(StyleName.REALISM)
                    .setDescription("Also known as naturalism, this style of art is considered as 'real art' " +
                            "and has been the dominant style of painting since the Renaissance.");
            styles.add(styleRealism);

            this.styleRepository.saveAll(styles);
        }
    }
}
