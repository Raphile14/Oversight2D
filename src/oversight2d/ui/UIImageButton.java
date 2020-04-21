package oversight2d.ui;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import oversight2d.gfx.Assets;

/**
 *
 * @author Raphael Dalangin
 */
public class UIImageButton extends UIObject {
    
    private BufferedImage[] images;
    private ClickListener clicker;

    public UIImageButton(float x, float y, int width, int height, BufferedImage[] images, ClickListener clicker) {
        super(x, y, width, height);
        this.images = images;
        this.clicker = clicker;
    }

    @Override
    public void tick() {
        
    }

    @Override
    public void render(Graphics g) {
        if (hovering)
            g.drawImage(images[5], (int) x, (int) y, width, height, null);
        else 
            g.drawImage(images[0], (int) x, (int) y, width, height, null);
    }

    @Override
    public void onClick() {
        clicker.onClick();
    }
    
    
}
