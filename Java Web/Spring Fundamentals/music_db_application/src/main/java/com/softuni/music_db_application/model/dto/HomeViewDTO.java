package com.softuni.music_db_application.model.dto;

import java.util.ArrayList;
import java.util.List;

public class HomeViewDTO {

    private List<AlbumDTO> albums;

    public HomeViewDTO() {
        this.albums = new ArrayList<>();
    }

    public List<AlbumDTO> getAlbums() {
        return albums;
    }

    public HomeViewDTO setAlbums(List<AlbumDTO> albums) {
        this.albums = albums;
        return this;
    }

    public int getAlbumsCount () {

        int albumsCount = 0;

        for (AlbumDTO album : albums) {
           albumsCount = albumsCount + album.getCopies();
        }

        return albumsCount;
    }
}
