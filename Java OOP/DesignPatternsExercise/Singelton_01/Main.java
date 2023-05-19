package Singelton_01;

public class Main {
    public static void main(String[] args) {


        SingletonAccountManager instance = SingletonAccountManager.getInstance();
        System.out.println(instance.getName());
        System.out.println(instance.getPosition());
        SingletonAccountManager.getInstance().setName("Pe6o");

        instance.setPosition("Shef");
        System.out.println(instance.getName());
        System.out.println(instance.getPosition());
        instance.getData();

        instance.setPosition("Production Lead");
        instance.setName("Ivan Sotirov");
        System.out.println(instance.getName());
        System.out.println(instance.getPosition());

        instance.getData();
    }
}
