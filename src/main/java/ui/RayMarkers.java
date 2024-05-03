package main.java.ui;

import processing.core.PApplet;

import java.awt.*;
import java.util.Objects;

import static main.java.setter.Rays.rayPositions;
import static main.java.utilities.Text.drawText;
import static main.java.utilities.Text.drawSquare;

public class RayMarkers {
    // ACCESS TO PApplet TO USE PROCESSING FEATURES
    static PApplet parent;

    public RayMarkers(PApplet parent) {
        RayMarkers.parent = parent;
    }

    // Variables for colours
    private static final int[] red = {255, 0, 0};
    private static final int[] purple = {138, 43, 226};
    private static final int[] blue = {0, 0, 255};

    /**
     * Draws a marker on a given position with a specific colour
     * The colour is defined by an RGB array and position is determined by an int
     *
     * @param rgb An array of ints representing red, green, and blue shades of the colour
     * @param position An int representing the position where the marker is drawn
     */
    private static void drawMarker(int[] rgb, int position) {
        // Getting colours from array
        int r = rgb[0];
        int g = rgb[1];
        int b = rgb[2];
        parent.noStroke();
        parent.fill(r, g, b);

        // VARIABLES for position
        int x;
        int y;

        // VARIABLES for indexes of marker co-ordinates
        int firstIndex = FixedCoords.numberPositions[position][0];
        int secondIndex = FixedCoords.numberPositions[position][1];

        // CONSTANTS for x CO-ORDS
        int topLeftX = firstIndex - 19;
        int bottomLeftX = firstIndex - 22;
        int topBottomX = firstIndex - 5;
        int bottomRightX = firstIndex + 12;
        int topRightX = firstIndex + 13;

        // CONSTANTS for y CO-ORDS
        int leftY = secondIndex - 5;
        int bottomY = secondIndex + 12;
        int rightY = secondIndex - 4;
        int topY = secondIndex - 20;

        // Calculating Locations
        if (position >= 0 && position <= 8) { // top left
            x = topLeftX;
            y = leftY;
            drawSquare(x, y);
        } else if (position >= 9 && position <= 18) { // bottom left
            x = bottomLeftX;
            y = leftY;
            drawSquare(x, y);
        } else if (position >= 19 && position <= 27) { // bottom
            x = topBottomX;
            y = bottomY;
            drawSquare(x, y);
        } else if (position >= 28 && position <= 35) { // bottom right
            x = bottomRightX;
            y = rightY;
            drawSquare(x, y);
        } else if (position >= 36 && position <= 45) { // top right
            x = topRightX;
            y = rightY;
            drawSquare(x, y);
        } else if (position >= 46 && position <= 53) { // top
            x = topBottomX;
            y = topY;
            drawSquare(x, y);
        }
    }

    // METHODS TO DRAW DIFFERENT MARKERS
    // Absorbed => RED
    private static void drawAbsorbed(int index) {
        drawMarker(red, index);
    }

    // Reflected 180 => PURPLE
    private static void drawReflected180(int index) {
        drawMarker(purple, index);
    }

    // Deflected => BLUE, Different Numbering
    private static void drawDeflected(int index, int endIndex, int numDeflectedRays) {
        // Start Marker
        drawMarker(blue, index);
        drawDeflectedNum(index, numDeflectedRays);
        // End Marker
        drawMarker(blue, endIndex);
        drawDeflectedNum(endIndex, numDeflectedRays);
    }

    // Method for positioning of deflected ray numbering
    private static void drawDeflectedNum(int position, int num) {
        // VARIABLES for position
        int x;
        int y;

        // VARIABLES for indexes of marker co-ordinates
        int firstIndex = FixedCoords.numberPositions[position][0];
        int secondIndex = FixedCoords.numberPositions[position][1];

        // CONSTANTS for x CO-ORDS
        int topLeftX = firstIndex - 19;
        int bottomLeftX = firstIndex - 22;
        int topBottomX = firstIndex - 5;
        int bottomRightX = firstIndex + 12;
        int topRightX = firstIndex + 13;

        // CONSTANTS for y CO-ORDS
        int leftY = secondIndex + 4;
        int bottomY = secondIndex + 21;
        int rightY = secondIndex + 5;
        int topY = secondIndex - 11;

        // CALCULATING LOCATIONS
        if (position >= 0 && position <= 8) { // top left
            x = topLeftX;
            y = leftY;
            drawNumber(x, y, num);
        } else if (position >= 9 && position <= 18) { // bottom left
            x = bottomLeftX;
            y = leftY;
            drawNumber(x, y, num);
        } else if (position >= 19 && position <= 27) { // bottom
            x = topBottomX;
            y = bottomY;
            drawNumber(x, y, num);
        } else if (position >= 28 && position <= 35) { // bottom right
            x = bottomRightX;
            y = rightY;
            drawNumber(x, y, num);
        } else if (position >= 36 && position <= 45) { // top right
            x = topRightX;
            y = rightY;
            drawNumber(x, y, num);
        } else if (position >= 46 && position <= 53) { // top
            x = topBottomX;
            y = topY;
            drawNumber(x, y, num);
        }
    }

    // Method for drawing number
    private static void drawNumber(int x, int y, int num) {
        drawText(16, Integer.toString(num), x, y);
    }

    // METHODS FOR FIGURING OUT WHICH RAY MARKER TO DRAW + SCORING
    public static int markerScore = 0;

    /**
     * This method is used to draw markers for rays based on their exit coordinates
     * - Direct Hit: -1, -1
     * - Reflected: -2, -2
     * - Deflected: Coordinates
     * It also calculates the score and marker based on the condition of the rays
     *
     * @param numOfRays The number of rays to be processed
     * @param shots An array of ints representing the start indices of the rays
     * @param rayExitCoordinates An array of Points
     *                           representing the exit coords of the rays
     */
    public static void drawRayMarkers(int numOfRays, int[] shots, Point[] rayExitCoordinates) {
        // Initial counts reset to 0
        int numDeflectedRays = 0;
        int score = 0;

        for (int i = 0; i < numOfRays; i++) {
            int startIndex = shots[i] - 1;
            // Extracting first two elements for Math.round to compare float with int
            Point exitCoords = rayExitCoordinates[i];
            // Calculating type of ray
            if (Objects.equals(exitCoords, new Point(-1, -1))) {
                score++;
                RayMarkers.drawAbsorbed(startIndex); // DIRECT HIT
            } else if (Objects.equals(exitCoords, new Point(-2, -2))) {
                score++;
                RayMarkers.drawReflected180(startIndex); // REFLECTED
            } else {
                score += 2;
                numDeflectedRays++;
                int endIndex = findEndIndex(exitCoords, rayPositions);
                RayMarkers.drawDeflected(startIndex, endIndex, numDeflectedRays); // DEFLECTED
            }
        }
        markerScore = score;
    }

    /**
     * This helper method find the index of a point in the rayPositions
     * array that is within a certain range of the exitCoords point.
     * The range is defined as a difference of less than or equal to 3
     *
     * @param exitCoords
     * @param rayPositions
     * @return The index of the matching point in the rayPositions array.
     *         If no matching point is found, it defaults to 0.
     */
    private static int findEndIndex(Point exitCoords, int[][] rayPositions) {
        // Loop through ray coordinates
        for (int j = 0; j < rayPositions.length; j++) {
            int[] positionCoords = {rayPositions[j][0], rayPositions[j][1]};
            // Check if the difference between coordinates is within the specified range
            if (Math.abs(exitCoords.x - positionCoords[0]) <= 3 &&
                    Math.abs(exitCoords.y - positionCoords[1]) <= 3) {
                return j;
            }
        }
        return 0; // Default to 0 if no matching index is found
    }

    // METHODS FOR RAY MARKER KEY
    public static void drawRayMarkerKey(int x, int y) {
        parent.stroke(255, 255, 255);
        parent.fill(0);
        // Draw the rectangle
        parent.rect(x, y, 250, 215, 12, 12, 12, 12);
        // Text
        drawDetails();
    }

    private static void drawDetails() {
        // Title
        drawText(20, "Ray Markers Key", 807, 80);
        // Key
        drawKey(red, 775, 105);
        drawText(17, "Ray Absorbed", 800, 115);
        drawKey(purple, 775, 140);
        drawText(17, "Ray Reflected 180 °", 800, 150);
        drawKey(blue, 775, 175);
        drawText(17, "Ray Deflected or", 800, 185);
        drawText(17, "No Atom Found", 800, 205);
        drawText(15, "(Changes number for each set", 800, 230);
        drawText(15, "of deflected ray start and end)", 800, 250);
    }

    private static void drawKey(int[] rgb, int x, int y) {
        int r = rgb[0];
        int g = rgb[1];
        int b = rgb[2];
        // Drawing Key
        parent.noStroke();
        parent.fill(r, g, b);
        parent.rect(x, y, 10, 10);
    }
}
