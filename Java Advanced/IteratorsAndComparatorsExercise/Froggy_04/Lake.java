package Froggy_04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.stream.Collectors;

public class Lake implements Iterable<Integer> {
    private int[] stones;

    public Lake(int[] stones) {
        this.stones = stones;
    }

    @Override
    public String toString() {
        return String.join(", ", Arrays.stream(this.stones).boxed()
                .collect(Collectors.toCollection(ArrayList::new)).toString()
                .replaceAll("([\\[\\]])", ""));
    }


    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            private int index = 0;
            private int lastEvenIndex =
                    stones.length % 2 == 0 ? stones.length - 2 : stones.length - 1;

            @Override
            public boolean hasNext() {
                return this.index < stones.length || this.index % 2 == 0;
            }

            @Override
            public Integer next() {
                if (this.index == this.lastEvenIndex) {
                    int element = stones[this.index];
                    this.index = 1;
                    return element;
                }
                int element = stones[index];
                this.index += 2;
                return element;
            }

        };
    }

    public class Frog {
    }
}
