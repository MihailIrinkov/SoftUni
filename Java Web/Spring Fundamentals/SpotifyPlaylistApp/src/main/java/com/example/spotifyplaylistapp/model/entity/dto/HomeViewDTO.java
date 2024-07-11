package com.example.spotifyplaylistapp.model.entity.dto;

import java.util.ArrayList;
import java.util.List;

public class HomeViewDTO {

    private List<SongDTO> popSongs;

    private List<SongDTO> rockSongs;

    private List<SongDTO> jazzSongs;

    private List<SongDTO> myPlayList;


    public HomeViewDTO() {
        this.popSongs = new ArrayList<>();
        this.rockSongs = new ArrayList<>();
        this.jazzSongs = new ArrayList<>();
        this.myPlayList = new ArrayList<>();
    }

    public List<SongDTO> getPopSongs() {
        return popSongs;
    }

    public HomeViewDTO setPopSongs(List<SongDTO> popSongs) {
        this.popSongs = popSongs;
        return this;
    }

    public List<SongDTO> getRockSongs() {
        return rockSongs;
    }

    public HomeViewDTO setRockSongs(List<SongDTO> rockSongs) {
        this.rockSongs = rockSongs;
        return this;
    }

    public List<SongDTO> getJazzSongs() {
        return jazzSongs;
    }

    public HomeViewDTO setJazzSongs(List<SongDTO> jazzSongs) {
        this.jazzSongs = jazzSongs;
        return this;
    }

    public List<SongDTO> getMyPlayList() {
        return myPlayList;
    }

    public HomeViewDTO setMyPlayList(List<SongDTO> myPlayList) {
        this.myPlayList = myPlayList;
        return this;
    }

    public String totalDuration(List<SongDTO> myPlayList) {

        int totalDuration = 0;

        for (int i = 0; i < myPlayList.size(); i++) {
            totalDuration = totalDuration + myPlayList.get(i).getDuration();
        }

        int S = totalDuration % 60;
        int H = totalDuration / 60;
        int M = H % 60;
        H = H / 60;
//        H + ":" + M + ":" + S

        String result = M + ":" + S;
        return result;
    }
}
