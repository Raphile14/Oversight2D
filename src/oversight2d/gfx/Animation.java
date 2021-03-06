package oversight2d.gfx;

import java.awt.image.BufferedImage;

/**
 *
 * @author Raphael Dalangin
 */
public class Animation {
    
    private int speed, index;
    private long lastTime, timer;
    private BufferedImage[] frames;

    // Handles the animation frames
    public Animation(int speed, BufferedImage[] frames) {
        this.speed = speed;
        this.frames = frames;
        index = 0;
        timer = 0;
        lastTime = System.currentTimeMillis();
        System.out.println(frames.length);
    }
    
    public void tick() {
        timer += System.currentTimeMillis() - lastTime;
        lastTime = System.currentTimeMillis();
        
        if(timer > speed) {
            index++;
            timer = 0;
            if (index >= frames.length) {
                index = 0;
            }
        }
    }
    
    public BufferedImage getCurrentFrame() {
        return frames[index];
    }
    
    public void printInt() {
        System.out.println(index);
    }
}
