/*
 *  ===============================================================================
 *  MovingPanman.java : A shape that is a pacman.
 *  A pacman has 4 handles shown when it is selected (by clicking on it).
 *  UPI: rhua966
 *  Name: Rui Huang
 *  ===============================================================================
 */

import java.awt.*;

public class MovingPacman extends MovingSquare {

    /**
     * Constructor to create a pacman with default parameters.
     */
    public MovingPacman() {
        super();
    }

    /**
     * Constructor to create a pacman.
     */
    public MovingPacman(int x, int y, int w, int h, int mw, int mh, Color bc, Color fc, int pathType) {
        super(x, y, w, h, mw, mh, bc, fc, pathType);
    }
    public void draw(Graphics g) {
        int d = width / 20;
        Graphics2D g2d = (Graphics2D) g;
        g.setColor(borderColor);
        g.fillArc(topLeft.x, topLeft.y, width, height, 30, 300);
        g.setColor(fillColor);
        g.fillArc(topLeft.x + d, topLeft.y + d, width - 2 * d, height - 2 * d, 30, 300);
        g.setColor(Color.black);
        g.fillOval((int)(topLeft.x + width / 2.5), (int)(topLeft.y + width / 4.4), width / 10, width / 10);
        drawHandles(g);
    }
    public boolean contains(Point mousePt) {
        Point endPt = new Point(topLeft.x + width, topLeft.y + height);
        double dx = (2 * mousePt.x - topLeft.x - endPt.x) / (double) width;
        double dy = (2 * mousePt.y - topLeft.y - endPt.y) / (double) height;
        return Math.pow(dx, 2) + Math.pow(dy, 2) < 1.0;
    }
}