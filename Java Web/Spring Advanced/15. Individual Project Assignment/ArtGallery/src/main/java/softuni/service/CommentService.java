package softuni.service;

import softuni.model.dto.binding.CreateCommentBindingModel;
import softuni.model.dto.view.CommentViewModel;

public interface CommentService {

    void create(CreateCommentBindingModel createCommentBindingModel);
    CommentViewModel createRest(CreateCommentBindingModel createCommentBindingModel);

    void approve(Long id);

    void delete(Long id);

}
