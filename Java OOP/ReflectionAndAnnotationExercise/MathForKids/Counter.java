package MathForKids;

import java.util.ArrayList;
import java.util.List;

public class Counter {
    private int count;
    private List<Integer> counter;

    public Counter(int count, List<Integer> counter) {
        this.count = count;
        this.counter = new ArrayList<>();
    }

    public void setCount(int count) {
        this.count = count;
        counter.add(count);
    }

    //System.out.println("Решени задачи " + counter1);
    public Counter(int count) {
        this.count = count;
    }
    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();

        sb.append(counter.size());

        return sb.toString();
    }

}
