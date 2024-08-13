package com.paintingscollectors.model.dto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HomeViewDTO {

    List<PaintingDTO> myPaintings;
    Set<PaintingDTO> myFavorites;

    List<PaintingDTO> otherPaintings;

    List<PaintingDTO> mostRated;

    public HomeViewDTO() {
        myPaintings = new ArrayList<>();
        myFavorites = new HashSet<>();
        otherPaintings = new ArrayList<>();
        mostRated = new ArrayList<>();
    }

    public List<PaintingDTO> getMyPaintings() {
        return myPaintings;
    }

    public HomeViewDTO setMyPaintings(List<PaintingDTO> myPaintings) {
        this.myPaintings = myPaintings;
        return this;
    }

    public Set<PaintingDTO> getMyFavorites() {
        return myFavorites;
    }

    public HomeViewDTO setMyFavorites(Set<PaintingDTO> myFavorites) {
        this.myFavorites = myFavorites;
        return this;
    }

    public List<PaintingDTO> getOtherPaintings() {
        return otherPaintings;
    }

    public HomeViewDTO setOtherPaintings(List<PaintingDTO> otherPaintings) {
        this.otherPaintings = otherPaintings;
        return this;
    }

    public List<PaintingDTO> getMostRated() {
        return mostRated;
    }

    public HomeViewDTO setMostRated(List<PaintingDTO> mostRated) {
        this.mostRated = mostRated;
        return this;
    }
}
