package bg.softuni.pathfinder.service.impl;

import bg.softuni.pathfinder.exceptions.CommentNotFoundException;
import bg.softuni.pathfinder.model.dto.binding.CreateCommentBindingModel;
import bg.softuni.pathfinder.model.dto.view.CommentViewModel;
import bg.softuni.pathfinder.model.entity.Comment;
import bg.softuni.pathfinder.repository.CommentRepository;
import bg.softuni.pathfinder.repository.RouteRepository;
import bg.softuni.pathfinder.repository.UserRepository;
import bg.softuni.pathfinder.service.CommentService;
import bg.softuni.pathfinder.service.helpers.LoggedUserHelperService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final RouteRepository routeRepository;
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
//        Route route = optionalRoute.get();
//        User user = optionalUser.get();
//
//        Comment comment = mapper.map(createCommentBindingModel, Comment.class);
//        comment.setRoute(route);
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
