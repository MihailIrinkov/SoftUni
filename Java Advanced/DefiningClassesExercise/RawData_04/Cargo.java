package RawData_04;

public class Cargo {
    private String cargo;
    int cargoWeight;

    public Cargo(String cargo, int cargoWeight) {
        this.cargo = cargo;
        this.cargoWeight = cargoWeight;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getCargo() {
        return this.cargo;
    }

    public void setCargoWeight(int cargoWeight) {
        this.cargoWeight = cargoWeight;
    }

    public int getCargoWeight() {
        return this.cargoWeight;
    }
}
