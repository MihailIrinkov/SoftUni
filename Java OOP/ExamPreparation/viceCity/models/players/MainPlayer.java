package viceCity.models.players;

import viceCity.models.guns.Gun;
import viceCity.repositories.interfaces.Repository;

public class MainPlayer extends BasePlayer{
    private static final int INITIAL_LIFE_POINTS = 100;
    private static final String MainPlayer_NAME = "Tommy Vercetti";

    public MainPlayer() {
        super(MainPlayer_NAME, INITIAL_LIFE_POINTS);
    }

}
