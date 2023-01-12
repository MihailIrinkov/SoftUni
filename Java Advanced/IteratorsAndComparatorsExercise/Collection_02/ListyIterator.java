package Collection_02;

import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class ListyIterator implements Iterator<ListyIterator>{

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

        public void printAll() {
            for (String s : data) {
                System.out.print(s + " ");
            }
            System.out.println();
        }

        public boolean hasNext() {
            if (this.index < this.data.size() - 1) {
                return true;
            }
            return false;
        }

    @Override
    public ListyIterator next() {
        return null;
    }

    @Override
    public void remove() {
        Iterator.super.remove();
    }

    @Override
    public void forEachRemaining(Consumer<? super ListyIterator> action) {
        Iterator.super.forEachRemaining(action);
    }

    public void print () {
            if (this.data.isEmpty()) {
                System.out.println("Invalid Operation!");
            } else {
                System.out.println(this.data.get(index));
            }
        }


}

