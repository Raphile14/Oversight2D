package oversight2d.states;

import java.awt.Graphics;
import oversight2d.Game;
import oversight2d.entities.creature.Player;
import oversight2d.gfx.Assets;
import oversight2d.tiles.Tile;
import oversight2d.worlds.World;

/**
 *
 * @author Raphael Dalangin
 */
public class GameState extends State {
    
    private Player player;
    private World world;

    public GameState(Game game) {
        super(game);
        world = new World("");
        player = new Player(game, world, 100, 100);        
    }
    
    @Override
    public void tick() {
        world.tick();
        player.tick();
    }

    @Override
    public void render(Graphics g) {      
        world.render(g);
        player.render(g);
    }
    
    
}
