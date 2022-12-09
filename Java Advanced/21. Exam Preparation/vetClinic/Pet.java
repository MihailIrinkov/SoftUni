package vetClinic;

public class Pet {
    private String name;
    private int age;
    private String owner;

   public Pet(String name, int age, String owner){
        this.name = name;
        this.age = age;
        this.owner = owner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
    @Override
    public String toString(){
//       StringBuilder stringBuilder = new StringBuilder();
//       stringBuilder.append(name);
//       stringBuilder.append(" ");
//       stringBuilder.append(age);
//       stringBuilder.append(" ");
//       stringBuilder.append(owner);
//       return stringBuilder.toString();
        return String.format("%s %d (%s)", getName(), getAge(), getOwner());
    }
}
