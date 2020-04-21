package oversight2d;

import oversight2d.gfx.GameCamera;
import oversight2d.input.KeyManager;
import oversight2d.input.MouseManager;
import oversight2d.worlds.World;

/**
 *
 * @author Raphael Dalangin
 */
public class Handler {
    
    private Game game;
    private World world;
    
    Handler(Game game) {
        this.game = game;
    }

    public GameCamera getGameCamera() {
        return game.getGameCamera();
    }
    
    public KeyManager getKeyManager() {
        return game.getKeyManager();
    }
    
    public MouseManager getMouseManager() {
        return game.getMouseManager();
    }
    
    public int getWidth() {
        return game.getWidth();
    }
    
    public int getHeight() {
        return game.getHeight();
    }
    
    // Getters and Setters
    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public World getWorld() {
        return world;
    }

    public void setWorld(World world) {
        this.world = world;
    }
    
    
}
