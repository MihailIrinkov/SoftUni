package com.philately.service.impl;

import com.philately.model.dto.AddStampBindingModel;
import com.philately.model.dto.HomeViewDTO;
import com.philately.model.dto.StampDTO;
import com.philately.model.entity.Paper;
import com.philately.model.entity.Stamp;
import com.philately.model.entity.User;
import com.philately.repository.PaperRepository;
import com.philately.repository.StampRepository;
import com.philately.repository.UserRepository;
import com.philately.service.LoggedUser;
import com.philately.service.StampService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class StampServiceImpl implements StampService {

    private final LoggedUser loggedUser;
    private final StampRepository stampRepository;
    private final UserRepository userRepository;
    private final PaperRepository paperRepository;

    public StampServiceImpl(LoggedUser loggedUser,
                            StampRepository stampRepository,
                            UserRepository userRepository,
                            PaperRepository paperRepository) {
        this.loggedUser = loggedUser;
        this.stampRepository = stampRepository;
        this.userRepository = userRepository;
        this.paperRepository = paperRepository;
    }

    @Override
    public void addStamp(AddStampBindingModel addStampBindingModel) {

        Paper paperName = this.paperRepository.findByName(addStampBindingModel.getPaper());

        if (paperName != null) {

            User owner = this.userRepository.findByUsername(loggedUser.getUsername()).get();

            Stamp stampToSave = new Stamp()
                    .setName(addStampBindingModel.getName())
                    .setDescription(addStampBindingModel.getDescription())
                    .setImageUrl(addStampBindingModel.getImageUrl())
                    .setPaper(paperName)
                    .setPrice(addStampBindingModel.getPrice())
                    .setOwner(owner);

            this.stampRepository.save(stampToSave);
        }
    }

    @Override
    public HomeViewDTO getHomeView() {

        HomeViewDTO homeViewDTO = new HomeViewDTO();

        User owner = this.userRepository.findByUsername(loggedUser.getUsername()).get();

        Set<StampDTO> myStamps = this.stampRepository.findAllByOwner(owner).stream()
                .map(stamp -> new StampDTO()
                        .setId(stamp.getId())
                        .setOwnerName(stamp.getOwner().getUsername())
                        .setName(stamp.getName())
                        .setDescription(stamp.getDescription())
                        .setPrice(stamp.getPrice())
                        .setImageUrl(stamp.getImageUrl())
                        .setPaperName(stamp.getPaper().getName())).collect(Collectors.toSet());;
        homeViewDTO.setMyStamps(myStamps);

        homeViewDTO.setMyPurchases(owner.getPurchasedStamps()
                .stream()
                .map(stamp -> new StampDTO()
                        .setId(stamp.getId())
                        .setOwnerName(stamp.getOwner().getUsername())
                        .setName(stamp.getName())
                        .setDescription(stamp.getDescription())
                        .setPrice(stamp.getPrice())
                        .setImageUrl(stamp.getImageUrl())
                        .setPaperName(stamp.getPaper().getName())).collect(Collectors.toSet()));

        Set<StampDTO> offeredStamps = this.stampRepository.findAllByOwnerIsNot(owner).stream()
                .map(stamp -> new StampDTO()
                        .setId(stamp.getId())
                        .setOwnerName(stamp.getOwner().getUsername())
                        .setName(stamp.getName())
                        .setDescription(stamp.getDescription())
                        .setPrice(stamp.getPrice())
                        .setImageUrl(stamp.getImageUrl())
                        .setPaperName(stamp.getPaper().getName())).collect(Collectors.toSet());
        homeViewDTO.setOfferedStamps(offeredStamps);

        homeViewDTO.setMyWishList(owner.getWishedStamps().stream()
                .map(stamp -> new StampDTO()
                        .setId(stamp.getId())
                        .setOwnerName(stamp.getOwner().getUsername())
                        .setName(stamp.getName())
                        .setDescription(stamp.getDescription())
                        .setPrice(stamp.getPrice())
                        .setImageUrl(stamp.getImageUrl())
                        .setPaperName(stamp.getPaper().getName())).collect(Collectors.toSet()));

        return homeViewDTO;
    }

    @Override
    public void addToWishList(Long id) {
        Stamp stamp = this.stampRepository.findById(id).get();

        User user = this.userRepository.findByUsername(loggedUser.getUsername()).get();

        user.getWishedStamps().add(stamp);

        this.userRepository.save(user);

    }
}
