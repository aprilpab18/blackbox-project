package main.java.setter;
import main.java.ui.RayMarkers;
import processing.core.*;

import java.util.Arrays;

public class Rays {

    PApplet parent;

    public Rays(PApplet parent){
        this.parent = parent;
    }

    // START AND END COORDINATES OF RAYS AND DIRECTION THEY MOVE IN
    public static int[][] rayPositions = {
            {215, 75, 215, 75, 1}, // 1
            {200, 99, 200, 99, 3}, // 2
            {184, 125, 184, 125, 1}, // 3
            {170, 149, 170, 149, 3}, // 4
            {155, 175, 155, 175, 1}, // 5
            {140, 199, 140, 199, 3}, // 6
            {125, 225, 125, 225, 1}, // 7
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
            {483, 74, 483, 74, 2}, // 46
            {453, 76, 453, 76, 1}, // 47
            {423, 74, 423, 74, 2}, // 48
            {393, 76, 393, 76, 1}, // 49
            {363, 74, 363, 74, 2}, // 50
            {332, 76, 332, 76, 1}, // 51
            {304, 74, 304, 74, 2}, // 52
            {273, 75, 273, 75, 1}, // 53
            {244, 74, 244, 74, 2}, // 54
    };


    public static int[][] downAndRightExits = {
            {485, 525, 28}, // 28
            {425, 525, 26}, // 26
            {365, 525, 24}, // 24
            {305, 525, 22}, // 22
            {245, 525, 20}, // 20
            {605, 325, 36}, // 36
            {575, 375, 34}, // 34
            {545, 425, 32}, // 32
            {515, 475, 30}, // 30
    };

    public static int[][] downAndLeftExits = {
            {455, 525, 27}, // 27
            {395, 525, 25}, // 25
            {335, 525, 23}, // 23
            {275, 525, 21}, // 21
            {215, 525, 19}, // 19
            {185, 475, 17}, // 17
            {155, 425, 15}, // 15
            {125, 375, 13}, // 13
            {95, 325, 11}, // 11
    };

    public static int[][] rightExits = {
            {500, 100, 45}, // 45
            {530, 150, 43}, // 43
            {560, 200, 41}, // 41
            {590, 250, 39}, // 39
            {620, 300, 37}, // 37
            {590, 350, 35}, // 35
            {560, 400, 33}, // 33
            {530, 450, 31}, // 31
            {500, 500, 29}, // 29
    };

    public static int[][] leftExits = {
            {200, 500, 18}, // 18
            {170, 450, 16}, // 16
            {140, 400, 14}, // 14
            {110, 350, 12}, // 12
            {80, 300, 10}, // 10
            {110, 250, 8}, // 8
            {140, 200, 6}, // 6
            {170, 150, 4}, // 4
            {200, 100, 2}, // 2
    };

    public static int[][] upAndRightExits = {
            {245, 75, 54}, // 54
            {305, 75, 52}, // 52
            {365, 75, 50}, // 50
            {425, 75, 48}, // 48
            {485, 75, 46}, // 46
            {515, 125, 44}, // 44
            {545, 175, 42}, // 42
            {575, 225, 40}, // 40
            {605, 275, 38}, // 38
    };

    public static int[][] upAndLeftExits = {
            {95, 275, 9}, // 9
            {125, 225, 7}, // 7
            {155, 175, 5}, // 5
            {185, 125, 3}, // 3
            {215, 75, 1}, // 1
            {275, 75, 53}, // 53
            {335, 75, 51}, // 51
            {395, 75, 49}, // 49
            {455, 75, 47}, // 47
    };

    private static int[][][] exits = {
            downAndRightExits,
            downAndLeftExits,
            rightExits,
            leftExits,
            upAndRightExits,
            upAndLeftExits
    };


    // 1 = Down and right
    // 2 = Down and left
    // 3 = Right
    // 4 = Left
    // 5 = Up and right
    // 6 = Up and left


    // INCREMENTS TO MOVE FROM ONE HEXAGON TO THE NEXT ALONG LINES
    public static int[][] incrementsAlongLine = {
            {30, 50},
            {-30, 50},
            {60, 0},
            {-60, 0},
            {30, -50},
            {-30, -50}
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



    // FIND EXIT ON LINE OF RAY

    public static int[] setExit(float[] startCoords, int direction, PApplet sketch) {
        int[] exit = new int[] {0, 0, 0};
        int[][] exitsInDirection = exits[direction-1];
        float[] testCoords = startCoords;

        while (true) {
            boolean exitSet = false;

            // CHECK IF TEST COORDS HAVE REACHED ANY EXIT IN ARRAY
            for (int i = 0; i < exitsInDirection.length; i++) {
                if (sketch.dist(testCoords[0], testCoords[1], exitsInDirection[i][0], exitsInDirection[i][1]) < 15) { // IF COORDS REACH EXIT
                    exit = new int[]{exitsInDirection[i][0], exitsInDirection[i][1], exitsInDirection[i][2]}; // Set exit coordinates

                    exitSet = true;
                    break;
                }
            }

            if (exitSet) { // If exit found, exit infinite loop
                break;
            }

            // MOVE TEST COORDINATES TO NEXT POINT ALONG LINE
            testCoords[0] += ((float) incrementsAlongLine[direction - 1][0] / 2);
            testCoords[1] += ((float) incrementsAlongLine[direction - 1][1] / 2);

            // IF TEST COORDS GO OFF-SCREEN, ERROR (NO EXIT FOUND)
            if (testCoords[0] < 0 || testCoords[0] > sketch.width || testCoords[1] > sketch.height || testCoords[1] < 0) {
                sketch.print("NO EXIT FOUND");
                break;
            }
        }
        return exit;
    }

    // SET ATOMS HIT FUNCTION ------------------------------
    // CHECK FOR REFLECT FUNCTION --------------------------





    // DISPLAYS RAY AND RETURNS COORDINATES OF END OF RAY
    public static float[] drawRay(float startX, float startY, float angle, float lineLength, boolean displayRay, PApplet sketch) {
        sketch.stroke(0, 255, 0); // Colour of rays
        sketch.strokeWeight(3);

        // CALCULATE END COORDINATES
        float endX = startX + sketch.cos(angle) * lineLength;
        float endY = startY + sketch.sin(angle) * lineLength;

        if (displayRay) {
            sketch.line(startX, startY, endX, endY);
        }

        return new float[] {endX, endY};
    }



    // DRAW RAYS RECURSIVELY, CHECKING FOR BOUNCES
    public static float[] drawRayWithBounces(int[][] atomPositions, float startX, float startY, int direction, boolean firstRay, boolean displayRays, PApplet sketch) {
        float[] endOfLine;

        int numOfAtoms = atomPositions.length;


        boolean directHit = false;
        float influenceX = 0;
        float influenceY = 0;

        int numOfCirclesOfInfluence = 0;

        // CHECK FOR REFLECTED - STARTING INSIDE AN ATOM'S CIRCLE OF INFLUENCE
        for (int i = 0; i < numOfAtoms; i++) {
            if (sketch.dist(startX, startY, atomPositions[i][0], atomPositions[i][1]) < 59 && firstRay) { // STARTS INSIDE AN ATOM

                // CHECK IF DIRECT HIT
                if (sketch.dist((startX+(incrementsAlongLine[direction-1][0]/2)), (startY+(incrementsAlongLine[direction-1][1]/2)), atomPositions[i][0], atomPositions[i][1]) < 5) {
                    float distance = sketch.dist(atomPositions[i][0], atomPositions[i][1], startX, startY);
                    drawRay(startX, startY, angles[direction-1], distance, displayRays, sketch);
                    endOfLine = new float[] {-1, -1};
                    return endOfLine;
                }

                // OTHERWISE REFLECT
                endOfLine = new float[] {-2, -2};
                return endOfLine;
            }
        }


        // SET DISTANCE TO MAX -> PASSES STRAIGHT THROUGH
        int[] exit = setExit(new float[] {startX, startY}, direction, sketch);
        float distance = sketch.dist(startX, startY, exit[0], exit[1]);

        // Starting position is half distance to next centre point -> Move back half
        float[] testCoords = {startX, startY};
        if (firstRay) {
            testCoords[0] -= ((float) incrementsAlongLine[direction - 1][0] / 2);
            testCoords[1] -= ((float) incrementsAlongLine[direction - 1][1] / 2);
        }

        int[] atomsHit = new int[6];


        int incrementX = incrementsAlongLine[direction-1][0];
        int incrementY = incrementsAlongLine[direction-1][1];

            // While next position before exit and no circles of influence found
            while ((testCoords[0] + incrementX) < sketch.width && (testCoords[0] + incrementX) > 0 && (testCoords[1] + incrementY) < sketch.height && (testCoords[1] + incrementY) > 0 && numOfCirclesOfInfluence == 0) {

                // Move to next centre point
                testCoords[0] += incrementX;
                testCoords[1] += incrementY;


                // CHECK IF ANY CIRCLES OF INFLUENCE HIT - IF SO STORE THEM AND THE COORDINATES OF THE TEST COORDINATES

                for (int i = 0; i < numOfAtoms; i++) {
                    if (PApplet.dist(testCoords[0], testCoords[1], atomPositions[i][0], atomPositions[i][1]) <= 65) {
                        atomsHit[numOfCirclesOfInfluence] = i;
                        numOfCirclesOfInfluence++;
                        influenceX = testCoords[0];
                        influenceY = testCoords[1];
                    }
                }


                // ONLY ONE CIRCLE OF INFLUENCE FOUND
                if (numOfCirclesOfInfluence == 1) {

                    // CHECK FOR DIRECT HIT
                    for (int[] atom : atomPositions) {
                        if (sketch.dist(testCoords[0] + incrementX, testCoords[1] + incrementY, atom[0], atom[1]) < 5) {
                            directHit = true;
                            distance = sketch.dist(atom[0], atom[1], startX, startY);
                            break;
                        }
                    }

                    // ELSE BOUNCE
                    if (!directHit) {
                        distance = sketch.dist(influenceX, influenceY, startX, startY);
                        drawRay(startX, startY, angles[direction - 1], distance, displayRays, sketch);

                        switch (direction) {
                            case 1, 2, 5, 6:
                                if (influenceX > atomPositions[atomsHit[0]][0]) { // HITS RIGHT SIDE OF CIRCLE
                                    switch (direction) {
                                        case 1, 5:
                                            return drawRayWithBounces(atomPositions, influenceX, influenceY, 3, false, displayRays, sketch);
                                        case 2:
                                            return drawRayWithBounces(atomPositions, influenceX, influenceY, 1, false, displayRays, sketch);
                                        case 6:
                                            return drawRayWithBounces(atomPositions, influenceX, influenceY, 5, false, displayRays, sketch);
                                    }
                                } else { // HITS LEFT SIDE OF CIRCLE
                                    switch (direction) {
                                        case 1:
                                            return drawRayWithBounces(atomPositions, influenceX, influenceY, 2, false, displayRays, sketch);
                                        case 2, 6:
                                            return drawRayWithBounces(atomPositions, influenceX, influenceY, 4, false, displayRays, sketch);
                                        case 5:
                                            return drawRayWithBounces(atomPositions, influenceX, influenceY, 6, false, displayRays, sketch);
                                    }

                                }

                            case 3, 4:
                                if (influenceY > atomPositions[atomsHit[0]][1]) { // HITS BOTTOM HALF OF CIRCLE
                                    switch (direction) {
                                        case 3:
                                            return drawRayWithBounces(atomPositions, influenceX, influenceY, 1, false, displayRays, sketch);
                                        case 4:
                                            return drawRayWithBounces(atomPositions, influenceX, influenceY, 2, false, displayRays, sketch);
                                    }
                                } else { // HITS TOP HALF OF CIRCLE -> BOUNCES UP AND RIGHT
                                    switch (direction) {
                                        case 3:
                                            return drawRayWithBounces(atomPositions, influenceX, influenceY, 5, false, displayRays, sketch);
                                        case 4:
                                            return drawRayWithBounces(atomPositions, influenceX, influenceY, 6, false, displayRays, sketch);
                                    }
                                }
                        }
                    }
                }

                // DEAL WITH MULTIPLE CIRCLES
                else if (numOfCirclesOfInfluence > 1) {

                    distance = PApplet.dist(influenceX, influenceY, startX, startY);
                    drawRay(startX, startY, angles[direction-1], distance, displayRays, sketch);

                    boolean oneCircleAboveOther = false;
                    boolean verticallyAligned = false;
                    int y;

                    switch (direction) {
                        case 1:

                            // ONE ABOVE THE OTHER -> REFLECT
                            // BESIDE EACH OTHER -> BOUNCE

                            y = atomPositions[atomsHit[0]][1];
                            for (int i = 1; i < numOfCirclesOfInfluence; i++) {
                                if (y != atomPositions[atomsHit[i]][1]) {
                                    oneCircleAboveOther = true;
                                    break;
                                }
                            }

                            if (oneCircleAboveOther) { // ONE ABOVE THE OTHER
                                if (sketch.dist(atomPositions[atomsHit[0]][0], atomPositions[atomsHit[0]][1], atomPositions[atomsHit[1]][0], atomPositions[atomsHit[1]][1]) <= 60) {
                                    // BOUNCE LEFT
                                    return drawRayWithBounces(atomPositions, influenceX, influenceY, 4, false, displayRays, sketch);
                                } else {
                                    // REFLECT
                                    return drawRayWithBounces(atomPositions, influenceX, influenceY, 6, false, displayRays, sketch);
                                }
                            } else { // BESIDE
                                return drawRayWithBounces(atomPositions, influenceX, influenceY, 5, false, displayRays, sketch);
                            }


                        case 2:

                            // ONE ABOVE THE OTHER -> REFLECT
                            // BESIDE EACH OTHER -> BOUNCE


                            y = atomPositions[atomsHit[0]][1];
                            for (int i = 1; i < numOfCirclesOfInfluence; i++) {
                                if (y != atomPositions[atomsHit[i]][1]) {
                                    oneCircleAboveOther = true;
                                    break;
                                }
                            }

                            if (oneCircleAboveOther) { // ONE ABOVE THE OTHER
                                if (sketch.dist(atomPositions[atomsHit[0]][0], atomPositions[atomsHit[0]][1], atomPositions[atomsHit[1]][0], atomPositions[atomsHit[1]][1]) <= 60) {
                                    // BOUNCE RIGHT
                                    return drawRayWithBounces(atomPositions, influenceX, influenceY, 3, false, displayRays, sketch);
                                } else {
                                    // REFLECT
                                    return drawRayWithBounces(atomPositions, influenceX, influenceY, 5, false, displayRays, sketch);
                                }
                            } else { // BESIDE
                                return drawRayWithBounces(atomPositions, influenceX, influenceY, 6, false, displayRays, sketch);
                            }


                        case 3:

                            // VERTICALLY ALIGNED -> REFLECT
                            // ONE IN FRONT OF OTHER -> BOUNCE (2 OPTIONS)


                            // CHECK IF 2 OF THE ATOMS ARE VERTICALLY ALIGNED
                            for (int i = 0; i < numOfCirclesOfInfluence; i++) {
                                for (int j = i + 1; j < numOfCirclesOfInfluence; j++) {
                                    if (atomPositions[atomsHit[i]][0] == atomPositions[atomsHit[j]][0]) {
                                        verticallyAligned = true;
                                        break;
                                    }
                                }
                            }


                            if (verticallyAligned) { // ONE ABOVE THE OTHER
                                return drawRayWithBounces(atomPositions, influenceX, influenceY, 4, false, displayRays, sketch);
                            } else { // BESIDE - CAN ONLY BE 2 CIRCLES OF INFLUENCE

                                // Atom positions sorted -> First circle of influence found will be higher up
                                if (atomPositions[atomsHit[0]][0] > atomPositions[atomsHit[1]][0]) { // Top further right than bottom -> Up and left
                                    return drawRayWithBounces(atomPositions, influenceX, influenceY, 6, false, displayRays, sketch);
                                } else { // Top further left than bottom -> Down and left
                                    return drawRayWithBounces(atomPositions, influenceX, influenceY, 2, false, displayRays, sketch);
                                }

                            }


                        case 4:

                            // VERTICALLY ALIGNED -> REFLECT
                            // ONE IN FRONT OF OTHER -> BOUNCE (2 OPTIONS)


                            // CHECK IF 2 OF THE ATOMS ARE VERTICALLY ALIGNED
                            for (int i = 0; i < numOfCirclesOfInfluence; i++) {
                                for (int j = i + 1; j < numOfCirclesOfInfluence; j++) {
                                    if (atomPositions[atomsHit[i]][0] == atomPositions[atomsHit[j]][0]) {
                                        verticallyAligned = true;
                                        break;
                                    }
                                }
                            }


                            if (verticallyAligned) { // ONE ABOVE THE OTHER
                                return drawRayWithBounces(atomPositions, influenceX, influenceY, 3, false, displayRays, sketch);
                            } else { // BESIDE - CAN ONLY BE 2 CIRCLES OF INFLUENCE
                                // Atom positions sorted -> First circle of influence found will be higher up
                                if (atomPositions[atomsHit[0]][0] > atomPositions[atomsHit[1]][0]) { // Top further right than bottom -> Down and right
                                    return drawRayWithBounces(atomPositions, influenceX, influenceY, 1, false, displayRays, sketch);
                                } else { // Top further left than bottom -> Up and right
                                    return drawRayWithBounces(atomPositions, influenceX, influenceY, 5, false, displayRays, sketch);
                                }
                            }


                        case 5:

                            // ONE ABOVE THE OTHER -> REFLECT
                            // BESIDE EACH OTHER -> BOUNCE


                            y = atomPositions[atomsHit[0]][1];
                            for (int i = 1; i < numOfCirclesOfInfluence; i++) {
                                if (y != atomPositions[atomsHit[i]][1]) {
                                    oneCircleAboveOther = true;
                                    break;
                                }
                            }

                            if (oneCircleAboveOther) { // ONE ABOVE THE OTHER
                                if (PApplet.dist(atomPositions[atomsHit[0]][0], atomPositions[atomsHit[0]][1], atomPositions[atomsHit[1]][0], atomPositions[atomsHit[1]][1]) <= 60) {
                                    // BOUNCE LEFT
                                    return drawRayWithBounces(atomPositions, influenceX, influenceY, 4, false, displayRays, sketch);
                                } else {
                                    // REFLECT
                                    return drawRayWithBounces(atomPositions, influenceX, influenceY, 2, false, displayRays, sketch);
                                }
                            } else {
                                return drawRayWithBounces(atomPositions, influenceX, influenceY, 1, false, displayRays, sketch);
                            }


                        case 6:
                            // ONE ABOVE THE OTHER -> REFLECT
                            // BESIDE EACH OTHER -> BOUNCE

                            y = atomPositions[atomsHit[0]][1];
                            for (int i = 1; i < numOfCirclesOfInfluence; i++) {
                                if (y != atomPositions[atomsHit[i]][1]) {
                                    oneCircleAboveOther = true;
                                    break;
                                }
                            }

                            if (oneCircleAboveOther) { // ONE ABOVE THE OTHER
                                if (sketch.dist(atomPositions[atomsHit[0]][0], atomPositions[atomsHit[0]][1], atomPositions[atomsHit[1]][0], atomPositions[atomsHit[1]][1]) <= 60) {
                                    // BOUNCE RIGHT
                                    return drawRayWithBounces(atomPositions, influenceX, influenceY, 3, false, displayRays, sketch);
                                } else {
                                    // REFLECT
                                    return drawRayWithBounces(atomPositions, influenceX, influenceY, 1, false, displayRays, sketch);
                                }
                            } else { // BESIDE
                                return drawRayWithBounces(atomPositions, influenceX, influenceY, 2, false, displayRays, sketch);
                            }

                        }
                    }
            }

            endOfLine = drawRay(startX, startY, angles[direction-1], distance, displayRays, sketch); // doesn't hit anything


        if (directHit) {
            endOfLine = new float[] {-1, -1};
        }
        return endOfLine;
    }


    public void displayRays(int numOfRays, int[] shots, int[][] atomPositions, PApplet sketch) {
        for (int i = 0; i < numOfRays; i++) {
            int rayNumInList = shots[i] - 1;

            int direction = Rays.rayPositions[rayNumInList][4];
            drawRayWithBounces(atomPositions, Rays.rayPositions[rayNumInList][0], Rays.rayPositions[rayNumInList][1], direction, true, true, sketch);
        }
    }


    public static void drawRayMarkers(int numOfRays, int[] shots, float[][] rayExitCoordinates) {
        // LOGIC STARTS HERE
        for (int i = 0; i < numOfRays; i++) {
            int startIndex = shots[i] - 1;

            /* Ray Conditions
             * - DIRECT HIT: -1, -1
             * - REFLECTED: -2, -2
             * - DEFLECTED: Coordinates */

            // Extracting first two elements for Math.round to compare float with int
            float[] exitCoords = {rayExitCoordinates[i][0], rayExitCoordinates[i][1]};

            if (Arrays.equals(exitCoords, new float[]{-1, -1})) {
                RayMarkers.drawAbsorbed(startIndex); // DIRECT HIT
            } else if (Arrays.equals(exitCoords, new float[]{-2, -2})) {
                RayMarkers.drawReflected180(startIndex); // REFLECTED
            } else {
                // Find End Index
                int endIndex = 0;

                // Loop through to compare
                for (int j = 0; j < rayPositions.length; j++) {
                    // Extracting first two elements of rayPositions[j]
                    int[] positionCoords = {rayPositions[j][0], rayPositions[j][1]};

                    // Compare the first two elements of rayPositions[j] with exitCoords
                    if (Arrays.equals(positionCoords, new int[]{(int) Math.floor(exitCoords[0]), (int) Math.floor(exitCoords[1])})) {
                        endIndex = j;
                        break; // Exit loop once endIndex is found
                    }
                }

                RayMarkers.drawDeflected(startIndex, endIndex);
                int coord = endIndex + 1;
                System.out.println(coord + ": " + Arrays.toString(exitCoords));
            }
        }
    }


}