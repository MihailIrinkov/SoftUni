package factoryExercise;

public class CakeFactory {
    public static Cake createCake(String type, double diameter, double price, int pieces) {
        Cake cake = null;
        switch (type) {
            case "WhiteCake":
                cake = new WhiteCake(diameter, price, pieces);
                break;
            case "SpinachCake":
                cake = new SpinachCake(diameter, price, pieces);
                break;
            case "ChocolateCake":
                cake = new ChocolateCake(diameter, price, pieces);
                break;
            case "BiscuitCake":
                cake = new BiscuitCake(diameter, price, pieces);
                break;
        }
        return cake;
    }
}
