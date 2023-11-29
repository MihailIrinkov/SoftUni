package softuni.bg.exerciseJSONprocessing.services.user;

import softuni.bg.exerciseJSONprocessing.domain.models.user.UserWithSoldProductsModel;
import softuni.bg.exerciseJSONprocessing.domain.models.user.UserWithSoldProductsWrapperModel;

import java.io.IOException;
import java.util.List;

public interface UserService {

    abstract List<UserWithSoldProductsModel> getUsersWithSoldProducts() throws IOException;

    UserWithSoldProductsWrapperModel getUsersWithSoldProducts2() throws IOException;
}
