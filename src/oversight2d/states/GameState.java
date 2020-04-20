package oversight2d.states;

import java.awt.Graphics;
import oversight2d.Game;
import oversight2d.Handler;
import oversight2d.entities.creature.Player;
import oversight2d.entities.statics.Tree;
import oversight2d.gfx.Assets;
import oversight2d.tiles.Tile;
import oversight2d.worlds.World;

/**
 *
 * @author Raphael Dalangin
 */
public class GameState extends State {
    
    private World world;

    public GameState(Handler handler) {
        super(handler);        
        world = new World(handler, "resources/oversight2d/worlds/world1.txt"); 
        handler.setWorld(world);
    }
    
    @Override
    public void tick() {
        world.tick();
    }

    @Override
    public void render(Graphics g) {      
        world.render(g);
    }
    
    
}
