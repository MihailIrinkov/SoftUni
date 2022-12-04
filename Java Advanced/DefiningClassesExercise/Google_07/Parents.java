package Google_07;

public class Parents {
    private String name;
    private String parentBirthday;

    public Parents(String name, String parentBirthday) {
        this.name = name;
        this.parentBirthday = parentBirthday;
    }

    @Override
    public String toString() {
        return name + " " + parentBirthday;
    }
}
