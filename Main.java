import main.java.setter.*;
import main.java.ui.*;
import processing.core.PApplet;
import processing.core.PImage;

// Importing packaged util static methods
import java.util.Arrays;
import java.util.Objects;

import static main.java.utilities.Text.*;


public class Main extends PApplet {
    Grid grid;
    Computer computer;
    StartMenu startMenu;
    Rays rays;
    RayMarkers rayMarkers;


    public int numOfAtoms = 6;
    public boolean startScreen = true;

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
    public float[][] rayExitCoordinates = new float[54][2];
    // -1, -1 = DIRECT HIT
    // -2, -2 = REFLECTED

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


        while (!computer.checkIfUnique(atomBoxNumbers, atomBoxNumbers.length)) { // Generates unique random atom positions -> Not very efficient way -> Try move into function
            atomBoxNumbers = computer.generateAtoms(numOfAtoms);
        }

        atomBoxNumbers = new int[] {5, 14, 21, 23, 31, 55};
    }

    public void draw() {

        if (startScreen) {
            startMenu.displayStartMenu();

            // Check start button is pressed to continue
            if (startMenu.isStartPressed()) {
                startScreen = false;
            }
        }

        else { // AFTER START SCREEN -> GAMEPLAY
            background(0);

            // Instructions Menu
            if (startMenu.isInstructDisplayed()) {
                startMenu.instructMenu.displayInstructMenu();
            }

            // Highlight selected number
            if (userInput != "" && Integer.parseInt(userInput) >= 1 && Integer.parseInt(userInput) <= 54) {
                selectedNumber = Integer.parseInt(userInput);
            }
            else {
                selectedNumber = -1;
            }


            // Draw grid
            grid.drawImage(selectedNumber);
//            atomPositions = grid.drawGrid(230, 100, 30, atomBoxNumbers);

            // Draw rays (Move into showingAtoms in next sprint)
            for (int i = 0; i < numOfRays; i++) {
                int rayNumInList = shots[i] - 1;

                int direction = Rays.rayPositions[rayNumInList][4];
                rayExitCoordinates[i] = Rays.drawRayWithBounces(atomPositions, Rays.rayPositions[rayNumInList][0], Rays.rayPositions[rayNumInList][1], direction, true, false,this);


                // CHECK FOR REFLECTED RAYS
                if (dist(rayExitCoordinates[i][0], rayExitCoordinates[i][1], Rays.rayPositions[rayNumInList][0], Rays.rayPositions[rayNumInList][1]) < 5) {
                    rayExitCoordinates[i] = new float[] {-2, -2};
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


            // Show/hide atoms
            fill(255);
            textSize(20);
            textAlign(0, 0);


            if (showingAtoms) {
                text("Press 'X' to hide the atoms & rays", 10, 20);
                rays.displayRays(numOfRays, shots, atomPositions, this);
                grid.drawAtoms(atomPositions);
            }
            else {
                text("Press 'X' to show the atoms & rays", 10, 20);
            }



            // RAY MARKERS
            RayMarkers.drawRayMarkerKey(750,50);
            Rays.drawRayMarkers(numOfRays, shots, rayExitCoordinates);
        }

    }


    private void displayEndScreen() {

        // ADD CODE FOR END SCREEN HERE !!!!!!
        background(0, 0, 255);
    }


    // Method called when a key is released
    public void keyReleased() {

        // Check if the ENTER key is released
        if (key == ENTER) {
            // Try parsing the userInput to an integer
            if (userInput != "") {

                int num = Integer.parseInt(userInput);
                // Check if the parsed number is within the range 1 to 54
                if (num >= 1 && num <= 54) {
                    // If it's within the range, store it in the shots array and increment the number of rays
                    inputInRange = true;

                    // !!!!!!!!!! CHECK IF RAY ALREADY IN SHOTS ARRAY !!!!!!!!!! -> DISPLAY MESSAGE IF SO
                    duplicateInput = false;
                    for(int i = 0; i < shots.length; i++){
                        if (num == shots[i]) {
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
                userInput = userInput.substring(0, userInput.length()-1);
            }
        }
        // Check if the released key is a digit
        else if (Character.isDigit(key)){
            // If it's a digit, add it to userInput
            userInput += key;
        }
        // Check if the released key is 'x' or 'X'
        else if (key == 'x' || key == 'X') {
            // Toggle the showingAtoms variable
            if (showingAtoms) {
                showingAtoms = false;
            } else {
                showingAtoms = true;
            }
        }
    }

    public static void main(String[] args) {
        PApplet.main("Main");
    }
}
