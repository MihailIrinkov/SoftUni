package bg.softuni.pathfinder.config;

import bg.softuni.pathfinder.exceptions.RouteNotFoundException;
import bg.softuni.pathfinder.model.dto.binding.CreateCommentBindingModel;
import bg.softuni.pathfinder.model.dto.view.PictureViewModel;
import bg.softuni.pathfinder.model.dto.view.RouteCategoryViewModel;
import bg.softuni.pathfinder.model.dto.view.RouteDetailsViewModel;
import bg.softuni.pathfinder.model.entity.Comment;
import bg.softuni.pathfinder.model.entity.Picture;
import bg.softuni.pathfinder.model.entity.Route;
import bg.softuni.pathfinder.model.entity.User;
import bg.softuni.pathfinder.repository.CategoryRepository;
import bg.softuni.pathfinder.repository.RouteRepository;
import bg.softuni.pathfinder.repository.UserRepository;
import bg.softuni.pathfinder.service.helpers.LoggedUserHelperService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.Provider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;
import java.util.Optional;

@Configuration
@RequiredArgsConstructor
public class AppConfig {

    private final CategoryRepository categoryRepository;
    private final UserRepository userRepository;
    private final RouteRepository routeRepository;
    private final LoggedUserHelperService loggedUserHelperService;

//    private final RoleService roleService;

    @Bean
    public ModelMapper modelMapper() {
        final ModelMapper modelMapper = new ModelMapper();

//        Provider<User> loggedUserProvider = req -> getLoggeduser();
//        Provider<String> youtubeSubUrlProvider = req -> YouTubeUtil.getUrl((String) req.getSource());

        modelMapper.createTypeMap(Route.class, RouteDetailsViewModel.class)
                .addMappings(mapper -> mapper
                        .map(route -> route.getAuthor().getUsername(),
                                RouteDetailsViewModel::setAuthorName));

        // RouteCategoryViewModel
        modelMapper
                .createTypeMap(Route.class, RouteCategoryViewModel.class)
                .addMappings(mapper -> mapper
                        .map(Route::getName, RouteCategoryViewModel::setTitle));

        // CreateCommentBindingModel -> Comment

        Provider<Comment> bindingModelToCommentProvider = ctx -> {

            CreateCommentBindingModel createCommentBindingModel =
                    (CreateCommentBindingModel) ctx.getSource();

            Optional<Route> optionalRoute =
                    routeRepository.findById(createCommentBindingModel.getRouteId());

            if (optionalRoute.isEmpty()) {
                throw new RouteNotFoundException("Route not found");
            }

            User user =
                    userRepository.findByUsername(loggedUserHelperService.getUserName()).orElse(null);

            Route route = optionalRoute.get();

            Comment comment = new Comment();
            comment.setRoute(route);
            comment.setAuthor(user);
            comment.setCreated(LocalDateTime.now());

            return comment;
        };

        modelMapper
                .createTypeMap(CreateCommentBindingModel.class, Comment.class)
                .setProvider(bindingModelToCommentProvider);


        // Picture -> PictureViewModel
        modelMapper
                .createTypeMap(Picture.class, PictureViewModel.class)
                .addMappings(mapper -> mapper
                        .map(Picture::getUrl, PictureViewModel::setSrc))
                .addMappings(mapper -> mapper
                        .map(Picture::getTitle, PictureViewModel::setAlt));

        return modelMapper;
    }


//    @Bean
//    public ModelMapper modelMapper(){
//        return new ModelMapper();
//    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
