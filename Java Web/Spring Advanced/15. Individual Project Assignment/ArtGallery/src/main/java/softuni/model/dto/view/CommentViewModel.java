package softuni.model.dto.view;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CommentViewModel {

    private Long id;
    private String content;
    private String authorName;
    private Boolean approved;
}
