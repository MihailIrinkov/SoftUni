package softuni.bg.exerciseJSONprocessing.services.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.bg.exerciseJSONprocessing.domain.models.user.UserModelDto;
import softuni.bg.exerciseJSONprocessing.domain.models.user.UserWithSoldProducts;
import softuni.bg.exerciseJSONprocessing.domain.models.user.UserWithSoldProductsModel;
import softuni.bg.exerciseJSONprocessing.domain.models.user.UserWithSoldProductsWrapperModel;
import softuni.bg.exerciseJSONprocessing.repositories.UserRepository;

import java.io.IOException;
import java.util.List;

import static softuni.bg.exerciseJSONprocessing.constants.Pats.FOURTH_JSON_PATH;
import static softuni.bg.exerciseJSONprocessing.constants.Pats.SECOND_JSON_PATH;
import static softuni.bg.exerciseJSONprocessing.constants.Utils.*;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserWithSoldProductsModel> getUsersWithSoldProducts() throws IOException {

        final List<UserWithSoldProductsModel> users = this.userRepository
                .findAllBySellingProductsBuyerIsNotNullOrderBySellingProductsBuyerLastNameAscSellingProductsBuyerFirstName()
                .stream()
                .map(user -> MODEL_MAPPER.map(user, UserWithSoldProductsModel.class))
                .toList();

        writeIntoJsonFile(users, SECOND_JSON_PATH);

        return users;
    }

    @Override
    public UserWithSoldProductsWrapperModel getUsersWithSoldProducts2() throws IOException {

        final List<UserWithSoldProducts> users = this.userRepository
                .findAllBySellingProductsBuyerIsNotNullOrderBySellingProductsBuyerLastNameAscSellingProductsBuyerFirstName()
                .stream()
                .map(user -> MODEL_MAPPER.map(user, UserModelDto.class))
                .map(UserModelDto::toUserWithProductModel)
                .toList();

        writeIntoJsonFile(users, FOURTH_JSON_PATH);

        UserWithSoldProductsWrapperModel response =
                new UserWithSoldProductsWrapperModel(users);

        writeIntoJsonFile2(response, FOURTH_JSON_PATH);

        return response;
    }
}
