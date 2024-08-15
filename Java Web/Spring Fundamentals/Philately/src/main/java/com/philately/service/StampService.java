package com.philately.service;

import com.philately.model.dto.AddStampBindingModel;
import com.philately.model.dto.HomeViewDTO;

public interface StampService {

    void addStamp(AddStampBindingModel addStampBindingModel);

    HomeViewDTO getHomeView();

    void addToWishList(Long id);
}
