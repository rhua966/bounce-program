import java.awt.*;
import java.util.*;

class MovingPyramid extends MovingRectangle {
	private int xSize, ySize;
	public static final int NUMBER_OF_ROWS = 5;

	/** constructor to create a rectangle with default values */
	public MovingPyramid() { super(); setUp(); }
	/** constructor to create a rectangle/square with default values */
	public MovingPyramid(int defaultsize) { super(defaultsize); setUp(); }
	public MovingPyramid(int x, int y, int w, int h, int mw, int mh, Color bc, Color fc, int pathType) {
		super(x ,y ,w, h, mw ,mh, bc, fc, pathType);
		setUp();
	}
	private void setUp() {
		xSize = width/(2*NUMBER_OF_ROWS -1);
		ySize = height/(NUMBER_OF_ROWS);
	}
	public void draw(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		int  startX= x +(NUMBER_OF_ROWS-1)*xSize , currentX=startX, currentY=y;
		boolean rowFilled = false;
		boolean filled = false;
		for (int i=0; i<NUMBER_OF_ROWS; i++) {
			filled = false;
			for (int j=0; j<=i*2; j++) {
				if (filled)
					g2d.setPaint(fillColor);
				else g2d.setPaint(Color.white);
				g.fillRect(currentX, currentY, xSize, ySize);
				currentX += xSize;
				filled = !filled;
			}
			startX -= xSize;
			currentY += ySize;
			currentX = startX;
		}
        g2d.setPaint(borderColor);
        g2d.drawRect(x, y, width, height);
	}
	public void setHeight(int h) {
		super.setHeight(h);
		setUp();
	}
	public void setWidth(int w) {
		super.setWidth(w);
		setUp();
	}
	public int getXSize() {return xSize; }
	public int getYSize() {return ySize; }
	public static int geNumberOfRows() {return NUMBER_OF_ROWS; }
}