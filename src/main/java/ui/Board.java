package main.java.ui;

import processing.core.PApplet;

public class Board extends PApplet{
    public int xPos = -120;
    public boolean startScreen = true;

    public int[][] blackBoxCoordinates = new int[61][2];

    public void setup() {

    }

    public static void main(String[] args) {
        PApplet.main("Board", args);
    }

    public void settings() {
        size(700, 700);
    }


    public void draw() {
        if (startScreen) {
            if (!mousePressed) {
                displayStartScreen();
            }
            else {
                startScreen = false;
            }
        }
        else {
            background(0);

            xPos += 3;

            if (xPos > width + 400) {
                xPos = -120;
            }


            drawGrid(470, 150, 30);
        }
    }



    public void drawHexagon(int xPos, int yPos, int sideLength) { // Give coord of top of left vertical line

        // Middle = xPos, yPos

        line(xPos-sideLength, yPos-(sideLength/2), xPos-sideLength, yPos+(sideLength/2)); // Left line
        line(xPos+sideLength, yPos-(sideLength/2), xPos+sideLength, yPos+(sideLength/2)); // Right line
        line(xPos-sideLength, yPos-(sideLength/2), xPos, yPos-sideLength); // Top left line
        line(xPos+sideLength, yPos-(sideLength/2), xPos, yPos-sideLength); // Top right line
        line(xPos-sideLength, yPos+(sideLength/2), xPos, yPos+sideLength); // Bottom left line
        line(xPos+sideLength, yPos+(sideLength/2), xPos, yPos+sideLength); // Bottom right line
    }



    public void drawGrid(int xPos, int yPos, int sideLength) { // xPos of top left of left line of first row

        stroke(255, 38, 125); // Colour of grid
        strokeWeight(3);


        // top half and middle of board
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5+i; j++) {
                drawHexagon(xPos - ((sideLength*2)*j) + (sideLength*i), yPos + ((sideLength + (sideLength/2))*i), sideLength);
            }
        }

        // bottom four rows
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 8-i; j++) {
                drawHexagon(xPos-(11*sideLength) + ((sideLength*2)*j) + (sideLength*i), yPos+(7*sideLength + (sideLength/2)) + ((sideLength + (sideLength/2))*i), sideLength);
            }
        }




        // NUMBERS



    }

    public void displayStartScreen() {

        // ADD CODE FOR START SCREEN HERE :O


        //background(0, 0, 255);
    }

}