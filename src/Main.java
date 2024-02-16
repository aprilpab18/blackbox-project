import main.java.ui.*;
import processing.core.PApplet;

import processing.core.PApplet;

public class Main extends PApplet {
    Grid grid;

    public void settings() {
        size(700, 700);
    }

    public void setup() {
        grid = new Grid(this);
    }

    public void draw() {
        background(0);
        grid.drawGrid(470, 150, 30);
    }

    public static void main(String[] args) {
        PApplet.main("Main");
    }
}


