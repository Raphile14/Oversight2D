package oversight2d.worlds;

import java.awt.Graphics;
import oversight2d.tiles.Tile;

/**
 *
 * @author Raphael Dalangin
 */
public class World {
    
    private int width, height;
    private int[][] tiles;
    
    protected float xMove, yMove;
    
    public World(String path) {
        loadWorld(path);
        this.xMove = 0;       
        this.yMove = 0;
    }
    
    public void move() {
        
    }
    
    public void tick() {
        
    }
    
    public void render(Graphics g) {
        for(int y = 0; y < height; y ++) {
            for (int x = 0; x < width; x++) {
                getTile(x, y).render(g, (x * Tile.TILE_WIDTH) + (int) xMove, y * Tile.TILE_HEIGHT + (int) yMove);
            }
        }
    }            
    
    public Tile getTile(int x, int y) {
        Tile t = Tile.tiles[tiles[x][y]];
        if( t == null) {
            return Tile.dirtTile;
        }
        return t;
    }
    
    private void loadWorld(String path) {
        width = 30;
        height = 12;
        tiles = new int[width][height];
        
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                tiles[x][y] = 0;
            }
        }
    }
    
    // Setters

    public void setxMove(float xMove) {
        this.xMove += xMove;
    }

    public void setyMove(float yMove) {
        this.yMove += yMove;
    }
        
}
