/*
 *	===============================================================================
 *	MovingSquare.java : shape that is a square.
 *	A square has 4 handles shown when it is selected (by clicking on it).
 *	===============================================================================
 */
import java.awt.*;
public class MovingSquare extends MovingRectangle {

	/** constuctor to create a rectangle with default values */
	public MovingSquare() {super(Math.min(DEFAULTWIDTH, DEFAULTHEIGHT));}

	/** constuctor to create a rectangle shape */
	public MovingSquare(int x, int y, int s, int mw, int mh, Color bc, Color fc, int pathType) {
		super(x ,y ,s, s, mw ,mh, bc, fc, pathType);
	}
	public MovingSquare(int defaultsize) { super(defaultsize); }
    /** Set the height and width of the shape.
     * @param h     the height/width value */
	public void setHeight(int h) {
		super.setHeight(h);
		super.setWidth(h);
	}

    /** Set the height and width of the shape.
     * @param w     the height/width value */
	public void setWidth(int w) {
		super.setHeight(w);
		super.setWidth(w);
	}

}