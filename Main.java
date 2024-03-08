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

    // Variable for storing if ray input is out of range
    public boolean inputInRange = true;

    // Variable for storing if ray input has been used already
    public boolean duplicateInput = false;
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

        startScreen = false;
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
            atomPositions = grid.drawGrid(230, 100, 30, atomBoxNumbers);


            float[] angles = {
                    2 * PI * ((float) 58.8 /360), // Down and right
                    2 * PI * ((float) 120.8 /360), // Down and left
                    0F, // Right
                    PI, // Left
                    -2 * PI * ((float) 58.8 /360), // Up and right
                    -2 * PI * ((float) 120.8 /360) // Up and left
            };

            // Draw rays
            for (int i = 0; i < numOfRays; i++) {
                int rayNumInList = shots[i] - 1;

                // Test Markers (Insert Boolean Logic After Rays Implemented)
                rayMarkers.drawNoAtom(rayNumInList);

                int direction = rays.rayPositions[rayNumInList][4];
                float angle = angles[direction-1];
                boolean circleOfInfluence = false;
                boolean directHit = false;
                float influenceX = 0;
                float influenceY = 0;


                // SET DISTANCE TO MAX -> PASSES STRAIGHT THROUGH
                float distance = dist(rays.rayPositions[rayNumInList][0], rays.rayPositions[rayNumInList][1], rays.rayPositions[rayNumInList][2], rays.rayPositions[rayNumInList][3]);


                // CHECK FOR CIRCLES OF INFLUENCE

                // IF CIRCLE OF INFLUENCE -> WHILE IN CIRCLE OF INFLUENCE:
                //      IF DIST(TESTX, TEXTY, ATOM) < 15 -> DIRECT HIT
                //      OTHERWISE BOUNCE




                if (direction == 1) { // Down and right
                    for (int j = 0; j < numOfAtoms; j++) {
                        float testX = rays.rayPositions[rayNumInList][0];
                        float testY = rays.rayPositions[rayNumInList][1];

                        while (dist(testX, testY, atomPositions[j][0], atomPositions[j][1]) > 15 && testX < rays.rayPositions[rayNumInList][2] && testY < rays.rayPositions[rayNumInList][3]) {
                            testX++;
                            testY += 1.66;

                            if (dist(testX, testY, atomPositions[j][0], atomPositions[j][1]) <= 60 && !circleOfInfluence) {
                                circleOfInfluence = true;
                                influenceX = testX;
                                influenceY = testY;
                            }
                        }

                        if (dist(testX, testY, atomPositions[j][0], atomPositions[j][1]) <= 15) {
                            distance = dist(rays.rayPositions[rayNumInList][0], rays.rayPositions[rayNumInList][1], atomPositions[j][0], atomPositions[j][1]);
//                            println("ABSORBED");
                            directHit = true;
                            break;
                        }

                        if (circleOfInfluence) { // Circle of influence and NOT direct hit
//                            println("BOUNCE");
                            distance = dist(influenceX, influenceY, rays.rayPositions[rayNumInList][0], rays.rayPositions[rayNumInList][1]);

                            float newAngle = angle;

                            if (influenceX > atomPositions[j][0]) {
                                newAngle -= (float) (2 * PI * (58.8/360));
                                rays.drawRay(influenceX, influenceY, newAngle, 200, this);
                            }
                            else {
                                newAngle += (2 * PI * ((float) 62.8 /360));
                                rays.drawRay(influenceX, influenceY, newAngle, 200, this);
                            }

                            break;
                        }
                    }
                }
                else if (direction == 2) { // Down and left
                    for (int j = 0; j < numOfAtoms; j++) {
                        float testX = rays.rayPositions[rayNumInList][0];
                        float testY = rays.rayPositions[rayNumInList][1];

                        while (dist(testX, testY, atomPositions[j][0], atomPositions[j][1]) > 15 && testX > rays.rayPositions[rayNumInList][2] && testY < rays.rayPositions[rayNumInList][3]) {
                            testX--;
                            testY += 1.66;

                            if (dist(testX, testY, atomPositions[j][0], atomPositions[j][1]) <= 60 && !circleOfInfluence) {
                                circleOfInfluence = true;
                                influenceX = testX;
                                influenceY = testY;
                            }
                        }

                        if (dist(testX, testY, atomPositions[j][0], atomPositions[j][1]) <= 15) {
                            distance = dist(rays.rayPositions[rayNumInList][0], rays.rayPositions[rayNumInList][1], atomPositions[j][0], atomPositions[j][1]);
//                            println("ABSORBED");
                            directHit = true;
                            break;
                        }

                        if (circleOfInfluence) { // Circle of influence and NOT direct hit
//                            println("BOUNCE");
                            distance = dist(influenceX, influenceY, rays.rayPositions[rayNumInList][0], rays.rayPositions[rayNumInList][1]);

                            float newAngle = angle;

                            if (influenceX > atomPositions[j][0]) {
                                newAngle -= (float) (2 * PI * (61.8/360));
                                rays.drawRay(influenceX, influenceY, newAngle, 200, this);
                            }
                            else {
                                newAngle += (float) (2 * PI * (58.8/360));
                                rays.drawRay(influenceX, influenceY, newAngle, 200, this);
                            }

                            break;
                        }
                    }
                }
                else if (direction == 5) { // Up and right
                    for (int j = numOfAtoms - 1; j >= 0; j--) {
                        float testX = rays.rayPositions[rayNumInList][0];
                        float testY = rays.rayPositions[rayNumInList][1];

                        while (dist(testX, testY, atomPositions[j][0], atomPositions[j][1]) > 15 && testX < rays.rayPositions[rayNumInList][2] && testY > rays.rayPositions[rayNumInList][3]) {
                            testX++;
                            testY -= 1.66;

                            if (dist(testX, testY, atomPositions[j][0], atomPositions[j][1]) <= 60 && !circleOfInfluence) {
                                circleOfInfluence = true;
                                influenceX = testX;
                                influenceY = testY;
                            }
                        }

                        if (dist(testX, testY, atomPositions[j][0], atomPositions[j][1]) <= 15) {
                            distance = dist(rays.rayPositions[rayNumInList][0], rays.rayPositions[rayNumInList][1], atomPositions[j][0], atomPositions[j][1]);
//                            println("ABSORBED");
                            directHit = true;
                            break;
                        }

                        if (circleOfInfluence) { // Circle of influence and NOT direct hit
//                            println("BOUNCE");
                            distance = dist(influenceX, influenceY, rays.rayPositions[rayNumInList][0], rays.rayPositions[rayNumInList][1]);

                            float newAngle = angle;

                            if (influenceX > atomPositions[j][0]) {
                                newAngle += (float) (2 * PI * (58.8/360));
                                rays.drawRay(influenceX, influenceY, newAngle, 200, this);
                            }
                            else {
                                newAngle -= (2 * PI * ((float) 62.8 /360));
                                rays.drawRay(influenceX, influenceY, newAngle, 200, this);
                            }

                            break;
                        }
                    }
                }
                else if (direction == 6) { // Up and left
                    for (int j = numOfAtoms - 1; j >= 0; j--) {
                        float testX = rays.rayPositions[rayNumInList][0];
                        float testY = rays.rayPositions[rayNumInList][1];

                        while (dist(testX, testY, atomPositions[j][0], atomPositions[j][1]) > 15 && testX > rays.rayPositions[rayNumInList][2] && testY > rays.rayPositions[rayNumInList][3]) {
                            testX--;
                            testY -= 1.66;

                            if (dist(testX, testY, atomPositions[j][0], atomPositions[j][1]) <= 60 && !circleOfInfluence) {
                                circleOfInfluence = true;
                                influenceX = testX;
                                influenceY = testY;
                            }
                        }

                        if (dist(testX, testY, atomPositions[j][0], atomPositions[j][1]) <= 15) {
                            distance = dist(rays.rayPositions[rayNumInList][0], rays.rayPositions[rayNumInList][1], atomPositions[j][0], atomPositions[j][1]);
//                            println("ABSORBED");
                            directHit = true;
                            break;
                        }

                        if (circleOfInfluence) { // Circle of influence and NOT direct hit
//                            println("BOUNCE");
                            distance = dist(influenceX, influenceY, rays.rayPositions[rayNumInList][0], rays.rayPositions[rayNumInList][1]);

                            float newAngle = angle;

                            if (influenceX > atomPositions[j][0]) {
                                newAngle += (2 * PI * ((float) 62.8 /360));
                                rays.drawRay(influenceX, influenceY, newAngle, 200, this);
                            }
                            else {
                                newAngle -= (2 * PI * ((float) 58.8 /360));
                                rays.drawRay(influenceX, influenceY, newAngle, 200, this);
                            }

                            break;
                        }
                    }
                }







                // Direct hit from side
                for (int j = 0; j < numOfAtoms; j++) {
                    if (atomPositions[j][1] == rays.rayPositions[rayNumInList][1]) {
                        if (atomPositions[j][0] > rays.rayPositions[rayNumInList][0]) { // Hit from left
                            distance = atomPositions[j][0] - rays.rayPositions[rayNumInList][0];
                            directHit = true;
                            break;
                        }
                        else { // Hit from right
                            distance = rays.rayPositions[rayNumInList][0] - atomPositions[j][0];
                            directHit = true;
                        }
                    }
                }



                // vv MOVE TO ANOTHER FILE !!!!!!!!!!!!! vv

                stroke(255);


//                if (direction == 1) { // Down and right
//                    for (int j = 0; j < numOfAtoms; j++) {
//                        float testX = rays.rayPositions[rayNumInList][0];
//                        float testY = rays.rayPositions[rayNumInList][1];
//
//                        while (dist(testX, testY, atomPositions[j][0], atomPositions[j][1]) > 30 && testX < rays.rayPositions[rayNumInList][2] && testY < rays.rayPositions[rayNumInList][3]) {
//                            testX++;
//                            testY += 1.66;
//                        }
//
//                        if (dist(testX, testY, atomPositions[j][0], atomPositions[j][1]) <= 30) {
//                            distance = dist(rays.rayPositions[rayNumInList][0], rays.rayPositions[rayNumInList][1], atomPositions[j][0], atomPositions[j][1]);
//                            println("ABSORBED");
//                            break;
//                        }
//                    }
//                }
//                else if (direction == 2) { // Down and left
//                    for (int j = 0; j < numOfAtoms; j++) {
//                        float testX = rays.rayPositions[rayNumInList][0];
//                        float testY = rays.rayPositions[rayNumInList][1];
//
//                        while (dist(testX, testY, atomPositions[j][0], atomPositions[j][1]) > 30 && testX > rays.rayPositions[rayNumInList][2] && testY < rays.rayPositions[rayNumInList][3]) {
//                            testX--;
//                            testY += 1.66;
//                        }
//
//                        if (dist(testX, testY, atomPositions[j][0], atomPositions[j][1]) <= 30) {
//                            distance = dist(rays.rayPositions[rayNumInList][0], rays.rayPositions[rayNumInList][1], atomPositions[j][0], atomPositions[j][1]);
//                            println("ABSORBED");
//                            break;
//                        }
//                    }
//                }
//                else if (direction == 5) { // Up and right
//                    for (int j = 0; j < numOfAtoms; j++) {
//                        float testX = rays.rayPositions[rayNumInList][0];
//                        float testY = rays.rayPositions[rayNumInList][1];
//
//                        while (dist(testX, testY, atomPositions[j][0], atomPositions[j][1]) > 30 && testX < rays.rayPositions[rayNumInList][2] && testY > rays.rayPositions[rayNumInList][3]) {
//                            testX++;
//                            testY -= 1.66;
//                        }
//
//                        if (dist(testX, testY, atomPositions[j][0], atomPositions[j][1]) <= 30) {
//                            distance = dist(rays.rayPositions[rayNumInList][0], rays.rayPositions[rayNumInList][1], atomPositions[j][0], atomPositions[j][1]);
//                            println("ABSORBED");
//                        }
//                    }
//                }
//                else if (direction == 6) { // Up and left
//                    for (int j = 0; j < numOfAtoms; j++) {
//                        float testX = rays.rayPositions[rayNumInList][0];
//                        float testY = rays.rayPositions[rayNumInList][1];
//
//                        while (dist(testX, testY, atomPositions[j][0], atomPositions[j][1]) > 30 && testX > rays.rayPositions[rayNumInList][2] && testY > rays.rayPositions[rayNumInList][3]) {
//                            testX--;
//                            testY -= 1.66;
//                        }
//
//                        if (dist(testX, testY, atomPositions[j][0], atomPositions[j][1]) <= 30) {
//                            distance = dist(rays.rayPositions[rayNumInList][0], rays.rayPositions[rayNumInList][1], atomPositions[j][0], atomPositions[j][1]);
//                            println("ABSORBED");
//                        }
//                    }
//                }


                rays.drawRay(rays.rayPositions[rayNumInList][0], rays.rayPositions[rayNumInList][1], angle, distance, this);



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
            text("Enter Ray Co-ord: " + userInput, width/2, 595);

            // If number is not in range
            if(!inputInRange){
                fill(255, 0, 0);
                textSize(20);
                text("Number not in range, please try again.", width/2, 625);
            }

            if(duplicateInput){
                fill(255, 0, 0);
                textSize(20);
                text("Duplicate input number, please try again.", width/2, 625);
            }


            // Show/hide atoms

            fill(255);
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
                    inputInRange = true;

                    // !!!!!!!!!! CHECK IF RAY ALREADY IN SHOTS ARRAY !!!!!!!!!! -> DISPLAY MESSAGE IF SO
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

    // Method to draw input box UI
    public void drawInputBox() {
        stroke(255, 255, 255);
        fill(0);
        // Draw the rectangle
        rect(145, 570, 410, 80, 12, 12, 12, 12);
    }

    public static void main(String[] args) {
        PApplet.main("Main");
    }
}
