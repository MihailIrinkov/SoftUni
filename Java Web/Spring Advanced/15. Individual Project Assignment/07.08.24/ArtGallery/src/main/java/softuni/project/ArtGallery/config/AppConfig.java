package softuni.project.ArtGallery.config;


import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.Provider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import softuni.project.ArtGallery.exceptions.ArtistNotFoundException;
import softuni.project.ArtGallery.model.dto.binding.CreateCommentBindingModel;
import softuni.project.ArtGallery.model.dto.view.ArtistCategoryViewModel;
import softuni.project.ArtGallery.model.dto.view.ArtistDetailsViewModel;
import softuni.project.ArtGallery.model.dto.view.PictureViewModel;
import softuni.project.ArtGallery.model.entity.Artist;
import softuni.project.ArtGallery.model.entity.Comment;
import softuni.project.ArtGallery.model.entity.Picture;
import softuni.project.ArtGallery.repository.ArtistRepository;

import java.time.LocalDateTime;
import java.util.Optional;

@Configuration
@RequiredArgsConstructor
public class AppConfig {

    private final ArtistRepository artistRepository;


    @Bean
    public ModelMapper modelMapper() {
        final ModelMapper modelMapper = new ModelMapper();


        modelMapper.createTypeMap(Artist.class, ArtistDetailsViewModel.class)
                .addMappings(mapper -> mapper
                        .map(route -> route.getAuthor().getUsername(),
                                ArtistDetailsViewModel::setAuthorName));

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

//            User user =
//                    userRepository.findByUsername(loggedUserHelperService.getUserName()).orElse(null);

            Artist route = optionalRoute.get();

            Comment comment = new Comment();
            comment.setArtist(route);
            comment.setAuthor(null);
//            comment.setAuthor(user);
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


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
