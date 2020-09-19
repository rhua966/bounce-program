/*
 *	===============================================================================
 *	MovingRectangle.java : A shape that is a rectangle.
 *	A rectangle has 4 handles shown when it is selected (by clicking on it).
 *	=============================================================================== */
import java.awt.*;
public class MovingRectangle extends MovingShape {

	/** constructor to create a rectangle with default values */
	public MovingRectangle() { super(); }

	/** constructor to create a rectangle/square with default values */
	public MovingRectangle(int defaultsize) { super(defaultsize); }

	/** constructor to create a rectangle shape */
	public MovingRectangle(int x, int y, int w, int h, int mw, int mh, Color bc, Color fc, int pathType) {
		super(x ,y ,w, h ,mw ,mh, bc, fc, pathType);
	}

	/** return the area of the shape
     * @return the area */
	public double getArea() { return width * height; }

	/** draw the rectangle with the fill colour
	 *	If it is selected, draw the handles
	 *	@param g	the Graphics control */
	public void draw(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setPaint(fillColor);
		g2d.fillRect(x, y, width, height);
		g2d.setPaint(borderColor);
		g2d.drawRect(x, y, width, height);
	}

	/** Returns whether the point is in the rectangle or not
	 * @return true if and only if the point is in the rectangle, false otherwise. */
	public boolean contains(Point mousePt) {
		return (x <= mousePt.x && mousePt.x <= (x + width + 1)	&&	y <= mousePt.y && mousePt.y <= (y + height + 1));
	}
	public void setHeight(int height) {}
}