package main.java.utilities;

import static main.java.utilities.Text.drawError;

public class ErrorHandling {
    public static void handleInputOutOfRange(int x, int y) {
        drawError(20, "Number not in range, please try again.", x, y);
    }

    public static void handleDuplicateInput(int x, int y) {
        drawError(20, "Duplicate input number, please try again.", x, y);
    }
}