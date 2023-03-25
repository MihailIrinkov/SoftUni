package BarracksWarsAnewFactory_03.barracksWars.models.barracksWars.models.units;

import barracksWars.models.units.AbstractUnit;

public class Swordsman extends AbstractUnit {
    private static final int SWORDSMAN_HEALTH = 40;
    private static final int SWORDSMAN_DAMAGE = 13;

    public Swordsman() {
        super(SWORDSMAN_HEALTH, SWORDSMAN_DAMAGE);
    }
}
