package oversight2d.gfx;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author Raphael Dalangin
 */
public class ImageLoader {
    
	// Loads image from file
    public static BufferedImage loadImage(String path) {
        try {
            return ImageIO.read(ImageLoader.class.getResource(path));
        } catch (Exception ex) {
            System.out.println("Can't find image at " + path);
            System.exit(1);
        }
        return null;
    }
}
