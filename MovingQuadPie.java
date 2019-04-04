/*
 *  ===============================================================================
 *  MovingQuadPie.java : A shape that is a quad pie.
 *  A quad pie has 4 handles shown when it is selected (by clicking on it).
 *  UPI: rhua966
 *  Name: Rui Huang
 *  ===============================================================================
 */

import java.awt.*;

public class MovingQuadPie extends MovingShape {

    /**
     * Constructor to create a quad pie with default parameters.
     */
    public MovingQuadPie() {
        this(0, 0, 50, 50, defaultMarginWidth, defaultMarginHeight, defaultBorderColor, defaultFillColor, defaultPath);
    }

    /**
     * Constructor to create a square shape.
     */
    public MovingQuadPie(int x, int y, int w, int h, int mw, int mh, Color bc, Color fc, int pathType) {
        super(x, y, (w >= h) ? h : w, (w >= h) ? h : w, mw, mh, bc, fc, pathType);
    }

    /** draw the quad pie with the fill colour
     *  If it is selected, draw the handles
     *  @param g	the Graphics control
     */
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g.setColor(borderColor);
        g.drawOval(topLeft.x, topLeft.y, width, height);
        g.setColor(fillColor);
        g.fillArc(topLeft.x, topLeft.y, width, height, 0, 90);
        g.fillArc(topLeft.x, topLeft.y, width, height, 180, 90);
        drawHandles(g);
    }
    public boolean contains(Point mousePt) {
        Point endPt = new Point(topLeft.x + width, topLeft.y + height);
        double dx = (2 * mousePt.x - topLeft.x - endPt.x) / (double) width;
        double dy = (2 * mousePt.y - topLeft.y - endPt.y) / (double) height;
        return Math.pow(dx, 2) + Math.pow(dy, 2) < 1.0;
    }
}