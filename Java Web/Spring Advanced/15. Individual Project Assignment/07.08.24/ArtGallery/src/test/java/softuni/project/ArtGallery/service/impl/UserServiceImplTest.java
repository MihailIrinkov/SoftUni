package softuni.project.ArtGallery.service.impl;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import softuni.project.ArtGallery.repository.UserRepository;
import softuni.project.ArtGallery.service.UserService;

@SpringBootTest
public class UserServiceImplTest {

    @Autowired
    private UserService userServiceToTest;

    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    void setUp() {
        userRepository.deleteAll();
    }

    @AfterEach
    void tearDown(){
        userRepository.deleteAll();
    }

    @Test
    void test_delete() {

    }
}
