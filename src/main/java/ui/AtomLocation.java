/**
 * Class for storing pairs of x and y coordinates of atoms
 */

package main.java.ui;

public class AtomLocation {
    private int x;
    private int y;

    public AtomLocation(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

}

