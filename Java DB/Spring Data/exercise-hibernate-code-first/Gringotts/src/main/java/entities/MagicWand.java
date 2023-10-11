package entities;

import javax.persistence.*;

@Entity
@Table(name = "magic_wands")
public class MagicWand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "magic_wand_creator", length = 1000)
    private String magicWandCreator;

    @Column(name = "magic_wand_size")
    private Integer magicWandSize;

    public MagicWand() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMagicWandCreator() {
        return magicWandCreator;
    }

    public void setMagicWandCreator(String magicWandCreator) {
        this.magicWandCreator = magicWandCreator;
    }

    public Integer getMagicWandSize() {
        return magicWandSize;
    }

    public void setMagicWandSize(Integer magicWandSize) {
        this.magicWandSize = magicWandSize;
    }
}
