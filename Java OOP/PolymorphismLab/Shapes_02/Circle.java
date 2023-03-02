package Shapes_02;

public class Circle extends Shape {
    private Double radius;

    public Circle(Double radius) {
        this.radius = radius;
        super.setArea(calculateArea());
        super.setPerimeter(calculatePerimeter());
    }

    @Override
    protected Double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    protected Double calculateArea() {
        return Math.PI * radius * radius;
    }

    public final Double getRadius() {
        return radius;
    }

    public void setRadius(Double radius) {
        this.radius = radius;
    }
}
