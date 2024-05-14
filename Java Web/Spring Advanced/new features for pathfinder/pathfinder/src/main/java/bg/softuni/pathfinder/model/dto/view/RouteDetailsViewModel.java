package bg.softuni.pathfinder.model.dto.view;


import bg.softuni.pathfinder.model.enums.Level;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public class RouteDetailsViewModel {

    private Long id;

    private String authorName;

    private String level;

    private String name;

    private String description;

    private String videoUrl;

    private List<CommentViewModel> comments;

    // TODO pass coordinates;
}
