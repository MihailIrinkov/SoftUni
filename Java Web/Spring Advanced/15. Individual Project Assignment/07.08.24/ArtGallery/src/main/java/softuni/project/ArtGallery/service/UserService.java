package softuni.project.ArtGallery.service;

import softuni.project.ArtGallery.model.dto.view.ChangeUsernameViewModel;
import softuni.project.ArtGallery.model.dto.view.UserProfileViewModel;
import softuni.project.ArtGallery.model.entity.User;

import java.util.List;

public interface UserService {

    User getLoggedUser();

    UserProfileViewModel getUserProfile();

    List<UserProfileViewModel> getAll();

    void delete(Long userId);

    boolean changeUsername(ChangeUsernameViewModel changeUsernameViewModel);
}
