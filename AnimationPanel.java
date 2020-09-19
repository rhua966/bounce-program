/*
 *    ==========================================================================================
 *    AnimationPanel.java : Moves shapes around on the screen according to different paths.
 *    It is the main drawing area where shapes are added and manipulated.
 *    It also contains a popup menu to clear all shapes.
 *    ==========================================================================================
 */

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class AnimationPanel extends JComponent implements Runnable {
    private Thread animationThread = null;    // the thread for animation
    private ArrayList<MovingShape> shapes;		// the ArrayList which stores a list of shapes
    private int currentWidth=100, currentHeight=50, currentShapeType, currentPath; // the current shape type, // the current path type
    private Color currentBorderColor = Color.yellow;  // the current border colour of a shape
    private Color currentFillColor = Color.green;  // the current fill colour of a shape
    private int delay = 100;         // the current animation speed
    JPopupMenu popup;                // popup menu
    private Random rand = new Random();

     /** Constructor of the AnimationPanel */
    public AnimationPanel() {
		rand.setSeed(30);
		shapes = new ArrayList<MovingShape>(); //create the ArrayList to store shapes
        Insets insets = getInsets();
        int marginWidth = getWidth() - insets.left - insets.right;
        int marginHeight = getHeight() - insets.top - insets.bottom;
        popup = new JPopupMenu(); //create the popup menu
        makePopupMenu();
        // add the mouse event to handle popup menu
		addMouseListener( new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				maybeShowPopup(e);
			}
			public void mouseReleased(MouseEvent e) {
				maybeShowPopup(e);
			}
			private void maybeShowPopup(MouseEvent e) {
				if (e.isPopupTrigger()) {
					popup.show(e.getComponent(), e.getX(), e.getY());
				}
			}
            public void mouseClicked( MouseEvent e ) {
                if (animationThread != null) {  // if the animation has started, then
                	boolean found = false;
                    for (MovingShape currentShape: shapes)
                    	if ( currentShape.contains( e.getPoint()) ) { // if the mousepoint is within a shape, then set the shape to be selected/deselected
                            currentShape.setSelected( ! currentShape.isSelected() );
                            found = true;
						}
					if (!found) createNewShape(e.getX(), e.getY());
            	}
			}
	    });
    }

    /** create a new shape
     * @param x     the x-coordinate of the mouse position
     * @param y    the y-coordinate of the mouse position */
    protected void createNewShape(int x, int y) {
        // get the margin of the frame
        Insets insets = getInsets();
        int marginWidth = getWidth() - insets.left - insets.right;
        int marginHeight = getHeight() - insets.top - insets.bottom;
        // create a new shape dependent on all current properties and the mouse position
        switch (currentShapeType) {
               case 0: {
			      shapes.add(new MovingRectangle(x,y,currentWidth,currentHeight,marginWidth,marginHeight,currentBorderColor,currentFillColor,currentPath));
			      break;
               } case 1: {
			      shapes.add(new MovingSquare(x,y,Math.min(currentWidth,currentHeight),marginWidth,marginHeight,currentBorderColor,currentFillColor,currentPath));
			      break;
               } case 2: {
			      shapes.add(new MovingEllipse(x,y,currentWidth,currentHeight,marginWidth,marginHeight,currentBorderColor,currentFillColor,currentPath));
			      break;
                } case 3: {
			      shapes.add(new MovingPyramid(x,y,currentWidth,currentHeight,marginWidth,marginHeight,currentBorderColor,currentFillColor,currentPath));
			      break;
                } case 4: {
			      shapes.add(new MovingOverlappedSquare(x,y,currentWidth,currentHeight,marginWidth,marginHeight,currentBorderColor,currentFillColor,currentPath,rand ));
			      break;
                // } case 5: {
			    //   shapes.add(new MovingFourLeaf(x,y,Math.min(currentWidth,currentHeight),marginWidth,marginHeight,currentBorderColor,currentFillColor,currentPath));
			    //   break;
			    }
			}
    }

    /** set the current shape type
     * @param s    the new shape type */
    public void setCurrentShapeType(int s) { currentShapeType = s; }

    /** set the current path type and the path type for all currently selected shapes
     * @param t    the new path type */
    public void setCurrentPathType(int index) {
        currentPath = index;
 		for (MovingShape currentShape: shapes)
			if ( currentShape.isSelected())
				currentShape.setPath(index);
    }

	/** get the current width
	 * @return currentWidth - the width value */
	public int getCurrentWidth() { return currentWidth; }
	/** set the current width and the width for all currently selected shapes
	 * @param w	the new width value */
	public void setCurrentWidth(int w) {
		currentWidth = w;
		for (MovingShape currentShape: shapes)
			if ( currentShape.isSelected())
				currentShape.setWidth(currentWidth);
	}

	/** get the current height
	 * @return currentHeight - the height value */
	public int getCurrentHeight() { return currentHeight; }
	/** set the current height and the height for all currently selected shapes
	 * @param h	the new height value */
	public void setCurrentHeight(int h) {
		currentHeight = h;
		for (MovingShape currentShape: shapes)
			if ( currentShape.isSelected())
				currentShape.setHeight(currentHeight);
	}

	/** get the current border colour
	 * @return currentBorderColor - the border colour value */
	public Color getCurrentBorderColor() { return currentBorderColor; }
 	/** set the current border colour and the border colour for all currently selected shapes
	 * @param bc	the new border colour value */
	public void setCurrentBorderColor(Color bc) {
		currentBorderColor = bc;
		for (MovingShape currentShape: shapes)
			if ( currentShape.isSelected())
				currentShape.setBorderColor(currentBorderColor);
	}

	/** get the current fill colour
	 * @return currentFillColor - the fill colour value */
	public Color getCurrentFillColor() { return currentFillColor; }
    /** set the current fill colour and the border colour for all currently selected shapes
     * @param bc    the new fill colour value */
    public void setCurrentFillColor(Color fc) {
        currentFillColor = fc;
        //complete this
		for (MovingShape currentShape: shapes)
			if ( currentShape.isSelected())
				currentShape.setFillColor(currentFillColor);
    }

	public void scaleUp() {
		for (MovingShape currentShape: shapes)
			if ( currentShape.isSelected())
				currentShape.scaleUp();
			}
	public void scaleDown() {
		for (MovingShape currentShape: shapes)
			if ( currentShape.isSelected())
				currentShape.scaleDown();
			}
    public String getSortedInfo() {
		Object[] info = shapes.toArray();
		Arrays.sort(info);
		StringBuffer buf = new StringBuffer();
		for (Object o: info)
			buf.append(o.toString() + "\n");
		return buf.toString(); } //complete this

   /** reset the margin size of all shapes from our ArrayList */
    public void resetMarginSize() {
        Insets insets = getInsets();
        int marginWidth = getWidth() - insets.left - insets.right;
        int marginHeight = getHeight() - insets.top - insets.bottom ;
        for (MovingShape currentShape: shapes)
				currentShape.setMarginSize(marginWidth,marginHeight );
    }

	/** remove all shapes from the ArrayList  */
    public void clearAllShapes() { shapes.clear(); }

    /**    update the painting area
     * @param g    the graphics control */
    public void update(Graphics g){ paint(g); }

    /**    move and paint all shapes within the animation area
     * @param g    the Graphics control */
    public void paintComponent(Graphics g) {
        for (MovingShape currentShape: shapes) {
            currentShape.move();
		    currentShape.draw(g);
		    currentShape.drawHandles(g);
		}
    }
    // you don't need to make any changes after this line ______________
    /** create the popup menu for our animation program  */
    protected void makePopupMenu() {
        JMenuItem menuItem;
     // clear all
        menuItem = new JMenuItem("Clear All");
        menuItem.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clearAllShapes();
            }
        });
        popup.add(menuItem);
     }
    /** change the speed of the animation
     * @param newValue     the speed of the animation in ms  */
    public void adjustSpeed(int newValue) {
        if (animationThread != null) {
            stop();
            delay = newValue;
            start();
        }
    }
    /**    When the "start" button is pressed, start the thread  */
    public void start() {
        animationThread = new Thread(this);
        animationThread.start();
    }
    /**    When the "stop" button is pressed, stop the thread */
    public void stop() {
        if (animationThread != null) {
            animationThread = null;
        }
    }
    /** run the animation */
    public void run() {
        Thread myThread = Thread.currentThread();
        while(animationThread==myThread) {
            repaint();
            pause(delay);
        }
    }
    /** Sleep for the specified amount of time */
    private void pause(int milliseconds) {
        try {
            Thread.sleep((long)milliseconds);
        } catch(InterruptedException ie) {}
    }
}
