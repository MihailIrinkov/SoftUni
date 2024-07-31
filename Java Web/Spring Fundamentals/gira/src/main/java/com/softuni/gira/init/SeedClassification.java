package com.softuni.gira.init;

import com.softuni.gira.model.ClassificaionName;
import com.softuni.gira.model.entity.Classification;
import com.softuni.gira.repository.ClassificationRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class SeedClassification implements CommandLineRunner {

    private final ClassificationRepository classificationRepository;

    public SeedClassification(ClassificationRepository classificationRepository) {
        this.classificationRepository = classificationRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (this.classificationRepository.count() == 0) {


            List<Classification> classifications = Arrays.stream(ClassificaionName.values())
                    .map(classificaionName ->
                            new Classification()
                                    .setClassificaionName(classificaionName))
                    .collect(Collectors.toList());
            this.classificationRepository.saveAll(classifications);
        }
    }
}
