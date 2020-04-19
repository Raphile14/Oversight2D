package oversight2d.entities.creature;

import java.awt.Graphics;
import oversight2d.Game;
import oversight2d.display.Display;
import oversight2d.gfx.Assets;
import oversight2d.worlds.World;

/**
 *
 * @author Raphael Dalangin
 */
public class Player extends Creature {
    
    private Game game;
    private World world;
    private int locationX, locationY;
    
    public Player(Game game, World world, float x, float y) {
        super(x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
        this.game = game;
        this.world = world;
        this.locationX = (Display.getWidth()/2) - DEFAULT_CREATURE_WIDTH / 2;
        this.locationY = (Display.getHeight() / 2) - DEFAULT_CREATURE_HEIGHT / 2;
    }

    @Override
    public void tick() {
        getInput();
//        move();
    }
    
    private void getInput() {
//        xMove = 0;
//        yMove = 0;
        
        if(game.getKeyManager().up) world.setyMove(speed); // yMove = -speed;
        if(game.getKeyManager().down) world.setyMove(-speed); // yMove = speed;
        if(game.getKeyManager().left) world.setxMove(speed); // xMove = -speed;
        if(game.getKeyManager().right) world.setxMove(-speed); // xMove = speed;
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.walkDown, locationX, locationY, width, height, null);
    }
            
}
