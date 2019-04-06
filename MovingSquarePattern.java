/*
 *  ===============================================================================
 *  MovingSquarePattern.java : A shape that is an square pattern.
 *  An square pattern has 4 handles shown when it is selected (by clicking on it).
 *  UPI: rhua966
 *  Name: Rui Huang
 *  ===============================================================================
 */

import java.awt.*;

public class MovingSquarePattern extends MovingShape {

    /**
     * Constructor to create a square pattern with default parameters.
     */
    public MovingSquarePattern() {
        this(0, 0, 50, 50, defaultMarginWidth, defaultMarginHeight, defaultBorderColor, defaultFillColor, defaultPath);
    }

    /**
     * Constructor to create a square pattern shape.
     */
    public MovingSquarePattern(int x, int y, int w, int h, int mw, int mh, Color bc, Color fc, int pathType) {
        super(x, y, (w > h) ? h : w, (w > h) ? h : w, mw, mh, bc, fc, pathType);
    }

    /** draw the square pattern with the fill colour
     *  If it is selected, draw the handles
     *  @param g	the Graphics control
     */
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g.setColor(fillColor);
    }
    public boolean contains(Point mousePt) {
        Point endPt = new Point(topLeft.x + width, topLeft.y + height);
        return (topLeft.x <= mousePt.x && mousePt.x <= endPt.x) && (topLeft.y <= mousePt.y && mousePt.y <= endPt.y);
    }
}