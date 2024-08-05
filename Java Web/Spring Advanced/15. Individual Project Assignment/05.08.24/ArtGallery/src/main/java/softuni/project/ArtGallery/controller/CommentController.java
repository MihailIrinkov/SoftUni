package softuni.project.ArtGallery.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import softuni.project.ArtGallery.model.dto.binding.CreateCommentBindingModel;
import softuni.project.ArtGallery.service.CommentService;

@Controller
@RequestMapping("/comments")
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/create")
    public ModelAndView create(CreateCommentBindingModel createCommentBindingModel) {
        commentService.create(createCommentBindingModel);

        return new ModelAndView("redirect:/artists/details/" +
                createCommentBindingModel.getArtistId());
    }

//    @PatchMapping("/{id}/approve/{artistId}")
    @PostMapping("/{id}/approve/{artistId}")
    public ModelAndView approve(@PathVariable("id") Long id,
                                @PathVariable("artistId") Long artistId) {
        commentService.approve(id);

        return new ModelAndView("redirect:/artists/details/" + artistId);
    }

//    @DeleteMapping("/{id}/{artistId}")
    @PostMapping("/{id}/{artistId}")
    public ModelAndView delete(@PathVariable("id") Long id,
                               @PathVariable("artistId") Long artistId) {
        commentService.delete(id);

        return new ModelAndView("redirect:/artists/details/" + artistId);
    }
}
