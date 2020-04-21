package oversight2d.gfx;

import oversight2d.Game;
import oversight2d.Handler;
import oversight2d.entities.Entity;
import oversight2d.tiles.Tile;

/**
 *
 * @author Raphael Dalangin
 */
public class GameCamera {
    
	// Always centers on entity
	
    private Handler handler;
    private float xOffset, yOffset;
    
    public GameCamera(Handler handler, float xOffset, float yOffset) {
        this.handler = handler;
        this.xOffset = xOffset;
        this.yOffset = yOffset;
    }
    
    // Check if there is an empty space and tries to avoid it    
    public void checkBlankSpace() {
        if (xOffset < 0) {
            xOffset = 0;
        } else if (xOffset > handler.getWorld().getWidth() * Tile.TILE_WIDTH - handler.getWidth()) {
            xOffset = handler.getWorld().getWidth() * Tile.TILE_WIDTH - handler.getWidth();
        }
        
        if (yOffset < 0) {
            yOffset = 0;
        } else if (yOffset > handler.getWorld().getHeight() * Tile.TILE_HEIGHT - handler.getHeight()) {
            yOffset = handler.getWorld().getHeight() * Tile.TILE_HEIGHT - handler.getHeight();
        }
    }
    
    // Center the camera on a selected entity
    public void centerOnEntity(Entity e) {
        xOffset = e.getX() - handler.getWidth() / 2 + e.getWidth() / 2;
        yOffset = e.getY() - handler.getHeight() / 2 + e.getWidth() / 2;
        checkBlankSpace();
    }

    // Move the camera based on input
    public void move(float xAmt, float yAmt) {
        xOffset += xAmt;
        yOffset += yAmt;
        checkBlankSpace();
    }
    
    // Getters and Setters
    public float getxOffset() {
        return xOffset;
    }

    public void setxOffset(float xOffset) {
        this.xOffset = xOffset;
        checkBlankSpace();
    }

    public float getyOffset() {
        return yOffset;        
    }

    public void setyOffset(float yOffset) {
        this.yOffset = yOffset;
        checkBlankSpace();
    }
    
}
