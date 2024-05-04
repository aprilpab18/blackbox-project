package main.java.utilities;

import main.java.setter.Computer;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ComputerTest {
    Computer computer = new Computer();

    @Test
    public void testGenerateAtoms() {
        // Checks if length is correct
        int[] atoms = computer.generateAtoms(5);
        assertEquals(5, atoms.length);

        // Checks if array is sorted in ascending order
        for (int i = 0; i < atoms.length - 1; i++) {
            assertTrue(atoms[i] <= atoms[i + 1]);
        }
    }

    // Test to see if method correctly identifies unique and non-unique arrays
    @Test
    public void testCheckIfUnique() {
        int[] uniqueArray = {1, 2, 3, 4, 5};
        assertTrue(computer.checkIfUnique(uniqueArray, uniqueArray.length));

        int[] nonUniqueArray = {1, 2, 3, 3, 5};
        assertFalse(computer.checkIfUnique(nonUniqueArray, nonUniqueArray.length));
    }
}

