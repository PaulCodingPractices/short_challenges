package org.example;

import java.util.*;
/**
 * Compares and updates the inventory stored in a 2D array against a second 2D array of a fresh delivery.
 * Updates the current existing inventory item quantities (in arr1). If an item cannot be found, add the new
 * item and quantity into the inventory array. The returned inventory array should be in alphabetical order by item.
 *
 * @param arr1 the 2D array representing the current inventory
 * @param arr2 the 2D array representing the fresh delivery
 * @return a new 2D array representing the updated inventory
 */

public class UpdatingInventory {
    public static String[][] updateInventory(String[][] arr1, String[][] arr2) {
        // Convert the 2D arrays to HashMaps for easier comparison and updating
        HashMap<String, Integer> map1 = convertToMap(arr1);
        HashMap<String, Integer> map2 = convertToMap(arr2);

        // Loop through the second HashMap and update the first HashMap
        for (Map.Entry<String, Integer> entry : map2.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();

            if (map1.containsKey(key)) {
                map1.put(key, map1.get(key) + value);
            } else {
                map1.put(key, value);
            }
        }

        // Convert the updated HashMap back to a 2D array and sort it alphabetically
        String[][] result = convertToArray(map1);
        Arrays.sort(result, (a, b) -> a[0].compareTo(b[0]));

        return result;
    }

    /**
     * Converts a 2D array to a HashMap, where the keys are the item names (i.e. the second element in each row)
     * and the values are the quantities (i.e. the first element in each row).
     *
     * @param arr the 2D array to be converted to a HashMap
     * @return a new HashMap representing the same data as the 2D array
     */
    private static HashMap<String, Integer> convertToMap(String[][] arr) {
        HashMap<String, Integer> map = new HashMap<>();

        for (String[] item : arr) {
            String key = item[1];
            Integer value = Integer.parseInt(item[0]);

            map.put(key, value);
        }

        return map;
    }

    private static String[][] convertToArray(HashMap<String, Integer> map) {
        String[][] arr = new String[map.size()][2];

        int i = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();

            arr[i][0] = value.toString();
            arr[i][1] = key;
            i++;
        }

        return arr;
    }
    public static void main(String[] args) {
        // Example inventory
        String[][] arr1 = {
                {"10", "apple"},
                {"5", "banana"},
                {"20", "pear"}
        };

        // Example fresh delivery
        String[][] arr2 = {
                {"5", "apple"},
                {"10", "banana"},
                {"15", "grape"}
        };

        // Update the inventory with the fresh delivery
        String[][] updatedInventory = updateInventory(arr1, arr2);

        // Print the updated inventory
        for (String[] item : updatedInventory) {
            System.out.println(item[0] + " " + item[1]);
        }
    }
}
