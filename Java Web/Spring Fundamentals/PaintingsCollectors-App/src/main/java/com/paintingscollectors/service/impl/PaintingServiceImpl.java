package com.paintingscollectors.service.impl;

import com.paintingscollectors.model.dto.AddPaintingBindingModel;
import com.paintingscollectors.model.dto.HomeViewDTO;
import com.paintingscollectors.model.dto.PaintingDTO;
import com.paintingscollectors.model.entity.Painting;
import com.paintingscollectors.model.entity.Style;
import com.paintingscollectors.model.entity.StyleName;
import com.paintingscollectors.model.entity.User;
import com.paintingscollectors.repository.PaintingRepository;
import com.paintingscollectors.repository.StyleRepository;
import com.paintingscollectors.repository.UserRepository;
import com.paintingscollectors.service.LoggedUser;
import com.paintingscollectors.service.PaintingService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class PaintingServiceImpl implements PaintingService {

    private final LoggedUser loggedUser;
    private final PaintingRepository paintingRepository;
    private final UserRepository userRepository;
    private final StyleRepository styleRepository;

    public PaintingServiceImpl(LoggedUser loggedUser,
                               PaintingRepository paintingRepository,
                               UserRepository userRepository,
                               StyleRepository styleRepository) {
        this.loggedUser = loggedUser;
        this.paintingRepository = paintingRepository;
        this.userRepository = userRepository;
        this.styleRepository = styleRepository;
    }

    @Override
    public HomeViewDTO getAll() {
        HomeViewDTO homeViewDTO = new HomeViewDTO();

        List<PaintingDTO> myPaintings = this.paintingRepository.findAllByOwner_Username(loggedUser.getUsername())
                .stream()
                .map(painting -> new PaintingDTO()
                        .setAuthor(painting.getAuthor())
                        .setId(painting.getId())
                        .setUrl(painting.getUrl())
                        .setName(painting.getName())
                        .setStyle(painting.getStyle().getName().toString())).collect(Collectors.toList());
        homeViewDTO.setMyPaintings(myPaintings);

        User owner = this.userRepository.findByUsername(loggedUser.getUsername()).get();
        List<PaintingDTO> otherPaintings = this.paintingRepository.findAllByOwnerIsNot(owner).stream()
                .map(painting -> new PaintingDTO()
                        .setAuthor(painting.getAuthor())
                        .setOwner(painting.getOwner().getUsername())
                        .setId(painting.getId())
                        .setUrl(painting.getUrl())
                        .setName(painting.getName())
                        .setStyle(painting.getStyle().getName().toString())).collect(Collectors.toList());
        homeViewDTO.setOtherPaintings(otherPaintings);

//        Set<PaintingDTO> favorites = this.paintingRepository.findAllByIsFavorite("Yes").stream()
//                .map(painting -> new PaintingDTO()
//                        .setAuthor(painting.getAuthor())
//                        .setOwner(painting.getOwner().getUsername())
//                        .setId(painting.getId())
//                        .setUrl(painting.getUrl())
//                        .setName(painting.getName())
//                        .setStyle(painting.getStyle().getName().toString())).collect(Collectors.toSet());

        Set<PaintingDTO> favorites = owner.getFavoritePaintings().stream()
                .map(painting -> new PaintingDTO()
                        .setAuthor(painting.getAuthor())
                        .setOwner(painting.getOwner().getUsername())
                        .setId(painting.getId())
                        .setUrl(painting.getUrl())
                        .setName(painting.getName())
                        .setStyle(painting.getStyle().getName().toString())).collect(Collectors.toSet());
        homeViewDTO.setMyFavorites(favorites);

        List<PaintingDTO> mostVoted = this.paintingRepository.findMostVoted().stream()
                .map(painting -> new PaintingDTO()
                        .setAuthor(painting.getAuthor())
                        .setOwner(painting.getOwner().getUsername())
                        .setId(painting.getId())
                        .setUrl(painting.getUrl())
                        .setName(painting.getName())
                        .setVotes(painting.getVotes())
                        .setStyle(painting.getStyle().getName().toString())).collect(Collectors.toList());
        homeViewDTO.setMostRated(mostVoted);

        return homeViewDTO;
    }


    @Override
    public void addPainting(AddPaintingBindingModel addPaintingBindingModel) {
        User owner = this.userRepository.findByUsername(loggedUser.getUsername()).get();
        Style style = this.styleRepository.findByName(StyleName.valueOf(addPaintingBindingModel.getStyle())).get();

        Painting paintingToSave = new Painting()
                .setAuthor(addPaintingBindingModel.getAuthor())
                .setName(addPaintingBindingModel.getName())
                .setUrl(addPaintingBindingModel.getUrl())
                .setOwner(owner)
                .setStyle(style);

        this.paintingRepository.save(paintingToSave);
    }

    @Override
    public void addToFavorites(Long id) {
        Painting painting = this.paintingRepository.findById(id).get();
        painting.setIsFavorite("Yes");

        User user = this.userRepository.findByUsername(loggedUser.getUsername()).get();
        user.getFavoritePaintings().add(painting);
        this.userRepository.save(user);

        this.paintingRepository.save(painting);
    }

    @Override
    public void removeFromFavorites(Long id) {
        Painting painting = this.paintingRepository.findById(id).get();
        painting.setIsFavorite("No");

        User user = this.userRepository.findByUsername(loggedUser.getUsername()).get();

        Set<Painting> favoritePaintings = user.getFavoritePaintings();

        for (Painting p : favoritePaintings) {
            if (p.getId() == painting.getId()) {
                favoritePaintings.remove(p);
                this.userRepository.save(user);
            }
        }

        this.paintingRepository.save(painting);
    }

    @Override
    public void vote(Long id) {
        Painting painting = this.paintingRepository.findById(id).get();

        User user = this.userRepository.findByUsername(loggedUser.getUsername()).get();

        boolean contains = false;

        for (Painting p : user.getRatedPaintings()) {
            if (p.getId() == painting.getId()) {
                contains = true;
            }
        }

        if (!contains) {
            user.getRatedPaintings().add(painting);
            this.userRepository.save(user);

            painting.vote();
            this.paintingRepository.save(painting);
        }

    }

    @Override
    public void delete(Long id) {
        Painting painting = this.paintingRepository.findById(id).get();

        if (painting.getIsFavorite().equals("No")) {
            this.paintingRepository.delete(painting);
        }
    }


}
