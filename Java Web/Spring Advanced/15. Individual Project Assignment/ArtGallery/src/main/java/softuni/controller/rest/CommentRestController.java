package softuni.controller.rest;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import softuni.model.dto.binding.CreateCommentBindingModel;
import softuni.model.dto.view.CommentViewModel;
import softuni.service.CommentService;

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
