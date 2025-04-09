package org.softuni.exam.structures;

import org.softuni.exam.entities.Deliverer;
import org.softuni.exam.entities.Package;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class DeliveriesManagerImpl implements DeliveriesManager {

    private Map<String, Deliverer> deliverersById = new LinkedHashMap<>();
    private Map<String, Package> packagesById = new LinkedHashMap<>();
    private Map<String, Package> unassingnedPackages = new LinkedHashMap<>();

    private Map<String, Integer> packagesCountByDeliverer = new LinkedHashMap<>();

    @Override
    public void addDeliverer(Deliverer deliverer) {
        deliverersById.put(deliverer.getId(), deliverer);
        packagesCountByDeliverer.put(deliverer.getId(), 0);
    }

    @Override
    public void addPackage(Package _package) {
        packagesById.put(_package.getId(), _package);
        unassingnedPackages.put(_package.getId(), _package);
    }

    @Override
    public boolean contains(Deliverer deliverer) {
        return deliverersById.containsKey(deliverer.getId());

//        return deliverersById.get(deliverer.getId()) != null;

    }

    @Override
    public boolean contains(Package _package) {
        return packagesById.containsKey(_package.getId());
    }

    @Override
    public Iterable<Deliverer> getDeliverers() {
        return deliverersById.values();
    }

    @Override
    public Iterable<Package> getPackages() {
        return packagesById.values();
    }

    @Override
    public void assignPackage(Deliverer deliverer, Package _package) throws IllegalArgumentException {
        if (!contains(deliverer) || !contains(_package)) {
            throw new IllegalArgumentException();
        }

        Integer currentCount = packagesCountByDeliverer.get(deliverer.getId());
        packagesCountByDeliverer.put(deliverer.getId(), currentCount + 1);
        unassingnedPackages.remove(_package.getId());
    }

    @Override
    public Iterable<Package> getUnassignedPackages() {
        return unassingnedPackages.values();
    }

    @Override
    public Iterable<Package> getPackagesOrderedByWeightThenByReceiver() {
        return packagesById.values()
                .stream()
                .sorted(Comparator.comparing(Package::getWeight).reversed()
                        .thenComparing(Package::getReceiver))
                .collect(Collectors.toList());
    }

    @Override
    public Iterable<Deliverer> getDeliverersOrderedByCountOfPackagesThenByName() {
        return deliverersById.values()
                .stream()
                .sorted(Comparator.comparing((Deliverer d) -> packagesCountByDeliverer.get(d.getId()))
                        .reversed()
                        .thenComparing(Deliverer::getName))
                .collect(Collectors.toList());
    }
}
