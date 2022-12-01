package SpeedRacing_03;

public class Car {
    //Model, fuel amount, fuel cost for 1 kilometer, and distance traveled
    private String model;
    private double fuelAmount;
    private double fuelCostPer1Km;
    private int distanceTraveled;

    public Car(String model, double fuelAmount, double fuelCostPer1Km) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelCostPer1Km = fuelCostPer1Km;
        this.distanceTraveled = 0;
    }
    public void setModel(String model){
        this.model = model;
    }
    public void setFuelAmount(double fuelAmount){
        this.fuelAmount = fuelAmount;
    }
    public void setFuelCostPer1Km(double fuelCostPer1Km){
        this.fuelCostPer1Km = fuelCostPer1Km;
    }
    public void setDistanceTraveled(int distanceTraveled){
        this.distanceTraveled = distanceTraveled;
    }
    public String getModel(){
        return model;
    }
    public double getFuelAmount(){
        return fuelAmount;
    }
    public double getFuelCostPer1Km(){
        return fuelCostPer1Km;
    }
    public int getDistanceTraveled(){
        return distanceTraveled;
    }
}
