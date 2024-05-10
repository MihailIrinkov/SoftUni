package bg.softuni.pathfinder.model.dto.view;

import lombok.experimental.SuperBuilder;

@SuperBuilder
public class RouteGetAllViewModel {

    private Long id;
    private String imageUrl;
    private String name;
    private String description;

    public RouteGetAllViewModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
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
}
