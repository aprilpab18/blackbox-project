package main.java.ui;

import main.java.setter.Rays;
import processing.core.PApplet;
import processing.core.PImage;

import java.util.List;

import static main.java.ui.RayMarkers.markerScore;
import static main.java.utilities.Text.drawText;

public class EndScreen {
    private final PApplet parent;
    public Grid grid;
    public Rays rays;

    // Variables for Scoring
    public static int score = 0;
    public static int correctAtomsNum = 0;
    public static int incorrectAtomsNum = 0;

    public EndScreen(PImage myImage, PApplet parent) {
        this.parent = parent;
        this.grid = new Grid(parent, myImage);
        this.rays = new Rays(parent);
    }

    public void drawEndScreen(int[][] atomPositions, boolean showRays, int numOfRays, int[] shots, float[][] rayExitCoordinates, List<AtomLocation> guessedAtoms) {

        grid.drawImage(-1);

        parent.fill(0, 255, 0);
        parent.stroke(0, 255, 0);
        for (int[] atom : atomPositions) {
            parent.ellipse(atom[0], atom[1], 30, 30);
        }

        parent.fill(255);
        parent.textSize(20);
        parent.textAlign(0, 0);


        if (showRays) {
            parent.text("Press 'X' to hide the rays you shot", 10, 20);
            rays.displayRays(numOfRays, shots, atomPositions, parent);

            // CIRCLES OF INFLUENCE
            for (int[] atom : atomPositions) {
                parent.noFill();
                parent.stroke(255, 255, 255, 120);
                parent.ellipse(atom[0], atom[1], 118, 118);
            }

            RayMarkers.drawRayMarkers(numOfRays, shots, rayExitCoordinates);
        }
        else {
            parent.text("Press 'X' to show the rays you shot", 10, 20);

            // Assuming all atoms are incorrect initially
            int atomScore = 30;
            int incorrectAtoms = 6;
            int atoms = 0;

            for (AtomLocation atomLocation : guessedAtoms) {

                // Yellow Atoms => Incorrect Guess
                parent.fill(255, 255, 0);
                parent.stroke(255, 255, 0);

                // Red Atoms => Correct Guess
                for (int[] atom : atomPositions) {
                    if (atomLocation.getX() == atom[0] && atomLocation.getY() == atom[1]) {
                        parent.fill(255, 0, 0);
                        parent.stroke(255, 0, 0);
                        atomScore -= 5; // Correct atoms: -5
                        atoms++;
                        incorrectAtoms--;
                        break;
                    }
                }

                parent.ellipse(atomLocation.getX(), atomLocation.getY(), 30, 30);

            }

            // Adding up total score
            score = atomScore + markerScore;
            correctAtomsNum = atoms;
            incorrectAtomsNum = incorrectAtoms;
        }

        drawScoreBoard();
//        drawAtomKey();
        drawExitButton(915, 490);

        // Graphics
        drawRay(575);
        drawText(40, "THANK YOU FOR PLAYING!", 325, 635);
        drawRay(675);
    }

    private void drawScoreBoard() {
        parent.stroke(255, 255, 255);
        parent.fill(0);

        // Draw the rectangle
        parent.rect(750, 50, 250, 215, 12, 12, 12, 12);

        drawText(40, "Score: " + score, 800, 90);
        drawText(20, "Correct Atoms: " + correctAtomsNum, 770, 135);
        drawText(20, "Incorrect Atoms: " + incorrectAtomsNum, 770, 185);
        drawText(20, "Ray Markers: " + markerScore, 770, 235);
    }

//    private void drawAtomKey() {
//        parent.stroke(255, 255, 255);
//        parent.fill(0);
//
//        // Draw the rectangle
//        parent.rect(750, 275, 250, 200, 12, 12, 12, 12);
//
//        drawText(30, "Atom Key", 815, 310);
//        drawText(17, "Correct Guessed Atoms: " + correctAtomsNum, 785, 135);
//        drawText(17, "Incorrect Guessed Atoms: " + incorrectAtomsNum, 785, 185);
//        drawText(17, "Actual Atoms: " + markerScore, 785, 235);
//    }

    private void drawExitButton(int x, int y) {
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
        parent.rect(x, y, 100, 50, 12);

        // Title
        parent.textSize(25);
        parent.fill(255,38,125);
        parent.text("EXIT", x + 27,y + 33);

        if (mouseOver && mousePressed) {
            parent.exit();
        }
    }


    public boolean drawPlayAgainButton(int x, int y) {
        // Check if the mouse is over the button
        boolean mouseOver = (parent.mouseX >= x && parent.mouseX <= x + 150 && parent.mouseY >= y && parent.mouseY <= y + 50);

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
        parent.rect(x, y, 150, 50, 12);

        // Title
        parent.textSize(25);
        parent.fill(255,38,125);
        parent.text("PLAY AGAIN", x + 15,y + 33);

        if (mouseOver && mousePressed) {
            return true;
        }

        return false;
    }

    // GRAPHICS METHODS

    // Variables for Ray
    float x = 0;      // Initial x-coordinate of the ray
    float speed = 1.2F;  // Speed of the ray
    public void drawRay(float y) {

        // Draw ray dynamically
        parent.stroke(255,255,255);
        parent.line(0, y, x, y);

        // Move the ray
        x += speed;

        // Change direction when the ray reaches the end
        if (x >= 1100 || x < 0) {
            speed *= -1; // bounce back
        }

    }

}
