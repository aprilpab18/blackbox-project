import main.java.setter.*;
import main.java.ui.*;
import processing.core.PApplet;
import processing.core.PImage;


public class Main extends PApplet {
    Grid grid;
    Computer computer;
    StartMenu startMenu;

    public int numOfAtoms = 6;
    public boolean startScreen = true;
    public String userInput = "";
    public int[] shots = new int[100];
    public int numOfRays = 0;
    public int[] atomBoxNumbers = new int[numOfAtoms];
    public int[][] atomPositions = new int[numOfAtoms][2];
    boolean showingAtoms = false;

    public void settings() {
        size(700, 700);
    }

    public void setup() {
        PImage myImage = loadImage("resources/board-w-triangles.png");

        computer = new Computer();
        grid = new Grid(this, myImage);
        startMenu = new StartMenu(this);

        while (!computer.checkIfUnique(atomBoxNumbers, atomBoxNumbers.length)) { // Generates unique random atom positions -> Not very efficient way -> Try move into function
            atomBoxNumbers = computer.generateAtoms(numOfAtoms);
        }

        for (int i = 0; i < numOfAtoms; i++) {
            System.out.println(atomBoxNumbers[i]);
        }

//        System.out.println(computer.checkIfUnique(atomBoxNumbers, atomBoxNumbers.length));
    }

    public void draw() {
        if (startScreen) {
            if (!mousePressed) {
                startMenu.displayStartScreen();
            }
            else {
                startScreen = false;
            }
        }

        else { // AFTER START SCREEN -> GAMEPLAY
            background(0);


            atomPositions = grid.drawGrid(230, 100, 30, atomBoxNumbers); // Draws grid and makes array of atom coordinates
            grid.drawImage();

            // Text for user input (where to shoot array)
            fill(255);
            textSize(50);
            text(userInput, width/2 - 30, 600);


            textSize(20);
            textAlign(0, 0);

            if (showingAtoms) {
                text("Press 'X' to hide the atoms", 10, 20);
                grid.drawAtoms(atomPositions);
            }
            else {
                text("Press 'X' to show the atoms", 10, 20);
            }

        }

    }

    private void displayStartScreen() {

        // ADD CODE FOR START SCREEN HERE :O
        background(0, 0, 0);
        textSize(40);
        text("START SCREEN", 230, 300);
        text("CLICK ANYWHERE TO START", 120, 400);
    }

    private void displayEndScreen() {

        // ADD CODE FOR END SCREEN HERE !!!!!!
        background(0, 0, 255);
    }



    public void keyReleased() { // WHAT HAPPENS WHEN A KEY IS RELEASED

        if (key == ENTER) {
            int num = Integer.parseInt(userInput);
            if (num >= 1 && num <= 54) {
                shots[numOfRays] = num;
                numOfRays++;
            }
            else {
                println("NOT IN RANGE");
            }
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
        else if (key == 'x' || key == 'X') {
            if (showingAtoms) {
                showingAtoms = false;
            }
            else {
                showingAtoms = true;
            }
        }
    }

    public static void main(String[] args) {
        PApplet.main("Main");
    }
}

