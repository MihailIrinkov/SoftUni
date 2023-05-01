package glacialExpedition.repositories;

import glacialExpedition.models.states.State;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class StateRepository implements Repository<State>{
    private Map<String, State> states;

    public StateRepository() {
        this.states = new LinkedHashMap<>();
    }

    @Override
    public Collection<State> getCollection() {
        return Collections.unmodifiableCollection(states.values());
    }

    @Override
    public void add(State state) {
        states.put(state.getName(), state);
    }

    @Override
    public boolean remove(State state) {
        return states.remove(state) != null;
    }

    @Override
    public State byName(String name) {
        State state = states.get(name);
        return state;
    }
}
