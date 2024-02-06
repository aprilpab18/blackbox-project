import processing.core.PApplet;

public class Main extends PApplet{
    public int xPos = -120;

    public static void main(String[] args) {
        PApplet.main("Main", args);
    }

    public void settings() {
        size(700, 700);
    }


    public void setup() {

    }

    public void draw() {
        background(0);

        xPos += 3;

        if (xPos > width+400) {
            xPos = -120;
        }


        stroke(255, 255, 0);
        strokeWeight(2);


        drawGrid(400, 100, 30);

    }


    public void drawHexagon(int xPos, int yPos, int sideLength) { // Give coord of top of left vertical line

        line(xPos, yPos, xPos, yPos+sideLength); // Left line
        line(xPos+(sideLength*2), yPos, xPos+(2*sideLength), yPos+sideLength); // Right line
        line(xPos, yPos, xPos+sideLength, yPos-(sideLength/2)); // Top left line
        line(xPos+sideLength, yPos-(sideLength/2), xPos+(2*sideLength), yPos); // Top right line
        line(xPos, yPos+sideLength, xPos+sideLength, yPos+(sideLength +  (sideLength/2))); // Bottom left line
        line(xPos+sideLength, yPos+(sideLength +  (sideLength/2)), xPos+(sideLength*2), yPos+sideLength); // Bottom right line
    }



    public void drawGrid(int xPos, int yPos, int sideLength) { // xPos of top left of left line of first row
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5+i; j++) {
                drawHexagon(xPos - ((sideLength*2)*j) + (sideLength*i), yPos + ((sideLength + (sideLength/2))*i), sideLength);
            }
        }

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 8-i; j++) {
                drawHexagon(xPos-(11*sideLength) + ((sideLength*2)*j) + (sideLength*i), yPos+(7*sideLength + (sideLength/2)) + ((sideLength + (sideLength/2))*i), sideLength);
            }
        }

    }

}