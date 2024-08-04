package softuni.project.ArtGallery.controller.rest;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import softuni.project.ArtGallery.model.dto.binding.CreateCommentBindingModel;
import softuni.project.ArtGallery.model.dto.view.CommentViewModel;
import softuni.project.ArtGallery.service.CommentService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/comments")
public class CommentRestController {

    private final CommentService commentService;

    @PostMapping("/create")
    public CommentViewModel create(@RequestBody CreateCommentBindingModel createCommentBindingModel) {
        return commentService.createRest(createCommentBindingModel);
    }
}
