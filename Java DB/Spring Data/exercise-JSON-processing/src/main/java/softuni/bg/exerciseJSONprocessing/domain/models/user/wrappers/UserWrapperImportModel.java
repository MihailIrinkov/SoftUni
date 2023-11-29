package softuni.bg.exerciseJSONprocessing.domain.models.user.wrappers;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import softuni.bg.exerciseJSONprocessing.domain.entities.User;
import softuni.bg.exerciseJSONprocessing.domain.models.user.UserImportModel;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@XmlRootElement(name = "users")
@XmlAccessorType(XmlAccessType.FIELD)
public class UserWrapperImportModel {

    @XmlElement(name = "user")
    private List<UserImportModel> users;
}
