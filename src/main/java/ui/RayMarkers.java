package main.java.ui;
import processing.core.PApplet;

import java.util.Random;


public class RayMarkers {
    // ACCESS TO PApplet TO USE PROCESSING FEATURES
    static PApplet parent;

    // CONSTRUCTOR
    public RayMarkers(PApplet parent) {
        this.parent = parent;
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

        // CALCULATING LOCATIONS (for now)
        if (position >= 0 && position <= 8){ // top left
            x = topLeftX;
            y = leftY;
            // Draw marker
            parent.rect(x, y, 10, 10);

        } else if (position >= 9 && position <= 18) { // bottom left
            x = bottomLeftX;
            y = leftY;
            // Draw marker
            parent.rect(x, y, 10, 10);
        } else if (position >= 19 && position <= 27) { // bottom
            x = topBottomX;
            y = bottomY;
            // Draw marker
            parent.rect(x, y, 10, 10);
        } else if (position >= 28 && position <= 35) { // bottom right
            x = bottomRightX;
            y = rightY;
            // Draw marker
            parent.rect(x, y, 10, 10);
        } else if (position >= 36 && position <= 45) { // top right
            x = topRightX;
            y = rightY;
            // Draw marker
            parent.rect(x, y, 10, 10);
        }  else if (position >= 46 && position <= 53) { // top
            x = topBottomX;
            y = topY;
            // Draw marker
            parent.rect(x, y, 10, 10);
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

        // TODO
        // End Marker
        drawMarker(blue, endIndex - 1);

    }

    // Reflected 180 => PURPLE, NOT DONE
    public static void drawReflected180(int index){
        drawMarker(purple, index);
    }

    // Random Colour Generator (Under Construction)
    public static int[] generateRandomRGB() {
        Random rand = new Random();
        int[] rgb = new int[3];

        // Generate random values for R, G, and B components
        rgb[0] = rand.nextInt(256); // R component (0-255)
        rgb[1] = rand.nextInt(256); // G component (0-255)
        rgb[2] = rand.nextInt(256); // B component (0-255)

        return rgb;
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
//        drawText(15, "(Changes colour for each set", 800, 230);
//        drawText(15, "of deflected ray start and end)", 800, 250);
//        drawText(17,"Ray is within a", 800, 285);
//        drawText(17,"circle of influence", 800, 305);


    }

    public static void drawText(int size, String text, int x, int y){
        parent.fill(255);
        parent.textSize(size);
        parent.text(text, x, y);
    }

    public static void drawKey(int r, int g, int b, int x, int y) {
        parent.noStroke();
        parent.fill(r, g, b);
        parent.rect(x,y,10,10);
    }
}
