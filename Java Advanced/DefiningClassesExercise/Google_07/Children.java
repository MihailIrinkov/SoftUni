package Google_07;

public class Children {
    private String childName;
    private String childBirthday;

    public Children(String childName, String childBirthday) {
        this.childName = childName;
        this.childBirthday = childBirthday;
    }
    @Override
    public String toString(){
        return childName + " " + childBirthday;
    }
}
