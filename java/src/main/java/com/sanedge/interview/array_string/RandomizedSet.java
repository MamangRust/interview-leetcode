package com.sanedge.interview.array_string;

import java.util.*;

public class RandomizedSet {

    private List<Integer> values;
    private Map<Integer, Integer> indicies;
    private Random rand;

    public RandomizedSet() {
        values = new ArrayList<>();
        indicies = new HashMap<>();
        rand = new Random();
    }

    public boolean insert(int val) {
        if (indicies.containsKey(val)) {
            return false;
        }

        values.add(val);
        indicies.put(val, values.size() - 1);
        return true;
    }

    public boolean remove(int val) {
        if (!indicies.containsKey(val)) {
            return false;
        }

        int index = indicies.get(val);
        int lastVal = values.get(values.size() - 1);

        values.set(index, lastVal);
        indicies.put(lastVal, index);

        values.remove(values.size() - 1);
        indicies.remove(val);

        return true;
    }

    public int getRandom() {
        return values.get(rand.nextInt(values.size()));
    }
}
