package bg.softuni.SpringRepositories.entities;
import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "labels")
public class Label extends BaseEntity {

    @Column(name = "title")
    private String title;

    @Column(name = "subtitle")
    private String subtitle;

    @OneToMany(mappedBy = "label", targetEntity = Shampoo.class)
    private Set<Shampoo> shampoos;

    public Label() {
    }


    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public String getSubtitle() {
        return this.subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }


    public Set<Shampoo> getShampoos() {
        return this.shampoos;
    }

    public void setShampoos(Set<Shampoo> shampoos) {
        this.shampoos = shampoos;
    }
}
