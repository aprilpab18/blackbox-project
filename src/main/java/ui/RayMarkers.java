package main.java.ui;
import processing.core.PApplet;


public class RayMarkers {
    // INSTANCE VARIABLES
    PApplet parent;

    // CONSTANTS
    private final int OPPOSITE_RAY = 27;

    // Co-ords of Grid
    int[][] numberPositions = {
            {211, 66}, // 1
            {191, 97}, // 2
            {180, 114}, // 3
            {160, 147}, // 4
            {150, 162}, // 5
            {130, 200}, // 6
            {121, 215}, // 7
            {100, 249}, // 8
            {90, 265}, // 9
            {70, 300}, // 10
            {86, 333}, // 11
            {95, 349}, // 12
            {115, 383}, // 13
            {127, 401}, // 14
            {145, 433}, // 15
            {156, 449}, // 16
            {177, 485}, // 17
            {187, 501}, // 18
            {205, 533}, // 19
            {249, 535}, // 20
            {271, 535}, // 21
            {310, 535}, // 22
            {331, 535}, // 23
            {370, 535}, // 24
            {390, 535}, // 25
            {430, 535}, // 26
            {451, 535}, // 27
            {491, 535}, // 28
            {514, 502}, // 29
            {524, 485}, // 30
            {545, 449}, // 31
            {556, 434}, // 32
            {574, 400}, // 33
            {585, 383}, // 34
            {604, 349}, // 35
            {614, 333}, // 36
            {635, 300}, // 37
            {614, 264}, // 38
            {605, 248}, // 39
            {585, 215}, // 40
            {575, 198}, // 41
            {555, 167}, // 42
            {545, 148}, // 43
            {522, 115}, // 44
            {514, 97}, // 45
            {493, 67}, // 46
            {451, 63}, // 47
            {430, 63}, // 48
            {390, 63}, // 49
            {370, 63}, // 50
            {331, 63}, // 51
            {310, 63}, // 52
            {271, 63}, // 53
            {249, 63} // 54
    };

    // CONSTRUCTOR
    public RayMarkers(PApplet parent) {
        this.parent = parent;
    }

    // Method to draw marker
    private void drawMarker(int r, int g, int b, int position){
        parent.noStroke();
        parent.fill(r, g, b);

        // VARIABLES for position
        int x;
        int y;
        int firstIndex = numberPositions[position][0];
        int secondIndex = numberPositions[position][1];

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

    // No Atom => RED
    public void drawNoAtom(int input){
        drawMarker(255,0,0, input);
        drawMarker(255,0,0, input + OPPOSITE_RAY);
    }

    // Absorbed => GREEN, one co-ord
    public void drawAbsorbed(int input){
        drawMarker(0,255,0, input);
    }
//
//
//    // Deflected 60 => BLUE
//    public void drawDeflected60(){
//
//    }
//
//    // Deflected 120 => PINK
//    public void drawDeflected120(){
//
//    }
//
//    // Deflected 180 => PURPLE, one co-ord
//    public void drawDeflected180(){
//
//    }
}
