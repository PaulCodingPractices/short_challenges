package org.example.DataStructuresImplementation;

public class HashMap {
    static class Entry {
        String key;
        int value;
        Entry next;

        public Entry(String key, int value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    static class BasicHashMap {
        private int size;
        private int capacity;
        private Entry[] table;

        public BasicHashMap(int capacity) {
            this.size = 0;
            this.capacity = capacity;
            this.table = new Entry[capacity];
        }

        private int hash(String key) {
            return Math.abs(key.hashCode()) % capacity;
        }

        public void put(String key, int value) {
            int index = hash(key);
            Entry newEntry = new Entry(key, value);
            if (table[index] == null) {
                table[index] = newEntry;
            } else {
                Entry current = table[index];
                while (current.next != null) {
                    if (current.key.equals(key)) {
                        current.value = value;
                        return;
                    }
                    current = current.next;
                }
                if (current.key.equals(key)) {
                    current.value = value;
                } else {
                    current.next = newEntry;
                    size++;
                }
            }
        }

        public int get(String key) {
            int index = hash(key);
            Entry current = table[index];
            while (current != null) {
                if (current.key.equals(key)) {
                    return current.value;
                }
                current = current.next;
            }
            return -1; // Key not found
        }

        public void remove(String key) {
            int index = hash(key);
            Entry current = table[index];
            Entry prev = null;
            while (current != null) {
                if (current.key.equals(key)) {
                    if (prev == null) {
                        table[index] = current.next;
                    } else {
                        prev.next = current.next;
                    }
                    size--;
                    return;
                }
                prev = current;
                current = current.next;
            }
        }
    }
    public static void main(String[] args) {
        BasicHashMap hashMap = new BasicHashMap(10);

        hashMap.put("one", 1);
        hashMap.put("two", 2);
        hashMap.put("three", 3);
        hashMap.put("four", 4);

        System.out.println("Value for 'one': " + hashMap.get("one")); // Output: Value for 'one': 1
        System.out.println("Value for 'three': " + hashMap.get("three")); // Output: Value for 'three': 3

        hashMap.remove("two");

        System.out.println("Value for 'two' after removal: " + hashMap.get("two")); // Output: Value for 'two' after removal: -1

        hashMap.put("four", 44);

        System.out.println("Value for 'four' after update: " + hashMap.get("four")); // Output: Value for 'four' after update: 44
    }
}
