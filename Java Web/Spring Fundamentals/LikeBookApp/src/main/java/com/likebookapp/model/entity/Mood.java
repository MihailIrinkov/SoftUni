package com.likebookapp.model.entity;

import com.likebookapp.enums.MoodNameEnum;

import javax.persistence.*;

@Entity
@Table(name = "moods")
public class Mood extends BaseEntity{

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, unique = true)
    private MoodNameEnum moodName;

    @Column(columnDefinition = "TEXT", nullable = true)
    private String description;

    public Mood() {
    }

    public MoodNameEnum getMoodName() {
        return moodName;
    }

    public void setMoodName(MoodNameEnum moodName) {
        this.moodName = moodName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
