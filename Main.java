import main.java.setter.*;
import main.java.ui.*;
import processing.core.PApplet;
import processing.core.PImage;


public class Main extends PApplet {
    Grid grid;
    Computer computer;
    StartMenu startMenu;
    Rays rays;
    RayMarkers rayMarkers;

    public int numOfAtoms = 6;
    public boolean startScreen = true;
    public String userInput = "";
    public int[] shots = new int[100];
    public int numOfRays = 0;
    public int[] atomBoxNumbers = new int[numOfAtoms];
    public int[][] atomPositions = new int[numOfAtoms][2];
    boolean showingAtoms = false;
    public int selectedNumber = -1;

    public void settings() {
        size(700, 700);
    }

    public void setup() {
        PImage myImage = loadImage("resources/board-w-triangles.png");

        computer = new Computer();
        grid = new Grid(this, myImage);
        startMenu = new StartMenu(this);
        rays = new Rays(this);
        rayMarkers = new RayMarkers(this);

        while (!computer.checkIfUnique(atomBoxNumbers, atomBoxNumbers.length)) { // Generates unique random atom positions -> Not very efficient way -> Try move into function
            atomBoxNumbers = computer.generateAtoms(numOfAtoms);
        }

        for (int i = 0; i < numOfAtoms; i++) {
            System.out.println(atomBoxNumbers[i]);
        }

    }

    public void draw() {
        if (startScreen) {
            if (!mousePressed) {
                startMenu.displayStartScreen();
            }
            else {
                startScreen = false;
            }
        }

        else { // AFTER START SCREEN -> GAMEPLAY
            background(0);

            // Draws grid and makes array of atom coordinates
//            atomPositions = grid.drawGrid(230, 100, 30, atomBoxNumbers);

            // Highlight selected number
            if (userInput != "" && Integer.parseInt(userInput) >= 1 && Integer.parseInt(userInput) <= 54) {
                selectedNumber = Integer.parseInt(userInput);
            }
            else {
                selectedNumber = -1;
            }

            // Draw grid
             grid.drawImage(selectedNumber); // ADD BACK AFTER TESTING
            println(mouseX + ", " + mouseY);

            atomPositions = grid.drawGrid(230, 100, 30, atomBoxNumbers); // REMOVE AFTER TESTING


            // Draw rays
            for (int i = 0; i < numOfRays; i++) {
                int rayNumInList = shots[i] - 1;

                // Test Markers (Insert Boolean Logic After Rays Implemented)
                rayMarkers.drawNoAtom(rayNumInList);

                int direction = rays.rayPositions[rayNumInList][4];
                float angle = 0;

                if (direction == 1) { // Down and right
                    angle = 0.97999F;
                }
                else if (direction == 2) { // Down and left
                    angle = 2.155978F;
                }
                else if (direction == 3) { // Right
                    angle = 0F;
                }
                else if (direction == 4) { // Left
                    angle = PI;
                }
                else if (direction == 5) { // Up and right
                      angle = -0.97999F;
                }
                else if (direction == 6) { // Up and left
                      angle = -2.155978F;
                }


                float distance = dist(rays.rayPositions[rayNumInList][0], rays.rayPositions[rayNumInList][1], rays.rayPositions[rayNumInList][2], rays.rayPositions[rayNumInList][3]);

                for (int j = 0; j < numOfAtoms; j++) {
                    if (atomPositions[j][1] == rays.rayPositions[rayNumInList][1]) {
                        if (atomPositions[j][0] > rays.rayPositions[rayNumInList][0]) { // Hit from left
                            distance = atomPositions[j][0] - rays.rayPositions[rayNumInList][0];
                            break;
                        }
                        else { // Hit from right
                            distance = rays.rayPositions[rayNumInList][0] - atomPositions[j][0];
                        }
                    }
                }

//                rays.drawRay(rays.rayPositions[rayNumInList][0], rays.rayPositions[rayNumInList][1], angle, distance, this);
                line(rays.rayPositions[rayNumInList][0], rays.rayPositions[rayNumInList][1], rays.rayPositions[rayNumInList][2], rays.rayPositions[rayNumInList][3]);

                // vv TESTING vv
//                float testX = 460;
//                float testY = 80;
//                stroke(255);
//                while (testX < 650) {
//                    ellipse(testX, testY, 1, 1);
//                    testX++;
//                    testY += 1.5;
//                }



            }


            // calculates the angle between two points
//            float angle  = (float) Math.atan2(80 - 620, 280 - 280); // x2 - x1, y2 - y1 620, 280, 80, 280
//            println("Angle: "+ angle);
//
//            // Down and right angle:
//            float downAndRight = 0.97999F;
//            Rays.drawRay(rays.rayPositions[52][0], rays.rayPositions[52][1], downAndRight, 500, this);
//
//            // down and left
//            // float downAndLeft = 0.97999F * 2.2F;
//            float f = 2.155978F;
//            Rays.drawRay(rays.rayPositions[51][0], rays.rayPositions[51][1], f, 500, this);


            // draws test line
//            stroke(0, 0, 255);
//            line(605, 300, 460, 80);

            // Text for user input (where to shoot a ray)
            drawInputBox();
            fill(255);
            textSize(30);
            text("Enter Ray Co-ord: " + userInput, width/2, 618);


            // Show/hide atoms

            textSize(20);
            textAlign(0, 0);

            if (showingAtoms) {
                text("Press 'X' to hide the atoms", 10, 20);
                grid.drawAtoms(atomPositions);
            }
            else {
                text("Press 'X' to show the atoms", 10, 20);
            }

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
                    shots[numOfRays] = num;
                    numOfRays++;
                } else {
                    // If it's not within the range, print a message
                    println("NOT IN RANGE");
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

    // Method to draw input box UI
    public void drawInputBox() {
        stroke(255, 255, 255);
        fill(0);
        // Draw the rectangle
        rect(145, 585, 410, 70, 12, 12, 12, 12);
    }

    public static void main(String[] args) {
        PApplet.main("Main");
    }
}
