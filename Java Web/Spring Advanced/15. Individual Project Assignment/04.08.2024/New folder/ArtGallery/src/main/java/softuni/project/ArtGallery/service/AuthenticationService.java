package softuni.project.ArtGallery.service;


import softuni.project.ArtGallery.model.dto.binding.UserRegisterBindingModel;

public interface AuthenticationService {

    boolean register(UserRegisterBindingModel userRegisterBindingModel);

}
