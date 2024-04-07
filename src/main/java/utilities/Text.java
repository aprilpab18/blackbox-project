package main.java.utilities;

import processing.core.PApplet;

public class Text {

    private static PApplet parent;

    // Constructor
    public Text(PApplet parent) {
        Text.parent = parent;
    }

    /* Utility methods to write text
     * - This is due to conflicting methods in Java Processing */
    public static void drawText(int size, String text, int x, int y){
        if (parent != null) { // Check if parent is not null
            parent.fill(255);
            parent.textSize(size);
            parent.text(text, x, y);
        } else {
            System.out.println("Parent is null!"); // Print error message for debugging
        }
    }

    public static void drawError(int size, String text, int x, int y){
        if (parent != null) { // Check if parent is not null
            parent.fill(255, 0, 0);
            parent.textSize(size);
            parent.text(text, x, y);
        } else {
            System.out.println("Parent is null!"); // Print error message for debugging
        }
    }

    // Bullet points used in InstructMenu
    public static void drawBullet(int x, int y) {
        if (parent != null) { // Check if parent is not null
            parent.rect(x, y, 5, 5);
        } else {
            System.out.println("Parent is null!"); // Print error message for debugging
        }
    }

    // Outline for Input Box in Main
    public static void drawInputBox() {
        parent.stroke(255, 255, 255);
        parent.fill(0);
        // Draw the rectangle
        parent.rect(145, 570, 410, 80, 12, 12, 12, 12);
    }
}
