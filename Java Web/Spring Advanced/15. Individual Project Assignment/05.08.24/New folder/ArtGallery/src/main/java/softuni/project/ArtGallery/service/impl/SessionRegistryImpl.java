package softuni.project.ArtGallery.service.impl;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.session.SessionInformation;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Service;
import softuni.project.ArtGallery.service.session.SessionRegistry;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

@Service
public class SessionRegistryImpl implements SessionRegistry {

    LocalDate localDate = LocalDate.now();

    Date date =  Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());



    @Override
    public SessionInformation getSessionInformation(String sessionId) {
        return new SessionInformation(SecurityContextHolder.getContext().getAuthentication().getPrincipal(), ((WebAuthenticationDetails) SecurityContextHolder.getContext().getAuthentication().getDetails())
                .getSessionId(), date);
    }
}
