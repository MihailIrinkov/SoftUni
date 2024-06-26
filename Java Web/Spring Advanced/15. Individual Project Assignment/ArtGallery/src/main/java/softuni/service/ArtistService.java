package softuni.service;

import softuni.model.dto.binding.AddArtistBindingModel;
import softuni.model.dto.binding.UploadPictureArtistBindingModel;
import softuni.model.dto.view.ArtistCategoryViewModel;
import softuni.model.dto.view.ArtistDetailsViewModel;
import softuni.model.dto.view.ArtistGetAllViewModel;
import softuni.model.dto.view.ArtistIndexViewModel;
import softuni.model.enums.CategoryNames;

import java.util.List;

public interface ArtistService {

    void add(AddArtistBindingModel addArtistBindingModel);

    List<ArtistGetAllViewModel> getAll();

    ArtistDetailsViewModel getDetails(Long id);

    void uploadPicture(UploadPictureArtistBindingModel uploadPictureArtistBindingModel);

    List<ArtistCategoryViewModel> getAllByCategory(CategoryNames categoryName);

    List<List<Double>> getCoordinates(Long artistId);

    ArtistIndexViewModel getMostCommentedArtist();

}
