package groomingSalon;

import java.util.ArrayList;
import java.util.List;

public class GroomingSalon {
    private List<Pet> data;
    private int capacity;

    public GroomingSalon(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public List<Pet> getData() {
        return data;
    }

    public void setData(List<Pet> data) {
        this.data = data;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void add(Pet pet) {
        if (data.size() < capacity) {
            data.add(pet);
        }
    }

    public boolean remove(String name) {

        for (Pet p : data) {
            if (p.getName().equals(name)) {
                return data.remove(p);

            }
        }
        return false;

    }

//    public boolean remove(String name) {
//        boolean isRemoved = false;
//        for (Pet p : data) {
//            if (p.getName().equals(name)) {
//                data.remove(p);
//                isRemoved = true;
//            }
//        }
//        return isRemoved;
//    }

    public Pet getPet(String name, String owner) {
        //String searchedName = null;

        for (Pet p: data) {
            if (p.getName().equals(name) && p.getOwner().equals(owner)) {
//                searchedName = p.getName();
                return p;
            }
        }

        return null;
    }

    public int getCount() {
        return  data.size();
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append("The grooming salon has the following clients:");

        for (Pet p : data) {
            sb.append("\n");
            sb.append(p.getName() + " " + p.getOwner());
        }
        return sb.toString();
    }

}
