package com.paintingscollectors.service;

import com.paintingscollectors.model.dto.AddPaintingBindingModel;
import com.paintingscollectors.model.dto.HomeViewDTO;

public interface PaintingService {

    HomeViewDTO getAll();

    void addPainting(AddPaintingBindingModel addPaintingBindingModel);

    void addToFavorites(Long id);
    void removeFromFavorites(Long id);

    void vote(Long id);

    void delete(Long id);
}
