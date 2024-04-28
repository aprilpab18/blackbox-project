import main.java.setter.*;
import main.java.ui.*;
import processing.core.PApplet;
import processing.core.PImage;

// Importing packaged util static methods
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static main.java.utilities.Text.*;


public class Main extends PApplet {
    // Allows other classes to access the Processing functions and features provided by PApplet.
    Grid grid;
    Computer computer;
    StartMenu startMenu;
    Rays rays;
    RayMarkers rayMarkers;
    Guessing guessing;
    EndScreen endScreen;

    public int numOfAtoms = 6;
    public boolean startScreen = true;
    public boolean gameScreen = true;
    public boolean showEndScreen = false;

    // Variable for storing if ray input is out of range
    public boolean inputInRange = true;

    // Variable for storing if ray input has been used already
    public boolean duplicateInput = false;
    public String userInput = "";
    public int[] shots = new int[54]; // Numbers on grid where rays have been shot from
    public int numOfRays = 0;
    public int[] atomBoxNumbers = new int[numOfAtoms];
    public int[][] atomPositions = new int[numOfAtoms][2];
    boolean showingAtoms = false;
    public int selectedNumber = -1;
    public Point[] rayExitCoordinates = new Point[54];
    // -1, -1 = DIRECT HIT
    // -2, -2 = REFLECTED
    public boolean showRays = false;
    boolean mouseReleased = false;
    List<AtomLocation> guessedAtoms = new ArrayList<>();

    public void settings() {
        size(1100, 700);
    }

    public void setup() {
        PImage myImage = loadImage("resources/board.png");

        computer = new Computer();
        grid = new Grid(this, myImage);
        startMenu = new StartMenu(this);
        rays = new Rays(this);
        rayMarkers = new RayMarkers(this);
        guessing = new Guessing(this, grid);
        endScreen = new EndScreen(myImage, this);

        // Generates unique random atom positions -> Not very efficient way -> Try move into function
        while (!computer.checkIfUnique(atomBoxNumbers, atomBoxNumbers.length)) {
            atomBoxNumbers = computer.generateAtoms(numOfAtoms);
        }
    }

    public void draw() {

        if (startScreen) {
            startMenu.displayStartMenu();

            // Check start button is pressed to continue
            if (startMenu.isStartPressed()) {
                startScreen = false;
                gameScreen = true;
            }
        }

        else if (gameScreen) { // AFTER START SCREEN -> GAMEPLAY
            background(0);

            // Instructions Menu
            if (startMenu.isInstructDisplayed()) {
                startMenu.instructMenu.displayInstructMenu();
            }

            // Highlight selected number
            if (!Objects.equals(userInput, "") && Integer.parseInt(userInput) >= 1 && Integer.parseInt(userInput) <= 54) {
                selectedNumber = Integer.parseInt(userInput);
            }
            else {
                selectedNumber = -1;
            }


            // Draw grid
            grid.drawImage(selectedNumber);
            atomPositions = grid.drawGrid(230, 100, 30, atomBoxNumbers);

            // Draw rays (Move into showingAtoms in next sprint)
            for (int i = 0; i < numOfRays; i++) {
                int rayNumInList = shots[i] - 1;

                int direction = Rays.rayPositions[rayNumInList][4];
                Point start = new Point (Rays.rayPositions[rayNumInList][0], Rays.rayPositions[rayNumInList][1]);
                rayExitCoordinates[i] = Rays.drawRayWithBounces(atomPositions, start, direction, true, false);


                // Check for reflected rays
                if (dist(rayExitCoordinates[i].x, rayExitCoordinates[i].y, Rays.rayPositions[rayNumInList][0], Rays.rayPositions[rayNumInList][1]) < 5) {
                    rayExitCoordinates[i] = new Point(-2, -2);
                }
            }

            // Text for user input (where to shoot a ray)
            drawInputBox();
            fill(255);
            drawText(30, "Enter Ray Co-ord: " + userInput, 350, 595);

            // ERROR HANDLING - If number is not in range
            if(!inputInRange){
                drawError(20, "Number not in range, please try again.", 350, 625);
            }

            else if(duplicateInput){
                drawError(20, "Duplicate input number, please try again.", 350, 625);
            }


            // Show/hide atoms for testing purposes
            fill(255);
            textSize(20);
            textAlign(0, 0);
//            if (showingAtoms) {
//                text("Press 'X' to hide the atoms & rays", 10, 20);
//                rays.displayRays(numOfRays, shots, atomPositions, this);
//                grid.drawAtoms(atomPositions);
//            }
//            else {
//                text("Press 'X' to show the atoms & rays", 10, 20);
//            }

            // Ray Markers
            RayMarkers.drawRayMarkerKey(750,50);
            RayMarkers.drawRayMarkers(numOfRays, shots, rayExitCoordinates);

            // Guessing with Atom Markers
            if (mouseReleased) {
                guessedAtoms = guessing.updateAtomsGuessed(mouseX, mouseY);
                mouseReleased = false;
            }
            if (!guessedAtoms.isEmpty()) {
                guessing.displayGuessedAtoms(guessedAtoms);
            }

            // End game button
            if(guessedAtoms.size() == 6){
                guessing.drawEndButton(800, 600);
            }

            if (guessing.isEndGamePressed()) {
                gameScreen = false;
                showEndScreen = true;
            }
        } else if (showEndScreen) {
            endScreen.drawEndScreen(atomPositions, showRays, numOfRays, shots, rayExitCoordinates, guessedAtoms);
        }
    }

    public void mouseReleased() {
        mouseReleased = true;
    }
    public void keyReleased() {
        if (!showEndScreen) {
            // Check if the ENTER key is released
            if (key == ENTER) {
                // Try parsing the userInput to an integer
                if (!Objects.equals(userInput, "")) {

                    int num = Integer.parseInt(userInput);
                    // Check if the parsed number is within the range 1 to 54
                    if (num >= 1 && num <= 54) {
                        // If it's within the range, store it in the shots array and increment the number of rays
                        inputInRange = true;

                        // !!!!!!!!!! CHECK IF RAY ALREADY IN SHOTS ARRAY !!!!!!!!!! -> DISPLAY MESSAGE IF SO
                        duplicateInput = false;
                        for (int shot : shots) {
                            if (num == shot) {
                                duplicateInput = true;
                                break;
                            }
                        }

                        if (!duplicateInput) { // NOT A DUPLICATE
                            shots[numOfRays] = num;
                            numOfRays++;
                        }

                    } else {
                        // If it's not within the range, print a message
                        // Print to screen instead
                        inputInRange = false;

                    }
                    // Reset userInput to an empty string
                    userInput = "";
                }
                /*
                 * Num will be the point that the ray is sent from (i.e. rayPostions - 1)
                 */

            }
            // Check if the BACKSPACE key is released
            else if (key == BACKSPACE) {
                // If userInput is not empty, remove the last character
                if (!userInput.isEmpty()) {
                    userInput = userInput.substring(0, userInput.length() - 1);
                }
            }
            // Check if the released key is a digit
            else if (Character.isDigit(key)) {
                // If it's a digit, add it to userInput
                userInput += key;
            }
        }
        // Check if the released key is 'x' or 'X'
        if (key == 'x' || key == 'X') {
            if (!showEndScreen) {
                // Toggle the showingAtoms variable
                showingAtoms = !showingAtoms;
            }
            else {
                showRays = !showRays;
            }
        }
    }
    public static void main(String[] args) {
        PApplet.main("Main");
    }
}