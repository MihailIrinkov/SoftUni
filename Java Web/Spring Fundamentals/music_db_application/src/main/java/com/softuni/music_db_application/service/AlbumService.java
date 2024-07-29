package com.softuni.music_db_application.service;

import com.softuni.music_db_application.model.dto.AddAlbumBindingModel;
import com.softuni.music_db_application.model.dto.AlbumDTO;
import com.softuni.music_db_application.model.entity.Album;

import java.util.List;

public interface AlbumService {

    void addAlbum(AddAlbumBindingModel addAlbumBindingModel);

    List<AlbumDTO> getAllAlbums();

    void delete(Long id);
}
