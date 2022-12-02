package RawData_04;

public class Engine {
    //private String engine;
    private int engineSpeed;
    private int enginePower;

    public Engine(int engineSpeed, int enginePower){
        this.enginePower = enginePower;
        this.engineSpeed = engineSpeed;
    }
//    public void setEnginePower(int enginePower){
//        this.enginePower = enginePower;
//    }
//    public int getEnginePower(){
//        return this.enginePower;
//    }
    public void setEngineSpeed(int engineSpeed){
        this.engineSpeed = engineSpeed;
    }
    public void setEnginePower(int enginePower){
        this.enginePower = enginePower;
    }
    public int getEnginePower(){
        return this.enginePower;
    }
}
