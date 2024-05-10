package com.likebookapp.init;

import com.likebookapp.enums.MoodNameEnum;
import com.likebookapp.model.entity.Mood;
import com.likebookapp.repository.MoodRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class MoodInit implements CommandLineRunner {

    private final MoodRepository moodRepository;

    public MoodInit(MoodRepository moodRepository) {
        this.moodRepository = moodRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        List<Mood> moods = new ArrayList<>();
        if (this.moodRepository.count() == 0) {
            Arrays.stream(MoodNameEnum.values())
                    .forEach(m -> {
                        Mood mood = new Mood();
                        mood.setMoodName(m);
                        moods.add(mood);
                    });
        }

        moodRepository.saveAll(moods);
    }
}
