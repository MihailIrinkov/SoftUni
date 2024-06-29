package softuni.project.ArtGallery.service.impl;


import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.project.ArtGallery.model.dto.view.UserProfileViewModel;
import softuni.project.ArtGallery.model.entity.User;
import softuni.project.ArtGallery.repository.UserRepository;
import softuni.project.ArtGallery.service.UserService;
import softuni.project.ArtGallery.service.helpers.LoggedUserHelperService;

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
