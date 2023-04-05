package viceCity.models.players;

import viceCity.Main;
import viceCity.common.ExceptionMessages;
import viceCity.models.guns.Gun;
import viceCity.repositories.interfaces.GunRepository;
import viceCity.repositories.interfaces.Repository;

import java.util.Collection;

public abstract class BasePlayer implements Player {
    private String name;
    private int lifePoints;
    private Repository<Gun> gunRepository;

    public BasePlayer(String name, int lifePoints) {
        this.setName(name);
        this.setLifePoints(lifePoints);
        this.gunRepository = new GunRepository();
    }


    @Override
    public boolean isAlive() {
        return this.lifePoints > 0;
    }

    @Override
    public void takeLifePoints(int points) {
//        this.lifePoints = this.lifePoints - points;
//
//        if (this.lifePoints < 0) {
//            this.lifePoints = 0;
//        }
        this.lifePoints = Math.max(0, this.lifePoints - points);
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(ExceptionMessages.PLAYER_NULL_USERNAME);
        }
        this.name = name;
    }

    public void setLifePoints(int lifePoints) {
        if (lifePoints < 0) {
            throw new IllegalArgumentException(ExceptionMessages
                    .PLAYER_LIFE_POINTS_LESS_THAN_ZERO);
        }
        this.lifePoints = lifePoints;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getLifePoints() {
        return lifePoints;
    }

    @Override
    public Repository<Gun> getGunRepository() {
        return gunRepository;
    }
}
