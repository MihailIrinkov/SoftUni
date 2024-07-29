package com.softuni.music_db_application.service.impl;

import com.softuni.music_db_application.init.ArtistRepository;
import com.softuni.music_db_application.model.dto.AddAlbumBindingModel;
import com.softuni.music_db_application.model.dto.AlbumDTO;
import com.softuni.music_db_application.model.entity.Album;
import com.softuni.music_db_application.model.entity.Artist;
import com.softuni.music_db_application.model.entity.GenreName;
import com.softuni.music_db_application.model.entity.User;
import com.softuni.music_db_application.repository.AlbumRepository;
import com.softuni.music_db_application.repository.UserRepository;
import com.softuni.music_db_application.service.AlbumService;
import com.softuni.music_db_application.service.LoggedUser;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AlbumServiceImpl implements AlbumService {

    private final LoggedUser loggedUser;
    private final AlbumRepository albumRepository;
    private final ArtistRepository artistRepository;
    private final UserRepository userRepository;

    public AlbumServiceImpl(LoggedUser loggedUser,
                            AlbumRepository albumRepository,
                            ArtistRepository artistRepository,
                            UserRepository userRepository) {
        this.loggedUser = loggedUser;
        this.albumRepository = albumRepository;
        this.artistRepository = artistRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void addAlbum(AddAlbumBindingModel addAlbumBindingModel) {

        Artist artist = this.artistRepository.findByName(addAlbumBindingModel.getArtist().getName()).get();

        User addedFrom = this.userRepository.findByUsername(loggedUser.getUsername()).get();

        Album album = new Album()
                .setName(addAlbumBindingModel.getName())
                .setImageUrl(addAlbumBindingModel.getImgUrl())
                .setPrice(addAlbumBindingModel.getPrice())
                .setCopies(addAlbumBindingModel.getCopies())
                .setReleasedDate(addAlbumBindingModel.getReleaseDate())
                .setProducer(addAlbumBindingModel.getProducer())
                .setArtist(artist)
                .setGenre(GenreName.valueOf(addAlbumBindingModel.getGenre()))
                .setAddedFrom(addedFrom)
                .setDescription(addAlbumBindingModel.getDescription());

        this.albumRepository.save(album);
    }

    @Override
    public List<AlbumDTO> getAllAlbums() {


        List<AlbumDTO> albums = this.albumRepository.findAllBy()
                .stream().map(album -> new AlbumDTO()
                        .setArtist(album.getArtist().getName())
                        .setName(album.getName())
                        .setId(album.getId())
                        .setGenre(album.getGenre())
                        .setPrice(album.getPrice())
                        .setCopies(album.getCopies())
                        .setImgUrl(album.getImageUrl())
                        .setReleaseDate(album.getReleasedDate()))
                .collect(Collectors.toList());

        return albums;
    }

    @Override
    public void delete(Long id) {

        Optional<Album> albumToDelete = this.albumRepository.findById(id);

        if (albumToDelete.isPresent()) {
            this.albumRepository.deleteById(id);
        } else {
            throw new NoSuchElementException();
        }
    }
}
