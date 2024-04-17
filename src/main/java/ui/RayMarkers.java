package main.java.ui;
import processing.core.PApplet;
import java.util.Arrays;
import static main.java.setter.Rays.rayPositions;
import static main.java.utilities.Text.drawText;
import static main.java.utilities.Text.drawSquare;

public class RayMarkers {
    // ACCESS TO PApplet TO USE PROCESSING FEATURES
    static PApplet parent;

    // CONSTRUCTOR
    public RayMarkers(PApplet parent) {
        RayMarkers.parent = parent;
    }

    // Variables for colours
    private static final int[] red = {255, 0, 0};
    private static final int[] purple = {138, 43, 226};
    private static final int[] blue = {0, 0, 255};

    // Method for logic to draw marker
    private static void drawMarker(int[] rgb, int position){
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
        int firstIndex = MarkerCoords.numberPositions[position][0];
        int secondIndex = MarkerCoords.numberPositions[position][1];

        // CONSTANTS for x CO-ORDS
        int topLeftX = firstIndex - 19;
        int bottomLeftX = firstIndex - 22;
        int topBottomX =  firstIndex - 5;
        int bottomRightX = firstIndex + 12;
        int topRightX = firstIndex + 13;

        // CONSTANTS for y CO-ORDS
        int leftY = secondIndex - 5;
        int bottomY =  secondIndex + 12;
        int rightY = secondIndex - 4;
        int topY =   secondIndex - 20;

        // CALCULATING LOCATIONS
        if (position >= 0 && position <= 8){ // top left
            x = topLeftX;
            y = leftY;
            // Draw marker
            drawSquare(x,y);
        } else if (position >= 9 && position <= 18) { // bottom left
            x = bottomLeftX;
            y = leftY;
            drawSquare(x,y);
        } else if (position >= 19 && position <= 27) { // bottom
            x = topBottomX;
            y = bottomY;
            drawSquare(x,y);
        } else if (position >= 28 && position <= 35) { // bottom right
            x = bottomRightX;
            y = rightY;
            drawSquare(x,y);
        } else if (position >= 36 && position <= 45) { // top right
            x = topRightX;
            y = rightY;
            drawSquare(x,y);
        }  else if (position >= 46 && position <= 53) { // top
            x = topBottomX;
            y = topY;
            drawSquare(x,y);
        }
    }

    // METHODS TO DRAW DIFFERENT MARKERS
    // Absorbed => RED
    private static void drawAbsorbed(int index){
        drawMarker(red, index);
    }

    // Reflected 180 => PURPLE
    private static void drawReflected180(int index){
        drawMarker(purple, index);
    }

    // Deflected => BLUE, Different Numbering
    private static void drawDeflected(int index, int endIndex, int numDeflectedRays){
        // Start Marker
        drawMarker(blue, index);
        drawDeflectedNum(index, numDeflectedRays);
        // End Marker
        drawMarker(blue, endIndex);
        drawDeflectedNum(endIndex, numDeflectedRays);
    }

    // Method for positioning of deflected ray numbering
    private static void drawDeflectedNum(int position, int num){
        // VARIABLES for position
        int x;
        int y;

        // VARIABLES for indexes of marker co-ordinates
        int firstIndex = MarkerCoords.numberPositions[position][0];
        int secondIndex = MarkerCoords.numberPositions[position][1];

        // CONSTANTS for x CO-ORDS
        int topLeftX = firstIndex - 19;
        int bottomLeftX = firstIndex - 22;
        int topBottomX =  firstIndex - 5;
        int bottomRightX = firstIndex + 12;
        int topRightX = firstIndex + 13;

        // CONSTANTS for y CO-ORDS
        int leftY = secondIndex + 4;
        int bottomY =  secondIndex + 21;
        int rightY = secondIndex + 5;
        int topY =   secondIndex - 11;

        // CALCULATING LOCATIONS
        if (position >= 0 && position <= 8){ // top left
            x = topLeftX;
            y = leftY;
            // Draw number
            drawNumber(x,y, num);
        } else if (position >= 9 && position <= 18) { // bottom left
            x = bottomLeftX;
            y = leftY;
            // Draw number
            drawNumber(x,y, num);
        } else if (position >= 19 && position <= 27) { // bottom
            x = topBottomX;
            y = bottomY;
            // Draw number
            drawNumber(x,y, num);
        } else if (position >= 28 && position <= 35) { // bottom right
            x = bottomRightX;
            y = rightY;
            // Draw number
            drawNumber(x,y, num);
        } else if (position >= 36 && position <= 45) { // top right
            x = topRightX;
            y = rightY;
            // Draw number
            drawNumber(x,y, num);
        }  else if (position >= 46 && position <= 53) { // top
            x = topBottomX;
            y = topY;
            // Draw number
            drawNumber(x,y, num);
        }
    }

    // Method for drawing number
    private static void drawNumber(int x, int y, int num) {
        drawText(16, Integer.toString(num), x, y);
    }

    // METHODS FOR FIGURING OUT WHICH RAY MARKER TO DRAW
    public static void drawRayMarkers(int numOfRays, int[] shots, float[][] rayExitCoordinates) {
        int numDeflectedRays = 0;

        for (int i = 0; i < numOfRays; i++) {
            int startIndex = shots[i] - 1;

            /* Ray Conditions
             * - DIRECT HIT: -1, -1
             * - REFLECTED: -2, -2
             * - DEFLECTED: Coordinates */

            // Extracting first two elements for Math.round to compare float with int
            float[] exitCoords = {rayExitCoordinates[i][0], rayExitCoordinates[i][1]};

            if (Arrays.equals(exitCoords, new float[]{-1, -1})) {
                RayMarkers.drawAbsorbed(startIndex); // DIRECT HIT
            } else if (Arrays.equals(exitCoords, new float[]{-2, -2})) {
                RayMarkers.drawReflected180(startIndex); // REFLECTED
            } else {
                numDeflectedRays++;
                int endIndex = findEndIndex(exitCoords, rayPositions, 3);
                RayMarkers.drawDeflected(startIndex, endIndex, numDeflectedRays); // DEFLECTED
            }
        }
    }

    // Helper method to compare exit coordinates within a range
    private static int findEndIndex(float[] exitCoords, int[][] rayPositions, int range) {

        // Loop through ray coordinates
        for (int j = 0; j < rayPositions.length; j++) {
            int[] positionCoords = {rayPositions[j][0], rayPositions[j][1]};
            // Check if the difference between coordinates is within the specified range
            if (Math.abs(exitCoords[0] - positionCoords[0]) <= range &&
                    Math.abs(exitCoords[1] - positionCoords[1]) <= range) {
                return j;
            }
        }
        return 0; // Default to 0 if no matching index is found
    }

    // METHODS FOR RAY MARKER KEY
    // Ray Marker Key
    public static void drawRayMarkerKey(int x, int y) {
        parent.stroke(255, 255, 255);
        parent.fill(0);

        // Draw the rectangle
        parent.rect(x, y, 250, 215, 12, 12, 12, 12);

        // Text
        drawDetails();
    }

    private static void drawDetails(){
        // Title
        drawText(20, "Ray Markers Key", 807, 80);

        // Key
        drawKey(255,0,0,775,105); // Red
        drawText(17,"Ray Absorbed", 800, 115);
        drawKey(138,43,226,775,140); // Green
        drawText(17, "Ray Reflected 180 °", 800, 150);
        drawKey(0,0,255,775,175); // Blue
        drawText(17,"Ray Deflected or", 800, 185);
        drawText(17,"No Atom Found", 800, 205);
        drawText(15, "(Changes number for each set", 800, 230);
        drawText(15, "of deflected ray start and end)", 800, 250);
    }

    public static void drawKey(int r, int g, int b, int x, int y) {
        parent.noStroke();
        parent.fill(r, g, b);
        parent.rect(x,y,10,10);
    }
}
