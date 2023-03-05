package Vehicles_01;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public abstract class Vehicles {
    private double fuelQuantity;
    private double fuelConsumption;

    public String drive(double distance) {
        double neededFuel = distance * fuelConsumption;
        if (fuelQuantity > (neededFuel)) {
            setFuelQuantity(getFuelQuantity() - neededFuel);
            DecimalFormat df = new DecimalFormat("##.##");

            return String.format("%s travelled %s km",
                    getClass().getSimpleName(), df.format(distance));
        } else {
            return String.format(getClass().getSimpleName() + " needs refueling");
        }
    }

    public void refuel(double liters) {
        this.fuelQuantity += liters;
    }

    public Vehicles(double fuelQuantity, double fuelConsumption) {
        this.fuelQuantity = fuelQuantity;
        this.fuelConsumption = fuelConsumption;
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

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    @Override
    public String toString() {

        return String.format("%s: %.2f", getClass().getSimpleName(), getFuelQuantity());
    }
}
