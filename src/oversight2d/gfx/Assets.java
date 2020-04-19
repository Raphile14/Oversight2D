package oversight2d.gfx;

import java.awt.image.BufferedImage;

/**
 *
 * @author Raphael Dalangin
 */
public class Assets {
    
    private static final int width = 60, height = 60;
    
    public static BufferedImage walkDown, walkLeft, walkRight, walkTop, menu,
                                dirt, stone, sand, grass, gold, diamond, coal;
    
    public static void init() {
        SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/oversight2d/textures/testSprite.png"));
        SpriteSheet sheet2 = new SpriteSheet(ImageLoader.loadImage("/oversight2d/textures/menu.jpg"));
        SpriteSheet sheet3 = new SpriteSheet(ImageLoader.loadImage("/oversight2d/textures/minecraft.png"));
        
        walkDown = sheet.crop(0, 0, width, height);
        walkLeft = sheet.crop(0, height, width, height);
        walkRight = sheet.crop(0, height * 2, width, height);
        walkTop = sheet.crop(0, height * 3, width, height);
        menu = sheet2.crop(0, 0, width * 3, height * 3);
        
        dirt = sheet3.crop(80, 0, 80, 80);
        stone = sheet3.crop(160, 0, 80, 80);
        sand = sheet3.crop(320, 0, 80, 80);
        grass = sheet3.crop(0, 80, 80, 80);
        gold = sheet3.crop(240, 80, 80, 80);
        diamond = sheet3.crop(320, 80, 80, 80);
        coal = sheet3.crop(80, 160, 80, 80);
    }
}
