package main.java.ui;
import processing.core.PApplet;
import java.util.Random;
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
    public static int[] red = {255, 0, 0};
    public static int[] purple = {138, 43, 226};
    public static int[] blue = {0, 0, 255};

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
            // Draw marker
            drawSquare(x,y);
        } else if (position >= 19 && position <= 27) { // bottom
            x = topBottomX;
            y = bottomY;
            // Draw marker
            drawSquare(x,y);
        } else if (position >= 28 && position <= 35) { // bottom right
            x = bottomRightX;
            y = rightY;
            // Draw marker
            drawSquare(x,y);
        } else if (position >= 36 && position <= 45) { // top right
            x = topRightX;
            y = rightY;
            // Draw marker
            drawSquare(x,y);
        }  else if (position >= 46 && position <= 53) { // top
            x = topBottomX;
            y = topY;
            // Draw marker
            drawSquare(x,y);
        }
    }


    // METHODS TO DRAW DIFFERENT MARKERS

    // Absorbed => GREEN, one co-ord, DONE!
    public static void drawAbsorbed(int index){
        drawMarker(red, index);
    }


    // Deflected => Different Colours

    public static void drawDeflected(int index, int endIndex){

        // Start Marker
        drawMarker(blue, index);
        drawDeflectedNum(index);

        // End Marker
        drawMarker(blue, endIndex);
        drawDeflectedNum(endIndex);

    }

    // Method for matching numbers (UNDER CONSTRUCTION)
    private static void drawDeflectedNum(int position){

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
            drawNumber(x,y);


        } else if (position >= 9 && position <= 18) { // bottom left
            x = bottomLeftX;
            y = leftY;
            // Draw number
            drawNumber(x,y);

        } else if (position >= 19 && position <= 27) { // bottom
            x = topBottomX;
            y = bottomY;
            // Draw number
            drawNumber(x,y);

        } else if (position >= 28 && position <= 35) { // bottom right
            x = bottomRightX;
            y = rightY;
            // Draw number
            drawNumber(x,y);

        } else if (position >= 36 && position <= 45) { // top right
            x = topRightX;
            y = rightY;
            // Draw number
            drawNumber(x,y);

        }  else if (position >= 46 && position <= 53) { // top
            x = topBottomX;
            y = topY;
            // Draw number
            drawNumber(x,y);

        }
    }

    public static int[] deflectedNum = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27};

    public static void drawNumber(int x, int y) {
        drawText(16, Integer.toString(deflectedNum[0]), x, y);
    }


    // Reflected 180 => PURPLE, NOT DONE
    public static void drawReflected180(int index){
        drawMarker(purple, index);
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

    public static void drawDetails(){
        // Title
        drawText(20, "Ray Markers Key", 807, 80);

        // Key
        drawKey(255,0,0,775,105); // Red
        drawText(17,"Ray Absorbed", 800, 115);
        drawKey(138,43,226,775,140); // Green
        drawText(17, "Ray Reflected 180 \u00B0", 800, 150);
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
