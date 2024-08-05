package softuni.project.ArtGallery.model.dto.binding;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.springframework.web.multipart.MultipartFile;
import softuni.project.ArtGallery.anotations.FileAnnotation;
import softuni.project.ArtGallery.model.enums.CategoryNames;

import java.util.Set;

public class AddArtistBindingModel {


    @Size(min = 3, message = "Name length must be more than 3 characters")
    @NotNull
    private String name;

    @Size(min = 5, message = "Description length must be more than 5 characters")
    @NotNull
    private String description;

    @FileAnnotation(contentTypes = "text/xml")
    private MultipartFile gpxCoordinates;


    @Pattern(regexp = "https:\\/\\/www\\.youtube\\.com\\/watch\\?v=.*", message = "Invalid youtube URL provided!")
    private String videoUrl;

    private Set<CategoryNames> categories;

    public AddArtistBindingModel() {
    }

    public MultipartFile getGpxCoordinates() {
        return gpxCoordinates;
    }

    public AddArtistBindingModel setGpxCoordinates(MultipartFile gpxCoordinates) {
        this.gpxCoordinates = gpxCoordinates;
        return this;
    }

    public Set<CategoryNames> getCategories() {
        return categories;
    }

    public void setCategories(Set<CategoryNames> categories) {
        this.categories = categories;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }
}
