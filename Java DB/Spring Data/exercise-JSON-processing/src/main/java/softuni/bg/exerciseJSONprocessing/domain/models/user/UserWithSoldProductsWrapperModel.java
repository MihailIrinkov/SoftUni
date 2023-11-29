package softuni.bg.exerciseJSONprocessing.domain.models.user;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserWithSoldProductsWrapperModel {

    private Integer count;

    private List<UserWithSoldProducts> users;

    public UserWithSoldProductsWrapperModel(List<UserWithSoldProducts> users) {
        this.users = users;
        this.count = users.size();
    }
}
