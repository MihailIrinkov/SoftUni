package factoryExercise;

public class Main {
    public static void main(String[] args) {

        Cake cake = CakeFactory.createCake("WhiteCake",
                12, 12, 12);
        System.out.println(cake.getClass().getSimpleName());

    }
}
