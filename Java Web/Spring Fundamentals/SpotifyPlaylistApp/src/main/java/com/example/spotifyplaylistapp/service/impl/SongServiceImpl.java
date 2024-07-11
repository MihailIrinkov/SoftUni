package com.example.spotifyplaylistapp.service.impl;

import com.example.spotifyplaylistapp.model.entity.Song;
import com.example.spotifyplaylistapp.model.entity.Style;
import com.example.spotifyplaylistapp.model.entity.StyleName;
import com.example.spotifyplaylistapp.model.entity.User;
import com.example.spotifyplaylistapp.model.entity.dto.AddSongBindingModel;
import com.example.spotifyplaylistapp.repository.SongRepo;
import com.example.spotifyplaylistapp.repository.StyleRepo;
import com.example.spotifyplaylistapp.repository.UserRepo;
import com.example.spotifyplaylistapp.service.LoggedUser;
import com.example.spotifyplaylistapp.service.SongService;
import org.springframework.stereotype.Service;

@Service
public class SongServiceImpl implements SongService {

    private final SongRepo songRepo;
//    private final UserRepo userRepo;
    private final StyleRepo styleRepo;

    private final LoggedUser loggedUser;

    public SongServiceImpl(SongRepo songRepo,
//                           UserRepo userRepo,
                           StyleRepo styleRepo,
                           LoggedUser loggedUser) {
        this.songRepo = songRepo;
//        this.userRepo = userRepo;
        this.styleRepo = styleRepo;
        this.loggedUser = loggedUser;
    }

    @Override
    public void addSong(AddSongBindingModel addSongBindingModel) {

//        User user = this.userRepo.findByUsername(loggedUser.getUsername()).get();

        Style selectedStyle = this.styleRepo.findByStyleName(StyleName.valueOf(addSongBindingModel.getStyle()));

        Song songToSave = new Song()
                .setTitle(addSongBindingModel.getTitle())
                .setPerformer(addSongBindingModel.getPerformer())
                .setStyle(selectedStyle)
                .setReleaseDate(addSongBindingModel.getReleaseDate())
                .setDuration(addSongBindingModel.getDuration());

        this.songRepo.save(songToSave);

//        user.getPlaylist().add(songToSave);
//        this.userRepo.save(user);
    }
}
