package org.softuni.mobilele.testutils;

import org.softuni.mobilele.enums.UserRoleEnum;
import org.softuni.mobilele.model.entity.UserRoleEntity;
import org.softuni.mobilele.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DBInit implements CommandLineRunner {

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Override
    public void run(String... args) throws Exception {
        if (userRoleRepository.count() == 0) {
            UserRoleEntity userRoleEntity1 = new UserRoleEntity();
            userRoleEntity1.setRole(UserRoleEnum.USER);
            UserRoleEntity userRoleEntity2 = new UserRoleEntity();
            userRoleEntity2.setRole(UserRoleEnum.ADMIN);
            new UserRoleEntity().setRole(UserRoleEnum.ADMIN);
            userRoleRepository.saveAll(List.of(
                    userRoleEntity1, userRoleEntity2
            ));
        }
    }
}
