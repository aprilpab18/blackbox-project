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


    public void drawImage(){
        // Draw image over Hexagon Grid
        parent.image(myImage, 0, 0, parent.width, parent.height);

        // Design of numbers
        parent.fill(255, 38, 125); // Set text color to pink
        parent.textSize(18); // Set text size
        parent.textAlign(parent.CENTER, parent.CENTER); // Align text to the center

        // Setting numbers to borders
        parent.text("1", 211, 66);
        parent.text("2", 191, 97);
        parent.text("3", 180, 112);
        parent.text("4", 160, 143);
        parent.text("5", 150, 157);
        parent.text("6", 130, 188);
        parent.text("7", 120, 202);
        parent.text("8", 100, 233);
        parent.text("9", 90, 247);
        parent.text("10", 70, 280);

        parent.text("11", 85, 311);
        parent.text("12", 95, 326);
        parent.text("13", 115, 357);
        parent.text("14", 126, 372);
        parent.text("15", 145, 401);
        parent.text("16", 156, 417);
        parent.text("17", 177, 448);
        parent.text("18", 185, 463);
        parent.text("19", 205, 492);

        parent.text("20", 249, 495);
        parent.text("21", 271, 495);
        parent.text("22", 310, 495);
        parent.text("23", 331, 495);
        parent.text("24", 370, 495);
        parent.text("25", 390, 495);
        parent.text("26", 430, 495);
        parent.text("27", 451, 495);
        parent.text("28", 491, 495);

        parent.text("29", 514, 464);
        parent.text("30", 524, 448);
        parent.text("31", 545, 417);
        parent.text("32", 556, 402);
        parent.text("33", 574, 372);
        parent.text("34", 585, 357);
        parent.text("35", 605, 327);
        parent.text("36", 617, 311);

        parent.text("37", 635, 280);
        parent.text("38", 614, 248);
        parent.text("39", 605, 233);
        parent.text("40", 585, 203);
        parent.text("41", 575, 188);
        parent.text("42", 555, 159);
        parent.text("43", 545, 143);
        parent.text("44", 522, 112);
        parent.text("45", 514, 97);
        parent.text("46", 493, 67);

        parent.text("47", 451, 66);
        parent.text("48", 430, 66);
        parent.text("49", 390, 66);
        parent.text("50", 370, 66);
        parent.text("51", 331, 66);
        parent.text("52", 310, 66);
        parent.text("53", 271, 66);
        parent.text("54", 249, 66);

    }

}
