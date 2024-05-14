package bg.softuni.pathfinder.service.impl;

import bg.softuni.pathfinder.exceptions.RouteNotFoundException;
import bg.softuni.pathfinder.exceptions.UserNotFoundException;
import bg.softuni.pathfinder.model.dto.binding.CreateCommentBindingModel;
import bg.softuni.pathfinder.model.entity.Comment;
import bg.softuni.pathfinder.model.entity.Route;
import bg.softuni.pathfinder.model.entity.User;
import bg.softuni.pathfinder.repository.CommentRepository;
import bg.softuni.pathfinder.repository.RouteRepository;
import bg.softuni.pathfinder.repository.UserRepository;
import bg.softuni.pathfinder.service.CommentService;
import bg.softuni.pathfinder.service.session.LoggedUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService {

    private final RouteRepository routeRepository;
    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private final ModelMapper mapper;
    private final LoggedUser loggedUser;

    public CommentServiceImpl(RouteRepository routeRepository,
                              CommentRepository commentRepository,
                              UserRepository userRepository,
                              ModelMapper mapper,
                              LoggedUser loggedUser) {
        this.routeRepository = routeRepository;
        this.commentRepository = commentRepository;
        this.userRepository = userRepository;
        this.mapper = mapper;
        this.loggedUser = loggedUser;
    }

    @Override
    public void create(CreateCommentBindingModel createCommentBindingModel) {
        Optional<Route> optionalRoute = routeRepository.findById(createCommentBindingModel.getRouteId());

        if (optionalRoute.isEmpty()) {
            throw new RouteNotFoundException("Route not found");
        }

        Optional<User> optionalUser =
                userRepository.findByUsername(loggedUser.getUsername());
        if (optionalUser.isEmpty()) {
            throw new UserNotFoundException("User with username: " +
                    loggedUser.getUsername() + " was not found");
        }
        Route route = optionalRoute.get();
        User user = optionalUser.get();

        Comment comment = mapper.map(createCommentBindingModel, Comment.class);
        comment.setRoute(route);
        comment.setAuthor(user);
        comment.setCreated(LocalDateTime.now());

        commentRepository.save(comment);
    }
}
