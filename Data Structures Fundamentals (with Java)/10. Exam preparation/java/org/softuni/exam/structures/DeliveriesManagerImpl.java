package org.softuni.exam.structures;

import org.softuni.exam.entities.Deliverer;
import org.softuni.exam.entities.Package;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DeliveriesManagerImpl implements DeliveriesManager {

    private Map<String, Deliverer> deliverersById = new LinkedHashMap<>();
    private Map<String, Package> packagesById = new LinkedHashMap<>();

    @Override
    public void addDeliverer(Deliverer deliverer) {
        deliverersById.put(deliverer.getId(), deliverer);
    }

    @Override
    public void addPackage(Package _package) {
        packagesById.put(_package.getId(), _package);
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

    }

    @Override
    public Iterable<Package> getUnassignedPackages() {
        return null;
    }

    @Override
    public Iterable<Package> getPackagesOrderedByWeightThenByReceiver() {
        return null;
    }

    @Override
    public Iterable<Deliverer> getDeliverersOrderedByCountOfPackagesThenByName() {
        return null;
    }
}
