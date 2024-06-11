package org.softuni.mobilele.testutils;

import org.softuni.mobilele.enums.UserRoleEnum;
import org.softuni.mobilele.model.entity.UserEntity;
import org.softuni.mobilele.repository.UserRepository;
import org.softuni.mobilele.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserTestDataUtil {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;

    public UserEntity createTestUser(String email) {
        return createUser(email, List.of(UserRoleEnum.USER));
    }

    public UserEntity createTestAdmin(String email) {
        return createUser(email, List.of(UserRoleEnum.ADMIN));
    }

    private UserEntity createUser(String email, List<UserRoleEnum> roles) {

        var roleEntity = userRoleRepository.findAllByRoleIn(roles);

        UserEntity newUser = new UserEntity();
        newUser.setActive(true);
        newUser.setEmail(email);
        newUser.setFirstName("Test user first");
        newUser.setLastName("Test user last");
        newUser.setUserRole(roleEntity);

        return userRepository.save(newUser);

    }

    public void cleanUp() {
        userRepository.deleteAll();
    }
}
