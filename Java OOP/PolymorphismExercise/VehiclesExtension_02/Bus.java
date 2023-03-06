package VehiclesExtension_02;

public class Bus extends Vehicles{
    public final static double AC_ADDITIONAL_CONSUMPTION_B = 1.4;
    private double additionalConsumption = AC_ADDITIONAL_CONSUMPTION_B;

    public Bus(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity, AC_ADDITIONAL_CONSUMPTION_B);
    }

    @Override
    public double getAdditionalConsumption() {
        return additionalConsumption;
    }

    @Override
    public void setAdditionalConsumption(double additionalConsumption) {
        this.additionalConsumption = additionalConsumption;
    }
}
