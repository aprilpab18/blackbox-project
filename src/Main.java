import main.java.ui.*;
import processing.core.PApplet;

import processing.core.PApplet;

public class Main extends PApplet {
    Grid grid;
    public boolean startScreen = true;

    public void settings() {
        size(700, 700);
    }

    public void setup() {
        grid = new Grid(this);
    }

    public void draw() {
        if(startScreen){
            if(!mousePressed){
                displayStartScreen();
            }
            else{
                startScreen = false;
            }
        }

        // Start screen is false
        else{
            // Set black background
            background(0);
            // Call draw grid function
            grid.drawGrid(470, 150, 30);
        }

    }

    private void displayStartScreen() {
        background(0,0,255);
    }

    public static void main(String[] args) {
        PApplet.main("Main");
    }
}


