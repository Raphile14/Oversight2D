package oversight2d.entities.creature;

import java.awt.Color;
import java.awt.Graphics;
import oversight2d.Game;
import oversight2d.Handler;
import oversight2d.display.Display;
import oversight2d.gfx.Assets;
import oversight2d.worlds.World;

/**
 *
 * @author Raphael Dalangin
 */
public class Player extends Creature {
        
    private int locationX, locationY;
    
    public Player(Handler handler, float x, float y) {
        super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
        
        bounds.x = 16;
        bounds.y = 16;
        bounds.width = 32;
        bounds.height = 50;
    }

    @Override
    public void tick() {
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
        g.drawImage(Assets.walkDown, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
        
//        g.setColor(Color.red);
//        g.fillRect(
//                (int) (x + bounds.x - handler.getGameCamera().getxOffset()), 
//                (int) (y + bounds.y - handler.getGameCamera().getyOffset()), 
//                (int) bounds.width, (int) bounds.height);
    }
            
}
