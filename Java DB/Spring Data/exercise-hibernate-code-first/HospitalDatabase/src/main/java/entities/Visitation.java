package entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "visitations")
public class Visitation extends BaseEntity{

    @Column(nullable = false)
    private Date visitationDate;

    @Column
    private String comments;


    public Visitation() {
    }

    public Date getVisitationDate() {
        return visitationDate;
    }

    public void setVisitationDate(Date visitationDate) {
        this.visitationDate = visitationDate;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
