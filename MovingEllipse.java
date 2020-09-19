/*
 *	===============================================================================
 *	MovingRectangle.java : A shape that is a rectangle.
 *	A rectangle has 4 handles shown when it is selected (by clicking on it).
 *	===============================================================================
 */
import java.awt.*;
public class MovingEllipse extends MovingShape {

	/** constructor to create a rectangle with default values */
	public MovingEllipse() { super(); }

	/** constructor to create an ellipse/circle with default values */
	public MovingEllipse(int defaultsize) { super(defaultsize); }
	/** constructor to create a rectangle shape
	 */
	public MovingEllipse(int x, int y, int w, int h, int mw, int mh, Color bc, Color fc, int pathType) {
		super(x ,y ,w, h ,mw ,mh, bc, fc, pathType);
	}

	/** return the area of the shape
     * @return the area */
	public double getArea() { return Math.PI * (width/2) * (height/2); }

	/** draw the rectangle with the fill colour
	 *	If it is selected, draw the handles
	 *	@param g	the Graphics control
	 */
	public void draw(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setPaint(fillColor);
		g2d.fillOval(x, y, width, height);
		g2d.setPaint(borderColor);
		g2d.drawOval(x, y, width, height);
	}

	/** Returns whether the point is in the oval or not
	 * @return true if and only if the point is in the oval, false otherwise.  */
	public boolean contains(Point mousePt) {
		double dx, dy;
		Point EndPt = new Point(x + width, y + height);
		dx = (2 * mousePt.x - x - EndPt.x) / (double) width;
		dy = (2 * mousePt.y - y - EndPt.y) / (double) height;
		return dx * dx + dy * dy < 1.0;
	}

}