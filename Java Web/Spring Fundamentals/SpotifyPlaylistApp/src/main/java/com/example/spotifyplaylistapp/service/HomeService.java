package com.example.spotifyplaylistapp.service;

import com.example.spotifyplaylistapp.model.entity.dto.HomeViewDTO;
import com.example.spotifyplaylistapp.model.entity.dto.SongDTO;

public interface HomeService {

    HomeViewDTO homeView();

    void addSongToPlayList(Long id);

    void deletePlayList(String username);
}
