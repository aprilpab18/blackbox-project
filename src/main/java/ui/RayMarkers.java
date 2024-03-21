package main.java.ui;
import processing.core.PApplet;


public class RayMarkers {
    // INSTANCE VARIABLES
    static PApplet parent;

    // CONSTRUCTOR
    public RayMarkers(PApplet parent) {
        this.parent = parent;
    }

    // Method to draw marker
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

        // CALCULATING LOCATIONS
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
    public static void drawNoAtom(int index) {
        // User Inputted Marker
        drawMarker(255, 0, 0, index);

        // FIND OPPOSITE MARKER
        int length = MarkerCoords.straightOppMarkers.length;
        int coord = index + 1; // actual ray co-ord as on grid

        for (int i = 0; i < length; i++) {
            if (MarkerCoords.straightOppMarkers[i][0] == coord) { // first column
                drawMarker(255, 0, 0, MarkerCoords.straightOppMarkers[i][1] - 1);
            } else if (MarkerCoords.straightOppMarkers[i][1] == coord) {  // second column
                drawMarker(255, 0, 0, MarkerCoords.straightOppMarkers[i][0] - 1);
            }
        }
    }

    // Absorbed => GREEN, one co-ord, DONE!
    public static void drawAbsorbed(int index){
        drawMarker(0,255,0, index);
    }


    // Deflected 60 => BLUE
    public static void drawDeflected60(int index){
        drawMarker(0,0,255, index);
        drawMarker(0,0,255, index);

        /* TODO
         * Implement opposite marker from calculations  */
    }

    // Deflected 120 => PINK
    public void drawDeflected120(int index){
        drawMarker(255,0,0, index);
        drawMarker(255,0,0, index);

        /* TODO
         * Implement opposite marker from calculations  */
    }

    // Deflected 180 => PURPLE, DONE
    public void drawDeflected180(int index){
        drawMarker(128,0,128, index);
        drawMarker(128,0,128, index);
    }

    // Ray Marker Key
    public void drawRayMarkerKey() {
        // TODO
    }
}
