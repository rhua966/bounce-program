/*
 *  ===============================================================================
 *  MovingRectangle.java : A shape that is an rectangle.
 *  An rectangle has 4 handles shown when it is selected (by clicking on it).
 *  UPI: rhua966
 *  Name: Rui Huang
 *  ===============================================================================
 */

import java.awt.*;

public class MovingRectangle extends MovingShape {

    /**
     * Constructor to create a rectangle with default parameters.
     */
    public MovingRectangle() {
        this(0, 0, defaultWidth, defaultHeight, defaultMarginWidth, defaultMarginHeight, defaultBorderColor, defaultFillColor, defaultPath);
    }

    /**
     * Constructor to create a rectangle shape.
     */
    public MovingRectangle(int x, int y, int w, int h, int mw, int mh, Color bc, Color fc, int pathType) {
        super(x, y, w, h, mw, mh, bc, fc, pathType);
    }

    /** draw the rectangle with the fill colour
     *  If it is selected, draw the handles
     *  @param g	the Graphics control
     */
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g.setColor(fillColor);
        g.fillRect(topLeft.x, topLeft.y, width, height);
        g.setColor(borderColor);
        g.drawRect(topLeft.x, topLeft.y, width, height);
        drawHandles(g);
    }

    /** Returns whether the point is in the rectangle or not
     * @return true if and only if the point is in the rectangle, false otherwise.
     */
    public boolean contains(Point mousePt) {
        Point endPt = new Point(topLeft.x + width, topLeft.y + height);
        return (topLeft.x <= mousePt.x && mousePt.x <= endPt.x) && (topLeft.y <= mousePt.y && mousePt.y <= endPt.y);
    }
}
