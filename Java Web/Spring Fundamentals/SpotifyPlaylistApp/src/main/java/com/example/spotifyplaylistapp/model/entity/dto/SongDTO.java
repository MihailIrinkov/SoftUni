package com.example.spotifyplaylistapp.model.entity.dto;

public class SongDTO {

    private Long id;

    private String performer;

    private String title;

    private int duration;

    public SongDTO() {
    }

    public String getPerformer() {
        return performer;
    }

    public SongDTO setPerformer(String performer) {
        this.performer = performer;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public SongDTO setTitle(String title) {
        this.title = title;
        return this;
    }

    public int getDuration() {
        return duration;
    }

    public SongDTO setDuration(int duration) {
        this.duration = duration;
        return this;
    }

    public Long getId() {
        return id;
    }

    public SongDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getDurationInMin(int duration) {

        int S = duration % 60;
        int H = duration / 60;
        int M = H % 60;
        H = H / 60;

        String result = M + ":" + S;

        return result;
    }
}
