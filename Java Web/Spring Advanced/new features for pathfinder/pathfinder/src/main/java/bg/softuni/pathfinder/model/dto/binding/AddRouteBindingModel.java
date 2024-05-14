package bg.softuni.pathfinder.model.dto.binding;

import bg.softuni.pathfinder.model.enums.CategoryNames;
import bg.softuni.pathfinder.model.enums.Level;
import bg.softuni.pathfinder.validation.anotations.FileAnnotation;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.springframework.web.multipart.MultipartFile;

import java.util.Set;

public class AddRouteBindingModel {


    @Size(min = 3, message = "Name length must be more than 3 characters")
    private String name;

    @Size(min = 5, message = "Description length must be more than 5 characters")
    private String description;

    @FileAnnotation(contentTypes = "text/xml")
    private MultipartFile gpxCoordinates;

    private Level level;

    @Pattern(regexp = "https:\\/\\/www\\.youtube\\.com\\/watch\\?v=.*", message = "Invalid youtube URL provided!")
    private String videoUrl;

    private Set<CategoryNames> categories;

    public AddRouteBindingModel() {
    }

    public MultipartFile getGpxCoordinates() {
        return gpxCoordinates;
    }

    public AddRouteBindingModel setGpxCoordinates(MultipartFile gpxCoordinates) {
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

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }
}
