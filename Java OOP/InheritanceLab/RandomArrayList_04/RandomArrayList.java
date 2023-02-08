package RandomArrayList_04;

import java.util.ArrayList;
import java.util.Random;

public class RandomArrayList extends ArrayList {

    public Object getRandomElement() {

        int index = new Random().nextInt(super.size());

//        return super.remove(index);


        Object element = super.get(index);
        super.remove(index);
        return element;
    }
}
