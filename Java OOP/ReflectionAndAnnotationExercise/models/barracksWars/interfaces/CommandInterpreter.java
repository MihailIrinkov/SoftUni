package BarracksWarsAnewFactory_03.barracksWars.models.barracksWars.interfaces;

import barracksWars.interfaces.Executable;

public interface CommandInterpreter {

	Executable interpretCommand(String[] data, String commandName);
}
