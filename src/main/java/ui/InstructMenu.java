package main.java.ui;

import processing.core.PApplet;

public class InstructMenu {

    private PApplet parent;

    StartMenu startMenu;

    public InstructMenu(PApplet parent, StartMenu startMenu) {
        this.parent = parent;
        this.startMenu = startMenu;
    }

    public void displayInstructMenu() {
        parent.background(0);

        // Draw Rays
        startMenu.drawRay(25);
        startMenu.drawRay(675);

        // Instruction Details
        drawInstructions();

        // Buttons
        startMenu.drawStartButton(493,550);
    }

    private void drawInstructions() {
        // TODO
    }
}
