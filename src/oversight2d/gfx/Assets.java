package oversight2d.gfx;

import java.awt.image.BufferedImage;

/**
 *
 * @author Raphael Dalangin
 */
public class Assets {
    
    private static final int width = 60, height = 60;
    
    public static BufferedImage dirt, stone, sand, grass, gold, diamond, coal;
    
    public static BufferedImage[] player_down, player_up, player_left, player_right,
                                  menu;
    
    public static void init() {
        SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/oversight2d/textures/testSprite.png"));
        SpriteSheet sheet2 = new SpriteSheet(ImageLoader.loadImage("/oversight2d/textures/menu.jpg"));
        SpriteSheet sheet3 = new SpriteSheet(ImageLoader.loadImage("/oversight2d/textures/minecraft.png"));
        
        // Walk Animation
        player_down = new BufferedImage[8];        
        player_left = new BufferedImage[8];
        player_right = new BufferedImage[8];
        player_up = new BufferedImage[8];
        
        for (int x = 0; x < 8; x++) {
            player_down[x] = sheet.crop(x * width, 0, width, height);            
            player_left[x] = sheet.crop(x * width, height, width, height);
            player_right[x] = sheet.crop(x * width, height * 2, width, height);
            player_up[x] = sheet.crop(x * width, height * 3, width, height);
        }
        
//        for (int x = 0; x < 8; x++) {         
//            player_left[x] = sheet.crop(x * width, height, width, height);
//        }
        
        
//        menu[0] = sheet2.crop(0, 0, width * 3, height * 3);
//        menu[1] = sheet2.crop(width, 0, width * 3, height * 3);
        
        dirt = sheet3.crop(80, 0, 80, 80);
        stone = sheet3.crop(160, 0, 80, 80);
        sand = sheet3.crop(320, 0, 80, 80);
        grass = sheet3.crop(0, 80, 80, 80);
        gold = sheet3.crop(240, 80, 80, 80);
        diamond = sheet3.crop(320, 80, 80, 80);
        coal = sheet3.crop(80, 160, 80, 80);
    }
}
