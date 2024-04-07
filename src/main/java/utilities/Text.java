package main.java.utilities;

import processing.core.PApplet;

public class Text {

    private static PApplet parent; // Change to private

    public Text(PApplet parent) {
        Text.parent = parent; // Use Text.parent instead of this.parent
    }

    /* Utility method to write text
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

    // Bullet points used in InstructMenu
    public static void drawBullet(int x, int y) {
        if (parent != null) { // Check if parent is not null
            parent.rect(x, y, 5, 5);
        } else {
            System.out.println("Parent is null!"); // Print error message for debugging
        }
    }
}
