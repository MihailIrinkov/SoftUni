package Singelton_01;

public class SingletonAccountManager {
    private String name;
    private String department;
    private static SingletonAccountManager instance;

    private SingletonAccountManager() {
        this.name = "no name yet";
        this.department = "no department yet";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return department;
    }

    public void setPosition(String position) {
        this.department = position;
    }

    public static SingletonAccountManager getInstance() {
        if (instance == null) {
            instance = new SingletonAccountManager();
        }

        return instance;
    }

    public void getData(){
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "SingletonAccountManager{" +
                "name='" + name + '\'' +
                ", department='" + department + '\'' +
                '}';
    }
}
