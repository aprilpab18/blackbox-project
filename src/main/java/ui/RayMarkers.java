package main.java.ui;
import processing.core.PApplet;


public class RayMarkers {
    // ACCESS TO PApplet TO USE PROCESSING FEATURES
    static PApplet parent;

    // CONSTRUCTOR
    public RayMarkers(PApplet parent) {
        this.parent = parent;
    }

    // Method for logic to draw marker
    private static void drawMarker(int r, int g, int b, int position){
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

    // No Atom => RED, DONE!
//    public static void drawNoAtom(int index) {
//        // User Inputted Marker
//        drawMarker(255, 0, 0, index);

//        // FIND OPPOSITE MARKER
//        int length = MarkerCoords.straightOppMarkers.length;
//        int coord = index + 1; // actual ray co-ord as on grid
//
//        for (int i = 0; i < length; i++) {
//            if (MarkerCoords.straightOppMarkers[i][0] == coord) { // first column
//                drawMarker(255, 0, 0, MarkerCoords.straightOppMarkers[i][1] - 1);
//            } else if (MarkerCoords.straightOppMarkers[i][1] == coord) {  // second column
//                drawMarker(255, 0, 0, MarkerCoords.straightOppMarkers[i][0] - 1);
//            }
//        }
//    }

    // Absorbed => GREEN, one co-ord, DONE!
    public static void drawAbsorbed(int index){
        drawMarker(255,0,0, index);
    }


    // Deflected => Different Colours
    public static void drawDeflected(int index){
        drawMarker(0,0,255, index);

        // TODO
        // Find exit coordinate
    }

    // Reflected 180 => PURPLE, DONE
    public void drawDeflected180(int index){
        drawMarker(138,43,226, index);
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
        drawText(15, "(Changes colour for each set", 800, 230);
        drawText(15, "of deflected ray start and end)", 800, 250);


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
