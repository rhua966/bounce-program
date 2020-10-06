package bounce;

import java.awt.Image;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * Class to represent a rectangle that displays an image.
 * 
 * @author Ian Warren
 * 
 */
public class ImageRectangleShape extends RectangleShape {

	public static Image makeImage(String imageFileName, int shapeWidth) {
		File imageFile = new File(imageFileName);
		BufferedImage scaledImage = null;

		try {
			BufferedImage fullImage = ImageIO.read(imageFile);
			int fullImageWidth = fullImage.getWidth();
			int fullImageHeight = fullImage.getHeight();
				
			scaledImage = fullImage;
				
			// Scale the image if necessary.
			if(fullImageWidth > shapeWidth) {
				double scaleFactor = (double)shapeWidth / (double)fullImageWidth;
				int height = (int)((double)fullImageHeight * scaleFactor);
				System.out.println("w: " + shapeWidth + ", h: " + height);
					
				scaledImage = new BufferedImage(shapeWidth,height,BufferedImage.TYPE_INT_RGB); 
				Graphics2D g = scaledImage.createGraphics();
					
				// Method drawImage() scales images fast. The ImageObserver 
				// argument is null - if scaling was more expensive an 
				// ImageObserver could be added to wait for the scaling to
				// complete.
				g.drawImage(fullImage, 0, 0, shapeWidth, height, null);
			}
		} catch (IOException e) {
			System.out.println("Error loading image file " + imageFile.getName());
		}
		return scaledImage;
	}

	private Image _picture;
	
	public ImageRectangleShape(int deltaX, int deltaY, Image image) {
		// Derive the shape's width and height from the image.
		super(DEFAULT_X_POS, DEFAULT_Y_POS, deltaX, deltaY, image.getWidth(null), image.getHeight(null));
		
		_picture = image;
	}
	
	@Override
	public void paint(Painter painter) {
		painter.drawImage(_picture,_x,_y,_width,_height);
	}
}

