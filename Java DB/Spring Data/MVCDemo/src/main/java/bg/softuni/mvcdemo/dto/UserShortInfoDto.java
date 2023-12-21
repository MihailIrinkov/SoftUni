package bg.softuni.mvcdemo.dto;

public class UserShortInfoDto {

    private String username;

    public UserShortInfoDto() {
    }

    public UserShortInfoDto(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
