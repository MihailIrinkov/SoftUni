package softuni.project.ArtGallery.model.dto.binding;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;
import softuni.project.ArtGallery.anotations.FileAnnotation;

@Getter
@Setter
@NoArgsConstructor
public class UploadPictureArtistBindingModel {

    private long id;

    @FileAnnotation(contentTypes = {"image/png", "image/jpeg"})
    private MultipartFile picture;

    private Boolean isPrimary = false;
}
