package bounce;


/**
 * Solution class.
 */
public class GemShape extends Shape {

	protected static int GAP = 20;

	public GemShape() {
		super();
	}

	public GemShape(int x, int y, int deltaX, int deltaY, int width,
			int height) {
		super(x, y, deltaX, deltaY, width, height);
	}
	
	@Override
	public void paint(Painter painter) {
		if (_width >= 40) {
			painter.drawLine(_x, _y + (_height / 2), _x + GAP, _y);
			painter.drawLine(_x + GAP, _y, _x + _width - GAP, _y); // Top line.
			painter.drawLine(_x + _width - GAP, _y, _x + _width, _y + (_height / 2));
			painter.drawLine(_x + _width, _y + (_height / 2), _x + _width - GAP, _y + _height);
			painter.drawLine(_x + _width - GAP, _y + _height, _x + GAP, _y + _height); // Bottom line.
			painter.drawLine(_x + GAP, _y + _height, _x, _y + (_height / 2));
		}
		else {
			painter.drawLine(_x, _y + (_height / 2), _x + _width / 2, _y);
			painter.drawLine(_x + _width / 2, _y, _x + _width, _y + _height / 2);
			painter.drawLine(_x + _width, _y + _height / 2, _x + _width / 2, _y + _height);
			painter.drawLine(_x + _width / 2, _y + _height, _x, _y + (_height / 2));
		}
	}

}
