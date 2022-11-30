package CompanyRoster_02;

public class Employee {
    private String name;
    private double salary;
    private String position;
    private String department;
    private String email;
    private int age;

    public Employee(String name, double salary, String position, String department){
        this.name = name;
        this.salary = salary;
        this.position = position;
        this.department = department;
    }
   public Employee(String name, double salary, String position, String department, String email, int age){
        this.email = email;
        this.age = age;
        this.name = name;
        this.salary = salary;
        this.position = position;
        this.department = department;
    }
    public void setName(){
        this.name = name;
    }
    public void setSalary(){
        this.salary = salary;
    }
    public void setPosition(){
        this.position = position;
    }
    public void setDepartment(){
        this.department = department;
    }
    public void setEmail(){
        this.email = email;
    }
    public void setAge(){
        this.age = age;
    }
    public String getName(){
       return this.name = name;
    }

    public double getSalary() {
        return this.salary;
    }
    public String getPosition(){
        return this.position;
    }
    public String getDepartment(){
        return this.department;
    }
    public String getEmail(){
        return this.email;
    }

    public int getAge() {
        return this.age;
    }
}
