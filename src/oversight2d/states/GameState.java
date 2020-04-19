package oversight2d.states;

import java.awt.Graphics;
import oversight2d.Game;
import oversight2d.entities.creature.Player;
import oversight2d.gfx.Assets;
import oversight2d.tiles.Tile;

/**
 *
 * @author Raphael Dalangin
 */
public class GameState extends State {
    
    private Player player;

    public GameState(Game game) {
        super(game);
        player = new Player(game, 100, 100);
    }
    
    @Override
    public void tick() {
        player.tick();
    }

    @Override
    public void render(Graphics g) {        
        Tile.tiles[2].render(g, 0, 0);
        player.render(g);
    }
    
    
}
