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
        // TODO -> Just add in text ! :)
        parent.rect(80, 90, 5, 5);
        RayMarkers.drawText(25, "To shoot a ray, type the edge number you would like to shoot from and press enter.", 100, 100);

        parent.rect(80, 120, 5, 5);
        RayMarkers.drawText(25, "The computer will place a ray marker after each shot that will allow you to keep track"
                            , 100, 130);
        RayMarkers.drawText(25, " of where your rays enter and exit the board.", 103, 160);

        parent.rect(80, 180, 5, 5);
        RayMarkers.drawText(25, "To keep track of potential atom locations, simply click the hexagon on the board where"
                , 100, 190);
        RayMarkers.drawText(25, "you think the atom is situated."
                , 103, 220);
        RayMarkers.drawText(25, "To delete one of these atom markers, click the atom to remove it from the board."
                , 103, 250);

        parent.rect(80, 270, 5, 5);
        RayMarkers.drawText(25, "When you have placed 6 atom markers, the computer will give you the option to end"
                , 100, 280);
        RayMarkers.drawText(25, "the game. "
                , 103, 310);
        parent.rect(80, 330, 5, 5);
        RayMarkers.drawText(25, "Your score will be announced and the true atom locations will be revealed"
                , 100, 340);

        parent.rect(80, 360, 5, 5);
        RayMarkers.drawText(25, "Your score will be calculated based on your accuracy in guessing the atom location"
                , 100, 370);
        RayMarkers.drawText(25, "and the number of rays shot."
                , 103, 400);



        RayMarkers.drawText(50, "Good luck and have fun!"
                , 280, 490);





    }
}
