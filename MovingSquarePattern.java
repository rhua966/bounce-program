/*
 *  ===============================================================================
 *  MovingSquarePattern.java : A shape that is an square pattern.
 *  An square pattern has 4 handles shown when it is selected (by clicking on it).
 *  UPI: rhua966
 *  Name: Rui Huang
 *  ===============================================================================
 */

import java.awt.*;

public class MovingSquarePattern extends MovingSquare {

    /**
     * Constructor to create a square pattern with default parameters.
     */
    public MovingSquarePattern() {
        super();
    }

    /**
     * Constructor to create a square pattern shape.
     */
    public MovingSquarePattern(int x, int y, int w, int h, int mw, int mh, Color bc, Color fc, int pathType) {
        super(x, y, w, h, mw, mh, bc, fc, pathType);
    }
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        int d = width / 10;
        g.setColor(fillColor);
        g.drawRect(topLeft.x, topLeft.y, width, height);
        for(int i = 0; i < 10; i++) {
            g.drawLine(topLeft.x, topLeft.y + i * d, topLeft.x + i * d, topLeft.y + height);
            g.drawLine(topLeft.x + i * d, topLeft.y, topLeft.x + width, topLeft.y + i * d);
        }
        drawHandles(g);
    }
}