package main.java.setter;

import java.util.Arrays;
import java.util.Random;

public class Computer {
    /**
     * Generates an array of unique random ints
     * and sorts them in ascending order
     *
     * @param numOfAtoms The number of atoms (random ints) to generate
     * @return Any array of sorted unique random ints
     */
    public int[] generateAtoms(int numOfAtoms) {
        int[] atomNumbers = new int[numOfAtoms];

        for (int i = 0; i < numOfAtoms; i++) {
            Random random = new Random();
            atomNumbers[i] = random.nextInt(60);
        }

        Arrays.sort(atomNumbers);

        return atomNumbers;
    }

    /**
     * Checks if all elements in the given array are unique
     *
     * @param array The array to check for uniqueness
     * @param length The length of the array
     * @return true if all elements are unique, false otherwise
     */
    public boolean checkIfUnique(int[] array, int length) {
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (array[i] == array[j]) {
                    return false;
                }
            }
        }
        return true;
    }

}
