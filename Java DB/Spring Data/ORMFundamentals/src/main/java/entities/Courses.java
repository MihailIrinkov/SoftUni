package entities;

import orm.anotations.Column;
import orm.anotations.Entity;
import orm.anotations.Id;

@Entity(name = "courses")
public class Courses {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "length")
    private int length;

    public Courses(String name, int length) {
        this.name = name;
        this.length = length;
    }

    public Courses() {
    }

    @Override
    public String toString() {
        return "Courses{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", length=" + length +
                '}';
    }
}
