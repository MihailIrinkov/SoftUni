package softuni.exam.instagraphlite.models.dto;

import org.aspectj.weaver.ast.Not;
import softuni.exam.instagraphlite.models.entity.Picture;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserDTO {

    @NotNull
    @Size(min = 2, max = 18)
    private String username;

    @NotNull
    @Size(min = 4)
    private String password;

    @NotNull
    private String profilePicture;

    public UserDTO() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }
}
