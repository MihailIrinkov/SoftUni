package BarracksWarsAnewFactory_03.barracksWars.models.barracksWars.interfaces;

import barracksWars.interfaces.Unit;
import jdk.jshell.spi.ExecutionControl;

public interface UnitFactory {

    Unit createUnit(String unitType) throws ExecutionControl.NotImplementedException;
}