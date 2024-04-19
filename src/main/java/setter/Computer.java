package main.java.setter;

import java.util.Arrays;
import java.util.Random;

//import processing.core.PApplet;

public class Computer {

    public int[] generateAtoms(int numOfAtoms) {
        int[] atomNumbers = new int[numOfAtoms];

        for (int i = 0; i < numOfAtoms; i++) {
            Random random = new Random();
            atomNumbers[i] = random.nextInt(60);
        }

        Arrays.sort(atomNumbers);

        return atomNumbers;
    }

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
