package softuni.project.ArtGallery.service;

import softuni.project.ArtGallery.model.dto.binding.CreateCommentBindingModel;
import softuni.project.ArtGallery.model.dto.view.CommentViewModel;

public interface CommentService {
    void create(CreateCommentBindingModel createCommentBindingModel);

    CommentViewModel createRest(CreateCommentBindingModel createCommentBindingModel);

    void approve(Long id);

    void delete(Long id);

}
