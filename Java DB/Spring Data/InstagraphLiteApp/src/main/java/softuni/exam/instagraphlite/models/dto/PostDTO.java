package softuni.exam.instagraphlite.models.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "post")
@XmlAccessorType(XmlAccessType.FIELD)
public class PostDTO {

    @XmlElement(name = "caption")
    @NotNull
    @Size(min = 21)
    private String caption;

    @XmlElement(name = "user")
    private UserBasicDTO user;

    @XmlElement(name = "picture")
    private PictureBasicDTO picture;

    public PostDTO() {
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public UserBasicDTO getUser() {
        return user;
    }

    public void setUser(UserBasicDTO user) {
        this.user = user;
    }

    public PictureBasicDTO getPicture() {
        return picture;
    }

    public void setPicture(PictureBasicDTO picture) {
        this.picture = picture;
    }
}
