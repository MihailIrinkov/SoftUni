package com.philately.service.impl;

import com.philately.model.dto.StampDTO;
import com.philately.model.dto.UserLoginBindingModel;
import com.philately.model.dto.UserRegisterBindingModel;
import com.philately.model.entity.Stamp;
import com.philately.model.entity.User;
import com.philately.repository.PaperRepository;
import com.philately.repository.StampRepository;
import com.philately.repository.UserRepository;
import com.philately.service.LoggedUser;
import com.philately.service.UserService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final LoggedUser loggedUser;
    private final UserRepository userRepository;
    private final StampRepository stampRepository;

    private final PaperRepository paperRepository;

    public UserServiceImpl(LoggedUser loggedUser,
                           UserRepository userRepository,
                           StampRepository stampRepository,
                           PaperRepository paperRepository) {
        this.loggedUser = loggedUser;
        this.userRepository = userRepository;
        this.stampRepository = stampRepository;
        this.paperRepository = paperRepository;
    }

    @Override
    public boolean register(UserRegisterBindingModel userRegisterBindingModel) {

        if (!userRegisterBindingModel.getPassword().equals(userRegisterBindingModel.getConfirmPassword())) {
            return false;
        }

        Optional<User> byUsername = this.userRepository.findByUsername(userRegisterBindingModel.getUsername());
        Optional<User> byEmail = this.userRepository.findByEmail(userRegisterBindingModel.getEmail());

        if (byUsername.isPresent() || byEmail.isPresent()) {
            return false;
        }

        User userToSave = new User()
                .setUsername(userRegisterBindingModel.getUsername())
                .setEmail(userRegisterBindingModel.getEmail())
                .setPassword(userRegisterBindingModel.getPassword());
        this.userRepository.save(userToSave);

        return true;
    }

    @Override
    public boolean login(UserLoginBindingModel userLoginBindingModel) {

        Optional<User> user = this.userRepository.findByUsername(userLoginBindingModel.getUsername());

        if (user.isEmpty() || !user.get().getPassword().equals(userLoginBindingModel.getPassword())) {
            return false;
        }

        loggedUser.login(userLoginBindingModel.getUsername());

        return true;
    }

    @Override
    public void logout() {
        User user = this.userRepository.findByUsername(loggedUser.getUsername()).get();
        Set<Stamp> wishedStamps = user.getWishedStamps();
        user.getWishedStamps().removeAll(wishedStamps);

        this.userRepository.save(user);

        loggedUser.logout();
    }

    @Override
    public void removeFromWishList(Long id) {

        User user = this.userRepository.findByUsername(loggedUser.getUsername()).get();
        Stamp stampToRemove = this.stampRepository.findById(id).get();

        Set<Stamp> wishedStamps = user.getWishedStamps();

        for (Stamp s : wishedStamps) {
            if (s.getId().equals(stampToRemove.getId())) {
                wishedStamps.remove(s);
            }
        }
        user.setWishedStamps(wishedStamps);

        this.userRepository.save(user);
    }

    @Override
    public void buyStamp(String username) {
        User user = this.userRepository.findByUsername(username).get();

        Set<Stamp> stamps = user.getWishedStamps().stream()
                .map(stamp -> new Stamp()
                        .setDescription(stamp.getDescription())
                        .setName(stamp.getName())
                        .setImageUrl(stamp.getImageUrl())
                        .setPaper(this.paperRepository.findByName(stamp.getPaper().getName())))
                .collect(Collectors.toSet());


        Set<Stamp> wishedStamps = user.getWishedStamps();
        user.getWishedStamps().removeAll(wishedStamps);


        Set<Stamp> purchasedStamps = user.getPurchasedStamps();
        user.getWishedStamps().removeAll(purchasedStamps);

        user.setPurchasedStamps(stamps);

        this.userRepository.save(user);
    }


}
