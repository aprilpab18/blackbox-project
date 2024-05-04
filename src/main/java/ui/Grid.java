/**
 * Deals with everything to do with drawing the grid and its numbering
 */

package main.java.ui;

import processing.core.PApplet;
import processing.core.PImage;

public class Grid {
    PApplet parent;
    PImage myImage;
    public int[][] hexagonCentreCoordinates = new int[61][2];

    public Grid(PApplet parent, PImage myImage) {
        this.parent = parent;
        this.myImage = myImage;
    }

    public void drawHexagon(int xPos, int yPos, int sideLength) { // Give coord of top of left vertical line
        parent.stroke(255, 38, 125); // Colour of grid

        parent.line(xPos - sideLength, yPos - (sideLength / 2),
                xPos - sideLength, yPos + (sideLength / 2)); // Left line
        parent.line(xPos + sideLength, yPos - (sideLength / 2),
                xPos + sideLength, yPos + (sideLength / 2)); // Right line
        parent.line(xPos - sideLength, yPos - (sideLength / 2),
                xPos, yPos - sideLength - 5); // Top left line
        parent.line(xPos + sideLength, yPos - (sideLength / 2),
                xPos, yPos - sideLength - 5); // Top right line
        parent.line(xPos - sideLength, yPos + (sideLength / 2),
                xPos, yPos + sideLength + 5); // Bottom left line
        parent.line(xPos + sideLength, yPos + (sideLength / 2),
                xPos, yPos + sideLength + 5); // Bottom right line
    }

    // xPos of top left of left line of first row
    public int[][] drawGrid(int xPos, int yPos, int sideLength, int[] atomBoxNumbers) {
        int[][] atomPositions = new int[6][2];
        parent.stroke(255, 38, 125); // Colour of grid
        parent.strokeWeight(3);

        int atomCount = 0; // How many atom positions have been added
        int boxNumber = 0; // Box number
        boolean atom = false;

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5 + i; j++) {
                drawHexagon(xPos + ((sideLength * 2) * j) - (sideLength * i),
                        yPos + ((sideLength + (sideLength / 2)) * i) + (5 * i), sideLength);
                hexagonCentreCoordinates[boxNumber] = new int[]{xPos + ((sideLength * 2) * j) - (sideLength * i),
                        yPos + ((sideLength + (sideLength / 2)) * i) + (5 * i)};

                for (int k = 0; k < 6; k++) {
                    if (boxNumber == atomBoxNumbers[k]) {
                        atom = true;
                    }

                    if (atom) {
                        atomPositions[atomCount][0] = xPos + ((sideLength * 2) * j) - (sideLength * i);
                        atomPositions[atomCount][1] = yPos + ((sideLength + (sideLength / 2)) * i) + (5 * i);
                        atomCount++;
                        atom = false;
                    }
                }
                boxNumber++;
            }
        }

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 8 - i; j++) {
                drawHexagon(xPos - (3 * sideLength) + ((sideLength * 2) * j) + (sideLength * i),
                        yPos + (7 * sideLength + (sideLength / 2) + 25)
                                + ((sideLength + (sideLength / 2)) * i) + (5 * i), sideLength);
                hexagonCentreCoordinates[boxNumber] = new int[]{xPos - (3 * sideLength) + ((sideLength * 2) * j)
                        + (sideLength * i),
                        yPos + (7 * sideLength + (sideLength / 2) + 25) + ((sideLength + (sideLength / 2)) * i)
                                + (5 * i)};

                for (int k = 0; k < 6; k++) {
                    if (boxNumber == atomBoxNumbers[k]) {
                        atom = true;
                    }

                    if (atom) {
                        atomPositions[atomCount][0] = xPos - (3 * sideLength) + ((sideLength * 2) * j)
                                + (sideLength * i);
                        atomPositions[atomCount][1] = yPos + (7 * sideLength + (sideLength / 2) + 25)
                                + ((sideLength + (sideLength / 2)) * i) + (5 * i);
                        atomCount++;
                        atom = false;
                    }
                }
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
            parent.ellipse(atomPositions[i][0], atomPositions[i][1], 118, 118);
        }
    }

    public void drawImage(int selectedNumber) {
        // Draw image over Hexagon Grid
        parent.image(myImage, 0, 0, parent.width, parent.height);

        // Design of numbers
        parent.fill(255, 38, 125);
        parent.textSize(18);
        parent.textAlign(parent.CENTER, parent.CENTER);

        // Setting numbers to borders
        int[][] numberPositions = {
                {211, 66}, // 1
                {191, 97}, // 2
                {180, 114}, // 3
                {160, 147}, // 4
                {150, 162}, // 5
                {130, 200}, // 6
                {121, 215}, // 7
                {100, 249}, // 8
                {90, 265}, // 9
                {70, 300}, // 10
                {86, 333}, // 11
                {95, 349}, // 12
                {115, 383}, // 13
                {127, 401}, // 14
                {145, 433}, // 15
                {156, 449}, // 16
                {177, 485}, // 17
                {187, 501}, // 18
                {205, 533}, // 19
                {249, 535}, // 20
                {271, 535}, // 21
                {310, 535}, // 22
                {331, 535}, // 23
                {370, 535}, // 24
                {390, 535}, // 25
                {430, 535}, // 26
                {451, 535}, // 27
                {491, 535}, // 28
                {514, 502}, // 29
                {524, 485}, // 30
                {545, 449}, // 31
                {556, 434}, // 32
                {574, 400}, // 33
                {585, 383}, // 34
                {604, 349}, // 35
                {614, 333}, // 36
                {635, 300}, // 37
                {614, 264}, // 38
                {605, 248}, // 39
                {585, 215}, // 40
                {575, 198}, // 41
                {555, 167}, // 42
                {545, 148}, // 43
                {522, 115}, // 44
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

        // Highlight text as white when selected
        for (int i = 1; i < 55; i++) {
            if (i == selectedNumber) {
                parent.fill(255);
            } else {
                parent.fill(255, 38, 125);
            }
            parent.text(i, numberPositions[i - 1][0], numberPositions[i - 1][1]);
        }

    }

}