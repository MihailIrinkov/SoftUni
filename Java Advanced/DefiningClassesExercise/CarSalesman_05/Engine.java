package CarSalesman_05;

public class Engine {
    private String model;
    private int power;
    private int displacement;
    private String efficiency;

    public Engine(String model, int power){
        this.model = model;
        this.power = power;
    }
    public Engine(int displacement, String efficiency, String model, int power){
        this.model = model;
        this.power = power;
        this.displacement = displacement;
        this.efficiency = efficiency;
    }
    public void setModel(String model){
        this.model = model;
    }
    public String getModel(){
        return this.model;
    }
    public void setPower(int power){
        this.power = power;
    }

    public int getPower() {
        return this.power;
    }
    public void setDisplacement(int displacement){
        this.displacement = displacement;
    }

    public int getDisplacement() {
        return this.displacement;
    }
    public void setEfficiency(String efficiency){
        this.efficiency = efficiency;
    }
    public String getEfficiency(){
        return this.efficiency;
    }
}
