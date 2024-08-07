package softuni.project.ArtGallery.model.dto.view;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
public class ChangeUsernameViewModel {

    @NotNull
    @Size(min = 3, message = "Username length must be more than 3 characters")
    private String newUsername;

    @NotNull
    @Size(min = 3, message = "Username length must be more than 3 characters")
    private String confirmNewUsername;

}
