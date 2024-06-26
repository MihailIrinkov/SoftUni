package softuni.config;


import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.Provider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import softuni.exceptions.ArtistNotFoundException;
import softuni.model.dto.binding.CreateCommentBindingModel;
import softuni.model.dto.view.PictureViewModel;
import softuni.model.dto.view.ArtistCategoryViewModel;
import softuni.model.dto.view.ArtistDetailsViewModel;
import softuni.model.entity.Comment;
import softuni.model.entity.Picture;
import softuni.model.entity.Artist;
import softuni.model.entity.User;
import softuni.repository.CategoryRepository;
import softuni.repository.ArtistRepository;
import softuni.repository.UserRepository;
import softuni.service.helpers.LoggedUserHelperService;

import java.time.LocalDateTime;
import java.util.Optional;

@Configuration
@RequiredArgsConstructor
public class AppConfig {

    private final CategoryRepository categoryRepository;
    private final UserRepository userRepository;
    private final ArtistRepository artistRepository;
    private final LoggedUserHelperService loggedUserHelperService;

//    private final RoleService roleService;

    @Bean
    public ModelMapper modelMapper() {
        final ModelMapper modelMapper = new ModelMapper();

//        Provider<User> loggedUserProvider = req -> getLoggeduser();
//        Provider<String> youtubeSubUrlProvider = req -> YouTubeUtil.getUrl((String) req.getSource());

        modelMapper.createTypeMap(Artist.class, ArtistDetailsViewModel.class)
                .addMappings(mapper -> mapper
                        .map(route -> route.getAuthor().getUsername(),
                                ArtistDetailsViewModel::setAuthorName));

        // RouteCategoryViewModel
        modelMapper
                .createTypeMap(Artist.class, ArtistCategoryViewModel.class)
                .addMappings(mapper -> mapper
                        .map(Artist::getName, ArtistCategoryViewModel::setTitle));

        // CreateCommentBindingModel -> Comment

        Provider<Comment> bindingModelToCommentProvider = ctx -> {

            CreateCommentBindingModel createCommentBindingModel =
                    (CreateCommentBindingModel) ctx.getSource();

            Optional<Artist> optionalRoute =
                    artistRepository.findById(createCommentBindingModel.getArtistId());

            if (optionalRoute.isEmpty()) {
                throw new ArtistNotFoundException("Route not found");
            }

            User user =
                    userRepository.findByUsername(loggedUserHelperService.getUserName()).orElse(null);

            Artist route = optionalRoute.get();

            Comment comment = new Comment();
            comment.setArtist(route);
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
