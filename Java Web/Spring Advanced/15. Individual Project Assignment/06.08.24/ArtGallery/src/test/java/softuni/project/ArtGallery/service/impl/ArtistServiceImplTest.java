package softuni.project.ArtGallery.service.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import softuni.project.ArtGallery.exceptions.ArtistNotFoundException;
import softuni.project.ArtGallery.model.entity.Artist;
import softuni.project.ArtGallery.repository.ArtistRepository;
import softuni.project.ArtGallery.repository.CategoryRepository;
import softuni.project.ArtGallery.service.UserService;
import softuni.project.ArtGallery.service.helpers.PictureHelperService;

import java.util.Optional;

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

    @Test
    void add() {
    }

    @Test
    void getAll() {
    }

    @Test
    void getDetails() {

        Artist artist = new Artist();
        artist.setName("Rembrand");

        when(mockArtistRepository.findById(1L))
                .thenReturn(Optional.of(artist));

        Optional<Artist> mockArtistById = mockArtistRepository.findById(1L);

        Assertions.assertEquals("Rembrand", mockArtistById.get().getName());
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
}