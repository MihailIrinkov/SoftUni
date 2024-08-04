package softuni.project.ArtGallery.service.impl;


import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import softuni.project.ArtGallery.config.SecurityConfig;
import softuni.project.ArtGallery.model.dto.view.ChangeUsernameViewModel;
import softuni.project.ArtGallery.model.dto.view.UserProfileViewModel;
import softuni.project.ArtGallery.model.entity.User;
import softuni.project.ArtGallery.repository.UserRepository;
import softuni.project.ArtGallery.service.UserService;
import softuni.project.ArtGallery.service.helpers.LoggedUserHelperService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final ModelMapper modelMapper;
    private final LoggedUserHelperService loggedUserHelperService;
    private final SecurityConfig securityConfig;

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

    @Override
    public List<UserProfileViewModel> getAll() {
        return userRepository.findAll()
                .stream()
                .map(user -> modelMapper.map(user, UserProfileViewModel.class))
                .toList();
    }

    @Override
    public void delete(Long userId) {
        this.userRepository.deleteById(userId);
    }

    @Override
    public boolean changeUsername(ChangeUsernameViewModel changeUsernameViewModel) {

        Optional<User> optionalUser = this.userRepository.findByUsername(changeUsernameViewModel.getNewUsername());

        if (optionalUser.isPresent() ||
                !changeUsernameViewModel.getNewUsername()
                        .equals(changeUsernameViewModel.getConfirmNewUsername())) {
            return false;
        }

        User user = this.userRepository.findByUsername(loggedUserHelperService.getUserName()).get();
        user.setUsername(changeUsernameViewModel.getNewUsername());

        this.userRepository.save(user);

        SecurityContextHolder.getContext().setAuthentication(null);

        SecurityContextHolder.clearContext();

        return true;
    }

}
