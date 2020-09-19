import java.awt.*;
import java.util.*;

class MovingOverlappedSquare extends MovingRectangle { //with min values
	private boolean isOverlapped = false;
	private Random rand;
	private Rectangle square1, square2;
	public static final int SIZE = 30;

	/** constructor to create a rectangle with default values */
	public MovingOverlappedSquare(Random obj) { super(); this.rand = obj;
       		validateSize(); setUp();}
	/** constructor to create a rectangle/square with default values */
	public MovingOverlappedSquare(int defaultsize, Random obj) { super(defaultsize);
		validateSize();
		this.rand = obj;  setUp();
		}
	private void validateSize() {
		if (width<2*SIZE) width=2*SIZE+1;
		if (height<SIZE) height=SIZE+1;
	}
	/** constructor to create a rectangle shape */
	public MovingOverlappedSquare(int x, int y, int w, int h, int mw, int mh, Color bc, Color fc, int pathType, Random obj) {
		super(x ,y ,w, h ,mw ,mh, bc, fc, pathType);
		validateSize();
		this.rand = obj;
		setUp();
	}
    public boolean isRandomReady() { return rand != null; }
	private void setUp() {
		int dx1 = rand.nextInt(width-SIZE);
		int dy1 = rand.nextInt(height-SIZE);
		int dx2 = rand.nextInt(width-SIZE);
		int dy2 = rand.nextInt(height-SIZE);
		square1 = new Rectangle(x+dx1, y+dy1, SIZE, SIZE);
		square2 = new Rectangle(x+dx2, y+dy2, SIZE, SIZE);
		isOverlapped = square1.intersects(square2);
	}
	/** draw the rectangle with the fill colour
	 *	If it is selected, draw the handles
	*	@param g	the Graphics control */
	public void draw(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setPaint(borderColor);
		g.drawRect(x,y,width,height);
		if (isOverlapped) {
			g2d.setPaint(fillColor);
			g.fillRect(square1.x, square1.y, SIZE, SIZE);
			g.fillRect(square2.x, square2.y, SIZE, SIZE);
		} else {
			g2d.setPaint(borderColor);
			g.drawRect(square1.x, square1.y, SIZE, SIZE);
			g.drawRect(square2.x, square2.y, SIZE, SIZE);
		}
	}
	public boolean getIsOverlapped() { return isOverlapped; }
	public Rectangle getSquare1() { return square1; }
	public Rectangle getSquare2() { return square2; }

	public void setHeight(int h) {
		if (h>SIZE) {
			super.setHeight(h);
			setUp();
		}
	}
	public void setWidth(int w) {
		if (w>SIZE*2) {
			super.setWidth(w);
			setUp();
		}
	}
	public void move() {
		super.move();
		if (y==0) {
			square1.y =0;
			square2.y =0;
		} else {
			square1.translate(path.deltaX, path.deltaY);
			square2.translate(path.deltaX, path.deltaY);
		}

	}
}


