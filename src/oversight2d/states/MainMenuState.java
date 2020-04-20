package oversight2d.states;

import java.awt.Graphics;
import oversight2d.Game;
import oversight2d.Handler;
import oversight2d.gfx.Assets;

/**
 *
 * @author Raphael Dalangin
 */
public class MainMenuState extends State {
    
    public MainMenuState(Handler handler) {
        super(handler);
    }
    
    @Override
    public void tick() {
        
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.menu, 0, 0, null);
    }
}
