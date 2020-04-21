package oversight2d.gfx;

import java.awt.image.BufferedImage;

/**
 *
 * @author Raphael Dalangin
 */
public class SpriteSheet {
    
	// Stores the image as a SpriteSheet
	// Can crop images
	
    private BufferedImage sheet;
    
    public SpriteSheet(BufferedImage sheet) {
        this.sheet = sheet;
    }
    
    public BufferedImage crop(int x, int y, int width, int height) {
        return sheet.getSubimage(x, y, width, height);
    }
}
