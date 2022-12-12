package dealership;

public class Car {
    public String manufacturer;
    public String model;
    public int year;

    public Car (String manufacturer, String model, int year) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.year = year;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        //StringBuilder sb = new StringBuilder();

//        sb.append(getManufacturer() + " ");
//        sb.append(getModel() + " ");
//        sb.append(String.format("(%d)", getYear()));

//
//        sb.append(this.manufacturer + " ");
//        sb.append(this.model + " ");
//        sb.append(String.format("(%d)", this.year));

       // return sb.toString();
        return String.format("%s %s (%d)", this.manufacturer, this.model, this.year);
    }
}
