package com.example.spotifyplaylistapp.service.impl;

import com.example.spotifyplaylistapp.model.entity.Song;
import com.example.spotifyplaylistapp.model.entity.Style;
import com.example.spotifyplaylistapp.model.entity.StyleName;
import com.example.spotifyplaylistapp.model.entity.User;
import com.example.spotifyplaylistapp.model.entity.dto.HomeViewDTO;
import com.example.spotifyplaylistapp.model.entity.dto.SongDTO;
import com.example.spotifyplaylistapp.repository.SongRepo;
import com.example.spotifyplaylistapp.repository.StyleRepo;
import com.example.spotifyplaylistapp.repository.UserRepo;
import com.example.spotifyplaylistapp.service.HomeService;
import com.example.spotifyplaylistapp.service.LoggedUser;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class HomeServiceImpl implements HomeService {

    private final SongRepo songRepo;
    private final StyleRepo styleRepo;
    private final LoggedUser loggedUser;
    private final UserRepo userRepo;

    public HomeServiceImpl(SongRepo songRepo,
                           StyleRepo styleRepo,
                           LoggedUser loggedUser,
                           UserRepo userRepo) {
        this.songRepo = songRepo;
        this.styleRepo = styleRepo;
        this.loggedUser = loggedUser;
        this.userRepo = userRepo;
    }


    @Override
    public HomeViewDTO homeView() {

        HomeViewDTO homeViewDTO = new HomeViewDTO();
        User user = this.userRepo.findByUsername(loggedUser.getUsername()).get();
        List<SongDTO> playList = user.getPlaylist().stream()
                .map(song -> new SongDTO()
                        .setPerformer(song.getPerformer())
                        .setTitle(song.getTitle())
                        .setId(song.getId())
                        .setDuration(song.getDuration())).collect(Collectors.toList());

        Arrays.stream(StyleName.values())
                .forEach(styleName -> {
                    Style style = this.styleRepo.findByStyleName(styleName);

                    if (styleName.equals(StyleName.POP)) {
                        List<SongDTO> popSongs = this.songRepo.findAllByStyle(style).stream()
                                .map(song -> new SongDTO()
                                        .setDuration(song.getDuration())
                                        .setPerformer(song.getPerformer())
                                        .setId(song.getId())
                                        .setTitle(song.getTitle())).collect(Collectors.toList());

                        homeViewDTO.setPopSongs(popSongs);
                    } else if (styleName.equals(StyleName.ROCK)) {
                        List<SongDTO> rockSongs = this.songRepo.findAllByStyle(style).stream()
                                .map(song -> new SongDTO()
                                        .setDuration(song.getDuration())
                                        .setPerformer(song.getPerformer())
                                        .setId(song.getId())
                                        .setTitle(song.getTitle())).collect(Collectors.toList());
                        homeViewDTO.setRockSongs(rockSongs);
                    } else if (styleName.equals(StyleName.JAZZ)) {
                        List<SongDTO> jazzSongs = this.songRepo.findAllByStyle(style).stream()
                                .map(song -> new SongDTO()
                                        .setDuration(song.getDuration())
                                        .setPerformer(song.getPerformer())
                                        .setId(song.getId())
                                        .setTitle(song.getTitle())).collect(Collectors.toList());
                        homeViewDTO.setJazzSongs(jazzSongs);
                    }

                });

        homeViewDTO.setMyPlayList(playList);

        return homeViewDTO;
    }

    @Override
    public void addSongToPlayList(Long id) {
        User user = this.userRepo.findByUsername(loggedUser.getUsername()).get();
        Song songToAdd = this.songRepo.findById(id).get();

        List<Song> userSongs = user.getPlaylist();
        userSongs.add(songToAdd);
        this.userRepo.save(user);
    }

    @Override
    public void deletePlayList(String username) {
        User user = this.userRepo.findByUsername(username).get();
        user.getPlaylist().clear();

        this.userRepo.save(user);
    }


}
