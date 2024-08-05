package softuni.project.ArtGallery.service.session;

import org.springframework.security.core.session.SessionInformation;

public interface SessionRegistry {
    SessionInformation getSessionInformation(String sessionId);
}
