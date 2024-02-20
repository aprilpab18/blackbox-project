// Deals with everything to do with drawing the grid

package main.java.ui;
import processing.core.PApplet;

public class Grid{

    PApplet parent;


    public Grid(PApplet parent){
        this.parent = parent;
    }

    public void drawHexagon(int xPos, int yPos, int sideLength) { // Give coord of top of left vertical line

        parent.line(xPos-sideLength, yPos-(sideLength/2), xPos-sideLength, yPos+(sideLength/2)); // Left line
        parent.line(xPos+sideLength, yPos-(sideLength/2), xPos+sideLength, yPos+(sideLength/2)); // Right line
        parent.line(xPos-sideLength, yPos-(sideLength/2), xPos, yPos-sideLength); // Top left line
        parent.line(xPos+sideLength, yPos-(sideLength/2), xPos, yPos-sideLength); // Top right line
        parent.line(xPos-sideLength, yPos+(sideLength/2), xPos, yPos+sideLength); // Bottom left line
        parent.line(xPos+sideLength, yPos+(sideLength/2), xPos, yPos+sideLength); // Bottom right line

        // Middle = xPos, yPos

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
                drawHexagon(xPos + ((sideLength*2)*j) - (sideLength*i), yPos + ((sideLength + (sideLength/2))*i), sideLength);

                for (int k = 0; k < 6; k++) {
                    if (boxNumber == atomBoxNumbers[k]) {
                        atom = true;
                    }

                    if (atom) {
                        atomPositions[atomCount][0] = xPos + ((sideLength*2)*j) - (sideLength*i);
                        atomPositions[atomCount][1] = yPos + ((sideLength + (sideLength/2))*i);
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
                drawHexagon(xPos-(3*sideLength) + ((sideLength*2)*j) + (sideLength*i), yPos+(7*sideLength + (sideLength/2)) + ((sideLength + (sideLength/2))*i), sideLength);

                for (int k = 0; k < 6; k++) {
                    if (boxNumber == atomBoxNumbers[k]) {
                        atom = true;
                    }

                    if (atom) {
                        atomPositions[atomCount][0] = xPos-(3*sideLength) + ((sideLength*2)*j) + (sideLength*i);
                        atomPositions[atomCount][1] = yPos+(7*sideLength + (sideLength/2)) + ((sideLength + (sideLength/2))*i);
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

}
