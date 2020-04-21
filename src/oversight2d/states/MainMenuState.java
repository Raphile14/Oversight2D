package oversight2d.states;

import java.awt.Graphics;
import oversight2d.Game;
import oversight2d.Handler;
import oversight2d.gfx.Assets;
import oversight2d.ui.ClickListener;
import oversight2d.ui.UIImageButton;
import oversight2d.ui.UIManager;

/**
 *
 * @author Raphael Dalangin
 */
public class MainMenuState extends State {
    
	// Main Menu State
    private UIManager uiManager;
    
    public MainMenuState(Handler handler) {
        super(handler);
        uiManager = new UIManager(handler);
        handler.getMouseManager().setUIManager(uiManager);
        
        // UI Objects on screen
        uiManager.addObject(new UIImageButton(200, 200, 128, 64, Assets.player_down, new ClickListener() {
            @Override
            public void onClick() {
                handler.getMouseManager().setUIManager(null);
                State.setState(handler.getGame().gameState);
            }
        }));
        
    };
    
    @Override
    public void tick() {
        uiManager.tick();
    }

    @Override
    public void render(Graphics g) {
        uiManager.render(g);
    }
}
