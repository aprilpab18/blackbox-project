import processing.core.PApplet;
import processing.core.PImage;

public class Main extends PApplet{
    public int xPos = -120;

    public static void main(String[] args) {
        PApplet.main("Main", args);
    }

    public void settings() {
        size(700, 700);
    }


    PImage ava;

    public void setup() {

        ava = loadImage("https://www.sportsfile.com/winshare/w540/Library/SF1314/2298029.jpg");

    }

    public void draw() {
        background(36, 255, 28);

        image(ava, 200,100);

        xPos += 3;

        if (xPos > width+400) {
            xPos = -120;
        }


        stroke(0);
        strokeWeight(2);



        // Draw one hexagon

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5+i; j++) {
                drawHexagon(250 - (40*j) + (20*i), 100 + (30*i));
            }
        }

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 8-i; j++) {
                drawHexagon(30 + (40*j) + (20*i), 250 + (30*i));
            }
        }


    }


    public void drawHexagon(int xPos, int yPos) { // Give coord of top of left vertical line

        line(xPos, yPos, xPos, yPos+20); // Left line
        line(xPos+40, yPos, xPos+40, yPos+20); // Right line
        line(xPos, yPos, xPos+20, yPos-10); // Top left line
        line(xPos+20, yPos-10, xPos+40, yPos); // Top right line
        line(xPos, yPos+20, xPos+20, yPos+30); // Bottom left line
        line(xPos+20, yPos+30, xPos+40, yPos+20); // Bottom right line
    }

}