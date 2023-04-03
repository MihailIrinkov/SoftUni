package christmasRaces.repositories;

import christmasRaces.entities.races.Race;
import christmasRaces.repositories.interfaces.Repository;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class RaceRepository implements Repository<Race> {
    private Map<String, Race> raceMap;

    public RaceRepository() {
        raceMap = new LinkedHashMap<>();
    }

    @Override
    public Race getByName(String name) {
        return raceMap.get(name);
    }

    @Override
    public Collection<Race> getAll() {
        return Collections.unmodifiableCollection(raceMap.values());
    }

    @Override
    public void add(Race race) {
        raceMap.putIfAbsent(race.getName(), race);
    }

    @Override
    public boolean remove(Race race) {
        return raceMap.remove(race.getName()) != null;
    }
}
