package org.example;

import java.util.*;
/**
 * This program calculates the symmetric difference of two or more arrays.
 * The symmetric difference of two sets is the set of elements which are in either of the two sets but not in both.
 * The program prompts the user to input the number of arrays and the elements of each array.
 * It then calculates the symmetric difference of all the arrays and returns an array of unique values (no duplicates).
 * The program uses a HashSet to keep track of the unique values in the symmetric difference.
 */
public class SymmetricDifference {

        public static int[] symmetricDifference(int[]... arrays) {
            Set<Integer> result = new HashSet<>();
            for (int[] array : arrays) {
                for (int i : array) {
                    if (result.contains(i)) {
                        result.remove(i);
                    } else {
                        result.add(i);
                    }
                }
            }
            int[] resArray = new int[result.size()];
            int index = 0;
            for (int i : result) {
                resArray[index++] = i;
            }
            return resArray;
        }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the number of arrays: ");
        int n = input.nextInt();

        int[][] arrays = new int[n][];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter the number of elements in array " + (i+1) + ": ");
            int len = input.nextInt();
            arrays[i] = new int[len];
            System.out.print("Enter the elements of array " + (i+1) + ": ");
            for (int j = 0; j < len; j++) {
                arrays[i][j] = input.nextInt();
            }
        }

        int[] result = symmetricDifference(arrays);

        System.out.println(Arrays.toString(result));
    }

}
