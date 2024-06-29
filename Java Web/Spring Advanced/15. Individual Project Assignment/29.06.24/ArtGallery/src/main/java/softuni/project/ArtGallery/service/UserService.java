package softuni.project.ArtGallery.service;

import softuni.project.ArtGallery.model.dto.view.UserProfileViewModel;
import softuni.project.ArtGallery.model.entity.User;

public interface UserService {

    User getLoggedUser();

    UserProfileViewModel getUserProfile();
}
