package bounce;
import java.awt.Color;

/**
 * Solution class.
 */
public class DynamicRectangleShape extends RectangleShape {
	
	private static final Color DEFAULT_COLOR = Color.RED;
	
	protected boolean _filled;
	protected Color _color;
	
	public DynamicRectangleShape(int x, int y, int deltaX, int deltaY, int width,
			int height) {
		super(x, y, deltaX, deltaY, width, height);
		this._filled = true;
		this._color = DEFAULT_COLOR;
	}
	
	public DynamicRectangleShape(int x, int y, int deltaX, int deltaY, int width,
			int height, Color color) {
		super(x, y, deltaX, deltaY, width, height);
		this._filled = true;
		this._color = color;
	}
	
	@Override
	public void move(int width, int height) {
	    int preDeltaX = _deltaX;
	    int preDeltaY = _deltaY;
	    super.move(width, height);

	    if((preDeltaY < 0 && _deltaY > 0) ||
	       (preDeltaY > 0 && _deltaY < 0)) {
	      // Bounced off horizontal wall.
	      _filled = false;
	    }
	    if((preDeltaX < 0 && _deltaX > 0) ||
	       (preDeltaX > 0 && _deltaX < 0)) {
	      // Bounced off vertical wall.
	      _filled = true;
	    }
	  }

	@Override
	public void paint(Painter painter) {
		if(this._filled) {
			Color defaultColor = painter.getColor();
			painter.setColor(this._color);
			painter.fillRect(this._x, this._y, this._width, this._height);
			painter.setColor(defaultColor);
		} else {
			super.paint(painter);
		}
	}
}

