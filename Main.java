import processing.core.PApplet;
import processing.core.PImage;

public class Main extends PApplet{
    public int xPos = -120;
    public boolean startScreen = true;
    public String userInput = "";

    public static void main(String[] args) {
        PApplet.main("Main", args);
    }

    public void settings() {
        size(700, 700);
    }



    public void setup() {


    }

    public void draw() {
        if (startScreen) {
            if (mousePressed == false) {
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


            drawGrid(470, 100, 30);


            fill(255);
            textSize(50);
            text(userInput, width/2 - 30, 600);
        }
    }

    public void keyReleased() {
        userInput += key;
        if (key == ENTER) {
            userInput = "";
        }
        if (key == BACKSPACE) {
            userInput = userInput.substring(0, userInput.length()-2);
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




        // NUMBERS

//        textSize(18);
//
//        int x = 200;
//        int y = 120;
//        int num = 1;
//        boolean topCorner = true;
//
//        for (int i = 0; i < 9; i++) {
//            text(num, x, y);
//            num++;
//            if (topCorner) {
//                x -= 15;
//                y += 25;
//                topCorner = false;
//            }
//            else {
//                x -= 15;
//                y += 22;
//                topCorner = true;
//            }
//        }


    }

    public void displayStartScreen() {

        // ADD CODE FOR START SCREEN HERE :O


        background(0, 0, 255);
    }

}