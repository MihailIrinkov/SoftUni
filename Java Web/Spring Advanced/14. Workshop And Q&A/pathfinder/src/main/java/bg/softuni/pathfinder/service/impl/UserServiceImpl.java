package bg.softuni.pathfinder.service.impl;

import bg.softuni.pathfinder.exceptions.UserNotFoundException;
import bg.softuni.pathfinder.model.dto.view.UserProfileViewModel;
import bg.softuni.pathfinder.model.entity.User;
import bg.softuni.pathfinder.repository.UserRepository;
import bg.softuni.pathfinder.service.UserService;
import bg.softuni.pathfinder.service.helpers.LoggedUserHelperService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final ModelMapper modelMapper;
    private final LoggedUserHelperService loggedUserHelperService;

    @Override
    public User getLoggedUser() {
        return this.userRepository
                .findByUsername(loggedUserHelperService.getUserName()).get();
    }

    @Override
    public UserProfileViewModel getUserProfile() {
        User user = loggedUserHelperService.get();

        return modelMapper.map(user, UserProfileViewModel.class);
    }
}
