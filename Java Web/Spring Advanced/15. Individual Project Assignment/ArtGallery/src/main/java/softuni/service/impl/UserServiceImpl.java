package softuni.service.impl;


import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.model.dto.view.UserProfileViewModel;
import softuni.model.entity.User;
import softuni.repository.UserRepository;
import softuni.service.UserService;
import softuni.service.helpers.LoggedUserHelperService;

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
