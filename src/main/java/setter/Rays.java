package main.java.setter;
import main.java.ui.StartMenu;
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
            {485, 525}, // 28
            {425, 525}, // 26
            {365, 525}, // 24
            {305, 525}, // 22
            {245, 525}, // 20
            {605, 325}, // 36
            {575, 375}, // 34
            {545, 425}, // 32
            {515, 475}, // 30
    };

    public static int[][] downAndLeftExits = {
            {455, 525}, // 27
            {395, 525}, // 25
            {335, 525}, // 23
            {275, 525}, // 21
            {215, 525}, // 19
            {185, 475}, // 17
            {155, 425}, // 15
            {125, 375}, // 13
            {95, 325}, // 11
    };

    public static int[][] rightExits = {
            {500, 100}, // 45
            {530, 150}, // 43
            {560, 200}, // 41
            {590, 250}, // 39
            {620, 300}, // 37
            {590, 350}, // 35
            {560, 400}, // 33
            {530, 450}, // 31
            {500, 500}, // 29
    };

    public static int[][] leftExits = {
            {200, 500}, // 18
            {170, 450}, // 16
            {140, 400}, // 14
            {110, 350}, // 12
            {80, 300}, // 10
            {110, 250}, // 8
            {140, 200}, // 6
            {170, 150}, // 4
            {200, 100}, // 2
    };

    public static int[][] upAndRightExits = {
            {245, 75}, // 54
            {305, 75}, // 52
            {365, 75}, // 50
            {425, 75}, // 48
            {485, 75}, // 46
            {515, 125}, // 44
            {545, 175}, // 42
            {575, 225}, // 40
            {605, 275}, // 38
    };

    public static int[][] upAndLeftExits = {
            {95, 275}, // 9
            {125, 225}, // 7
            {155, 175}, // 5
            {185, 125}, // 3
            {215, 75}, // 1
            {275, 75}, // 53
            {335, 75}, // 51
            {395, 75}, // 49
            {455, 75}, // 47
    };


    // 1 = Down and right
    // 2 = Down and left
    // 3 = Right
    // 4 = Left
    // 5 = Up and right
    // 6 = Up and left



    public static float[] drawRay(float startX, float startY, float angle, float lineLength, PApplet sketch) {
        sketch.stroke(0, 255, 0); // Colour of rays
        sketch.strokeWeight(3);

        float endX = startX + sketch.cos(angle) * lineLength;
        float endY = startY + sketch.sin(angle) * lineLength;

        sketch.line(startX, startY, endX, endY);
        return new float[] {endX, endY};
    }



    public static float[] drawRayWithBounces(int[][] atomPositions, float startX, float startY, int direction, boolean firstRay, PApplet sketch) {
        float[] endOfLine = new float[] {0, 0};

        float[] angles = {
                2 * sketch.PI * ((float) 58.8 /360), // Down and right
                2 * sketch.PI * ((float) 120.8 /360), // Down and left
                0F, // Right
                sketch.PI, // Left
                -2 * sketch.PI * ((float) 58.8 /360), // Up and right
                -2 * sketch.PI * ((float) 120.8 /360) // Up and left
        };

        float angle = angles[direction - 1];

        int numOfAtoms = atomPositions.length;



        boolean circleOfInfluence = false;
        boolean directHit = false;
        float influenceX = 0;
        float influenceY = 0;


        // CHECK FOR REFLECTED
        for (int i = 0; i < numOfAtoms; i++) {
            if (sketch.dist(startX, startY, atomPositions[i][0], atomPositions[i][1]) < 59 && firstRay) {
                endOfLine = new float[] {-2, -2};
                System.out.println("REFLECTED");
                return endOfLine;
            }
        }



        // vvv CHECKS FOR EACH DIRECTION vvv

        if (direction == 1) { // Down and right ---------------------------------------------------------------------------------------------------

            float distance = 0;

            // SET DISTANCE TO MAX -> PASSES STRAIGHT THROUGH
            int[] exit = {0, 0};
            float[] testCoords = {startX, startY};

            while (true) {
                boolean exitSet = false;
                for (int i = 0; i < downAndRightExits.length; i++) {
                    if (sketch.dist(testCoords[0], testCoords[1], downAndRightExits[i][0], downAndRightExits[i][1]) < 15) {
                        exit = new int[]{downAndRightExits[i][0], downAndRightExits[i][1]};
                        distance = sketch.dist(startX, startY, exit[0], exit[1]);
                        exitSet = true;
                        break;
                    }
                }

                if (exitSet) {
                    break;
                }

                testCoords[0]++;
                testCoords[1] += 1.72;

                if (testCoords[0] > sketch.width || testCoords[1] > sketch.height) {
                    sketch.print("NO EXIT FOUND");
                    break;
                }
            }


            // ^^ SET DISTANCE TO MAX POSSIBLE DISTANCE TO EXIT ^^





            for (int j = 0; j < numOfAtoms; j++) {
                testCoords = new float[]{startX, startY};


                while (sketch.dist(testCoords[0], testCoords[1], atomPositions[j][0], atomPositions[j][1]) > 15 && testCoords[0] < exit[0] && testCoords[1] < exit[1]) {
                    testCoords[0]++;
                    testCoords[1] += 1.72;


                    // CIRCLE OF INFLUENCE FOUND
                    if (sketch.dist(testCoords[0], testCoords[1], atomPositions[j][0], atomPositions[j][1]) <= 59 && !circleOfInfluence) {
                        circleOfInfluence = true;
                        influenceX = testCoords[0];
                        influenceY = testCoords[1];
                    }
                }


                // DIRECT HIT
                if (sketch.dist(testCoords[0], testCoords[1], atomPositions[j][0], atomPositions[j][1]) <= 15) {
                    distance = sketch.dist(startX, startY, atomPositions[j][0], atomPositions[j][1]);
                    directHit = true;
                    break;
                }

                // CIRCLE OF INFLUENCE AND NOT DIRECT HIT
                if (circleOfInfluence) {
                    distance = sketch.dist(influenceX, influenceY, startX, startY);


                    float newAngle = angle;

                    drawRay(startX, startY, angles[0], distance, sketch);

                    if (influenceX > atomPositions[j][0]) { // HITS RIGHT SIDE OF CIRCLE -> BOUNCES RIGHT
                        return drawRayWithBounces(atomPositions, influenceX, influenceY, 3, false, sketch);

                    }
                    else { // HITS LEFT SIDE OF CIRCLE -> BOUNCES DOWN AND LEFT
                        return drawRayWithBounces(atomPositions, influenceX, influenceY, 2, false, sketch);
                    }

//                    break;
                }
            }

            endOfLine = drawRay(startX, startY, angles[0], distance, sketch);
        }





        else if (direction == 2) { // Down and left ---------------------------------------------------------------------------------------------------

            float distance = 0;

            // SET DISTANCE TO MAX -> PASSES STRAIGHT THROUGH
            int[] exit = {0, 0};
            float[] testCoords = {startX, startY};

            while (true) {
                boolean exitSet = false;
                for (int i = 0; i < downAndLeftExits.length; i++) {
                    if (sketch.dist(testCoords[0], testCoords[1], downAndLeftExits[i][0], downAndLeftExits[i][1]) < 15) {
                        exit = new int[]{downAndLeftExits[i][0], downAndLeftExits[i][1]};
                        distance = sketch.dist(startX, startY, exit[0], exit[1]);
                        exitSet = true;
                        break;
                    }
                }

                if (exitSet) {
                    break;
                }

                testCoords[0]--;
                testCoords[1] += 1.72;

                if (testCoords[0] < 0 || testCoords[1] > sketch.height) {
                    sketch.print("NO EXIT FOUND");
                    break;
                }
            }

            // ^^ SET DISTANCE TO MAX POSSIBLE DISTANCE TO EXIT ^^





            for (int j = 0; j < numOfAtoms; j++) {
                testCoords = new float[]{startX, startY};

                while (sketch.dist(testCoords[0], testCoords[1], atomPositions[j][0], atomPositions[j][1]) > 15 && testCoords[0] > exit[0] && testCoords[1] < exit[1]) {
                    testCoords[0]--;
                    testCoords[1] += 1.72;


                    // CIRCLE OF INFLUENCE FOUND
                    if (sketch.dist(testCoords[0], testCoords[1], atomPositions[j][0], atomPositions[j][1]) <= 59 && !circleOfInfluence && sketch.dist(testCoords[0], testCoords[1], startX, startY) > 10) {
                        circleOfInfluence = true;
                        influenceX = testCoords[0];
                        influenceY = testCoords[1];
                    }
                }


                // DIRECT HIT
                if (sketch.dist(testCoords[0], testCoords[1], atomPositions[j][0], atomPositions[j][1]) <= 15) {
                    distance = sketch.dist(startX, startY, atomPositions[j][0], atomPositions[j][1]);
                    directHit = true;
                    break;
                }

                // CIRCLE OF INFLUENCE AND NOT DIRECT HIT
                if (circleOfInfluence) {
                    distance = sketch.dist(influenceX, influenceY, startX, startY);

                    float newAngle = angle;

                    drawRay(startX, startY, angles[1], distance, sketch);

                    if (influenceX > atomPositions[j][0]) { // HITS RIGHT SIDE OF CIRCLE -> BOUNCES DOWN AND RIGHT
                        return drawRayWithBounces(atomPositions, influenceX, influenceY, 1, false, sketch);
                    } else { // HITS LEFT SIDE OF CIRCLE -> BOUNCES LEFT
                        return drawRayWithBounces(atomPositions, influenceX, influenceY, 4, false, sketch);
                    }

//                    break;
                }
            }
            endOfLine = drawRay(startX, startY, angles[1], distance, sketch);
        }


        else if (direction == 3) { // Right ---------------------------------------------------------------------------------------------------

            float distance = 0;

            // SET DISTANCE TO MAX -> PASSES STRAIGHT THROUGH
            int[] exit = {0, 0};
            float[] testCoords = {startX, startY};

            while (true) {
                boolean exitSet = false;
                for (int i = 0; i < rightExits.length; i++) {
                    if (sketch.dist(testCoords[0], testCoords[1], rightExits[i][0], rightExits[i][1]) < 15) {
                        exit = new int[]{rightExits[i][0], rightExits[i][1]};
                        distance = sketch.dist(startX, startY, exit[0], exit[1]);
                        exitSet = true;
                        break;
                    }
                }

                if (exitSet) {
                    break;
                }

                testCoords[0]++;
                testCoords[1] += 0.04;

                if (testCoords[0] > sketch.width) {
                    sketch.print("NO EXIT FOUND");
                    break;
                }
            }

            // ^^ SET DISTANCE TO MAX POSSIBLE DISTANCE TO EXIT ^^




            for (int j = 0; j < numOfAtoms; j++) {
                testCoords = new float[]{startX, startY};


                while (sketch.dist(testCoords[0], testCoords[1], atomPositions[j][0], atomPositions[j][1]) > 15 && testCoords[0] < exit[0]) {
                    testCoords[0]++;
                    testCoords[1] += 0.04;


                    // CIRCLE OF INFLUENCE FOUND
                    if (sketch.dist(testCoords[0], testCoords[1], atomPositions[j][0], atomPositions[j][1]) <= 59 && !circleOfInfluence) {
                        circleOfInfluence = true;
                        influenceX = testCoords[0];
                        influenceY = testCoords[1];
                    }
                }


                // DIRECT HIT
                if (sketch.dist(testCoords[0], testCoords[1], atomPositions[j][0], atomPositions[j][1]) <= 15) {
                    distance = sketch.dist(startX, startY, atomPositions[j][0], atomPositions[j][1]);
                    directHit = true;
                    break;
                }

                // CIRCLE OF INFLUENCE AND NOT DIRECT HIT
                if (circleOfInfluence && sketch.dist(influenceX, influenceY, startX, startY) > 5) {
                    distance = sketch.dist(influenceX, influenceY, startX, startY);

                    float newAngle = angle;

                    drawRay(startX, startY, angles[2], distance, sketch);

                    if (influenceY > atomPositions[j][1]) { // HITS BOTTOM HALF OF CIRCLE -> BOUNCES DOWN AND RIGHT
                        return drawRayWithBounces(atomPositions, influenceX, influenceY, 1, false, sketch);
                    }
                    else { // HITS TOP HALF OF CIRCLE -> BOUNCES UP AND RIGHT
                        return drawRayWithBounces(atomPositions, influenceX, influenceY, 5, false, sketch);

                    }

//                        break;

                }
            }

            endOfLine = drawRay(startX, startY, angles[2], distance, sketch);

        }


        else if (direction == 4) { // Left ---------------------------------------------------------------------------------------------------


            float distance = 0;

            // SET DISTANCE TO MAX -> PASSES STRAIGHT THROUGH
            int[] exit = {0, 0};
            float[] testCoords = {startX, startY};

            while (true) {
                boolean exitSet = false;
                for (int i = 0; i < leftExits.length; i++) {
                    if (sketch.dist(testCoords[0], testCoords[1], leftExits[i][0], leftExits[i][1]) < 15) {
                        exit = new int[]{leftExits[i][0], leftExits[i][1]};
                        distance = sketch.dist(startX, startY, exit[0], exit[1]);
                        exitSet = true;
                        break;
                    }
                }

                if (exitSet) {
                    break;
                }

                testCoords[0]--;
                testCoords[1] += 0.04;

                if (testCoords[0] < 0) {
                    sketch.print("NO EXIT FOUND");
                    break;
                }
            }


            // ^^ SET DISTANCE TO MAX POSSIBLE DISTANCE TO EXIT ^^




            for (int j = numOfAtoms-1; j >= 0; j--) {
                testCoords = new float[]{startX, startY};


                while (sketch.dist(testCoords[0], testCoords[1], atomPositions[j][0], atomPositions[j][1]) > 15 && testCoords[0] > exit[0]) {
                    testCoords[0]--;
                    testCoords[1] += 0.04;


                    // CIRCLE OF INFLUENCE FOUND
                    if (sketch.dist(testCoords[0], testCoords[1], atomPositions[j][0], atomPositions[j][1]) <= 59 && !circleOfInfluence) {
                        circleOfInfluence = true;
                        influenceX = testCoords[0];
                        influenceY = testCoords[1];
                    }
                }


                // DIRECT HIT
                if (sketch.dist(testCoords[0], testCoords[1], atomPositions[j][0], atomPositions[j][1]) <= 15) {
                    distance = sketch.dist(startX, startY, atomPositions[j][0], atomPositions[j][1]);
                    directHit = true;
                    break;
                }

                // CIRCLE OF INFLUENCE AND NOT DIRECT HIT
                if (circleOfInfluence && sketch.dist(influenceX, influenceY, startX, startY) > 5) {
                    distance = sketch.dist(influenceX, influenceY, startX, startY);

                    float newAngle = angle;

                    drawRay(startX, startY, angles[3], distance, sketch);

                    if (influenceY > atomPositions[j][1]) { // HITS BOTTOM HALF OF CIRCLE -> BOUNCES DOWN AND LEFT
                        return drawRayWithBounces(atomPositions, influenceX, influenceY, 2, false, sketch);
                    }
                    else { // HITS TOP HALF OF CIRCLE -> BOUNCES UP AND LEFT
                        return drawRayWithBounces(atomPositions, influenceX, influenceY, 6, false, sketch);
                    }

//                    break;

                }
            }

            endOfLine = drawRay(startX, startY, angles[3], distance, sketch);

        }


        else if (direction == 5) { // Up and right ---------------------------------------------------------------------------------------------------
            float distance = 0;

            // SET DISTANCE TO MAX -> PASSES STRAIGHT THROUGH
            int[] exit = {0, 0};
            float[] testCoords = {startX, startY};

            while (true) {
                boolean exitSet = false;
                for (int i = 0; i < upAndRightExits.length; i++) {
                    if (sketch.dist(testCoords[0], testCoords[1], upAndRightExits[i][0], upAndRightExits[i][1]) < 15) {
                        exit = new int[]{upAndRightExits[i][0], upAndRightExits[i][1]};
                        distance = sketch.dist(startX, startY, exit[0], exit[1]);
                        exitSet = true;
                        break;
                    }
                }

                if (exitSet) {
                    break;
                }

                testCoords[0]++;
                testCoords[1] -= 1.72;

                if (testCoords[0] > sketch.width || testCoords[1] < 0) {
                    sketch.print("NO EXIT FOUND");
                    break;
                }
            }

            // ^^ SET DISTANCE TO MAX POSSIBLE DISTANCE TO EXIT ^^



            for (int j = numOfAtoms - 1; j >= 0; j--) {
                testCoords = new float[]{startX, startY};

                while (sketch.dist(testCoords[0], testCoords[1], atomPositions[j][0], atomPositions[j][1]) > 15 && testCoords[0] < exit[0] && testCoords[1] > exit[1]) {

                    testCoords[0]++;
                    testCoords[1] -= 1.72;

//                    sketch.ellipse(testCoords[0], testCoords[1], 3, 3);


                    // CIRCLE OF INFLUENCE FOUND
                    if (sketch.dist(testCoords[0], testCoords[1], atomPositions[j][0], atomPositions[j][1]) <= 59 && !circleOfInfluence) {
                        circleOfInfluence = true;
                        influenceX = testCoords[0];
                        influenceY = testCoords[1];
                    }
                }


                // DIRECT HIT
                if (sketch.dist(testCoords[0], testCoords[1], atomPositions[j][0], atomPositions[j][1]) <= 15) {
                    distance = sketch.dist(startX, startY, atomPositions[j][0], atomPositions[j][1]);
                    directHit = true;
                    break;
                }

                // CIRCLE OF INFLUENCE AND NOT DIRECT HIT
                if (circleOfInfluence) {
                    distance = sketch.dist(influenceX, influenceY, startX, startY);

                    float newAngle = angle;

                    drawRay(startX, startY, angles[4], distance, sketch);

                    if (influenceX > atomPositions[j][0]) { // HITS RIGHT SIDE OF CIRCLE -> BOUNCES RIGHT
                        return drawRayWithBounces(atomPositions, influenceX, influenceY, 3, false, sketch);
                    } else { // HITS LEFT SIDE OF CIRCLE -> BOUNCES UP AND LEFT
                        return drawRayWithBounces(atomPositions, influenceX, influenceY, 6, false, sketch);
                    }

//                    break;
                }
            }
            endOfLine = drawRay(startX, startY, angles[4], distance, sketch);

        }


        else if (direction == 6) { // Up and left ---------------------------------------------------------------------------------------------------

            float distance = 0;

            // SET DISTANCE TO MAX -> PASSES STRAIGHT THROUGH
            int[] exit = {0, 0};
            float[] testCoords = {startX, startY};

            while (true) {
                boolean exitSet = false;
                for (int i = 0; i < upAndLeftExits.length; i++) {
                    if (sketch.dist(testCoords[0], testCoords[1], upAndLeftExits[i][0], upAndLeftExits[i][1]) < 15) {
                        exit = new int[]{upAndLeftExits[i][0], upAndLeftExits[i][1]};
                        distance = sketch.dist(startX, startY, exit[0], exit[1]);
                        exitSet = true;
                        break;
                    }
                }

                if (exitSet) {
                    break;
                }

                testCoords[0]--;
                testCoords[1] -= 1.72;

                if (testCoords[0] > sketch.width || testCoords[1] < 0) {
                    sketch.print("NO EXIT FOUND");
                    break;
                }
            }

            // ^^ SET DISTANCE TO MAX POSSIBLE DISTANCE TO EXIT ^^

            for (int j = numOfAtoms - 1; j >= 0; j--) {
                testCoords = new float[]{startX, startY};

                while (sketch.dist(testCoords[0], testCoords[1], atomPositions[j][0], atomPositions[j][1]) > 15 && testCoords[0] > exit[0] && testCoords[1] > exit[1]) {
                    testCoords[0]--;
                    testCoords[1] -= 1.72;


                    // CIRCLE OF INFLUENCE FOUND
                    if (sketch.dist(testCoords[0], testCoords[1], atomPositions[j][0], atomPositions[j][1]) <= 59 && !circleOfInfluence) {
                        circleOfInfluence = true;
                        influenceX = testCoords[0];
                        influenceY = testCoords[1];
                    }
                }


                // DIRECT HIT
                if (sketch.dist(testCoords[0], testCoords[1], atomPositions[j][0], atomPositions[j][1]) <= 15) {
                    distance = sketch.dist(startX, startY, atomPositions[j][0], atomPositions[j][1]);
                    directHit = true;
                    break;
                }

                // CIRCLE OF INFLUENCE AND NOT DIRECT HIT
                if (circleOfInfluence) {
                    distance = sketch.dist(influenceX, influenceY, startX, startY);

                    float newAngle = angle;

                    drawRay(startX, startY, angles[5], distance, sketch);

                    if (influenceX > atomPositions[j][0]) { // HITS RIGHT SIDE OF CIRCLE -> BOUNCES LEFT
                        return drawRayWithBounces(atomPositions, influenceX, influenceY, 5, false, sketch);
                    } else { // HITS LEFT SIDE OF CIRCLE -> BOUNCES UP AND RIGHT
                        return drawRayWithBounces(atomPositions, influenceX, influenceY, 4, false, sketch);
                    }

//                    break;
                }

            }
            endOfLine = drawRay(startX, startY, angles[5], distance, sketch);

        }

        if (directHit) {
            endOfLine = new float[] {-1, -1};
        }
        return endOfLine;
    }





}