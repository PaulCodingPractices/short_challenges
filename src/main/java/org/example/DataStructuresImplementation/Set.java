package org.example.DataStructuresImplementation;

import java.util.ArrayList;

/**
 * A generic Set implementation using an ArrayList to store items.
 * @param <T> the type of items in the set
 */
public class Set<T> {
    private ArrayList<T> items;

    /**
     * Constructs an empty set.
     */
    public Set() {
        this.items = new ArrayList<T>();
    }

    /**
     * Adds an item to the set if it is not already in the set.
     * @param item the item to add
     * @return true if the item was added, false if it was already in the set
     */
    public boolean add(T item) {
        if (!this.contains(item)) {
            this.items.add(item);
            return true;
        }
        return false;
    }

    /**
     * Removes an item from the set if it is in the set.
     * @param item the item to remove
     * @return true if the item was removed, false if it was not in the set
     */
    public boolean remove(T item) {
        if (this.contains(item)) {
            this.items.remove(item);
            return true;
        }
        return false;
    }

    /**
     * Returns whether the set contains an item.
     * @param item the item to check for
     * @return true if the set contains the item, false otherwise
     */
    public boolean contains(T item) {
        return this.items.contains(item);
    }

    /**
     * Returns whether the set is empty.
     * @return true if the set is empty, false otherwise
     */
    public boolean isEmpty() {
        return this.items.isEmpty();
    }

    /**
     * Returns the number of items in the set.
     * @return the number of items in the set
     */
    public int size() {
        return this.items.size();
    }

    /**
     * Removes all items from the set.
     */
    public void clear() {
        this.items.clear();
    }
    /**
     * Computes the union of this set and another set, and prints the result to the console.
     * @param otherSet the other set to compute the union with
     */
    public void union(Set<T> otherSet) {
        Set<T> unionSet = new Set<T>();
        for (T item : this.items) {
            unionSet.add(item);
        }
        for (T item : otherSet.items) {
            unionSet.add(item);
        }
        unionSet.print();
    }

    public Set<T> difference(Set<T> otherSet) {
        Set<T> differenceSet = new Set<T>();
        for (T item : this.items) {
            if (!otherSet.contains(item)) {
                differenceSet.add(item);
            }
        }
        return differenceSet;
    }






    /**
     * Prints the contents of the set to the console.
     */
    public void print() {
        System.out.print("[");
        for (int i = 0; i < this.items.size(); i++) {
            System.out.print(this.items.get(i));
            if (i < this.items.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}








