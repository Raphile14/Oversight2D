package oversight2d.worlds;

import java.awt.Graphics;
import oversight2d.Handler;
import oversight2d.entities.EntityManager;
import oversight2d.entities.creature.Player;
import oversight2d.entities.statics.Tree;
import oversight2d.tiles.Tile;
import oversight2d.utils.Utils;

/**
 *
 * @author Raphael Dalangin
 */
public class World {
    
	// Logic for loading and rendering world
    private Handler handler;
    private int width, height;
    private int spawnX, spawnY;
    private int[][] tiles;
    
    // Entities
    private EntityManager entityManager;   
    
    public World(Handler handler, String path) {
        this.handler = handler;
        entityManager = new EntityManager(handler, new Player(handler, 100, 100));
        entityManager.addEntity(new Tree(handler, 100, 250));
        
        loadWorld(path);        
        
        entityManager.getPlayer().setX(spawnX);
        entityManager.getPlayer().setY(spawnY);
    }
    
    public void move() {
        
    }
    
    public void tick() {
        entityManager.tick();
    }
    
    public void render(Graphics g) {
        int xStart = (int) Math.max(0, handler.getGameCamera().getxOffset() / Tile.TILE_WIDTH);
        int xEnd = (int) Math.min(width, (handler.getGameCamera().getxOffset() + handler.getWidth()) / Tile.TILE_WIDTH + 1); // width
        int yStart = (int) Math.max(0, handler.getGameCamera().getyOffset() / Tile.TILE_HEIGHT);
        int yEnd = (int) Math.min(height, (handler.getGameCamera().getyOffset() + handler.getHeight()) / Tile.TILE_HEIGHT + 1); // height
        
        for(int y = yStart; y < yEnd; y ++) {
            for (int x = xStart; x < xEnd; x++) {
                getTile(x, y).render(g, 
                        (int) (x * Tile.TILE_WIDTH - handler.getGameCamera().getxOffset()), 
                        (int) (y * Tile.TILE_HEIGHT - handler.getGameCamera().getyOffset()));
            }
        }
        
        // Entities
        entityManager.render(g);
    }            
    
    public Tile getTile(int x, int y) {
        if (x < 0 || y < 0 ||x >= width || y >= height) {
            return Tile.grassTile;
        }
        
        Tile t = Tile.tiles[tiles[x][y]];
        if( t == null) {
            return Tile.dirtTile;
        }
        return t;
    }
    
    private void loadWorld(String path) {
        String file = Utils.loadFileAsString(path);
        String[] tokens = file.split("\\s+");
        width = Utils.parseInt(tokens[0]);
        height = Utils.parseInt(tokens[1]);
        spawnX = Utils.parseInt(tokens[2]);
        spawnY = Utils.parseInt(tokens[3]);
        
        tiles = new int[width][height];
        
        for (int y = 0; y < height; y ++) {
            for (int x = 0; x < width; x ++) {
                tiles[x][y] = Utils.parseInt(tokens[(x + y * width) + 4]);
            }
        }
    }         

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }
    
    
}
