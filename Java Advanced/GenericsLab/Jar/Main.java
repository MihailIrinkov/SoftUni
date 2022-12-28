package Jar;

public class Main {
    public static void main(String[] args) {
        Jar jar = new Jar<>();
        jar.add(1);
        jar.add("a");
        jar.add(2);

       // Jar<Integer> jar1 = new Jar<Integer>();

        System.out.println(jar.remove());
        System.out.println(jar.remove());
    }
}
