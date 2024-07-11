package com.example.spotifyplaylistapp.model.entity.dto;

import com.example.spotifyplaylistapp.model.entity.Style;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.time.LocalDate;

public class AddSongBindingModel {

    @NotBlank
    @Size(min = 3, max = 20)
    private String performer;

    @NotBlank
    @Size(min = 2, max = 20)
    private String title;

    @NotNull
    @Positive
    private int duration;

    @PastOrPresent
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "You must select a date!")
    private LocalDate releaseDate;

    @NotNull(message = "You must select a stile!")
    private String style;

    public AddSongBindingModel() {
    }

    public String getPerformer() {
        return performer;
    }

    public AddSongBindingModel setPerformer(String performer) {
        this.performer = performer;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public AddSongBindingModel setTitle(String title) {
        this.title = title;
        return this;
    }

    public int getDuration() {
        return duration;
    }

    public AddSongBindingModel setDuration(int duration) {
        this.duration = duration;
        return this;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public AddSongBindingModel setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
        return this;
    }

    public String getStyle() {
        return style;
    }

    public AddSongBindingModel setStyle(String style) {
        this.style = style;
        return this;
    }
}
