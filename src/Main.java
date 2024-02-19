import main.java.ui.*;
import main.java.setter.*;
import processing.core.PApplet;

import processing.core.PApplet;

public class Main extends PApplet {
    Grid grid;
    Computer computer;
    public boolean startScreen = true;

    public String userInput = "";
    public int[] shots = new int[100];
    public int numOfRays = 0;
    public int[] atomBoxNumbers = new int[6];

    public void settings() {
        size(700, 700);
    }

    public void setup() {
        grid = new Grid(this);
        computer = new Computer();

        atomBoxNumbers = computer.generateAtoms(6);
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
            grid.drawGrid(230, 150, 30);
        }

    }

    private void displayStartScreen() {

        // ADD CODE FOR START SCREEN HERE :O
        background(0, 0, 0);
        textSize(40);
        text("START SCREEN", 230, 300);
        text("CLICK ANYWHERE TO START", 120, 400);
    }

    public void keyReleased() { // WHAT HAPPENS WHEN A KEY IS RELEASED

        if (key == ENTER) {
            int num = Integer.parseInt(userInput);
            if (num >= 1 && num <= 54) {
                shots[numOfRays] = num;
            }
            else {
                println("NOT IN RANGE");
            }
            numOfRays++;
            userInput = "";
        }
        else if (key == BACKSPACE) {
            if (!userInput.isEmpty()) {
                userInput = userInput.substring(0, userInput.length()-1);
            }
        }
        else if (Character.isDigit(key)){
            userInput += key;
        }
    }

    public static void main(String[] args) {
        PApplet.main("Main");
    }
}


