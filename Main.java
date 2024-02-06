import processing.core.PApplet;

public class Main extends PApplet{
    public int xPos = -120;

    public static void main(String[] args) {
        PApplet.main("Main", args);
    }

    public void settings() {
        size(500, 500);
    }


    public void setup() {

    }

    public void draw() {
        background(0, 14, 250);
        fill(255);
        rectMode(CENTER);
        rect(width/2, height-10, width, 20);
        ellipse(xPos, 400, 180, 180);
        ellipse(xPos, 260, 140, 140);
        ellipse(xPos, 140, 120, 120);

        // Face
        fill(0);
        ellipse(xPos-20, 120, 10, 10);
        ellipse(xPos+20, 120, 10, 10);
        stroke(250, 150, 0);
        strokeWeight(10);
        line(xPos ,145, xPos+40, 145);
        stroke(0);
        strokeWeight(1);
        ellipse(xPos-10, 175, 10, 10);
        ellipse(xPos-30, 160, 10, 10);
        ellipse(xPos+10, 175, 10, 10);
        ellipse(xPos+30, 160, 10, 10);

        // Buttons
        ellipse(xPos, 220, 10, 10);
        ellipse(xPos, 260, 10, 10);
        ellipse(xPos, 300, 10, 10);

        // Arms
        strokeWeight(6);
        stroke(118, 83, 30);
        line(xPos-70, 250, xPos-120, 300);
        line(xPos+70, 250, xPos+120, 300);
        strokeWeight(1);
        stroke(0);

        // Hat
        rect(xPos, 80, 100, 10);
        rect(xPos, 50, 70, 60);

        textSize(35);
        text("MERRY CHRISTMAS!", xPos-400, 200);
        text("DO UR WEBWORK", xPos-390, 240);
        xPos += 3;

        if (xPos > width+400) {
            xPos = -120;
        }
    }

}