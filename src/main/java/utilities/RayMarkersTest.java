package main.java.utilities;

import static main.java.ui.RayMarkers.findEndIndex;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.awt.Point;
import main.java.ui.RayMarkers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import processing.core.PApplet;

public class RayMarkersTest {
    // ACCESS TO PApplet TO USE PROCESSING FEATURES
    private PApplet parent;

    // Ensures that it's executed before each test method
    @BeforeEach
    public void setUp() {
        parent = new PApplet();
    }

    // Test for different ray scoring conditions
    @Test
    public void testMarkerScoring() {
        // VARIABLES
        int numOfRays = 3;
        Point[] rayExitCoordinates = {
                new Point(-1, -1),  // Direct Hit
                new Point(-2, -2),  // Reflected
                new Point(1, 1)     // Deflected
        };

        // Check the score
        int score = RayMarkers.calculateMarkerScore(numOfRays, rayExitCoordinates);
        assertEquals(4, score, "Incorrect Total Score.");
    }

    // Test for ensuring findEndIndex finds the exit coordinates
    // and returns the correct index (or 0)
    @Test
    public void testFindEndIndex() {
        // Define the ray positions
        int[][] rayPositions = {
                {2, 2},
                {4, 4},
                {6, 6},
                {8, 8}
        };

        // Matching a ray position exactly
        Point exitCoords1 = new Point(4, 4);
        int result1 = findEndIndex(exitCoords1, rayPositions);
        assertEquals(1, result1, "The index of the matching point " +
                "in the rayPositions array is incorrect.");

        // Within the specified range (returns index of closest point)
        Point exitCoords2 = new Point(7, 7);
        int result2 = findEndIndex(exitCoords2, rayPositions);
        assertEquals(2, result2, "The index of the matching point " +
                "in the rayPositions array is incorrect.");

        // No matching point found
        Point exitCoords3 = new Point(1000, 1000);
        int result3 = findEndIndex(exitCoords3, rayPositions);
        assertEquals(0, result3, "The index of the matching point " +
                "in the rayPositions array is incorrect.");
    }
}

