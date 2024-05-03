package main.java.ui;

import main.java.setter.Rays;
import processing.core.PApplet;
import processing.core.PImage;

import java.awt.*;
import java.util.List;

import static main.java.ui.RayMarkers.markerScore;
import static main.java.utilities.Text.drawText;
import static main.java.utilities.Text.drawAtom;

public class EndScreen {

    // ACCESS TO PApplet TO USE PROCESSING FEATURES
    private final PApplet parent;
    public Grid grid;
    public Rays rays;

    // Variables for Scoring
    public static int score = 0;
    public static int correctAtomsNum = 0;
    public static int incorrectAtomsNum = 0;

    // Variables for colours
    private static final int[] red = {255, 0, 0};
    private static final int[] green = {0, 255, 0};
    private static final int[] yellow = {255, 255, 0};

    // CONSTRUCTOR
    public EndScreen(PImage myImage, PApplet parent) {
        this.parent = parent;
        this.grid = new Grid(parent, myImage);
        this.rays = new Rays(parent);
    }

    public void drawEndScreen(int[][] atomPositions, boolean showRays, int numOfRays, int[] shots, Point[] rayExitCoordinates, List<AtomLocation> guessedAtoms) {

        grid.drawImage(-1);

        // Yellow Atoms => Computer/Setter Atoms
        for (int[] atom : atomPositions) {
            drawAtom(yellow, atom[0], atom[1], 30);
        }

        // Aligning
        parent.fill(255);
        parent.textSize(20);
        parent.textAlign(0, 0);

        if (showRays) {
            parent.text("Press 'X' to hide the rays you shot", 10, 20);
            rays.displayRays(numOfRays, shots, atomPositions);

            // Yellow Atoms => Guesses
            for (int[] atom : atomPositions) {
                drawAtom(yellow, atom[0], atom[1], 30);
            }

            // CIRCLES OF INFLUENCE
            for (int[] atom : atomPositions) {
                parent.noFill();
                parent.stroke(255, 255, 255, 120);
                parent.ellipse(atom[0], atom[1], 118, 118);
            }
            RayMarkers.drawRayMarkers(numOfRays, shots, rayExitCoordinates);
        } else {
            parent.text("Press 'X' to display the rays you shot", 10, 20);

            // Assuming all atoms are incorrect initially
            int atomScore = 30;
            int incorrectAtoms = 6;
            int atoms = 0;

            for (AtomLocation atomLocation : guessedAtoms) {
                // Red Atoms => Incorrect Guess
                drawAtom(red, atomLocation.getX(), atomLocation.getY(), 30);
                // Green Atoms => Correct Guess
                for (int[] atom : atomPositions) {
                    if (atomLocation.getX() == atom[0] && atomLocation.getY() == atom[1]) {
                        drawAtom(green, atomLocation.getX(), atomLocation.getY(), 30);
                        // Adjust scoring
                        atomScore -= 5; // Correct atoms: -5
                        atoms++;
                        incorrectAtoms--;
                        break;
                    }
                }
            }
            // Adding up total score
            score = atomScore + markerScore;
            correctAtomsNum = atoms;
            incorrectAtomsNum = incorrectAtoms;
        }
        drawScoreBoard();
        drawAtomsKey();
        drawExitButton(830, 490);

        // Graphics
        drawRay(575);
        drawText(40, "THANK YOU FOR PLAYING!", 325, 635);
        drawRay(675);
    }

    // SCOREBOARDS + ATOMS KEY
    private void drawScoreBoard() {
        // Outline
        parent.stroke(255, 255, 255);
        parent.fill(0);
        parent.rect(750, 50, 250, 215, 12, 12, 12, 12);
        // Details
        drawText(40, "Score: " + score, 800, 90);
        drawText(20, "Correct Guesses: " + correctAtomsNum, 770, 135);
        drawText(20, "Incorrect Guesses: " + incorrectAtomsNum, 770, 185);
        drawText(20, "Ray Markers: " + markerScore, 770, 235);
    }

    private void drawAtomsKey() {
        // Outline
        parent.stroke(255, 255, 255);
        parent.fill(0);
        parent.rect(750, 275, 250, 200, 12, 12, 12, 12);
        // Details
        drawText(30, "Atoms Key", 815, 310);
        drawText(20, "Correct Atoms: ", 770, 355);
        drawAtom(green, 910, 348, 20);
        drawText(20, "Incorrect Atoms: ", 770, 405);
        drawAtom(red, 925, 398, 20);
        drawText(20, "Actual Atoms: ", 770, 455);
        drawAtom(yellow, 900, 448, 20);
    }

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
        parent.fill(255, 38, 125);
        parent.text("EXIT", x + 27, y + 33);

        if (mouseOver && mousePressed) {
            parent.exit();
        }
    }

    // GRAPHICS METHODS

    // Variables for Ray
    private float x = 0;
    private float speed = 1.2F;

    private void drawRay(float y) {
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


}
