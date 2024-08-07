package softuni.project.ArtGallery.model.dto.view;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import softuni.project.ArtGallery.model.entity.User;
import softuni.project.ArtGallery.model.enums.UserRoles;
import softuni.project.ArtGallery.repository.UserRepository;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
public class UserProfileViewModel {

    private UserRepository userRepository;

    private String fullName;

    private String username;

    private int age;

    private Long id;

}
