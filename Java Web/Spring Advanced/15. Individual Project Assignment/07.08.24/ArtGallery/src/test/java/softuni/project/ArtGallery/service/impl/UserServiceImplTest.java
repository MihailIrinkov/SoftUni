package softuni.project.ArtGallery.service.impl;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import softuni.project.ArtGallery.model.entity.Artist;
import softuni.project.ArtGallery.model.entity.Category;
import softuni.project.ArtGallery.model.entity.Role;
import softuni.project.ArtGallery.model.entity.User;
import softuni.project.ArtGallery.model.enums.CategoryNames;
import softuni.project.ArtGallery.model.enums.UserRoles;
import softuni.project.ArtGallery.repository.ArtistRepository;
import softuni.project.ArtGallery.repository.UserRepository;
import softuni.project.ArtGallery.service.UserService;

import java.util.Optional;
import java.util.Set;

@SpringBootTest
public class UserServiceImplTest {

    @Autowired
    private UserService userServiceToTest;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ArtistRepository artistRepository;

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
        User userToDelete = createUser();

        userRepository.save(userToDelete);

        Optional<User> byId = userRepository.findById(userToDelete.getId());

        userServiceToTest.delete(userToDelete.getId());

        Assertions.assertTrue(userRepository.findByUsername(userToDelete.getUsername()).isEmpty());
    }

    private static User createUser() {
        User user = new User();
        user.setUsername("testIT");
        user.setPassword("12345");
        user.setRoles(Set.of(new Role(UserRoles.ADMIN),
                new Role(UserRoles.USER)));
        user.setAge(25);
        user.setEmail("testIT@test.com");
        user.setFullName("fullName");
        user.setId(1001L);

        return user;
    }

    private static Artist createArtist() {
        User user = createUser();

        Artist artist = new Artist();
        artist.setId(123L);
        artist.setName("Rembrand");
        artist.setAuthor(user);
        artist.setImageUrl("testartis2/30d7cc37-420a-4757-a672-14cfdc6ede03.jpg");
        artist.setVideoUrl("uRBngj5z4oY");
        artist.setCategories(Set.of(new Category(CategoryNames.TEMPERA)));
//        artist.setComments(new ArrayList<>());
        artist.setDescription("mockDescription");
//        artist.setPictures(new ArrayList<>());

        return artist;
    }
}
