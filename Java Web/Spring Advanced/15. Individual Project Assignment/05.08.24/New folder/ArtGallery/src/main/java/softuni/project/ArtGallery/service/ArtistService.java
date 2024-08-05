package softuni.project.ArtGallery.service;

import softuni.project.ArtGallery.model.dto.binding.AddArtistBindingModel;
import softuni.project.ArtGallery.model.dto.binding.UploadPictureArtistBindingModel;
import softuni.project.ArtGallery.model.dto.view.ArtistCategoryViewModel;
import softuni.project.ArtGallery.model.dto.view.ArtistDetailsViewModel;
import softuni.project.ArtGallery.model.dto.view.ArtistGetAllViewModel;
import softuni.project.ArtGallery.model.dto.view.ArtistIndexViewModel;
import softuni.project.ArtGallery.model.enums.CategoryNames;

import java.util.List;

public interface ArtistService {
    void add(AddArtistBindingModel addArtistBindingModel);

    List<ArtistGetAllViewModel> getAll();

    ArtistDetailsViewModel getDetails(Long id);

    void uploadPicture(UploadPictureArtistBindingModel uploadPictureArtistBindingModel);

    List<ArtistCategoryViewModel> getAllByCategory(CategoryNames categoryName);

    List<List<Double>> getCoordinates(Long artistId);


}
