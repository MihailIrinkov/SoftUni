package com.likebookapp.model.dto.post;

import com.likebookapp.enums.MoodNameEnum;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class PostBindingModel {

    private Long userId;

    @NotNull
    @Size(min = 2, max = 150, message = "Content length must be between 2 and 150 characters!")
    private String content;

    @NotNull(message = "You must select a mood!")
    private MoodNameEnum mood;

    public PostBindingModel() {
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public MoodNameEnum getMood() {
        return mood;
    }

    public void setMood(MoodNameEnum mood) {
        this.mood = mood;
    }
}
