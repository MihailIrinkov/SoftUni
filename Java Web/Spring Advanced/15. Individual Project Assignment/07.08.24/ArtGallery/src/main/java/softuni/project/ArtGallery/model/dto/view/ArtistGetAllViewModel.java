package softuni.project.ArtGallery.model.dto.view;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
public class ArtistGetAllViewModel {

    private Long id;
    private String imageUrl;
    private String name;
    private String description;

}
