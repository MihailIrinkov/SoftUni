package softuni.project.ArtGallery.service.impl;


import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import softuni.project.ArtGallery.exceptions.ArtistNotFoundException;
import softuni.project.ArtGallery.model.dto.binding.AddArtistBindingModel;
import softuni.project.ArtGallery.model.dto.binding.UploadPictureArtistBindingModel;
import softuni.project.ArtGallery.model.dto.view.ArtistCategoryViewModel;
import softuni.project.ArtGallery.model.dto.view.ArtistDetailsViewModel;
import softuni.project.ArtGallery.model.dto.view.ArtistGetAllViewModel;
import softuni.project.ArtGallery.model.dto.view.ArtistIndexViewModel;
import softuni.project.ArtGallery.model.entity.Artist;
import softuni.project.ArtGallery.model.entity.Category;
import softuni.project.ArtGallery.model.entity.User;
import softuni.project.ArtGallery.model.enums.CategoryNames;
import softuni.project.ArtGallery.repository.ArtistRepository;
import softuni.project.ArtGallery.repository.CategoryRepository;
import softuni.project.ArtGallery.service.ArtistService;
import softuni.project.ArtGallery.service.UserService;
//import softuni.project.ArtGallery.service.helpers.CommentHelperService;
import softuni.project.ArtGallery.service.helpers.LoggedUserHelperService;
import softuni.project.ArtGallery.service.helpers.PictureHelperService;
import softuni.project.ArtGallery.util.YouTubeUtil;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ArtistServiceImpl implements ArtistService {

    private static final String BASE_GPX_COORDINATES_PATH = ".\\src\\main\\resources\\coordinates\\";
    private static final String BASE_IMAGES_PATH = ".\\src\\main\\resources\\static\\images\\";
    private final ArtistRepository artistRepository;
    private final CategoryRepository categoryRepository;

    private final PictureHelperService pictureHelperService;
    private final UserService userService;
    private final ModelMapper modelMapper;
    private final LoggedUserHelperService loggedUserHelperService;
//    private final CommentHelperService commentHelperService;

    private final ModelMapper mapper;

    @Override
    public void add(AddArtistBindingModel addArtistBindingModel) {
        Artist artist = mapper.map(addArtistBindingModel, Artist.class);
        artist.getCategories().clear();

        String filePath = getFilePath(artist.getName());
        boolean isUploaded = uploadGpxCoordinates(addArtistBindingModel.getGpxCoordinates(), filePath);

        if (isUploaded) {
            artist.setGpxCoordinates(filePath);
        }


        Set<Category> categories = categoryRepository
                .findByNameIn(addArtistBindingModel.getCategories());
        artist.addCategories(categories);

        User user = userService.getLoggedUser();
        artist.setAuthor(user);

        artist.setVideoUrl(YouTubeUtil.getUrl(addArtistBindingModel.getVideoUrl()));

        this.artistRepository.save(artist);
    }

    private boolean uploadGpxCoordinates(MultipartFile file, String filePath) {

        try {
            File newFile = new File(BASE_GPX_COORDINATES_PATH + filePath);
            newFile.getParentFile().mkdirs();
            newFile.createNewFile();

            OutputStream outputStream = new FileOutputStream(newFile);
            outputStream.write(file.getBytes());

            return true;
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public List<ArtistGetAllViewModel> getAll() {
        return artistRepository.findAll().stream()
                .map(artist -> modelMapper.map(artist, ArtistGetAllViewModel.class))
                .toList();

    }

    @Override
    public ArtistDetailsViewModel getDetails(Long id) {
        Artist artist = artistRepository.findById(id)
                .orElseThrow(() -> new ArtistNotFoundException(
                        "Artist with id: " + id + " was not found!"));

        return modelMapper.map(artist, ArtistDetailsViewModel.class);
    }

    @Override
    public void uploadPicture(UploadPictureArtistBindingModel uploadPictureArtistBindingModel) {
        MultipartFile pictureFile = uploadPictureArtistBindingModel.getPicture();

        boolean isPrimary = uploadPictureArtistBindingModel.getIsPrimary();


        Artist artist =
                artistRepository.findById(uploadPictureArtistBindingModel.getId())
                        .orElseThrow(() -> new ArtistNotFoundException("Artist not found"));

        String picturePath = getPicturePath(pictureFile, artist.getName(), isPrimary);

        try {
            File file = new File(BASE_IMAGES_PATH + picturePath);
            file.getParentFile().mkdirs();
            file.createNewFile();

            OutputStream outputStream = new FileOutputStream(file);
            outputStream.write(pictureFile.getBytes());


            if (isPrimary) {
                artist.setImageUrl(picturePath);
                artistRepository.save(artist);
            } else {
                pictureHelperService.create(artist, picturePath);
            }

        } catch (IOException e) {
            System.out.println(e.getStackTrace());
        }

    }

    @Override
    public List<ArtistCategoryViewModel> getAllByCategory(CategoryNames categoryName) {
        List<Artist> artists = artistRepository.findAllByCategories_Name(categoryName);

        List<ArtistCategoryViewModel> viewArtists = artists
                .stream()
                .map(artist -> modelMapper.map(artist, ArtistCategoryViewModel.class))
                .toList();

        return viewArtists;
    }

    @Override
    public List<List<Double>> getCoordinates(Long artistId) {
        Artist artist = this.artistRepository.findById(artistId)
                .orElseThrow(() -> new ArtistNotFoundException("Artist not found"));

//        try {
//            GPX gpx = GPX.read(Path.of(BASE_GPX_COORDINATES_PATH + artist.getGpxCoordinates()));
//
//            return gpx.getTracks().get(0).getSegments().get(0).getPoints().stream()
//                    .map(point -> {
//                        List<Double> coordinates = new ArrayList<>();
//                        coordinates.add(point.getLongitude().doubleValue());
//                        coordinates.add(point.getLatitude().doubleValue());
//                        return coordinates;
//                    })
//                    .toList();
//        } catch (IOException ex) {
//            ex.printStackTrace();
//            return null;
//        }
        return null;
    }

//    public ArtistIndexViewModel getMostCommentedArtist() {
//        Long artistId = commentHelperService.getMostCommentedArtistId();
//
//        if (artistId != null && artistId != 0) {
//            return artistRepository.findById(artistId)
//                    .map(artist -> modelMapper.map(artist, ArtistIndexViewModel.class))
//                    .orElse(null);
//        }
//        return null;
//    }

    private String getPicturePath(MultipartFile pictureFile, String artistName, boolean isPrimary) {

        String ext = getFileExtension(pictureFile.getOriginalFilename());

        String pathPattern = "%s/%s%s." + ext;

        return String.format(pathPattern,
                transformArtistName(artistName),
                isPrimary ? "" : "gallery",
                UUID.randomUUID());
    }

    private String getFileExtension(String fileName) {
        String[] splitPictureName = fileName.split("\\.");
        return splitPictureName[splitPictureName.length - 1];
    }

    private String getFilePath(String artistName) {
        String pathPattern = "%s\\%s_%s.xml";
        return String.format(pathPattern,
                loggedUserHelperService.getUserName(),
                transformArtistName(artistName),
                UUID.randomUUID());
    }

    private String transformArtistName(String artistName) {
        return artistName.toLowerCase()
                .replaceAll("\\s+", "_");
    }
}
