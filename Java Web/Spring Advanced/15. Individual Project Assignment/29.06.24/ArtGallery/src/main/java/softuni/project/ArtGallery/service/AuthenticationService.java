package softuni.project.ArtGallery.service;


import softuni.project.ArtGallery.model.dto.binding.UserRegisterBindingModel;

public interface AuthenticationService {

    void register(UserRegisterBindingModel userRegisterBindingModel);

}
