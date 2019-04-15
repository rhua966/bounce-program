/*
 *  ===============================================================================
 *  MovingSquare.java : A shape that is an square.
 *  An square has 4 handles shown when it is selected (by clicking on it).
 *  UPI: rhua966
 *  Name: Rui Huang
 *  ===============================================================================
 */

import java.awt.*;

public class MovingSquare extends MovingRectangle {

    /**
     * Constructor to create a square with default parameters.
     */
    public MovingSquare() {
        super();
    }

    /**
     * Constructor to create a square shape.
     */
    public MovingSquare(int x, int y, int w, int h, int mw, int mh, Color bc, Color fc, int pathType) {
        super(x, y, w, h, mw, mh, bc, fc, pathType);
    }
}