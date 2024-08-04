package softuni.project.ArtGallery.model.dto.binding;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CreateCommentBindingModel {

    private long artistId;

    private String textContent;
}
