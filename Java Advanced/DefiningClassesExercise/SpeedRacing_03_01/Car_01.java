package SpeedRacing_03_01;

public class Car_01 {
    private String model;
    private double fuelAmount;
    private double fuelCostPer1Km;
    private int distanceTraveled;

    public Car_01(String model, double fuelAmount, double fuelCostPer1Km) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelCostPer1Km = fuelCostPer1Km;
        this.distanceTraveled = 0;
    }

    public double fuelConsumation(int amountOfKm) {
        return amountOfKm * this.fuelCostPer1Km;
    }

    public boolean hasEnoughFuel(int amountOfKm) {
        return this.fuelAmount >= fuelConsumation(amountOfKm);
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setFuelAmount(double fuelAmount) {
        this.fuelAmount = fuelAmount;
    }

    public void setFuelCostPer1Km(double fuelCostPer1Km) {
        this.fuelCostPer1Km = fuelCostPer1Km;
    }

    public void setDistanceTraveled(int distanceTraveled) {
        this.distanceTraveled = distanceTraveled;
    }

    public String getModel() {
        return model;
    }

    public double getFuelAmount() {
        return fuelAmount;
    }

    public double getFuelCostPer1Km() {
        return fuelCostPer1Km;
    }

    public int getDistanceTraveled() {
        return distanceTraveled;
    }
}
