package softuni.model.dto.view;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ArtistIndexViewModel extends ArtistViewModel {

    private List<PictureViewModel> pictures;
}
