package softuni.service;


import softuni.model.dto.binding.UserRegisterBindingModel;

public interface AuthenticationService {

    void register(UserRegisterBindingModel userRegisterBindingModel);

}
