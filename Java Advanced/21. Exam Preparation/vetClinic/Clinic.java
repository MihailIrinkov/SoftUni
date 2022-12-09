package vetClinic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Clinic {
    private int capacity;
    private List<Pet> data;


    public Clinic (int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
//        this.data = data;
    }



    public void add(Pet pet) {
        if (data.size() < capacity) {
            data.add(pet);
        }
    }

    public boolean remove(String name) {
        return data.removeIf(e -> e.getName().equals(name));
    }

    public Pet getPet(String name, String owner) {
//        for (Pet pet: data) {
//            if (pet.getName().equals(name) && pet.getOwner().equals(owner)) {
//                return pet;
//            }
//        }
//        return null;
        return data.stream()
                .filter(e -> e.getName().equals(name) && e.getOwner().equals(owner))
                .findAny()
                .orElse(null);
    }

    public Pet getOldestPet() {
//        int max = Integer.MIN_VALUE;
//        for (Pet p : data) {
//            if (p.getAge() > max) {
//                max = p.getAge();
//            }
//        }
//
//        Pet searched = null;
//        for (Pet p : data) {
//            if (p.getAge() == max) {
//                searched = p;
//            }
//        }
//        return searched;
        return Collections.max(data, (f, s) -> Integer.compare(f.getAge(), s.getAge()));
    }

    public int getCount() {
        return data.size();
    }

    public String getStatistics() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("The clinic has the following patients:");
        for (Pet pet : data) {
            stringBuilder.append("\n");
            stringBuilder.append(pet.getName() + " " + pet.getOwner());
        }
        return stringBuilder.toString();
    }
}
