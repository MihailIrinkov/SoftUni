package bg.softuni.pathfinder.service.impl;

import bg.softuni.pathfinder.exceptions.UserNotFoundException;
import bg.softuni.pathfinder.model.dto.view.UserProfileViewModel;
import bg.softuni.pathfinder.model.entity.User;
import bg.softuni.pathfinder.repository.UserRepository;
import bg.softuni.pathfinder.service.UserService;
import bg.softuni.pathfinder.service.session.LoggedUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final LoggedUser loggedUser;

    private final ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository,
                           LoggedUser loggedUser,
                           ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.loggedUser = loggedUser;
        this.modelMapper = modelMapper;
    }

    @Override
    public User getLoggedUser() {
        return this.userRepository
                .findByUsername(loggedUser.getUsername()).get();
    }

    @Override
    public UserProfileViewModel getUserProfile() {
        User user = userRepository.findByUsername(loggedUser.getUsername())
                .orElseThrow(() -> new UserNotFoundException("User not found!"));

        return modelMapper.map(user, UserProfileViewModel.class);
    }
}
