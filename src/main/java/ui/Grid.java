// Deals with everything to do with drawing the grid

package main.java.ui;
import processing.core.PApplet;
import processing.core.PImage;

public class Grid {

    PApplet parent;
    PImage myImage;


    public Grid(PApplet parent, PImage myImage){
        this.parent = parent;
        this.myImage = myImage;
    }

    public void drawHexagon(int xPos, int yPos, int sideLength) { // Give coord of top of left vertical line

        parent.stroke(255, 38, 125); // Colour of grid


        parent.line(xPos-sideLength, yPos-(sideLength/2), xPos-sideLength, yPos+(sideLength/2)); // Left line
        parent.line(xPos+sideLength, yPos-(sideLength/2), xPos+sideLength, yPos+(sideLength/2)); // Right line
        parent.line(xPos-sideLength, yPos-(sideLength/2), xPos, yPos-sideLength-5); // Top left line
        parent.line(xPos+sideLength, yPos-(sideLength/2), xPos, yPos-sideLength-5); // Top right line
        parent.line(xPos-sideLength, yPos+(sideLength/2), xPos, yPos+sideLength+5); // Bottom left line
        parent.line(xPos+sideLength, yPos+(sideLength/2), xPos, yPos+sideLength+5); // Bottom right line

        // Middle = xPos, yPos


        // FOR TESTING - SHOW MIDDLES OF HEXAGONS
//        parent.stroke(255, 255, 0);
//        parent.ellipse(xPos, yPos, 5, 5);

    }



    public int[][] drawGrid(int xPos, int yPos, int sideLength, int[] atomBoxNumbers) { // xPos of top left of left line of first row

        int[][] atomPositions = new int[6][2];
        parent.stroke(255, 38, 125); // Colour of grid
        parent.strokeWeight(3);

        int atomCount = 0; // How many atom positions have been added
        int boxNumber = 0; // Box number
        boolean atom = false;


        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5+i; j++) {
                drawHexagon(xPos + ((sideLength*2)*j) - (sideLength*i), yPos + ((sideLength + (sideLength/2))*i) + (5*i), sideLength);

                for (int k = 0; k < 6; k++) {
                    if (boxNumber == atomBoxNumbers[k]) {
                        atom = true;
                    }

                    if (atom) {
                        atomPositions[atomCount][0] = xPos + ((sideLength*2)*j) - (sideLength*i);
                        atomPositions[atomCount][1] = yPos + ((sideLength + (sideLength/2))*i) + (5*i);
                        atomCount++;
                        atom = false;
                    }
                }

                // PRINT BOX NUMBERS
//                parent.textSize(15);
//                parent.fill(255);
//                parent.text(boxNumber, xPos + ((sideLength*2)*j) - (sideLength*i), yPos + ((sideLength + (sideLength/2))*i));
                boxNumber++;
            }
        }

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 8-i; j++) {
                drawHexagon(xPos-(3*sideLength) + ((sideLength*2)*j) + (sideLength*i), yPos+(7*sideLength + (sideLength/2) + 25) + ((sideLength + (sideLength/2))*i) + (5*i), sideLength);

                for (int k = 0; k < 6; k++) {
                    if (boxNumber == atomBoxNumbers[k]) {
                        atom = true;
                    }

                    if (atom) {
                        atomPositions[atomCount][0] = xPos-(3*sideLength) + ((sideLength*2)*j) + (sideLength*i);
                        atomPositions[atomCount][1] = yPos+(7*sideLength + (sideLength/2) + 25) + ((sideLength + (sideLength/2))*i) + (5*i);
                        atomCount++;
                        atom = false;
                    }
                }

                // PRINT BOX NUMBERS
//                parent.fill(255);
//                parent.text(boxNumber, xPos-(3*sideLength) + ((sideLength*2)*j) + (sideLength*i), yPos+(7*sideLength + (sideLength/2)) + ((sideLength + (sideLength/2))*i));
                boxNumber++;
            }
        }

        return atomPositions;


    }


    public void drawAtoms(int[][] atomPositions) {
        for (int i = 0; i < 6; i++) {
            parent.stroke(0, 0, 255);
            parent.fill(0, 0, 255);
            parent.ellipse(atomPositions[i][0], atomPositions[i][1], 30, 30);
        }

        // Circles of influence
        for (int i = 0; i < 6; i++) {
            parent.noFill();
            parent.stroke(255, 255, 255, 120);
            parent.ellipse(atomPositions[i][0], atomPositions[i][1], 120, 120);
        }

        if (PApplet.dist(parent.mouseX, parent.mouseY, atomPositions[0][0], atomPositions[0][1]) <= 60) {
            parent.background(255);
        }

    }


    public void drawImage(int selectedNumber){
        // Draw image over Hexagon Grid
        parent.image(myImage, 0, 0, parent.width, parent.height);

        // Design of numbers

        parent.fill(255, 38, 125); // Set text color to pink
        parent.textSize(18); // Set text size
        parent.textAlign(parent.CENTER, parent.CENTER); // Align text to the center

        // Setting numbers to borders
        int[][] numberPositions = {
                {211, 66}, // 1
                {191, 97}, // 2
                {180, 112}, // 3
                {160, 143}, // 4
                {150, 157}, // 5
                {130, 188}, // 6
                {120, 202}, // 7
                {100, 233}, // 8
                {90, 247}, // 9
                {70, 280}, // 10
                {85, 311}, // 11
                {95, 326}, // 12
                {115, 357}, // 13
                {126, 372}, // 14
                {145, 401}, // 15
                {156, 417}, // 16
                {177, 448}, // 17
                {185, 463}, // 18
                {205, 492}, // 19
                {249, 495}, // 20
                {271, 495}, // 21
                {310, 495}, // 22
                {331, 495}, // 23
                {370, 495}, // 24
                {390, 495}, // 25
                {430, 495}, // 26
                {451, 495}, // 27
                {491, 495}, // 28
                {514, 464}, // 29
                {524, 448}, // 30
                {545, 417}, // 31
                {556, 402}, // 32
                {574, 372}, // 33
                {585, 357}, // 34
                {605, 327}, // 35
                {617, 311}, // 36
                {635, 280}, // 37
                {614, 248}, // 38
                {605, 233}, // 39
                {585, 203}, // 40
                {575, 188}, // 41
                {555, 159}, // 42
                {545, 143}, // 43
                {522, 112}, // 44
                {514, 97}, // 45
                {493, 67}, // 46
                {451, 63}, // 47
                {430, 63}, // 48
                {390, 63}, // 49
                {370, 63}, // 50
                {331, 63}, // 51
                {310, 63}, // 52
                {271, 63}, // 53
                {249, 63} // 54
        };


        for (int i = 1; i < 55; i++) {
            if (i == selectedNumber) {
                parent.fill(255);
            }
            else {
                parent.fill(255, 38, 125);
            }

            parent.text(i, numberPositions[i-1][0], numberPositions[i-1][1]);
        }

    }

}