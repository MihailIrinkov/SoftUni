package softuni.service.helpers;


import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import softuni.exceptions.UserNotFoundException;
import softuni.model.entity.User;
import softuni.model.enums.UserRoles;
import softuni.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class LoggedUserHelperService {
    private final UserRepository userRepository;


    public User get() {
        String username = getUserName();
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UserNotFoundException(
                        "User with username: " + username + " was n ot found"));
    }

    public boolean isLogged() {
        return !hasRole(UserRoles.ANONYMOUS);
    }

    public boolean isAdmin() {
        return hasRole(UserRoles.ADMIN);
    }

    public boolean isModerator() {
        return hasRole(UserRoles.MODERATOR);
    }

    public boolean isOnlyUser() {
        return getAuthentication().getAuthorities()
                .stream()
                .allMatch(role -> role.getAuthority().equals("ROLE_" + UserRoles.USER));
    }

    public String getUserName() {
        return getUserDetails().getUsername();
    }

    private UserDetails getUserDetails() {
        return (UserDetails) getAuthentication().getPrincipal();
    }
    private Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    public boolean hasRole(UserRoles userRoles) {

            return getAuthentication().getAuthorities()
                    .stream()
                    .anyMatch(role -> role.getAuthority().equals("ROLE_" + userRoles));

    }
}
