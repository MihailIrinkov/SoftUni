package vehicleShop.repositories;

import vehicleShop.models.worker.Worker;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class WorkerRepository implements Repository<Worker> {
    private Map<String, Worker> workers;

    public WorkerRepository() {
        this.workers = new LinkedHashMap<>();
    }

    @Override
    public Collection<Worker> getWorkers() {
        return Collections.unmodifiableCollection(workers.values());
    }

    @Override
    public void add(Worker worker) {
        workers.put(worker.getName(), worker);
    }

    @Override
    public boolean remove(Worker worker) {
        return workers.remove(worker.getName()) != null;
    }

    @Override
    public Worker findByName(String name) {
        return workers.values().stream().filter(w -> w.getName().equals(name))
                .findFirst().orElse(null);
    }
}
