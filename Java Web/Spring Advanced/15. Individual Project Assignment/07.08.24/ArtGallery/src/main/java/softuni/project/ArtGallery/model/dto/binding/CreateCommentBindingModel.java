package softuni.project.ArtGallery.model.dto.binding;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CreateCommentBindingModel {

    private long artistId;

    @NotNull
    private String textContent;
}
