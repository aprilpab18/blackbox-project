package main.java.ui;

import processing.core.PApplet;

public class StartMenu {

    // ACCESS TO PApplet TO USE PROCESSING FEATURES
    private final PApplet parent;
    public InstructMenu instructMenu;
    private boolean startPressed = false;
    public boolean instructScreen = false;

    // VARIABLES FOR ATOMS + ANIMATION
    private float outerRadius = 65;    // Outer circle size
    private boolean expanding = true;

    // VARIABLES FOR RAY
    float x = 0;      // Initial x-coordinate of the ray
    float speed = 1.2F;  // Speed of the ray

    public StartMenu(PApplet parent) {
        this.parent = parent;
        this.instructMenu = new InstructMenu(parent, this);
    }

    // METHODS
    public void displayStartMenu() {
        parent.background(0);

        drawAtom(100, 100);
        drawAtom(1000, 600);

        drawRay(250);
        drawRay(450);

        drawTitle();

        drawStartButton(400, 375);
        drawInstructButton(530, 375);

        // Displaying Instructions Screen
        if (instructScreen) {
            instructMenu.displayInstructMenu();
        }

    }

    public void drawAtom(float x, float y) {
        // ATOM
        parent.fill(0, 150, 255);           // Blue
        parent.ellipse(x, y, 35, 35); // Drawing circle
        // with coordinates & size

        drawCircleInfluence(x, y);

    }

    private void drawCircleInfluence(float x, float y) {
        float angleOffset = PApplet.radians(45); // Offset to start the outer ring from the top

        parent.noFill();            // Ensures circle of influence is an outline
        parent.stroke(255);     // White stroke color
        parent.strokeWeight(3);     // Font size

        // DRAWING OUTER CIRCLE using Geometry
        parent.beginShape();
        // Speed of outer circle
        float angleStep = 0.01F;
        for (float a = angleOffset; a < angleOffset + parent.TWO_PI; a += angleStep) {
            float newX = x + PApplet.cos(a) * outerRadius;
            float newY = y + PApplet.sin(a) * outerRadius;
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
            // Until where outer stops
            float innerRadius = 18;
            if (outerRadius <= innerRadius) {  // Expands when size met
                expanding = true;
            }
        }
    }

    private void drawTitle() {
        String title = "Black Box +";
        float titleWidth = parent.textWidth(title) + 45; // used for centering

        parent.textSize(70);
        parent.fill(255);
        parent.text("Black Box", (float) parent.width / 2 - titleWidth, (float) parent.height / 2);

        parent.fill(255, 38, 125);
        parent.text("+", (float) parent.width / 2 - titleWidth + parent.textWidth("Black Box "), (float) parent.height / 2);
    }

    public void drawRay(float y) {
        // Draw ray dynamically
        parent.stroke(255, 255, 255);
        parent.line(0, y, x, y);

        // Move the ray
        x += speed;

        // Change direction when the ray reaches the end
        if (x >= 1100 || x < 0) {
            speed *= -1; // bounce back
        }

    }

    // Methods for Start button
    public void drawStartButton(int x, int y) {
        // Check if the mouse is over the button
        boolean mouseOver = (parent.mouseX >= x && parent.mouseX <= x + 100 && parent.mouseY >= y && parent.mouseY <= y + 50);

        // Check if mouse is pressed
        boolean mousePressed = parent.mousePressed;

        // Hover Logic
        if (mouseOver) {
            parent.stroke(255, 255, 255);
            parent.fill(150); // Lighter shade
        } else {
            parent.stroke(255, 255, 255);
            parent.fill(0);
        }
        parent.rect(x, y, 100, 50, 12, 12, 12, 12);

        // Title
        parent.textSize(25);
        parent.fill(255, 38, 125);
        parent.text("START", x + 18, y + 33);

        if (mouseOver && mousePressed) {
            startPressed = true;
        }
    }

    public boolean isStartPressed() {
        return startPressed;
    }

    public void drawInstructButton(int x, int y) {
        // Check if the mouse is over the button
        boolean mouseOver = (parent.mouseX >= x && parent.mouseX <= x + 155 && parent.mouseY >= y && parent.mouseY <= y + 50);

        // Check if mouse is pressed
        boolean mousePressed = parent.mousePressed;

        // Hover Logic
        if (mouseOver) {
            parent.stroke(255, 255, 255);
            parent.fill(150); // Lighter shade
        } else {
            parent.stroke(255, 255, 255);
            parent.fill(0);
        }
        parent.rect(x, y, 157, 50, 12, 12, 12, 12);

        // Title
        parent.textSize(25);
        parent.fill(255, 38, 125);
        parent.text("Instructions", x + 18, y + 33);

        if (mouseOver && mousePressed) {
            instructScreen = true;
        }

    }

    public boolean isInstructDisplayed() {
        return instructScreen;
    }

}