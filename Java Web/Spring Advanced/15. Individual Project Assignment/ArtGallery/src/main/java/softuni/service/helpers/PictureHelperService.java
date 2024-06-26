package softuni.service.helpers;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import softuni.model.entity.Picture;
import softuni.model.entity.Artist;
import softuni.repository.PictureRepository;

@Service
@RequiredArgsConstructor
public class PictureHelperService {

    private final PictureRepository pictureRepository;
    private final LoggedUserHelperService loggedUserHelperService;

    public void create(Artist artist, String picturePath) {
        Picture picture = new Picture();
        picture.setTitle(artist.getName());
        picture.setArtist(artist);
        picture.setUrl(picturePath);
        picture.setAuthor(loggedUserHelperService.get());

        pictureRepository.save(picture);
    }
}
