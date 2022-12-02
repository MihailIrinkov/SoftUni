package RawData_04;

import java.util.ArrayList;
import java.util.List;

public class Tire {

    private double tirePressure;
    private int tireAge;
//    private double tire2Pressure;
//    private int tire2Age;
//    private double tire3Pressure;
//    private int tire3Age;
//    private double tire4Pressure;
//    private int tire4Age;
//    private List<Tire> tireListC = new ArrayList<>();
    public Tire(double tirePressure, int tireAge){
        this.tireAge = tireAge;
        this.tirePressure = tirePressure;
    }
//    public void setTire(List<Tire>){
//        tireListC.add(Tire);
//    }

//    public String getTire() {
//        return this.tire;
//    }
    public void setTirePressure(double tirePressure){
        this.tirePressure = tirePressure;
    }
    public double getTirePressure(){
        return this.tirePressure;
    }
    public void setTireAge(int tireAge){
        this.tireAge = tireAge;
    }
    public int getTireAge(){
        return this.tireAge;
    }
//    public void setTire2Pressure(double tire2Pressure){
//        this.tire2Pressure = tire2Pressure;
//    }
//    public double getTire2Pressure(){
//        return tire2Pressure;
//    }
//    public void setTire2Age(int tire2Age){
//        this.tire2Age = tire2Age;
//    }
//    public int getTire2Age(){
//        return this.tire2Age;
//    }
//    public void setTire3Pressure(double tire3Pressure){
//        this.tire3Pressure = tire3Pressure;
//    }
//    public double getTire3Pressure(){
//        return this.tire3Pressure;
//    }
//    public void setTire3Age(int tire3Age){
//        this.tire3Age = tire3Age;
//    }
//    public int getTire3Age(){
//        return this.tire3Age;
//    }
//    public void setTire4Pressure(double tire4Pressure){
//        this.tire4Pressure = tire4Pressure;
//    }
//    public double getTire4Pressure(){
//        return this.tire4Pressure;
//    }
//    public void setTire4Age(int tire4Pressure){
//        this.tire4Pressure = tire4Pressure;
//    }
//    public int getTire4Age(){
//        return this.tire4Age;
//    }
}
