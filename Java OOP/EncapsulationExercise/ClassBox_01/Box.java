package ClassBox_01;

public class Box {
    private double length;
    private double width;
    private double height;

    public Box(double length, double width, double height) {
        setLength(length);
        setWidth(width);
        setHeight(height);
    }

    public void setLength(double length) {

        if (length > 0) {
            this.length = length;
        } else {
            throw new IllegalArgumentException("Length cannot be zero or negative");
        }
    }

    public void setWidth(double width) {

        if (width > 0) {
            this.width = width;
        } else {
            throw new IllegalArgumentException("Width cannot be zero or negative");
        }
    }

    public void setHeight(double height) {

        if (height > 0) {
            this.height = height;
        } else {
            throw new IllegalArgumentException("Height cannot be zero or negative");
        }
    }

    public double calculateSurfaceArea() {
        //2lw + 2lh + 2wh
        return 2 * this.length * this.width + 2 * this.length * this.height +
                2 * this.width * this.height;
    }

    public double calculateLateralSurfaceArea() {
        // 2lh + 2wh
        return 2 * this.length * this.height + 2 * this.width * this.height;
    }

    public double calculateVolume() {
        // lwh
        return this.length * this.width * this.height;
    }
}
