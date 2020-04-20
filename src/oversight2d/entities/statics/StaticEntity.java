package oversight2d.entities.statics;

import oversight2d.Handler;
import oversight2d.entities.Entity;

/**
 *
 * @author Raphael Dalangin
 */
public abstract class StaticEntity extends Entity {
    
    public StaticEntity(Handler handler, float x, float y, int width, int height) {
        super(handler, x, y, width, height);
    }
    
}
