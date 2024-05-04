/**
 * Deals with the guessing of atoms by the setter and navigation to the end screen
 */

package main.java.ui;

import processing.core.PApplet;

import static main.java.utilities.Text.drawError;

import java.util.ArrayList;
import java.util.List;

public class Guessing {
    private final PApplet parent;
    private final Grid grid;
    private boolean endGamePressed;

    // Keeps track of number of potential atom locations
    public int numAtomGuesses = 0;

    private final List<AtomLocation> atomGuessLocationsList = new ArrayList<>();


    // CONSTRUCTOR
    public Guessing(PApplet parent, Grid grid) {
        this.parent = parent;
        this.grid = grid;
    }

    public void drawEndButton(int x, int y) {
        boolean mouseOver = (parent.mouseX >= x && parent.mouseX <= x + 100
                && parent.mouseY >= y && parent.mouseY <= y + 50);
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
        parent.rect(x, y, 150, 50, 12, 12, 12, 12);

        // Title
        parent.textSize(25);
        parent.fill(255, 38, 125);
        parent.text("END GAME?", x + 18, y + 33);

        if (mouseOver && mousePressed && numAtomGuesses == 6) {
            endGamePressed = true;
        } else if (mouseOver && mousePressed) {
            endGamePressed = false;
            drawError(20, "You have not yet placed 6 atoms!", x - 40, y + 75);
        }
    }

    public boolean isEndGamePressed() {
        return endGamePressed;
    }

    /**
     * Updates the list of guessed atom locations based on mouse click
     * that is within a specific range from the centre of a hexagon on the grid
     *
     * @param mouseX The x-coordinate of the mouse click
     * @param mouseY The y-coordinate of the mouse click
     * @return The updated list of AtomLocation objects representing guessed atom locations
     */
    public List<AtomLocation> updateAtomsGuessed(int mouseX, int mouseY) {
        if (numAtomGuesses < 7) {
            // Iterate through the hexagon centre coordinates
            for (int i = 0; i < grid.hexagonCentreCoordinates.length; i++) {
                int[] centre = grid.hexagonCentreCoordinates[i];
                // Calculate distance between mouse click and hexagon center
                double distance = PApplet.dist(mouseX, mouseY, centre[0], centre[1]);
                // Within threshold => clicked
                if (distance < 20) {
                    // Check if the clicked location is empty (no atom placed yet)
                    boolean locationEmpty = true;
                    for (AtomLocation atomLocation : atomGuessLocationsList) {
                        if (atomLocation.getX() == centre[0] && atomLocation.getY() == centre[1]) {
                            // If the location is not empty, remove the guessed atom
                            locationEmpty = false;
                            atomGuessLocationsList.remove(atomLocation);
                            numAtomGuesses--;
                            break;
                        }
                    }
                    // If the location is empty, place the atom guess
                    if (locationEmpty && numAtomGuesses != 6) {
                        // Store the atom guess location
                        AtomLocation newLocation = new AtomLocation(centre[0], centre[1]);
                        atomGuessLocationsList.add(newLocation);
                        // Increment number of atom guesses
                        numAtomGuesses++;
                    }
                    break;
                }
            }
        }
        // Return the updated list of atom guess locations
        return atomGuessLocationsList;
    }

    public void displayGuessedAtoms(List<AtomLocation> atomGuessLocationsList) {
        parent.fill(255);
        for (AtomLocation atomLocation : atomGuessLocationsList) {
            parent.ellipse(atomLocation.getX(), atomLocation.getY(), 30, 30);

        }
    }
}
