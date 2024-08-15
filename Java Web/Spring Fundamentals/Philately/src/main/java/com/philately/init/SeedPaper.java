package com.philately.init;

import com.philately.model.entity.Paper;
import com.philately.model.entity.PaperName;
import com.philately.repository.PaperRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SeedPaper implements CommandLineRunner {

    private final PaperRepository paperRepository;

    public SeedPaper(PaperRepository paperRepository) {
        this.paperRepository = paperRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        if (this.paperRepository.count() == 0) {
            List<Paper> papers = new ArrayList<>();

            Paper paperWove = new Paper()
                    .setName(PaperName.WOVE_PAPER)
                    .setDescription("Has an even texture without any particular distinguishing features.");
            papers.add(paperWove);

            Paper paperLaid = new Paper()
                    .setName(PaperName.LAID_PAPER)
                    .setDescription("When held up to the light, shows parallel lines of greater or less width running across the stamp.");
            papers.add(paperLaid);

            Paper paperGranit = new Paper()
                    .setName(PaperName.GRANITE_PAPER)
                    .setDescription("Has tiny specks of coloured fibre in it, which can usually be seen with the naked eye.");
            papers.add(paperGranit);

            this.paperRepository.saveAll(papers);
        }
    }
}
