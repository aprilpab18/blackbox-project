package main.java.setter;

import java.util.Random;

import processing.core.PApplet;

public class Computer {

    public int[] generateAtoms(int numOfAtoms) {
        int[] atomNumbers = new int[numOfAtoms];

        for (int i = 0; i < numOfAtoms; i++) {
            Random random = new Random();
            atomNumbers[i] = random.nextInt(60);

//            while (!checkIfUnique(atomNumbers, i)) {        // Check if number already in array
//                println("CHANGE " + atomNumbers.toString());
//                atomNumbers[i] = random.nextInt(60);
//            }

        }

        return atomNumbers;
    }




}
