package main.java.ui;

import main.java.setter.Rays;
import processing.core.PApplet;
import processing.core.PImage;

import java.util.List;

public class EndScreen {
    private final PApplet parent;
    public Grid grid;
    public Rays rays;
    private int score = 0;



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

            Rays.drawRayMarkers(numOfRays, shots, rayExitCoordinates);


        }
        else {
            parent.text("Press 'X' to show the rays you shot", 10, 20);

            for (AtomLocation atomLocation : guessedAtoms) {

                parent.fill(255, 0, 0);
                parent.stroke(255, 0, 0);

                for (int[] atom : atomPositions) {
                    if (atomLocation.getX() == atom[0] && atomLocation.getY() == atom[1]) {
                        parent.fill(255, 255, 0);
                        parent.stroke(255, 255, 0);
                        break;
                    }
                }

                parent.ellipse(atomLocation.getX(), atomLocation.getY(), 30, 30);

            }

        }

        parent.textSize(40);
        parent.fill(255);
        parent.text("Score: " + score, 800, 160);

        drawExitButton(900, 490);

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

}
