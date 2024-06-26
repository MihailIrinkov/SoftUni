package softuni.service;

import softuni.model.dto.view.UserProfileViewModel;
import softuni.model.entity.User;

public interface UserService {

    User getLoggedUser();

    UserProfileViewModel getUserProfile();
}
