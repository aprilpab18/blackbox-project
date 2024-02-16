// Deals with everything to do with drawing the grid

package main.java.ui;
import processing.core.PApplet;

public class Grid{

    PApplet parent;

    public Grid(PApplet parent){
        this.parent = parent;
    }

    public void drawHexagon(int xPos, int yPos, int sideLength) { // Give coord of top of left vertical line

        // Middle = xPos, yPos

        parent.line(xPos-sideLength, yPos-(sideLength/2), xPos-sideLength, yPos+(sideLength/2)); // Left line
        parent.line(xPos+sideLength, yPos-(sideLength/2), xPos+sideLength, yPos+(sideLength/2)); // Right line
        parent.line(xPos-sideLength, yPos-(sideLength/2), xPos, yPos-sideLength); // Top left line
        parent.line(xPos+sideLength, yPos-(sideLength/2), xPos, yPos-sideLength); // Top right line
        parent.line(xPos-sideLength, yPos+(sideLength/2), xPos, yPos+sideLength); // Bottom left line
        parent.line(xPos+sideLength, yPos+(sideLength/2), xPos, yPos+sideLength); // Bottom right line
    }



    public void drawGrid(int xPos, int yPos, int sideLength) { // xPos of top left of left line of first row

        parent.stroke(255, 38, 125); // Colour of grid
        parent.strokeWeight(3);


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


}
