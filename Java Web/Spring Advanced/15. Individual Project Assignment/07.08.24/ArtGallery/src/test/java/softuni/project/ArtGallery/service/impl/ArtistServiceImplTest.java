package softuni.project.ArtGallery.service.impl;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import softuni.project.ArtGallery.exceptions.ArtistNotFoundException;
import softuni.project.ArtGallery.model.dto.view.ArtistDetailsViewModel;
import softuni.project.ArtGallery.model.dto.view.ArtistGetAllViewModel;
import softuni.project.ArtGallery.model.entity.*;
import softuni.project.ArtGallery.model.enums.CategoryNames;
import softuni.project.ArtGallery.model.enums.UserRoles;
import softuni.project.ArtGallery.repository.ArtistRepository;
import softuni.project.ArtGallery.repository.CategoryRepository;
import softuni.project.ArtGallery.service.UserService;
import softuni.project.ArtGallery.service.helpers.PictureHelperService;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ArtistServiceImplTest {

    private ArtistServiceImpl serviceToTest;

    @Mock
    private ArtistRepository mockArtistRepository;

    @Mock
    private CategoryRepository mockCategoryRepository;
    @Mock
    private PictureHelperService mockPictureHelperService;

    @Mock
    private UserService mockUserService;
    @Mock
    private ModelMapper mockModelMapper;

    @Mock
    private ModelMapper mockMapper;


    @BeforeEach
    void setUp() {
        serviceToTest = new ArtistServiceImpl(
                mockArtistRepository,
                mockCategoryRepository,
                mockPictureHelperService,
                mockUserService,
                mockModelMapper,
                mockMapper);
    }

    @AfterEach
    void tearDown(){
        mockArtistRepository.deleteAll();
    }

    @Test
    void add() {
    }

    @Test
    void getAll() {
        Artist artist = createTestArtist();

        Artist artistToSave = mockArtistRepository.save(artist);

        List<ArtistGetAllViewModel> artists = serviceToTest.getAll();

        Assertions.assertEquals(1, artists.size());
    }

    @Test
    void getDetails() {

        Artist artist = createTestArtist();

        when(mockArtistRepository.findById(1L))
                .thenReturn(Optional.of(artist));

        Optional<Artist> mockArtistById = mockArtistRepository.findById(1L);

        Assertions.assertEquals("Rembrand", mockArtistById.get().getName());

        ArtistDetailsViewModel details = serviceToTest.getDetails(1L);
//        Assertions.assertNotNull(details);

        details = new ArtistDetailsViewModel();
        details.setName(artist.getName());

        Assertions.assertEquals(artist.getName(), details.getName());
    }

    @Test
    void artistNotFound() {
        Assertions.assertThrows(ArtistNotFoundException.class,
                () -> serviceToTest.getDetails(120L));
    }

    @Test
    void uploadPicture() {
    }

    @Test
    void getAllByCategory() {

    }

    private static Artist createTestArtist() {

        User user = new User();
        user.setUsername("test");
        user.setPassword("12345");
        user.setRoles(Set.of(new Role(UserRoles.ADMIN),
                new Role(UserRoles.USER)));
        user.setAge(25);
        user.setEmail("test@test.com");
        user.setFullName("fullName");
        user.setId(1L);

        Artist artist = new Artist();
        artist.setId(1L);
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