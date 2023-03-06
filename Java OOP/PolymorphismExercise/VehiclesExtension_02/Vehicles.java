package VehiclesExtension_02;

import java.text.DecimalFormat;

public class Vehicles {

    private double fuelQuantity;
    private double fuelConsumption;
    private double tankCapacity;
    private double additionalConsumption;

    public Vehicles(double fuelQuantity, double fuelConsumption, double tankCapacity, double additionalConsumption) {
        this.fuelQuantity = fuelQuantity;
        this.fuelConsumption = fuelConsumption;
        this.tankCapacity = tankCapacity;
        this.additionalConsumption = additionalConsumption;
    }

    public String driveWithAc(double distance) {
        setFuelConsumption(getFuelConsumption() + additionalConsumption);
        String result = this.drive(distance);
        setFuelConsumption(getFuelConsumption() - additionalConsumption);
        return result;
    }

    public String drive(double distance) {
        double neededFuel = distance * getFuelConsumption();
        if (neededFuel > getFuelQuantity()) {
            return this.getClass().getSimpleName() + " needs refueling";
        }
        setFuelQuantity(getFuelQuantity() - neededFuel);
        DecimalFormat df = new DecimalFormat("##.##");

        return String.format("%s travelled %s km",
                getClass().getSimpleName(), df.format(distance));
    }

    public void refuel(double liters) {
        if (liters <= 0) {
            throw new IllegalArgumentException("Fuel must be a positive number");
        }
        if ((fuelQuantity + liters) > tankCapacity) {
            throw new IllegalArgumentException("Cannot fit fuel in tank");
        }
        this.fuelQuantity += liters;
    }

    public double getFuelQuantity() {
        return fuelQuantity;
    }

    public void setFuelQuantity(double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public double getTankCapacity() {
        return tankCapacity;
    }

    public void setTankCapacity(double tankCapacity) {
        this.tankCapacity = tankCapacity;
    }

    public double getAdditionalConsumption() {
        return additionalConsumption;
    }

    public void setAdditionalConsumption(double additionalConsumption) {
        this.additionalConsumption = additionalConsumption;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }


    @Override
    public String toString() {

        return String.format("%s: %.2f", getClass().getSimpleName(), getFuelQuantity());
    }

}
