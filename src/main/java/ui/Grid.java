// Deals with everything to do with drawing the grid

package main.java.ui;
import processing.core.PApplet;

public class Grid{

    public int[] atomBoxNumbers = new int[6];
    public int[][] atomPositions = new int[6][2];

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



    public void drawGrid(int xPos, int yPos, int sideLength) { // xPos of top left of left line of first row

        parent.stroke(255, 38, 125); // Colour of grid
        parent.strokeWeight(3);

        int atomCount = 0; // How many atom positions have been added
        int boxNumber = 0; // Box number
        boolean atom = false;


        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5 + i; j++) {
                drawHexagon(xPos + ((sideLength * 2) * j) - (sideLength * i), yPos + ((sideLength + (sideLength / 2)) * i), sideLength);

                for (int k = 0; k < 6; k++) {
                    if (boxNumber == atomBoxNumbers[k]) {
                        atom = true;
                    }

                    if (atom) {
                        atomPositions[atomCount][0] = xPos + ((sideLength * 2) * j) - (sideLength * i);
                        atomPositions[atomCount][1] = yPos + ((sideLength + (sideLength / 2)) * i);
                        parent.fill(0, 0, 255);
                        parent.ellipse(atomPositions[atomCount][0], atomPositions[atomCount][1], 30, 30);
                        System.out.println("ATOM: " + boxNumber);
                        atomCount++;
                        atom = false;
                    }
                }
                parent.textSize(15);
                parent.fill(255);
                parent.text(boxNumber, xPos + ((sideLength * 2) * j) - (sideLength * i), yPos + ((sideLength + (sideLength / 2)) * i));
                boxNumber++;
            }
        }

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 8 - i; j++) {
                drawHexagon(xPos - (3 * sideLength) + ((sideLength * 2) * j) + (sideLength * i), yPos + (7 * sideLength + (sideLength / 2)) + ((sideLength + (sideLength / 2)) * i), sideLength);

                for (int k = 0; k < 6; k++) {
                    if (boxNumber == atomBoxNumbers[k]) {
                        atom = true;
                    }

                    if (atom) {
                        atomPositions[atomCount][0] = xPos - (3 * sideLength) + ((sideLength * 2) * j) + (sideLength * i);
                        atomPositions[atomCount][1] = yPos + (7 * sideLength + (sideLength / 2)) + ((sideLength + (sideLength / 2)) * i);
                        parent.fill(0, 0, 255);
                        parent.ellipse(atomPositions[atomCount][0], atomPositions[atomCount][1], 30, 30);
                        System.out.println("ATOM: " + boxNumber);
                        atomCount++;
                        atom = false;
                    }
                }

                parent.fill(255);
                parent.text(boxNumber, xPos - (3 * sideLength) + ((sideLength * 2) * j) + (sideLength * i), yPos + (7 * sideLength + (sideLength / 2)) + ((sideLength + (sideLength / 2)) * i));
                boxNumber++;
            }
        }
    }

}
