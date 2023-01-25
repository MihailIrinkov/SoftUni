package TrafficLights_04;

public class TrafficLight {
    private  Color color;

    public TrafficLight(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void changeColor () {

        switch (color) {
            case GREEN:
                this.color = Color.YELLOW;
                break;

            case RED:
                this.color = Color.GREEN;
                break;

            case YELLOW:
                this.color = Color.RED;
                break;
        }
    }
}
