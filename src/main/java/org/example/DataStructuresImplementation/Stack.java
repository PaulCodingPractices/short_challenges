package org.example.DataStructuresImplementation;

import java.util.ArrayList;
import java.util.EmptyStackException;

/**
 * A generic stack implementation using an ArrayList to store items.
 * @param <T> the type of items in the stack
 */
public class Stack<T> {
    private ArrayList<T> items;

    /**
     * Constructs an empty stack.
     */
    public Stack() {
        this.items = new ArrayList<T>();
    }

    /**
     * Adds an item to the top of the stack.
     * @param item the item to add
     */
    public void push(T item) {
        this.items.add(item);
    }

    /**
     * Removes and returns the item at the top of the stack.
     * @return the item at the top of the stack
     * @throws EmptyStackException if the stack is empty
     */
    public T pop() {
        if (this.isEmpty()) {
            throw new EmptyStackException();
        }
        return this.items.remove(this.items.size() - 1);
    }

    /**
     * Returns the item at the top of the stack without removing it.
     * @return the item at the top of the stack
     * @throws EmptyStackException if the stack is empty
     */
    public T peek() {
        if (this.isEmpty()) {
            throw new EmptyStackException();
        }
        return this.items.get(this.items.size() - 1);
    }

    /**
     * Returns whether the stack is empty.
     * @return true if the stack is empty, false otherwise
     */
    public boolean isEmpty() {
        return this.items.isEmpty();
    }

    /**
     * Returns the number of items in the stack.
     * @return the number of items in the stack
     */
    public int size() {
        return this.items.size();
    }

    /**
     * Removes all items from the stack.
     */
    public void clear() {
        this.items.clear();
    }

    /**
     * Prints the contents of the stack to the console.
     */
    public void print() {
        System.out.print("[");
        for (int i = this.items.size() - 1; i >= 0; i--) {
            System.out.print(this.items.get(i));
            if (i > 0) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}