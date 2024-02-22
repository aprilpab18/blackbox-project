package main.java.ui;
import processing.core.PApplet;

public class StartMenu {

    // ACCESS TO PApplet TO USE PROCESSING FEATURES
    private PApplet parent;



    // VARIABLES FOR ATOMS + ANIMATION
    private float outerRadius = 65;    // Outer circle size
    private float innerRadius = 18;    // Until where outer stops
    private float angleStep = 0.01F;   // Speed of outer circle
    private boolean expanding = true;



    // VARIABLES FOR RAY
    float x = 0;      // Initial x-coordinate of the ray
    float speed = 1.2F;  // Speed of the ray



    // CONSTRUCTOR
    public StartMenu(PApplet parent) {
        this.parent = parent;
    }



    // METHODS
    public void displayStartScreen() {
        parent.background(0);

        // Draw Atoms (Inner Circle)
        drawAtom(100, 100);
        drawAtom(600, 600);

        // Draw Rays
        drawRay(250);
        drawRay(450);

        // TITLE
        drawTitle();

    }

    private void drawAtom(float x, float y) {
        // ATOM
        parent.fill(0, 150, 255);           // Blue
        parent.ellipse(x, y, 35, 35); // Drawing circle
        // with coordinates & size

        // CIRCLE OF INFLUENCE
        drawCircleInfluence(x,y);

    }

    private void drawCircleInfluence(float x, float y){
        float angleOffset = parent.radians(45); // Offset to start the outer ring from the top

        parent.noFill();            // Ensures circle of influence is an outline
        parent.stroke(255);     // White stroke color
        parent.strokeWeight(3);     // Font size

        // DRAWING OUTER CIRCLE using Geometry
        parent.beginShape();
        for (float a = angleOffset; a < angleOffset + parent.TWO_PI; a += angleStep) {
            float newX = x + parent.cos(a) * outerRadius;
            float newY = y + parent.sin(a) * outerRadius;
            parent.vertex(newX, newY);
        }
        parent.endShape(parent.CLOSE);

        // ANIMATION
        if (expanding) { // Expanding
            outerRadius += 1;
            if (outerRadius >= 65) { // Retracts when size met
                expanding = false;
            }
        } else { // Retracting
            outerRadius -= 1;
            if (outerRadius <= innerRadius) {  // Expands when size met
                expanding = true;
            }
        }
    }

    private void drawTitle(){
        String title = "Black Box +";
        float titleWidth = parent.textWidth(title) + 45; // used for centering

        parent.textSize(70);
        parent.fill(255);
        parent.text("Black Box", parent.width / 2 - titleWidth, parent.height / 2);

        parent.fill(255, 38, 125);
        parent.text("+", parent.width / 2 - titleWidth + parent.textWidth("Black Box "), parent.height / 2);

        // Description
        String description = "Press screen to start!";
        parent.textSize(25);
        parent.fill(255);
        parent.text(description, parent.width / 2 - parent.textWidth(description) / 2 - 5, parent.height / 2 + 40);
    }

    private void drawRay(float y) {

        // Draw ray dynamically
        parent.line(0, y, x, y);

        // Move the ray
        x += speed;

        // Change direction when the ray reaches the end
        if (x >= 700 || x < 0) {
            speed *= -1; // bounce back
        }

    }
}