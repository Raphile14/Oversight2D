package oversight2d.tiles;

import oversight2d.gfx.Assets;

/**
 *
 * @author Raphael Dalangin
 */
public class StoneTile extends Tile {
    
    public StoneTile(int id) {
        super(Assets.stone, id);
    }
    
    @Override
    public boolean isSolid() {
        return true;
    }
    
}
