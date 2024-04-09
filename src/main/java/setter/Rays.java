package main.java.setter;
import main.java.ui.RayMarkers;
import processing.core.*;

public class Rays {

    PApplet parent;

    public Rays(PApplet parent){
        this.parent = parent;
    }
    public static int[][] rayPositions = {
            {215, 75, 485, 525, 1}, // 1
            {200, 100, 500, 100, 3}, // 2
            {185, 125, 425, 525, 1}, // 3
            {170, 150, 530, 150, 3}, // 4
            {155, 175, 365, 525, 1}, // 5
            {140, 200, 560, 200, 3}, // 6
            {125, 225, 305, 525, 1}, // 7
            {110, 250, 590, 250, 3}, // 8
            {95, 275, 245, 525, 1}, // 9
            {80, 300, 620, 300, 3}, // 10
            {95, 325, 245, 75, 5}, // 11
            {110, 350, 590, 350, 3}, // 12
            {125, 375, 305, 75, 5}, // 13
            {140, 400, 560, 400, 3}, // 14
            {155, 425, 365, 75, 5}, // 15
            {170, 450, 530, 450, 3}, // 16
            {185, 475, 425, 75, 5}, // 17
            {200, 500, 500, 500, 3}, // 18
            {215, 525, 485, 75, 5}, // 19
            {245, 525, 95, 275, 6}, // 20
            {275, 525, 515, 125, 5}, // 21
            {305, 525, 125, 225, 6}, // 22
            {335, 525, 545, 175, 5}, // 23
            {365, 525, 155, 175, 6}, // 24
            {395, 525, 575, 225, 5}, // 25
            {425, 525, 185, 125, 6}, // 26
            {455, 525, 605, 275, 5}, // 27
            {485, 525, 215, 75, 6}, // 28
            {500, 500, 200, 500, 4}, // 29
            {515, 475, 275, 75, 6}, // 30
            {530, 450, 170, 450, 4}, // 31
            {545, 425, 335, 75, 6}, // 32
            {560, 400, 140, 400, 4}, // 33
            {575, 375, 395, 75, 6}, // 34
            {590, 350, 110, 350, 4}, // 35
            {605, 325, 455, 75, 6}, // 36
            {620, 300, 80, 300, 4}, // 37
            {605, 275, 455, 525, 2}, // 38
            {590, 250, 110, 250, 4}, // 39
            {575, 225, 395, 525, 2}, // 40
            {560, 200, 140, 200, 4}, // 41
            {545, 175, 335, 525, 2}, // 42
            {530, 150, 170, 150, 4}, // 43
            {515, 125, 275, 525, 2}, // 44
            {500, 100, 200, 100, 4}, // 45
            {485, 75, 215, 525, 2}, // 46
            {455, 75, 605, 325, 1}, // 47
            {425, 75, 185, 475, 2}, // 48
            {395, 75, 575, 375, 1}, // 49
            {365, 75, 155, 425, 2}, // 50
            {335, 75, 545, 425, 1}, // 51
            {305, 75, 125, 375, 2}, // 52
            {275, 75, 515, 475, 1}, // 53
            {245, 75, 95, 325, 2}, // 54
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



    // FIND EXIT ON LINE OF RAY
    public static int[] setExit(float startX, float startY, int xChange, int yChange, int[][] exits, PApplet sketch) {
        int[] exit = new int[] {0, 0, 0};
        float[] testCoords = {startX, startY};

        while (true) {
            boolean exitSet = false;

            // CHECK IF TEST COORDS HAVE REACHED ANY EXIT IN ARRAY
            for (int i = 0; i < exits.length; i++) {
                if (sketch.dist(testCoords[0], testCoords[1], exits[i][0], exits[i][1]) < 15) { // IF COORDS REACH EXIT
                    exit = new int[]{exits[i][0], exits[i][1], exits[i][2]}; // Set exit coordinates

                    exitSet = true;
                    break;
                }
            }

            if (exitSet) { // If exit found, exit infinite loop
                break;
            }

            // MOVE TEST COORDINATES TO NEXT POINT ALONG LINE
            testCoords[0] += (xChange / 2);
            testCoords[1] += (yChange / 2);

            // IF TEST COORDS GO OFF-SCREEN, ERROR (NO EXIT FOUND)
            if (testCoords[0] < 0 || testCoords[0] > sketch.width || testCoords[1] > sketch.height || testCoords[1] < 0) {
                sketch.print("NO EXIT FOUND");
                break;
            }
        }
        // TESTING PURPOSES FOR FINDING OUT NEXT SPRINT
//        System.out.println("Exit coordinates: (" + exit[0] + ", " + exit[1] + ")"); // Print exit coordinates
        return exit;
    }

    // SET ATOMS HIT FUNCTION ------------------------------
    // CHECK FOR REFLECT FUNCTION --------------------------



    public static float[] checkForStartingInAtom(float startX, float startY, int direction) {

        return new float[] {};
    }


    // DISPLAYS RAY AND RETURNS COORDINATES OF END OF RAY
    public static float[] drawRay(float startX, float startY, float angle, float lineLength, PApplet sketch) {
        sketch.stroke(0, 255, 0); // Colour of rays
        sketch.strokeWeight(3);

        // CALCULATE END COORDINATES
        float endX = startX + sketch.cos(angle) * lineLength;
        float endY = startY + sketch.sin(angle) * lineLength;

        sketch.line(startX, startY, endX, endY);

        return new float[] {endX, endY};
    }



    // DRAW RAYS RECURSIVELY, CHECKING FOR BOUNCES
    public static float[] drawRayWithBounces(int index, int[][] atomPositions, float startX, float startY, int direction, boolean firstRay, PApplet sketch) {
        float[] endOfLine = new float[] {0, 0};


        // ANGLES OF RAYS
        float[] angles = {
                sketch.radians((float) 58.8), // Down and right
                sketch.radians((float) 120.8), // Down and left
                sketch.radians((float) 0), // Right
                sketch.radians((float) 180), // Left
                sketch.radians((float) 300.8), // Up and right
                sketch.radians((float) 238.8), // Up and left
        };

        int numOfAtoms = atomPositions.length;


        boolean circleOfInfluence = false;
        boolean directHit = false;
        float influenceX = 0;
        float influenceY = 0;


        // CHECK FOR REFLECTED - STARTING INSIDE AN ATOM'S CIRCLE OF INFLUENCE
        for (int i = 0; i < numOfAtoms; i++) {
            if (sketch.dist(startX, startY, atomPositions[i][0], atomPositions[i][1]) < 59 && firstRay) { // STARTS INSIDE AN ATOM

                // CHECK IF DIRECT HIT
                if (sketch.dist((startX+(incrementsAlongLine[direction-1][0]/2)), (startY+(incrementsAlongLine[direction-1][1]/2)), atomPositions[i][0], atomPositions[i][1]) < 5) {
                    float distance = sketch.dist(atomPositions[i][0], atomPositions[i][1], startX, startY);
                    drawRay(startX, startY, angles[direction-1], distance, sketch);
                    endOfLine = new float[] {-1, -1};
                    return endOfLine;
                }

                // OTHERWISE REFLECT
                endOfLine = new float[] {-2, -2};
                return endOfLine;
            }
        }




        // vvv CHECKS FOR EACH DIRECTION vvv

        if (direction == 1) { // Down and right ---------------------------------------------------------------------------------------------------

            // SET DISTANCE TO MAX -> PASSES STRAIGHT THROUGH
            int[] exit = setExit(startX, startY, 30, 50, downAndRightExits, sketch);
            float distance = sketch.dist(startX, startY, exit[0], exit[1]);

            // Starting position is half distance to next centre point -> Move back half
            float[] testCoords = {startX, startY};
            if (firstRay) {
                testCoords[0] -= 15;
                testCoords[1] -= 25;
            }

            int numOfCirclesOfInfluence = 0;

            // While next position before exit and no circles of influence found
            while ((testCoords[0] + 30) < exit[0] && (testCoords[1] + 50) < exit[1] && numOfCirclesOfInfluence == 0) {
                // Move to next centre point
                testCoords[0] += 30;
                testCoords[1] += 50;


                // CHECK IF ANY CIRCLES OF INFLUENCE HIT - IF SO STORE THEM AND THE COORDINATES OF THE TEST COORDINATES
                int[] atomsHit = new int[6];
                for (int i = 0; i < numOfAtoms; i++) {
                    if (sketch.dist(testCoords[0], testCoords[1], atomPositions[i][0], atomPositions[i][1]) <= 65) {
                        atomsHit[numOfCirclesOfInfluence] = i;
                        numOfCirclesOfInfluence++;
                        influenceX = testCoords[0];
                        influenceY = testCoords[1];
                    }
                }

                // ONLY ONE CIRCLE OF INFLUENCE FOUND
                if (numOfCirclesOfInfluence == 1) {

                    // CHECK FOR DIRECT HIT
                    for (int i = 0; i < numOfAtoms; i++) {
                        if (sketch.dist(testCoords[0]+30, testCoords[1]+50, atomPositions[i][0], atomPositions[i][1]) < 5) {
                            directHit = true;
                            distance = sketch.dist(atomPositions[i][0], atomPositions[i][1], startX, startY);
                            break;
                        }
                    }

                    // ELSE BOUNCE
                    if (!directHit) {
                        distance = sketch.dist(influenceX, influenceY, startX, startY);
                        drawRay(startX, startY, angles[0], distance, sketch);

                        if (influenceX > atomPositions[atomsHit[0]][0]) { // HITS RIGHT SIDE OF CIRCLE -> BOUNCES RIGHT
                            return drawRayWithBounces(index, atomPositions, influenceX, influenceY, 3, false, sketch);
                        }
                        else { // HITS LEFT SIDE OF CIRCLE -> BOUNCES DOWN AND LEFT
                            return drawRayWithBounces(index, atomPositions, influenceX, influenceY, 2, false, sketch);
                        }

                    }
                }

                // DEAL WITH MULTIPLE CIRCLES
                else if (numOfCirclesOfInfluence > 1) {

                    distance = sketch.dist(influenceX, influenceY, startX, startY);
                    drawRay(startX, startY, angles[0], distance, sketch);


                    boolean reflect = false;
                    // ONE ABOVE THE OTHER -> REFLECT
                    // BESIDE EACH OTHER -> BOUNCE


                    int y = atomPositions[atomsHit[0]][1];
                    for (int i = 1; i < numOfCirclesOfInfluence; i++) {
                        if (y != atomPositions[atomsHit[i]][1]) {
                            reflect = true;
                            break;
                        }
                    }




                    if (reflect) { // ONE ABOVE THE OTHER
                        if (sketch.dist(atomPositions[atomsHit[0]][0], atomPositions[atomsHit[0]][1], atomPositions[atomsHit[1]][0], atomPositions[atomsHit[1]][1]) <= 60) {
                            // BOUNCE LEFT
                            return drawRayWithBounces(index, atomPositions, influenceX, influenceY, 4, false, sketch);
                        }
                        else {
                            // REFLECT
                            return drawRayWithBounces(index, atomPositions, influenceX, influenceY, 6, false, sketch);
                        }
                    }
                    else { // BESIDE
                        return drawRayWithBounces(index, atomPositions, influenceX, influenceY, 5, false, sketch);
                    }
                }
            }

            endOfLine = drawRay(startX, startY, angles[0], distance, sketch); // doesn't hit anything

            // Ray Markers Calculated
            if (directHit) {
                RayMarkers.drawAbsorbed(index);
            } else if (endOfLine[0] == -2 && endOfLine[1] == -2) {
                RayMarkers.drawReflected180(index);
            } else {
                RayMarkers.drawDeflected(index, exit[2]);
            }
        }





        else if (direction == 2) { // Down and left ---------------------------------------------------------------------------------------------------

            // SET DISTANCE TO MAX -> PASSES STRAIGHT THROUGH
            int[] exit = setExit(startX, startY, -30, 50, downAndLeftExits, sketch);
            float distance = sketch.dist(startX, startY, exit[0], exit[1]);


            float[] testCoords = {startX, startY};
            if (firstRay) {
                testCoords[0] += 15;
                testCoords[1] -= 25;
            }

            int numOfCirclesOfInfluence = 0;



                while ((testCoords[0] - 30) > exit[0] && (testCoords[1] + 50) < exit[1] && numOfCirclesOfInfluence == 0) {
                    testCoords[0] -= 30;
                    testCoords[1] += 50;


                    int[] atomsHit = new int[6];
                    for (int i = 0; i < numOfAtoms; i++) {
                        if (sketch.dist(testCoords[0], testCoords[1], atomPositions[i][0], atomPositions[i][1]) <= 65) {
                            atomsHit[numOfCirclesOfInfluence] = i;
                            numOfCirclesOfInfluence++;
                            influenceX = testCoords[0];
                            influenceY = testCoords[1];
                        }
                    }

                    if (numOfCirclesOfInfluence == 1) {
                        // CHECK FOR DIRECT HIT
                        for (int i = 0; i < numOfAtoms; i++) {
                            if (sketch.dist(testCoords[0] - 30, testCoords[1] + 50, atomPositions[i][0], atomPositions[i][1]) < 5) {
                                directHit = true;
                                distance = sketch.dist(atomPositions[i][0], atomPositions[i][1], startX, startY);
                                break;
                            }
                        }

                        // ELSE BOUNCE
                        if (!directHit) {
                            distance = sketch.dist(influenceX, influenceY, startX, startY);
                            drawRay(startX, startY, angles[1], distance, sketch);

                            if (influenceX > atomPositions[atomsHit[0]][0]) { // HITS RIGHT SIDE OF CIRCLE -> BOUNCES DOWN AND RIGHT
                                return drawRayWithBounces(index, atomPositions, influenceX, influenceY, 1, false, sketch);
                            } else { // HITS LEFT SIDE OF CIRCLE -> BOUNCES LEFT
                                return drawRayWithBounces(index, atomPositions, influenceX, influenceY, 4, false, sketch);
                            }
                        }

                    } else if (numOfCirclesOfInfluence > 1) {
                        // DEAL WITH MULTIPLE CIRCLES !!!
                        distance = sketch.dist(influenceX, influenceY, startX, startY);
                        drawRay(startX, startY, angles[1], distance, sketch);

                        boolean reflect = false;
                        // ONE ABOVE THE OTHER -> REFLECT
                        // BESIDE EACH OTHER -> BOUNCE


                        int y = atomPositions[atomsHit[0]][1];
                        for (int i = 1; i < numOfCirclesOfInfluence; i++) {
                            if (y != atomPositions[atomsHit[i]][1]) {
                                reflect = true;
                                break;
                            }
                        }

                        if (reflect) { // ONE ABOVE THE OTHER
                            if (sketch.dist(atomPositions[atomsHit[0]][0], atomPositions[atomsHit[0]][1], atomPositions[atomsHit[1]][0], atomPositions[atomsHit[1]][1]) <= 60) {
                                // BOUNCE RIGHT
                                return drawRayWithBounces(index, atomPositions, influenceX, influenceY, 3, false, sketch);
                            }
                            else {
                                // REFLECT
                                return drawRayWithBounces(index, atomPositions, influenceX, influenceY, 5, false, sketch);
                            }
                        } else { // BESIDE
                            return drawRayWithBounces(index, atomPositions, influenceX, influenceY, 6, false, sketch);
                        }
                    }
                }
            endOfLine = drawRay(startX, startY, angles[1], distance, sketch);

            // Ray Markers Calculated
            if (directHit) {
                RayMarkers.drawAbsorbed(index);
            } else {
                RayMarkers.drawDeflected(index, exit[2]);
            }
        }


        else if (direction == 3) { // Right ---------------------------------------------------------------------------------------------------

            // SET DISTANCE TO MAX -> PASSES STRAIGHT THROUGH
            int[] exit = setExit(startX, startY, 60, 0, rightExits, sketch);
            float distance = sketch.dist(startX, startY, exit[0], exit[1]);


            float[] testCoords = {startX, startY};
            if (firstRay) {
                testCoords[0] -= 30;
            }

            int numOfCirclesOfInfluence = 0;

            while ((testCoords[0] + 60) < exit[0] && numOfCirclesOfInfluence == 0) {
                testCoords[0] += 60;

                int[] atomsHit = new int[6];
                for (int i = 0; i < numOfAtoms; i++) {
                    if (sketch.dist(testCoords[0], testCoords[1], atomPositions[i][0], atomPositions[i][1]) <= 65) {
                        atomsHit[numOfCirclesOfInfluence] = i;
                        numOfCirclesOfInfluence++;
                        influenceX = testCoords[0];
                        influenceY = testCoords[1];
                    }
                }

                if (numOfCirclesOfInfluence == 1) {
                    // CHECK FOR DIRECT HIT
                    for (int i = 0; i < numOfAtoms; i++) {
                        if (sketch.dist(testCoords[0] + 60, testCoords[1], atomPositions[i][0], atomPositions[i][1]) < 5) {
                            directHit = true;
                            distance = sketch.dist(atomPositions[i][0], atomPositions[i][1], startX, startY);
                            break;
                        }
                    }

                    // ELSE BOUNCE
                    if (!directHit) {
                        distance = sketch.dist(influenceX, influenceY, startX, startY);
                        drawRay(startX, startY, angles[2], distance, sketch);

                        if (influenceY > atomPositions[atomsHit[0]][1]) { // HITS BOTTOM HALF OF CIRCLE -> BOUNCES DOWN AND RIGHT
                            return drawRayWithBounces(index, atomPositions, influenceX, influenceY, 1, false, sketch);
                        } else { // HITS TOP HALF OF CIRCLE -> BOUNCES UP AND RIGHT
                            return drawRayWithBounces(index, atomPositions, influenceX, influenceY, 5, false, sketch);
                        }
                    }


                } else if (numOfCirclesOfInfluence > 1) {
                    // DEAL WITH MULTIPLE CIRCLES !!!
                    distance = sketch.dist(influenceX, influenceY, startX, startY);
                    drawRay(startX, startY, angles[2], distance, sketch);


                    boolean reflect = false;
                    // VERTICALLY ALIGNED -> REFLECT
                    // ONE IN FRONT OF OTHER -> BOUNCE (2 OPTIONS)


                    // CHECK IF 2 OF THE ATOMS ARE VERTICALLY ALIGNED
                    for (int i = 0; i < numOfCirclesOfInfluence; i++) {
                        for (int j = i + 1; j < numOfCirclesOfInfluence; j++) {
                            if (atomPositions[atomsHit[i]][0] == atomPositions[atomsHit[j]][0]) {
                                reflect = true;
                                break;
                            }
                        }
                    }


                    if (reflect) { // ONE ABOVE THE OTHER
                        return drawRayWithBounces(index, atomPositions, influenceX, influenceY, 4, false, sketch);
                    }
                    else { // BESIDE - CAN ONLY BE 2 CIRCLES OF INFLUENCE

                        // Atom positions sorted -> First circle of influence found will be higher up
                        if (atomPositions[atomsHit[0]][0] > atomPositions[atomsHit[1]][0]) { // Top further right than bottom -> Up and left
                            return drawRayWithBounces(index, atomPositions, influenceX, influenceY, 6, false, sketch);
                        }
                        else { // Top further left than bottom -> Down and left
                            return drawRayWithBounces(index, atomPositions, influenceX, influenceY, 2, false, sketch);
                        }
                    }
                }
            }

            endOfLine = drawRay(startX, startY, angles[2], distance, sketch);

            // Ray Markers Calculated
            if (directHit) {
                RayMarkers.drawAbsorbed(index);
            } else {
                RayMarkers.drawDeflected(index, exit[2]);
            }

        }


        else if (direction == 4) { // Left ---------------------------------------------------------------------------------------------------


            // SET DISTANCE TO MAX -> PASSES STRAIGHT THROUGH
            int[] exit = setExit(startX, startY, -60, 0, leftExits, sketch);
            float distance = sketch.dist(startX, startY, exit[0], exit[1]);


            float[] testCoords = {startX, startY};
            if (firstRay) {
                testCoords[0] += 30;
            }

            int numOfCirclesOfInfluence = 0;

            while ((testCoords[0] - 60) > exit[0] && numOfCirclesOfInfluence == 0) {
                testCoords[0] -= 60;

                int[] atomsHit = new int[6];
                for (int i = 0; i < numOfAtoms; i++) {
                    if (sketch.dist(testCoords[0], testCoords[1], atomPositions[i][0], atomPositions[i][1]) <= 65) {
                        atomsHit[numOfCirclesOfInfluence] = i;
                        numOfCirclesOfInfluence++;
                        influenceX = testCoords[0];
                        influenceY = testCoords[1];
                    }
                }


                if (numOfCirclesOfInfluence == 1) {
                    // CHECK FOR DIRECT HIT
                    for (int i = 0; i < numOfAtoms; i++) {
                        if (sketch.dist(testCoords[0] - 60, testCoords[1], atomPositions[i][0], atomPositions[i][1]) < 5) {
                            directHit = true;
                            distance = sketch.dist(atomPositions[i][0], atomPositions[i][1], startX, startY);
                            break;
                        }
                    }

                    // ELSE BOUNCE
                    if (!directHit) {
                        distance = sketch.dist(influenceX, influenceY, startX, startY);
                        drawRay(startX, startY, angles[3], distance, sketch);

                        if (influenceY > atomPositions[atomsHit[0]][1]) { // HITS BOTTOM HALF OF CIRCLE -> BOUNCES DOWN AND LEFT
                            return drawRayWithBounces(index, atomPositions, influenceX, influenceY, 2, false, sketch);
                        }
                        else { // HITS TOP HALF OF CIRCLE -> BOUNCES UP AND LEFT
                            return drawRayWithBounces(index, atomPositions, influenceX, influenceY, 6, false, sketch);
                        }
                    }

                }
                else if (numOfCirclesOfInfluence > 1) {
                    // DEAL WITH MULTIPLE CIRCLES !!!
                    distance = sketch.dist(influenceX, influenceY, startX, startY);
                    drawRay(startX, startY, angles[3], distance, sketch);


                    boolean reflect = false;
                    // VERTICALLY ALIGNED -> REFLECT
                    // ONE IN FRONT OF OTHER -> BOUNCE (2 OPTIONS)


                    // CHECK IF 2 OF THE ATOMS ARE VERTICALLY ALIGNED
                    for (int i = 0; i < numOfCirclesOfInfluence; i++) {
                        for (int j = i + 1; j < numOfCirclesOfInfluence; j++) {
                            if (atomPositions[atomsHit[i]][0] == atomPositions[atomsHit[j]][0]) {
                                reflect = true;
                                break;
                            }
                        }
                    }


                    if (reflect) { // ONE ABOVE THE OTHER
                        return drawRayWithBounces(index, atomPositions, influenceX, influenceY, 3, false, sketch);
                    }
                    else { // BESIDE - CAN ONLY BE 2 CIRCLES OF INFLUENCE
                        // Atom positions sorted -> First circle of influence found will be higher up
                        if (atomPositions[atomsHit[0]][0] > atomPositions[atomsHit[1]][0]) { // Top further right than bottom -> Down and right
                            return drawRayWithBounces(index, atomPositions, influenceX, influenceY, 1, false, sketch);
                        }
                        else { // Top further left than bottom -> Up and right
                            return drawRayWithBounces(index, atomPositions, influenceX, influenceY, 5, false, sketch);
                        }
                    }
                }
            }
            endOfLine = drawRay(startX, startY, angles[3], distance, sketch);

            // Ray Markers Calculated
            if (directHit) {
                RayMarkers.drawAbsorbed(index);
            } else {
                RayMarkers.drawDeflected(index, exit[2]);
            }
        }


        else if (direction == 5) { // Up and right ---------------------------------------------------------------------------------------------------


            // SET DISTANCE TO MAX -> PASSES STRAIGHT THROUGH
            int[] exit = setExit(startX, startY, 30, -50, upAndRightExits, sketch);
            float distance = sketch.dist(startX, startY, exit[0], exit[1]);


            float[] testCoords = {startX, startY};
            if (firstRay) {
                testCoords[0] -= 15;
                testCoords[1] += 25;
            }

            int numOfCirclesOfInfluence = 0;

            while ((testCoords[0] + 30) < exit[0] && (testCoords[1] - 50) > exit[1] && numOfCirclesOfInfluence == 0) {
                testCoords[0] += 30;
                testCoords[1] -= 50;


                int[] atomsHit = new int[6];
                for (int i = 0; i < numOfAtoms; i++) {
                    if (sketch.dist(testCoords[0], testCoords[1], atomPositions[i][0], atomPositions[i][1]) <= 65) {
                        atomsHit[numOfCirclesOfInfluence] = i;
                        numOfCirclesOfInfluence++;
                        influenceX = testCoords[0];
                        influenceY = testCoords[1];
                    }
                }

                if (numOfCirclesOfInfluence == 1) {
                    // CHECK FOR DIRECT HIT
                    for (int i = 0; i < numOfAtoms; i++) {
                        if (sketch.dist(testCoords[0] + 30, testCoords[1] - 50, atomPositions[i][0], atomPositions[i][1]) < 5) {
                            directHit = true;
                            distance = sketch.dist(atomPositions[i][0], atomPositions[i][1], startX, startY);
                            break;
                        }
                    }

                    // ELSE BOUNCE
                    if (!directHit) {
                        distance = sketch.dist(influenceX, influenceY, startX, startY);
                        drawRay(startX, startY, angles[4], distance, sketch);

                        if (influenceX > atomPositions[atomsHit[0]][0]) { // HITS RIGHT SIDE OF CIRCLE -> BOUNCES RIGHT
                            return drawRayWithBounces(index, atomPositions, influenceX, influenceY, 3, false, sketch);
                        } else { // HITS LEFT SIDE OF CIRCLE -> BOUNCES UP AND LEFT
                            return drawRayWithBounces(index, atomPositions, influenceX, influenceY, 6, false, sketch);
                        }
                    }

                } else if (numOfCirclesOfInfluence > 1) {
                    // DEAL WITH MULTIPLE CIRCLES !!!
                    distance = sketch.dist(influenceX, influenceY, startX, startY);
                    drawRay(startX, startY, angles[4], distance, sketch);

                    boolean reflect = false;
                    // ONE ABOVE THE OTHER -> REFLECT
                    // BESIDE EACH OTHER -> BOUNCE


                    int y = atomPositions[atomsHit[0]][1];
                    for (int i = 1; i < numOfCirclesOfInfluence; i++) {
                        if (y != atomPositions[atomsHit[i]][1]) {
                            reflect = true;
                            break;
                        }
                    }

                    if (reflect) { // ONE ABOVE THE OTHER
                        if (sketch.dist(atomPositions[atomsHit[0]][0], atomPositions[atomsHit[0]][1], atomPositions[atomsHit[1]][0], atomPositions[atomsHit[1]][1]) <= 60) {
                            // BOUNCE LEFT
                            return drawRayWithBounces(index, atomPositions, influenceX, influenceY, 4, false, sketch);
                        }
                        else {
                            // REFLECT
                            return drawRayWithBounces(index, atomPositions, influenceX, influenceY, 2, false, sketch);
                        }
                    } else {
                        return drawRayWithBounces(index, atomPositions, influenceX, influenceY, 1, false, sketch);
                    }
                }
            }
            endOfLine = drawRay(startX, startY, angles[4], distance, sketch);

            // Ray Markers Calculated
            if (directHit) {
                RayMarkers.drawAbsorbed(index);
            } else {
                RayMarkers.drawDeflected(index, exit[2]);
            }
        }


        else if (direction == 6) { // Up and left ---------------------------------------------------------------------------------------------------

            // SET DISTANCE TO MAX -> PASSES STRAIGHT THROUGH
            int[] exit = setExit(startX, startY, -30, -50, upAndLeftExits, sketch);
            float distance = sketch.dist(startX, startY, exit[0], exit[1]);


            float[] testCoords = {startX, startY};
            if (firstRay) {
                testCoords[0] += 15;
                testCoords[1] += 25;
            }

            int numOfCirclesOfInfluence = 0;

            while ((testCoords[0] - 30) > exit[0] && (testCoords[1] - 50) > exit[1] && numOfCirclesOfInfluence == 0) {
                testCoords[0] -= 30;
                testCoords[1] -= 50;


                int[] atomsHit = new int[6];
                for (int i = 0; i < numOfAtoms; i++) {
                    if (sketch.dist(testCoords[0], testCoords[1], atomPositions[i][0], atomPositions[i][1]) <= 65) {
                        atomsHit[numOfCirclesOfInfluence] = i;
                        numOfCirclesOfInfluence++;
                        influenceX = testCoords[0];
                        influenceY = testCoords[1];
                    }
                }

                if (numOfCirclesOfInfluence == 1) {
                    // CHECK FOR DIRECT HIT
                    for (int i = 0; i < numOfAtoms; i++) {
                        if (sketch.dist(testCoords[0] - 30, testCoords[1] - 50, atomPositions[i][0], atomPositions[i][1]) < 5) {
                            directHit = true;
                            distance = sketch.dist(atomPositions[i][0], atomPositions[i][1], startX, startY);
                            break;
                        }
                    }

                    // ELSE BOUNCE
                    if (!directHit) {
                        distance = sketch.dist(influenceX, influenceY, startX, startY);
                        drawRay(startX, startY, angles[5], distance, sketch);

                        if (influenceX > atomPositions[atomsHit[0]][0]) { // HITS RIGHT SIDE OF CIRCLE -> BOUNCES LEFT
                            return drawRayWithBounces(index, atomPositions, influenceX, influenceY, 5, false, sketch);
                        } else { // HITS LEFT SIDE OF CIRCLE -> BOUNCES UP AND RIGHT
                            return drawRayWithBounces(index, atomPositions, influenceX, influenceY, 4, false, sketch);
                        }
                    }

                }
                else if (numOfCirclesOfInfluence > 1) {
                    // DEAL WITH MULTIPLE CIRCLES !!!
                    distance = sketch.dist(influenceX, influenceY, startX, startY);
                    drawRay(startX, startY, angles[5], distance, sketch);


                    boolean reflect = false;
                    // ONE ABOVE THE OTHER -> REFLECT
                    // BESIDE EACH OTHER -> BOUNCE

                    int y = atomPositions[atomsHit[0]][1];
                    for (int i = 1; i < numOfCirclesOfInfluence; i++) {
                        if (y != atomPositions[atomsHit[i]][1]) {
                            reflect = true;
                            break;
                        }
                    }

                    if (reflect) { // ONE ABOVE THE OTHER
                        if (sketch.dist(atomPositions[atomsHit[0]][0], atomPositions[atomsHit[0]][1], atomPositions[atomsHit[1]][0], atomPositions[atomsHit[1]][1]) <= 60) {
                            // BOUNCE RIGHT
                            return drawRayWithBounces(index, atomPositions, influenceX, influenceY, 3, false, sketch);
                        }
                        else {
                            // REFLECT
                            return drawRayWithBounces(index, atomPositions, influenceX, influenceY, 1, false, sketch);
                        }
                    }
                    else { // BESIDE
                        return drawRayWithBounces(index, atomPositions, influenceX, influenceY, 2, false, sketch);
                    }
                }
            }
            endOfLine = drawRay(startX, startY, angles[5], distance, sketch);

            // Ray Markers Calculated
            if (directHit) {
                RayMarkers.drawAbsorbed(index);
            } else {
                RayMarkers.drawDeflected(index, exit[2]);
            }
        }


        if (directHit) {
            endOfLine = new float[] {-1, -1};
        }
        return endOfLine;
    }



}