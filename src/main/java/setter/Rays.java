package main.java.setter;
import processing.core.*;
import java.awt.*;

/**
 * The Rays class handles all rays being shot and displayed during the game
 */

public class Rays {

    static PApplet parent;

    public Rays(PApplet parent) {
        Rays.parent = parent;
    }

    // Start and end coordinates of rays and direction they move in
    public static int[][] rayPositions = {
            {215, 75, 215, 75, 1}, // 1
            {200, 99, 200, 99, 3}, // 2
            {184, 125, 184, 125, 1}, // 3
            {170, 149, 170, 149, 3}, // 4
            {154, 175, 154, 175, 1}, // 5
            {140, 199, 140, 199, 3}, // 6
            {124, 225, 124, 225, 1}, // 7
            {110, 249, 110, 249, 3}, // 8
            {95, 274, 95, 274, 1}, // 9
            {80, 299, 80, 299, 3}, // 10
            {94, 324, 94, 324, 5}, // 11
            {110, 349, 110, 349, 3}, // 12
            {124, 374, 124, 374, 5}, // 13
            {140, 399, 140, 399, 3}, // 14
            {154, 424, 154, 424, 5}, // 15
            {170, 449, 170, 449, 3}, // 16
            {184, 474, 184, 474, 5}, // 17
            {200, 499, 200, 499, 3}, // 18
            {214, 524, 214, 524, 5}, // 19
            {246, 524, 246, 524, 6}, // 20
            {274, 524, 274, 524, 5}, // 21
            {306, 524, 305, 525, 6}, // 22
            {334, 524, 334, 524, 5}, // 23
            {366, 524, 366, 525, 6}, // 24
            {394, 524, 394, 524, 5}, // 25
            {426, 524, 424, 525, 6}, // 26
            {454, 524, 454, 524, 5}, // 27
            {486, 523, 486, 523, 6}, // 28
            {500, 500, 500, 500, 4}, // 29
            {515, 474, 515, 474, 6}, // 30
            {530, 450, 530, 450, 4}, // 31
            {544, 425, 544, 425, 6}, // 32
            {560, 400, 560, 400, 4}, // 33
            {574, 375, 574, 375, 6}, // 34
            {590, 350, 590, 350, 4}, // 35
            {604, 325, 604, 325, 6}, // 36
            {620, 300, 620, 300, 4}, // 37
            {604, 274, 604, 274, 2}, // 38
            {590, 250, 590, 250, 4}, // 39
            {574, 224, 574, 224, 2}, // 40
            {560, 200, 560, 200, 4}, // 41
            {543, 174, 543, 174, 2}, // 42
            {530, 150, 530, 150, 4}, // 43
            {513, 124, 513, 124, 2}, // 44
            {500, 100, 500, 100, 4}, // 45
            {484, 74, 484, 74, 2}, // 46
            {453, 76, 453, 76, 1}, // 47
            {423, 74, 423, 74, 2}, // 48
            {393, 76, 393, 76, 1}, // 49
            {363, 74, 363, 74, 2}, // 50
            {332, 76, 332, 76, 1}, // 51
            {304, 74, 304, 74, 2}, // 52
            {273, 75, 273, 75, 1}, // 53
            {244, 74, 244, 74, 2}, // 54
    };


    public static Point[] downAndRightExits = {
            new Point(485, 525), // 28
            new Point(425, 525), // 26
            new Point(365, 525), // 24
            new Point(305, 525), // 22
            new Point(245, 525), // 20
            new Point(605, 325), // 36
            new Point(575, 375), // 34
            new Point(545, 425), // 32
            new Point(515, 475) // 30
    };

    public static Point[] downAndLeftExits = {
            new Point(455, 525), // 27
            new Point(395, 525), // 25
            new Point(335, 525), // 23
            new Point(275, 525), // 21
            new Point(215, 525), // 19
            new Point(185, 475), // 17
            new Point(155, 425), // 15
            new Point(125, 375), // 13
            new Point(95, 325) // 11
    };

    public static Point[] rightExits = {
            new Point(500, 100), // 45
            new Point(530, 150), // 43
            new Point(560, 200), // 41
            new Point(590, 250), // 39
            new Point(620, 300), // 37
            new Point(590, 350), // 35
            new Point(560, 400), // 33
            new Point(530, 450), // 31
            new Point(500, 500) // 29
    };

    public static Point[] leftExits = {
            new Point(200, 500), // 18
            new Point(170, 450), // 16
            new Point(140, 400), // 14
            new Point(110, 350), // 12
            new Point(80, 300), // 10
            new Point(110, 250), // 8
            new Point(140, 200), // 6
            new Point(170, 150), // 4
            new Point(200, 100) // 2
    };

    public static Point[] upAndRightExits = {
            new Point(245, 75), // 54
            new Point(305, 75), // 52
            new Point(365, 75), // 50
            new Point(425, 75), // 48
            new Point(485, 75), // 46
            new Point(515, 125), // 44
            new Point(545, 175), // 42
            new Point(575, 225), // 40
            new Point(605, 275) // 38
    };

    public static Point[] upAndLeftExits = {
            new Point(95, 275), // 9
            new Point(125, 225), // 7
            new Point(155, 175), // 5
            new Point(185, 125), // 3
            new Point(215, 75), // 1
            new Point(275, 75), // 53
            new Point(335, 75), // 51
            new Point(395, 75), // 49
            new Point(455, 75) // 47
    };

    private static final Point[][] exits = {
            downAndRightExits,
            downAndLeftExits,
            rightExits,
            leftExits,
            upAndRightExits,
            upAndLeftExits
    };

    // INCREMENTS TO MOVE FROM ONE HEXAGON TO THE NEXT ALONG LINES
    public static int[][] incrementsAlongLine = {
            {30, 50}, // Down and right
            {-30, 50}, // Down and left
            {60, 0}, // Right
            {-60, 0}, // Left
            {30, -50}, // Up and right
            {-30, -50} // Up and left
    };

    // ANGLES OF RAYS
    private final static float[] angles = {
            PApplet.radians((float) 58.8), // Down and right
            PApplet.radians((float) 120.8), // Down and left
            PApplet.radians((float) 0), // Right
            PApplet.radians((float) 180), // Left
            PApplet.radians((float) 300.8), // Up and right
            PApplet.radians((float) 238.8), // Up and left
    };

    static int[][] atomPositions;
    static int numOfAtoms;


    /**
     * Finds the exit point along the line of a ray should it not deflect
     * @param start      Coordinates of start of the line
     * @param direction  Direction the ray is moving in
     * @return           Coordinates of the ray's exit
     **/

    public static Point setExit(Point start, int direction) {
        Point exit = new Point(0,0);
        Point[] exitsInDirection = exits[direction - 1];
        float[] testCoords = new float[]{start.x, start.y};

        while (true) {
            boolean exitSet = false;
            // CHECK IF TEST COORDS HAVE REACHED ANY EXIT IN ARRAY
            for (Point exitInDirection : exitsInDirection) {
                // IF COORDS REACH EXIT
                if (PApplet.dist(testCoords[0], testCoords[1], exitInDirection.x, exitInDirection.y) < 15) {
                    exit = exitInDirection; // Set exit coordinates

                    exitSet = true;
                    break;
                }
            }
            if (exitSet) {
                break;
            }
            // MOVE TEST COORDINATES TO NEXT POINT ALONG LINE
            testCoords[0] += ((float) incrementsAlongLine[direction - 1][0] / 2);
            testCoords[1] += ((float) incrementsAlongLine[direction - 1][1] / 2);

            // IF TEST COORDS GO OFF-SCREEN, ERROR (NO EXIT FOUND)
            if (testCoords[0] < 0 || testCoords[0] > parent.width
                    || testCoords[1] > parent.height || testCoords[1] < 0) {
                System.out.println("NO EXIT FOUND");
            }
        }
        return exit;
    }


    /**
     * Calculates coordinates at the end of a line of a ray
     * @param start         Coordinates of start of the line
     * @param angle         Angle at which the ray should point
     * @param lineLength    Length of the line of the ray
     * @return              Coordinates at the end of a line of a ray
     */
    private static Point calculateEndCoordinates(Point start, float angle, float lineLength) {
        return new Point((int) (start.x + PApplet.cos(angle) * lineLength),
                (int) (start.y + PApplet.sin(angle) * lineLength));
    }


    /**
     * Draws rays and calculates exit coordinates of ray drawn
     * @param start         Coordinates of the start of the line
     * @param angle         Angle at which the ray should point
     * @param lineLength    Length of the line of the ray
     * @param displayRay    Whether ray should be drawn or just end points calculated
     * @return              End coordinates of ray
     */
    private static Point drawRayAndReturnEndCoords(Point start, float angle, float lineLength, boolean displayRay) {
        parent.stroke(0, 255, 0); // Colour of rays
        parent.strokeWeight(3);

        Point endCoordinates = calculateEndCoordinates(start, angle, lineLength);
        if (displayRay) {
            parent.line((float) start.getX(), (float) start.getY(), endCoordinates.x, endCoordinates.y);
        }

        return endCoordinates;
    }

    /**
     * Sets the values of atomPositions
     * @param positionsOfAtoms      Passed in atom positions array
     */
    public static void setAtomPositions(int[][] positionsOfAtoms) {
        atomPositions = positionsOfAtoms;
        numOfAtoms = atomPositions.length;
    }



    /**
     * Recursively draws rays, checking for bounces
     * @param start         Coordinates of the start of the line
     * @param direction     Direction the ray is moving in
     * @param firstRay      Whether it is the first ray being drawn (or recursive call)
     * @param displayRays   Whether the ray should be displayed
     * @return              End coordinates of ray
     */
    public static Point drawRayWithBounces(Point start, int direction, boolean firstRay, boolean displayRays) {
        Point coordinatesOfCircleOfInfluence = new Point(0, 0);
        int numOfCirclesOfInfluence = 0;

        // CHECK FOR STARTING INSIDE AN ATOM
        for (int[] atomPosition : atomPositions) {
            if (checkForStartingInsideAtom(start, atomPosition) && firstRay) { // STARTS INSIDE AN ATOM
                return returnStartingInsideAtom(start, direction, atomPosition, displayRays);
            }
        }
        // Starting position is half distance to next centre point -> Move back half
        Point testCoords = new Point(start);
        decrementCoordinatesHalfAPosition(testCoords, direction, firstRay);
        int[] atomsHit = new int[6];

        while (checkIfNextCoordinatesOnScreen(testCoords, direction) && numOfCirclesOfInfluence == 0) {
            incrementCoordinatesOnePosition(testCoords, direction);

            // CHECK IF ANY CIRCLES OF INFLUENCE HIT - IF SO STORE THEM AND THE COORDINATES OF THE TEST COORDINATES
            for (int i = 0; i < numOfAtoms; i++) {
                if (PApplet.dist(testCoords.x, testCoords.y, atomPositions[i][0], atomPositions[i][1]) <= 65) {
                    atomsHit[numOfCirclesOfInfluence] = i;
                    numOfCirclesOfInfluence++;
                    coordinatesOfCircleOfInfluence = testCoords;
                }
            }
            if (numOfCirclesOfInfluence > 0) {
                return displayAndRecursiveCallsForCircleOfInfluence(numOfCirclesOfInfluence, start, testCoords,
                        direction, coordinatesOfCircleOfInfluence, atomsHit, displayRays);
            }
        }
        return displayAndReturnForNoCollisions(start, direction, displayRays);
    }

    /**
     * Display all rays on screen
     * @param numOfRays     How many rays user has shot
     * @param shots         Positions on grid that have been shot from
     */
    public void displayRays(int numOfRays, int[] shots) {
        for (int i = 0; i < numOfRays; i++) {
            int rayNumInList = shots[i] - 1;

            int direction = Rays.rayPositions[rayNumInList][4];
            Point start = new Point(Rays.rayPositions[rayNumInList][0], Rays.rayPositions[rayNumInList][1]);
            drawRayWithBounces(start, direction, true, true);
        }
    }

    /**
     * Moves coordinates to centre of next hexagon along the ray
     * @param coordinates   Starting coordinates of position along the ray
     * @param direction     Direction the ray is moving in
     */
    public static void incrementCoordinatesOnePosition(Point coordinates, int direction) {
        coordinates.x += incrementsAlongLine[direction-1][0];
        coordinates.y += incrementsAlongLine[direction-1][1];
    }

    /**
     * Checks if a ray starts within a circle of influence
     * @param start         Coordinates of the start of the line
     * @param atomPosition  Coordinates of the atom being checked
     * @return              Whether the ray starts inside the atom's circle of influence
     */
    private static boolean checkForStartingInsideAtom(Point start, int[] atomPosition) {
        return PApplet.dist(start.x, start.y, atomPosition[0], atomPosition[1]) < 59;
    }

    /**
     * Checks if a ray will be a direct hit from the circle of influence
     * @param start                 Start coordinates of the ray
     * @param direction             Direction in which the ray is moving
     * @param atomPosition          Coordinates of the atom being checked
     * @param startingInsideAtom    Whether the ray starts inside an atom
     * @return                      Whether the ray will go on to be a direct hit
     */
    private static boolean checkForDirectHit(Point start, int direction,
                                             int[] atomPosition, boolean startingInsideAtom) {
        if (startingInsideAtom) {
            return PApplet.dist((start.x + ((float) incrementsAlongLine[direction - 1][0] / 2)),
                    (start.y + ((float) incrementsAlongLine[direction - 1][1] / 2)),
                    atomPosition[0], atomPosition[1]) < 5;
        }
        else {
            return PApplet.dist(start.x + incrementsAlongLine[direction-1][0],
                    start.y + incrementsAlongLine[direction-1][1],
                    atomPosition[0], atomPosition[1]) < 5;
        }
    }

    /**
     * Displays a direct hit
     * @param start         Coordinates of start of the line
     * @param atomPosition  Coordinates of the atom being checked
     * @param direction     Direction in which the ray is moving
     * @param displayRays   Whether the ray should be displayed
     */
    private static void drawDirectHit(Point start, int[] atomPosition, int direction, boolean displayRays) {
        float distance = PApplet.dist(atomPosition[0], atomPosition[1],
                (float) start.getX(), (float) start.getY());
        drawRayAndReturnEndCoords(start, angles[direction - 1], distance, displayRays);
    }

    /**
     * Returns coordinates for a direct hit
     * @return      (-1,-1) which signifies a direct hit
     */
    private static Point returnDirectHit() {
        return new Point(-1, -1);
    }

    /**
     * Returns coordinates for a reflected hit
     * @return      (-2,-2) which signifies a reflected ray
     */
    private static Point returnReflected() {
        return new Point(-2, -2);
    }

    /**
     * Returns value for starting inside an atom
     * @param start         Coordinates of start of the line
     * @param direction     Direction in which the ray is moving
     * @param atomPosition  Coordinates of atom being checked
     * @param displayRays   Whether the ray should be displayed
     * @return              Returns direct hit or reflected values
     */
    private static Point returnStartingInsideAtom(Point start, int direction,
                                                  int[] atomPosition, boolean displayRays) {
        if (checkForDirectHit(start, direction, atomPosition, true)) {
            drawDirectHit(start, atomPosition, direction, displayRays);
            return returnDirectHit();
        }

        // OTHERWISE REFLECT
        return returnReflected();
    }

    /**
     *  Moves coordinates back along line half the distance to next hexagon centre
     * @param testCoords    Coordinates to be incremented
     * @param direction     Direction in which the ray is moving
     * @param firstRay      Whether it is the first ray being drawn (or recursive call)
     */
    private static void decrementCoordinatesHalfAPosition(Point testCoords, int direction, boolean firstRay) {
        if (firstRay) {
            testCoords.x -= (incrementsAlongLine[direction - 1][0] / 2);
            testCoords.y -= (incrementsAlongLine[direction - 1][1] / 2);
        }
    }

    /**
     * Checks if the next hexagon centre coordinate along ray is on the screen
     * @param coordinates   Current coordinates along line of ray
     * @param direction     Direction the ray is moving in
     * @return              If the next hexagon centre coordinate along ray is on the screen
     */
    private static boolean checkIfNextCoordinatesOnScreen(Point coordinates, int direction) {
        int incrementX = incrementsAlongLine[direction - 1][0];
        int incrementY = incrementsAlongLine[direction - 1][1];

        return (coordinates.x + incrementX) < parent.width
                && (coordinates.x + incrementX) > 0
                && (coordinates.y + incrementY) < parent.height
                && (coordinates.y + incrementY) > 0;
    }



    // ONE CIRCLE OF INFLUENCE -----------------------------------------------------------------------------------------

    /**
     * Checks if a ray hitting one circle of influence
     * hit the right side of the circle
     * @param coordinatesOfCircleOfInfluence    Coordinates at which a circle of influence was detected along ray
     * @param atomsHit                          List of coordinates of atoms whose circles of influence were hit by the ray
     * @return      If a ray hitting one circle of influence hit the right side of the circle
     */
    private static boolean checkIfHitsRightSideOfCircle(Point coordinatesOfCircleOfInfluence, int[] atomsHit) {
        return coordinatesOfCircleOfInfluence.x > atomPositions[atomsHit[0]][0];
    }

    /**
     * Calls recursive calls for a diagonal ray which
     * hits the right side of the circle of influence
     * @param direction                         Direction the ray is moving in
     * @param coordinatesOfCircleOfInfluence    Coordinates at which a circle of influence was detected along ray
     * @param displayRays                       Whether ray should be drawn or just end points calculated
     * @return      Recursive call for a diagonal ray which hits the right side of the circle of influence
     */
    private static Point diagonalRaysHitRightSideOfCircleRecursiveCalls(int direction,
                                                                        Point coordinatesOfCircleOfInfluence,
                                                                        boolean displayRays) {
        return switch (direction) {
            case 1, 5 -> drawRayWithBounces(coordinatesOfCircleOfInfluence, 3, false, displayRays);
            case 2 -> drawRayWithBounces(coordinatesOfCircleOfInfluence, 1, false, displayRays);
            case 6 -> drawRayWithBounces(coordinatesOfCircleOfInfluence, 5, false, displayRays);
            default -> new Point(0, 0); // ERROR
        };
    }

    /**
     * Calls recursive calls for a diagonal ray which
     * hits the left side of the circle of influence
     * @param direction                         Direction the ray is moving in
     * @param coordinatesOfCircleOfInfluence    Coordinates at which a circle of influence was detected along ray
     * @param displayRays                       Whether ray should be drawn or just end points calculated
     * @return      Recursive call for a diagonal ray which hits the left side of the circle of influence
     */
    private static Point diagonalRaysHitLeftSideOfCircleRecursiveCalls(int direction,
                                                                       Point coordinatesOfCircleOfInfluence,
                                                                       boolean displayRays) {
        return switch (direction) {
            case 1 -> drawRayWithBounces(coordinatesOfCircleOfInfluence, 2, false, displayRays);
            case 2, 6 -> drawRayWithBounces(coordinatesOfCircleOfInfluence, 4, false, displayRays);
            case 5 -> drawRayWithBounces(coordinatesOfCircleOfInfluence, 6, false, displayRays);
            default -> new Point(0, 0); // ERROR
        };
    }

    /**
     * Checks if a ray hitting one circle of influence
     * hit the bottom half of the circle
     * @param coordinatesOfCircleOfInfluence    Coordinates at which a circle of influence was detected along ray
     * @param atomsHit                          List of coordinates of atoms whose circles of influence were hit by the ray
     * @return      If a ray hitting one circle of influence hit the bottom half of the circle
     */
    private static boolean checkIfHitsBottomHalfOfCircle(Point coordinatesOfCircleOfInfluence, int[] atomsHit) {
        return coordinatesOfCircleOfInfluence.y > atomPositions[atomsHit[0]][1];
    }

    /**
     * Calls recursive calls for a diagonal ray which
     * hits the bottom half of the circle of influence
     * @param direction                         Direction the ray is moving in
     * @param coordinatesOfCircleOfInfluence    Coordinates at which a circle of influence was detected along ray
     * @param displayRays                       Whether ray should be drawn or just end points calculated
     * @return      Recursive call for a diagonal ray which hits the bottom half of the circle of influence
     */
    private static Point diagonalRaysHitBottomHalfOfCircleRecursiveCalls(int direction,
                                                                         Point coordinatesOfCircleOfInfluence,
                                                                         boolean displayRays) {
        return switch (direction) {
            case 3 -> drawRayWithBounces(coordinatesOfCircleOfInfluence, 1, false, displayRays);
            case 4 -> drawRayWithBounces(coordinatesOfCircleOfInfluence, 2, false, displayRays);
            default -> new Point(0, 0); // ERROR
        };
    }

    /**
     * Calls recursive calls for a diagonal ray which
     * hits the top half of the circle of influence
     * @param direction                         Direction the ray is moving in
     * @param coordinatesOfCircleOfInfluence    Coordinates at which a circle of influence was detected along ray
     * @param displayRays                       Whether ray should be drawn or just end points calculated
     * @return      Recursive call for a diagonal ray which hits the top half of the circle of influence
     */
    private static Point diagonalRaysHitTopHalfOfCircleRecursiveCalls(int direction,
                                                                      Point coordinatesOfCircleOfInfluence,
                                                                      boolean displayRays) {
        return switch (direction) {
            case 3 -> drawRayWithBounces(coordinatesOfCircleOfInfluence, 5, false, displayRays);
            case 4 -> drawRayWithBounces(coordinatesOfCircleOfInfluence, 6, false, displayRays);
            default -> new Point(0, 0); // ERROR
        };
    }

    /**
     * Calls recursive calls for a diagonal ray which
     * hits one circle of influence
     * @param coordinatesOfCircleOfInfluence    Coordinates at which a circle of influence was detected along ray
     * @param atomsHit                          List of coordinates of atoms whose circles of influence were hit by the ray
     * @param direction                         Direction the ray is moving in
     * @param displayRays                       Whether ray should be drawn or just end points calculated
     * @return      Recursive call for a diagonal ray which hits one circle of influence
     */
    private static Point diagonalRaysRecursiveCallsOneCircle(Point coordinatesOfCircleOfInfluence, int[] atomsHit,
                                                             int direction, boolean displayRays) {
        if (checkIfHitsRightSideOfCircle(coordinatesOfCircleOfInfluence, atomsHit)) {
            return diagonalRaysHitRightSideOfCircleRecursiveCalls(direction,
                    coordinatesOfCircleOfInfluence, displayRays);
        }
        else {
            return diagonalRaysHitLeftSideOfCircleRecursiveCalls(direction,
                    coordinatesOfCircleOfInfluence, displayRays);
        }
    }

    /**
     * Calls recursive calls for a horizontal ray which hits one circle of influence
     * @param coordinatesOfCircleOfInfluence    Coordinates at which a circle of influence was detected along ray
     * @param atomsHit                          List of coordinates of atoms whose circles of influence were hit by the ray
     * @param direction                         Direction the ray is moving in
     * @param displayRays                       Whether ray should be drawn or just end points calculated
     * @return      Recursive call for a horizontal ray which hits one circle of influence
     */
    private static Point horizontalRaysRecursiveCallsOneCircle(Point coordinatesOfCircleOfInfluence, int[] atomsHit,
                                                               int direction, boolean displayRays) {
        if (checkIfHitsBottomHalfOfCircle(coordinatesOfCircleOfInfluence, atomsHit)) {
            return diagonalRaysHitBottomHalfOfCircleRecursiveCalls(direction,
                    coordinatesOfCircleOfInfluence, displayRays);
        }
        else {
            return diagonalRaysHitTopHalfOfCircleRecursiveCalls(direction,
                    coordinatesOfCircleOfInfluence, displayRays);
        }
    }

    /**
     * Calls recursive calls for a ray which hits one circle of influence
     * @param direction                         Direction the ray is moving in
     * @param coordinatesOfCircleOfInfluence    Coordinates at which a circle of influence was detected along ray
     * @param atomsHit                          List of coordinates of atoms whose circles of influence were hit by the ray
     * @param displayRays                       Whether ray should be drawn or just end points calculated
     * @return      Recursive call for a ray which hits one circle of influence
     */
    private static Point oneCircleOfInfluenceRecursiveCalls(int direction, Point coordinatesOfCircleOfInfluence,
                                                            int[] atomsHit, boolean displayRays) {
        return switch (direction) {
            case 1, 2, 5, 6 -> // Diagonals
                    diagonalRaysRecursiveCallsOneCircle(coordinatesOfCircleOfInfluence,
                            atomsHit, direction, displayRays);
            case 3, 4 -> // Horizontals
                    horizontalRaysRecursiveCallsOneCircle(coordinatesOfCircleOfInfluence,
                            atomsHit, direction, displayRays);
            default -> new Point(0, 0);
        };
    }

    /**
     * Displays rays and calls recursive calls for a ray
     * which hits one circle of influence
     * @param start                             Coordinates of start of the line
     * @param coordinatesOfCircleOfInfluence    Coordinates at which a circle of influence was detected along ray
     * @param direction                         Direction the ray is moving in
     * @param atomsHit                          List of coordinates of atoms whose circles of influence were hit by the ray
     * @param displayRays                       Whether ray should be drawn or just end points calculated
     * @return      Recursive call for a ray which hits one circle of influence
     */
    private static Point displayAndRecursiveCallsForOneCircleOfInfluence(Point start,
                                                                         Point coordinatesOfCircleOfInfluence,
                                                                         int direction, int[] atomsHit,
                                                                         boolean displayRays) {
        float distance = PApplet.dist(coordinatesOfCircleOfInfluence.x, coordinatesOfCircleOfInfluence.y,
                start.x, start.y);
        drawRayAndReturnEndCoords(start, angles[direction - 1], distance, displayRays);

        return oneCircleOfInfluenceRecursiveCalls(direction, coordinatesOfCircleOfInfluence, atomsHit, displayRays);
    }

    /**
     * Displays rays and returns exit coordinates
     * for a ray which hits one circle of influence
     * @param start                             Coordinates of start of the line
     * @param testCoords                        Coordinates at position being checked along line
     * @param direction                         Direction the ray is moving in
     * @param coordinatesOfCircleOfInfluence    Coordinates at which a circle of influence was detected along ray
     * @param atomsHit                          List of coordinates of atoms whose circles of influence were hit by the ray
     * @param displayRays                       Whether ray should be drawn or just end points calculated
     * @return                                  Exit coordinates for a ray which hits one circle of influence
     */
    private static Point displayAndReturnForOneCircleOfInfluence(Point start, Point testCoords,
                                                                 int direction, Point coordinatesOfCircleOfInfluence,
                                                                 int[] atomsHit, boolean displayRays) {
        // CHECK FOR DIRECT HIT
        for (int[] atomPosition : atomPositions) {
            if (checkForDirectHit(testCoords, direction, atomPosition, false)) {
                drawDirectHit(start, atomPosition, direction, displayRays);
                return returnDirectHit();
            }
        }
        return displayAndRecursiveCallsForOneCircleOfInfluence(start, coordinatesOfCircleOfInfluence,
                direction, atomsHit, displayRays);
    }

    // MULTIPLE CIRCLES OF INFLUENCE -----------------------------------------------------------------------------------

    /**
     * Checks if one of the circles of influence
     * is higher up than the others
     * @param atomsHit                  List of coordinates of atoms whose circles of influence were hit by the ray
     * @param numOfCirclesOfInfluence   How many circles of influence were found at the coordinates
     * @return      Whether one of the circles of influence is higher up than the others
     */
    private static boolean checkIfOneCircleAboveOther(int[] atomsHit, int numOfCirclesOfInfluence) {
        int y = atomPositions[atomsHit[0]][1];
        for (int i = 1; i < numOfCirclesOfInfluence; i++) {
            if (y != atomPositions[atomsHit[i]][1]) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if any of the circles of influence
     * are vertically aligned
     * @param atomsHit                  List of coordinates of atoms whose circles of influence were hit by the ray
     * @param numOfCirclesOfInfluence   How many circles of influence were found at the coordinates
     * @return      If any of the circles of influence are vertically aligned
     */
    private static boolean checkIfVerticallyAligned(int[] atomsHit, int numOfCirclesOfInfluence) {
        for (int i = 0; i < numOfCirclesOfInfluence; i++) {
            for (int j = i + 1; j < numOfCirclesOfInfluence; j++) {
                if (atomPositions[atomsHit[i]][0] == atomPositions[atomsHit[j]][0]) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Calls recursive calls for a horizontal ray
     * with vertically aligned circles of influence
     * @param direction                         Direction the ray is moving in
     * @param coordinatesOfCircleOfInfluence    Coordinates at which a circle of influence was detected along ray
     * @param displayRays                       Whether ray should be drawn or just end points calculated
     * @return      Recursive call for a horizontal ray with vertically aligned circles of influence
     */
    private static Point horizontalRaysVerticallyAlignedRecursiveCalls(int direction,
                                                                       Point coordinatesOfCircleOfInfluence,
                                                                       boolean displayRays) {
        return switch (direction) {
            case 3 -> drawRayWithBounces(coordinatesOfCircleOfInfluence, 4, false, displayRays);
            case 4 -> drawRayWithBounces(coordinatesOfCircleOfInfluence, 3, false, displayRays);
            default -> new Point(0, 0); // ERROR
        };
    }

    /**
     * Checks if the top circle of influence is
     * further right than the bottom
     * @param atomsHit      List of coordinates of atoms whose circles of influence were hit by the ray
     * @return      If the top circle of influence is further right than the bottom
     */
    private static boolean checkIfTopCircleFurtherRightThanBottom(int[] atomsHit) {
        return atomPositions[atomsHit[0]][0] > atomPositions[atomsHit[1]][0];
    }

    /**
     * Calls recursive calls for horizontal rays
     * if top circle is further right than bottom
     * @param direction                         Direction the ray is moving in
     * @param coordinatesOfCircleOfInfluence    Coordinates at which a circle of influence was detected along ray
     * @param displayRays                       Whether ray should be drawn or just end points calculated
     * @return      Recursive call for horizontal rays if top circle is further right than bottom
     */
    private static Point horizontalRaysTopCircleFurtherRightRecursiveCalls(int direction,
                                                                           Point coordinatesOfCircleOfInfluence,
                                                                           boolean displayRays) {
        return switch (direction) {
            case 3 -> drawRayWithBounces(coordinatesOfCircleOfInfluence, 6, false, displayRays);
            case 4 -> drawRayWithBounces(coordinatesOfCircleOfInfluence, 1, false, displayRays);
            default -> new Point(0, 0); // ERROR
        };
    }

    /**
     * Calls recursive calls for horizontal rays
     * if top circle is further left than bottom
     * @param direction                         Direction the ray is moving in
     * @param coordinatesOfCircleOfInfluence    Coordinates at which a circle of influence was detected along ray
     * @param displayRays                       Whether ray should be drawn or just end points calculated
     * @return      Recursive call for horizontal rays if top circle is further left than bottom
     */
    private static Point horizontalRaysTopCircleFurtherLeftRecursiveCalls(int direction,
                                                                          Point coordinatesOfCircleOfInfluence,
                                                                          boolean displayRays) {
        return switch (direction) {
            case 3 -> drawRayWithBounces(coordinatesOfCircleOfInfluence, 2, false, displayRays);
            case 4 -> drawRayWithBounces(coordinatesOfCircleOfInfluence, 5, false, displayRays);
            default -> new Point(0, 0); // ERROR
        };
    }

    /**
     * Calls recursive calls for horizontal rays
     * if circles are beside each other
     * @param direction                         Direction the ray is moving in
     * @param atomsHit                          List of coordinates of atoms whose circles of influence were hit by the ray
     * @param coordinatesOfCircleOfInfluence    Coordinates at which a circle of influence was detected along ray
     * @param displayRays                       Whether ray should be drawn or just end points calculated
     * @return      Recursive call for horizontal rays if circles are beside each other
     */
    private static Point horizontalRaysMultipleCirclesBesideEachOtherRecursiveCalls(int direction, int[] atomsHit,
                                                                                    Point coordinatesOfCircleOfInfluence,
                                                                                    boolean displayRays) {
        if (checkIfTopCircleFurtherRightThanBottom(atomsHit)) { // Top further right than bottom
            return horizontalRaysTopCircleFurtherRightRecursiveCalls(direction,
                    coordinatesOfCircleOfInfluence, displayRays);
        }
        else { // Top further left than bottom
            return horizontalRaysTopCircleFurtherLeftRecursiveCalls(direction,
                    coordinatesOfCircleOfInfluence, displayRays);
        }
    }

    /**
     * Calls recursive calls for horizontal rays with multiple circles of influence
     * @param direction                         Direction the ray is moving in
     * @param coordinatesOfCircleOfInfluence    Coordinates at which a circle of influence was detected along ray
     * @param atomsHit                          List of coordinates of atoms whose circles of influence were hit by the ray
     * @param numOfCirclesOfInfluence           How many circles of influence were found at the coordinates
     * @param displayRays                       Whether ray should be drawn or just end points calculated
     * @return      Recursive call for horizontal rays with multiple circles of influence
     */
    private static Point horizontalRaysRecursiveCallsMultipleCircles(int direction,
                                                                     Point coordinatesOfCircleOfInfluence,
                                                                     int[] atomsHit, int numOfCirclesOfInfluence,
                                                                     boolean displayRays) {
        boolean verticallyAligned = checkIfVerticallyAligned(atomsHit, numOfCirclesOfInfluence);

        if (verticallyAligned) { // ONE ABOVE THE OTHER
            return horizontalRaysVerticallyAlignedRecursiveCalls(direction,
                    coordinatesOfCircleOfInfluence, displayRays);
        }
        else { // BESIDE - CAN ONLY BE 2 CIRCLES OF INFLUENCE
            return horizontalRaysMultipleCirclesBesideEachOtherRecursiveCalls(direction, atomsHit,
                    coordinatesOfCircleOfInfluence, displayRays);
        }
    }

    /**
     * Checks whether a diagonal ray meeting multiple
     * circles of influence should reflect
     * @param atomsHit          List of coordinates of atoms whose circles of influence were hit by the ray
     * @return      Whether ray should reflect
     */
    private static boolean checkIfDiagonalRayShouldReflectMultipleCircles(int[] atomsHit) {
        return !(PApplet.dist(atomPositions[atomsHit[0]][0],
                atomPositions[atomsHit[0]][1],
                atomPositions[atomsHit[1]][0],
                atomPositions[atomsHit[1]][1]) <= 60);
    }

    /**
     * Calls recursive calls for diagonal ray if it should reflect
     * @param direction                         Direction the ray is moving in
     * @param coordinatesOfCircleOfInfluence    Coordinates at which a circle of influence was detected along ray
     * @param displayRays                       Whether ray should be drawn or just end points calculated
     * @return      Recursive call for diagonal ray if it should reflect
     */
    private static Point diagonalRaysReflectRecursiveCalls(int direction,
                                                           Point coordinatesOfCircleOfInfluence,
                                                           boolean displayRays) {
        return switch (direction) {
            case 1 -> drawRayWithBounces(coordinatesOfCircleOfInfluence, 6, false, displayRays);
            case 2 -> drawRayWithBounces(coordinatesOfCircleOfInfluence, 5, false, displayRays);
            case 5 -> drawRayWithBounces(coordinatesOfCircleOfInfluence, 2, false, displayRays);
            case 6 -> drawRayWithBounces(coordinatesOfCircleOfInfluence, 1, false, displayRays);
            default -> new Point(0, 0); // ERROR
        };
    }

    /**
     * Calls recursive calls for diagonal rays meeting
     * multiple circles of influence bouncing with one circle above the other
     * @param direction                         Direction the ray is moving in
     * @param coordinatesOfCircleOfInfluence    Coordinates at which a circle of influence was detected along ray
     * @param displayRays                       Whether ray should be drawn or just end points calculated
     * @return      Recursive call for diagonal rays meeting multiple circles of influence bouncing with one circle above the other
     */
    private static Point diagonalRaysOneCircleAboveOtherBounceRecursiveCalls(int direction,
                                                                             Point coordinatesOfCircleOfInfluence,
                                                                             boolean displayRays) {
        return switch (direction) {
            case 1, 5 -> drawRayWithBounces(coordinatesOfCircleOfInfluence, 4, false, displayRays);
            case 2, 6 -> drawRayWithBounces(coordinatesOfCircleOfInfluence, 3, false, displayRays);
            default -> new Point(0, 0); // ERROR
        };
    }

    /**
     * Calls recursive calls for diagonal rays meeting
     * multiple circles of influence with one circle above the other
     * @param atomsHit                          List of coordinates of atoms whose circles of influence were hit by the ray
     * @param direction                         Direction the ray is moving in
     * @param coordinatesOfCircleOfInfluence    Coordinates at which a circle of influence was detected along ray
     * @param displayRays                       Whether ray should be drawn or just end points calculated
     * @return
     */
    private static Point diagonalRaysOneCircleAboveOtherRecursiveCalls(int[] atomsHit, int direction,
                                                                       Point coordinatesOfCircleOfInfluence,
                                                                       boolean displayRays) {
        if (checkIfDiagonalRayShouldReflectMultipleCircles(atomsHit)) {
            return diagonalRaysReflectRecursiveCalls(direction, coordinatesOfCircleOfInfluence, displayRays);
        }
        else {
            return diagonalRaysOneCircleAboveOtherBounceRecursiveCalls(direction,
                    coordinatesOfCircleOfInfluence, displayRays);
        }
    }

    /**
     * Calls recursive calls for diagonal rays meeting
     * multiple circles of influence with one circle above the other
     * @param direction                         Direction the ray is moving in
     * @param coordinatesOfCircleOfInfluence    Coordinates at which a circle of influence was detected along ray
     * @param displayRays                       Whether ray should be drawn or just end points calculated
     * @return      Recursive call for diagonal rays meeting multiple circles of influence with one circle above the other
     */
    private static Point diagonalRaysCirclesBesideEachOtherRecursiveCalls(int direction,
                                                                          Point coordinatesOfCircleOfInfluence,
                                                                          boolean displayRays) {
        return switch (direction) {
            case 1 -> drawRayWithBounces(coordinatesOfCircleOfInfluence, 5, false, displayRays);
            case 2 -> drawRayWithBounces(coordinatesOfCircleOfInfluence, 6, false, displayRays);
            case 5 -> drawRayWithBounces(coordinatesOfCircleOfInfluence, 1, false, displayRays);
            case 6 -> drawRayWithBounces(coordinatesOfCircleOfInfluence, 2, false, displayRays);
            default -> new Point(0, 0);
        };
    }

    /**
     * Calls recursive calls for diagonal rays meeting multiple circles of influence
     * @param atomsHit                          List of coordinates of atoms whose circles of influence were hit by the ray
     * @param numOfCirclesOfInfluence           How many circles of influence were found at the coordinates
     * @param direction                         Direction the ray is moving in
     * @param coordinatesOfCircleOfInfluence    Coordinates at which a circle of influence was detected along ray
     * @param displayRays                       Whether ray should be drawn or just end points calculated
     * @return      Recursive call for diagonal rays meeting multiple circles of influence
     */
    private static Point diagonalRaysRecursiveCallsMultipleCircles(int[] atomsHit, int numOfCirclesOfInfluence,
                                                                   int direction,
                                                                   Point coordinatesOfCircleOfInfluence,
                                                                   boolean displayRays) {
        boolean oneCircleAboveOther = checkIfOneCircleAboveOther(atomsHit, numOfCirclesOfInfluence);

        if (oneCircleAboveOther) {
            return diagonalRaysOneCircleAboveOtherRecursiveCalls(atomsHit, direction,
                    coordinatesOfCircleOfInfluence, displayRays);
        }
        else {
            return diagonalRaysCirclesBesideEachOtherRecursiveCalls(direction,
                    coordinatesOfCircleOfInfluence, displayRays);
        }
    }

    /**
     * Calls recursive calls for rays meeting multiple circles of influence
     * @param direction                         Direction the ray is moving in
     * @param atomsHit                          List of coordinates of atoms whose circles of influence were hit by the ray
     * @param numOfCirclesOfInfluence           How many circles of influence were found at the coordinates
     * @param coordinatesOfCircleOfInfluence    Coordinates at which a circle of influence was detected along ray
     * @param displayRays                       Whether ray should be drawn or just end points calculated
     * @return      Recursive calls for rays meeting multiple circles of influence
     */
    private static Point multipleCirclesOfInfluenceRecursiveCalls(int direction, int[] atomsHit,
                                                                  int numOfCirclesOfInfluence,
                                                                  Point coordinatesOfCircleOfInfluence,
                                                                  boolean displayRays) {
        return switch (direction) {
            case 1, 2, 5, 6 -> // Diagonals
                    diagonalRaysRecursiveCallsMultipleCircles(atomsHit, numOfCirclesOfInfluence, direction,
                            coordinatesOfCircleOfInfluence, displayRays);
            case 3, 4 -> // Horizontals
                    horizontalRaysRecursiveCallsMultipleCircles(direction, coordinatesOfCircleOfInfluence, atomsHit,
                            numOfCirclesOfInfluence, displayRays);
            default -> new Point(0, 0); // ERROR
        };
    }

    /**
     * Draws rays and returns exit coordinates of
     * ray for multiple circles of influence
     * @param start                             Coordinates of start of the line
     * @param coordinatesOfCircleOfInfluence    Coordinates at which a circle of influence was detected along ray
     * @param direction                         Direction the ray is moving in
     * @param atomsHit                          List of coordinates of atoms whose circles of influence were hit by the ray
     * @param numOfCirclesOfInfluence           How many circles of influence were found at the coordinates
     * @param displayRays                       Whether ray should be drawn or just end points calculated
     * @return      Exit coordinates of ray for multiple circles of influence
     */
    private static Point displayAndReturnForMultipleCirclesOfInfluence(Point start,
                                                                       Point coordinatesOfCircleOfInfluence,
                                                                       int direction, int[] atomsHit,
                                                                       int numOfCirclesOfInfluence,
                                                                       boolean displayRays) {
        float distance = PApplet.dist(coordinatesOfCircleOfInfluence.x, coordinatesOfCircleOfInfluence.y,
                start.x, start.y);
        drawRayAndReturnEndCoords(start, angles[direction - 1], distance, displayRays);

        return multipleCirclesOfInfluenceRecursiveCalls(direction, atomsHit, numOfCirclesOfInfluence,
                coordinatesOfCircleOfInfluence, displayRays);
    }

    /**
     * Displays ray and returns exit coordinates
     * for a ray which does not deflect
     * @param start         Coordinates of start of the line
     * @param direction     Direction the ray is moving in
     * @param displayRays   Whether ray should be drawn or just end points calculated
     * @return      Exit coordinates for a ray which does not deflect
     */
    private static Point displayAndReturnForNoCollisions(Point start, int direction, boolean displayRays) {
        Point exit = setExit(start, direction);
        float distance = PApplet.dist(start.x, start.y, exit.x, exit.y);

        return drawRayAndReturnEndCoords(start, angles[direction - 1], distance, displayRays);
    }

    /**
     * Displays rays and calls recursive calls
     * for a ray which has hit 1+ circle(s) of influence
     * @param numOfCirclesOfInfluence           How many circles of influence were found at the coordinates
     * @param start                             Coordinates of start of the line
     * @param testCoords
     * @param direction                         Direction the ray is moving in
     * @param coordinatesOfCircleOfInfluence    Coordinates at which a circle of influence was detected along ray
     * @param atomsHit                          List of coordinates of atoms whose circles of influence were hit by the ray
     * @param displayRays                       Whether ray should be drawn or just end points calculated
     * @return      Recursive calls for a ray which has hit 1+ circle(s) of influence
     */
    private static Point displayAndRecursiveCallsForCircleOfInfluence(int numOfCirclesOfInfluence, Point start,
                                                                      Point testCoords, int direction,
                                                                      Point coordinatesOfCircleOfInfluence,
                                                                      int[] atomsHit, boolean displayRays) {
        if (numOfCirclesOfInfluence == 1) {
            return displayAndReturnForOneCircleOfInfluence(start, testCoords, direction, coordinatesOfCircleOfInfluence,
                    atomsHit, displayRays);
        }
        else if (numOfCirclesOfInfluence > 1) {
            return displayAndReturnForMultipleCirclesOfInfluence(start, coordinatesOfCircleOfInfluence, direction,
                    atomsHit, numOfCirclesOfInfluence, displayRays);
        }
        return new Point(0,0); // ERROR
    }
}