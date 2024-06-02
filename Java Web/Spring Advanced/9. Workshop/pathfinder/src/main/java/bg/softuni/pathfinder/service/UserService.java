package bg.softuni.pathfinder.service;

import bg.softuni.pathfinder.model.dto.view.UserProfileViewModel;
import bg.softuni.pathfinder.model.entity.User;

public interface UserService {

    User getLoggedUser();

    UserProfileViewModel getUserProfile();
}
