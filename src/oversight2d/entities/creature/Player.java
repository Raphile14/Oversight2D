package oversight2d.entities.creature;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import oversight2d.Game;
import oversight2d.Handler;
import oversight2d.display.Display;
import oversight2d.gfx.Animation;
import oversight2d.gfx.Assets;
import oversight2d.worlds.World;

/**
 *
 * @author Raphael Dalangin
 */
public class Player extends Creature {
        
    // Animation
    private Animation animDown;
    private Animation animUp;
    private Animation animLeft;
    private Animation animRight;    
    
    public Player(Handler handler, float x, float y) {
        super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
        
        bounds.x = 16;
        bounds.y = 16;
        bounds.width = 32;
        bounds.height = 50;
        
        // Animation
        animDown = new Animation(100, Assets.player_down);
        animUp = new Animation(100, Assets.player_up);
        animLeft = new Animation(100, Assets.player_left);
        animRight = new Animation(100, Assets.player_right);
    }

    @Override
    public void tick() {
        animDown.tick();
        animUp.tick();
        animLeft.tick();
        animRight.tick();
        getInput();
        move();
        handler.getGameCamera().centerOnEntity(this);
    }
    
    private void getInput() {
        xMove = 0;
        yMove = 0;        
        
        if(handler.getKeyManager().up) yMove = -speed; // yMove = -speed;
        if(handler.getKeyManager().down) yMove = speed; // yMove = speed;
        if(handler.getKeyManager().left) xMove = -speed; // xMove = -speed;
        if(handler.getKeyManager().right) xMove = speed; // xMove = speed;
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(getCurrentAnimationFrame(), (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
        
//        g.setColor(Color.red);
//        g.fillRect(
//                (int) (x + bounds.x - handler.getGameCamera().getxOffset()), 
//                (int) (y + bounds.y - handler.getGameCamera().getyOffset()), 
//                (int) bounds.width, (int) bounds.height);
    }
    
    private BufferedImage getCurrentAnimationFrame() {
        if (xMove < 0) {
//            animLeft.printInt();
            return animLeft.getCurrentFrame();
        } else if (xMove > 0) {
//            animRight.printInt();
            return animRight.getCurrentFrame();
        } else if (yMove < 0) {
//            animUp.printInt();
            return animUp.getCurrentFrame();
        } else {
//            animDown.printInt();
            return animDown.getCurrentFrame();            
        }        
    }
            
}
