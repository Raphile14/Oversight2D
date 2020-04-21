package oversight2d.entities.creature;

import oversight2d.Game;
import oversight2d.Handler;
import oversight2d.entities.Entity;
import oversight2d.tiles.Tile;

/**
 *
 * @author Raphael Dalangin
 */
public abstract class Creature extends Entity {
    
    public static final int DEFAULT_HEALTH = 10;
    public static final float DEFAULT_SPEED = 5.0f;
    public static final int DEFAULT_CREATURE_WIDTH = 64,
                            DEFAULT_CREATURE_HEIGHT = 64;
    
    
    protected int health;
    protected float speed;
    protected float xMove, yMove;
    
    public Creature(Handler handler, float x, float y, int width, int height) {
        super(handler, x, y, width, height);
        health = DEFAULT_HEALTH;
        speed = DEFAULT_SPEED;
        xMove = 0;
        yMove = 0;
    }
    
    // Checks the movement of creature if a collision occurs
    public void move() {
        if (!checkEntityCollisions(xMove, 0.0f)) moveX();
        if (!checkEntityCollisions(0.0f, yMove)) moveY();
    }
    
    // Move and collision logic of the creature on X axis
    public void moveX() {
        if(xMove > 0) { // Moving Right
            int tx = (int) (x + xMove + bounds.x + bounds.width) / Tile.TILE_WIDTH;
            
            if(!collisionWithTile(tx, (int) (y + bounds.y) / Tile.TILE_HEIGHT) && 
                    !collisionWithTile(tx, (int) (y + bounds.y + bounds.height) / Tile.TILE_HEIGHT)) {
                x += xMove;
            } else {
                x = tx * Tile.TILE_WIDTH - bounds.x - bounds.width - 1;
            }
            
        } else if (xMove < 0) { // Moving Left
            int tx = (int) (x + xMove + bounds.x) / Tile.TILE_WIDTH;
            
            if(!collisionWithTile(tx, (int) (y + bounds.y) / Tile.TILE_HEIGHT) && 
                    !collisionWithTile(tx, (int) (y + bounds.y + bounds.height) / Tile.TILE_HEIGHT)) {
                x += xMove;
            } else {
                x = tx * Tile.TILE_WIDTH + Tile.TILE_WIDTH - bounds.x;
            }
        }
    }        
    
    // Move and collision logic of the creature on Y axis
    public void moveY() {
        if (yMove < 0) { // Moving Up
            int ty = (int) (y + yMove + bounds.y) / Tile.TILE_HEIGHT;
            
            if (!collisionWithTile((int) (x + bounds.x) / Tile.TILE_WIDTH, ty) && 
                    !collisionWithTile((int) (x + bounds.x + bounds.width) / Tile.TILE_WIDTH, ty)) {
                y += yMove;
            } else {
                y = ty * Tile.TILE_HEIGHT + Tile.TILE_HEIGHT - bounds.y;
            }
        } else if (yMove > 0) { // Moving Down
            int ty = (int) (y + yMove + bounds.y + bounds.height) / Tile.TILE_HEIGHT;
            
            if (!collisionWithTile((int) (x + bounds.x) / Tile.TILE_WIDTH, ty) && 
                    !collisionWithTile((int) (x + bounds.x + bounds.width) / Tile.TILE_WIDTH, ty)) {
                y += yMove;
            } else {
                y = ty * Tile.TILE_HEIGHT - bounds.y - bounds.height - 1;
            }
        }
    }
    
    // Checks if the tile to pass is passable or not
    protected boolean collisionWithTile(int x, int y) {
        return handler.getWorld().getTile(x, y).isSolid();
    }

    // Getters and Setters
    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public float getxMove() {
        return xMove;
    }

    public void setxMove(float xMove) {
        this.xMove = xMove;
    }

    public float getyMove() {
        return yMove;
    }

    public void setyMove(float yMove) {
        this.yMove = yMove;
    }
    
    
    
}
