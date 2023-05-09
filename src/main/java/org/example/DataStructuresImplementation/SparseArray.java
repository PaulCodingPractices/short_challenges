package org.example.DataStructuresImplementation;
import java.util.HashMap;

public class SparseArray {
    private HashMap<Integer, Integer> values;
    private int defaultValue;

    public SparseArray() {
        this(0);
    }

    public SparseArray(int defaultValue) {
        values = new HashMap<>();
        this.defaultValue = defaultValue;
    }

    public int get(int index) {
        if (values.containsKey(index)) {
            return values.get(index);
        }
        return defaultValue;
    }

    public void set(int index, int value) {
        if (value == defaultValue) {
            values.remove(index);
        } else {
            values.put(index, value);
        }
    }

    public static void main(String[] args) {
        SparseArray sparseArray = new SparseArray(0);
        sparseArray.set(0, 1);
        sparseArray.set(2, 3);
        sparseArray.set(1000000, 5);

        System.out.println(sparseArray.get(0)); // Output: 1
        System.out.println(sparseArray.get(1)); // Output: 0
        System.out.println(sparseArray.get(2)); // Output: 3
        System.out.println(sparseArray.get(1000000)); // Output: 5
    }
}