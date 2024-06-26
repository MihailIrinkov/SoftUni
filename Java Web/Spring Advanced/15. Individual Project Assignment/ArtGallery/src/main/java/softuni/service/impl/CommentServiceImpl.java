package softuni.service.impl;


import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exceptions.CommentNotFoundException;
import softuni.model.dto.binding.CreateCommentBindingModel;
import softuni.model.dto.view.CommentViewModel;
import softuni.model.entity.Comment;
import softuni.repository.CommentRepository;
import softuni.repository.ArtistRepository;
import softuni.repository.UserRepository;
import softuni.service.CommentService;
import softuni.service.helpers.LoggedUserHelperService;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final ArtistRepository artistRepository;
    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private final ModelMapper mapper;
    private final LoggedUserHelperService loggedUserHelperService;


    @Override
    public void create(CreateCommentBindingModel createCommentBindingModel) {

//        Optional<Route> optionalRoute = routeRepository.findById(createCommentBindingModel.getRouteId());
//
//        if (optionalRoute.isEmpty()) {
//            throw new RouteNotFoundException("Route not found");
//        }
//
//        Optional<User> optionalUser =
//                userRepository.findByUsername(loggedUser.getUsername());
//        if (optionalUser.isEmpty()) {
//            throw new UserNotFoundException("User with username: " +
//                    loggedUser.getUsername() + " was not found");
//        }
//        Route artists = optionalRoute.get();
//        User user = optionalUser.get();
//
//        Comment comment = mapper.map(createCommentBindingModel, Comment.class);
//        comment.setRoute(artists);
//        comment.setAuthor(user);
//        comment.setCreated(LocalDateTime.now());

        // replace in AppConfig via ModelMapper
        Comment comment = mapper.map(createCommentBindingModel, Comment.class);
        comment.setId(null);
        commentRepository.save(comment);
    }

    @Override
    public CommentViewModel createRest(CreateCommentBindingModel createCommentBindingModel) {
        Comment comment = mapper.map(createCommentBindingModel, Comment.class);
        comment.setId(null);

       return mapper.map(commentRepository.save(comment), CommentViewModel.class);
    }

    @Override
    public void approve(Long id) {
        Comment comment = commentRepository.findById(id)
                .orElseThrow(() -> new CommentNotFoundException("Comment with id: " + id
                        + " was not found"));

        comment.setApproved(true);
        commentRepository.save(comment);
    }

    @Override
    public void delete(Long id) {
          commentRepository.deleteById(id);
    }

}
