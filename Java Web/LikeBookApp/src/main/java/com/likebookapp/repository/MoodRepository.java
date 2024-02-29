package com.likebookapp.repository;

import com.likebookapp.enums.MoodNameEnum;
import com.likebookapp.model.entity.Mood;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MoodRepository extends JpaRepository<Mood, Long> {

    Mood findByMoodName(MoodNameEnum moodName);
}
