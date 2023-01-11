package ListyIterator_01;

import java.util.Iterator;
import java.util.List;

public class ListyIterator implements Iterable<ListyIterator>{
    private List<String> data;
    private int index;

    public ListyIterator (List<String> data) {
        this.data = data;

        int index = 0;
        if (this.data.isEmpty()) {
            this.index = -1;
        } else {
            this.index = 0;
        }
    }

    public boolean move () {
        if (this.index < this.data.size() - 1) {
            this.index++;
            return true;
        }
        return false;
    }

    public boolean hasNext() {
        if (this.index < this.data.size() - 1) {
            return true;
        }
        return false;
    }

    public void print () {
        if (this.data.isEmpty()) {
            System.out.println("Invalid Operation!");
        } else {
            System.out.println(this.data.get(index));
        }
    }



    @Override
    public Iterator<ListyIterator> iterator() {
        return null;
    }
}
