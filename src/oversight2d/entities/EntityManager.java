package oversight2d.entities;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Comparator;
import oversight2d.Handler;
import oversight2d.entities.creature.Player;

/**
 *
 * @author Raphael Dalangin
 */
public class EntityManager {
    
	// Stores all the entities alive in the game
    private Handler handler;
    private Player player;
    private ArrayList<Entity> entities;
    private Comparator<Entity> renderSorter = new Comparator<Entity>(){
        @Override
        public int compare(Entity a, Entity b) {
            if(a.getY() + a.getHeight() < b.getY() + b.getHeight()) return -1;
            else return 1;
        }
    
    };
    
    
    // Initiates the storage. Adds the player
    public EntityManager(Handler handler, Player player) {
        this.handler = handler;
        this.player = player;
        entities = new ArrayList<Entity>();
        addEntity(player);
    }
    
    public void tick() {
        for(int i = 0; i < entities.size(); i ++) {
            Entity e = entities.get(i);
            e.tick();
        }
        entities.sort(renderSorter);
    }
    
    public void render(Graphics g) {
        for(Entity e : entities) {
            e.render(g);
        }
    }
    
    public void addEntity(Entity e) {
        entities.add(e);
    }

    // Getters and Setters
    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public ArrayList<Entity> getEntities() {
        return entities;
    }

    public void setEntities(ArrayList<Entity> entities) {
        this.entities = entities;
    }

    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }
    
    
}
