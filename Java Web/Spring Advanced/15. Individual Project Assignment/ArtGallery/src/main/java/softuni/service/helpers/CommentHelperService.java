package softuni.service.helpers;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import softuni.repository.CommentRepository;

@Service
@RequiredArgsConstructor
public class CommentHelperService {

    private final CommentRepository commentRepository;

    public Long getMostCommentedArtistId() {
        return commentRepository.getMostCommentedRouteId();
    }
}
