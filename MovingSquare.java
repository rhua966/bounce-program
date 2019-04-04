/*
 *  ===============================================================================
 *  MovingSquare.java : A shape that is an square.
 *  An square has 4 handles shown when it is selected (by clicking on it).
 *  UPI: rhua966
 *  Name: Rui Huang
 *  ===============================================================================
 */

import java.awt.*;

public class MovingSquare extends MovingShape {

    /**
     * Constructor to create a square with default parameters.
     */
    public MovingSquare() {
        this(0, 0, 50, 50, defaultMarginWidth, defaultMarginHeight, defaultBorderColor, defaultFillColor, defaultPath);
    }

    /**
     * Constructor to create a square shape.
     */
    public MovingSquare(int x, int y, int w, int h, int mw, int mh, Color bc, Color fc, int pathType) {
        super(x, y, (w > h) ? h : w, (w > h) ? h : w, mw, mh, bc, fc, pathType);
    }

    /** draw the square with the fill colour
     *  If it is selected, draw the handles
     *  @param g	the Graphics control
     */
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g.setColor(borderColor);
        g.drawRect(topLeft.x, topLeft.y, width, height);
        g.setColor(fillColor);
        g.fillRect(topLeft.x, topLeft.y, width, height);
        drawHandles(g);
    }
    public boolean contains(Point mousePt) {
        Point endPt = new Point(topLeft.x + width, topLeft.y + height);
        return (topLeft.x <= mousePt.x && mousePt.x <= endPt.x) && (topLeft.y <= mousePt.y && mousePt.y <= endPt.y);
    }
}