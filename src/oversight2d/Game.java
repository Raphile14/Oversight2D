package oversight2d;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.logging.Level;
import java.util.logging.Logger;
import oversight2d.display.Display;
import oversight2d.gfx.Assets;
import oversight2d.gfx.GameCamera;
import oversight2d.gfx.ImageLoader;
import oversight2d.gfx.SpriteSheet;
import oversight2d.input.KeyManager;
import oversight2d.states.GameState;
import oversight2d.states.MainMenuState;
import oversight2d.states.SettingsState;
import oversight2d.states.State;

/**
 *
 * @author Raphael Dalangin
 */
public class Game implements Runnable {
    
    private Display display;    
    private int width, height;
    public String title;
    
    private boolean running = false;
    private Thread thread;
    
    private BufferStrategy bs;
    private Graphics g;    
    
    // States
    private State gameState;
    private State menuState;
    private State settingsState;
    
    // Input
    private KeyManager keyManager;
    
    // Camera
    private GameCamera gameCamera;
    
    // Handler
    private Handler handler;
    
    public Game(String title, int width, int height) {
        this.width = width;
        this.height = height;              
        this.title = title;
        keyManager = new KeyManager();
    }
    
    private void init() {
        display = new Display(title, width, height);
        display.getFrame().addKeyListener(keyManager);
        Assets.init();
                
        handler = new Handler(this);
        gameCamera = new GameCamera(handler, 0, 0);    
        gameState = new GameState(handler);
        menuState = new MainMenuState(handler);
        settingsState = new SettingsState(handler);
        State.setState(gameState);
    }
    
    private void tick() {
        keyManager.tick();
        
        if(State.getState() != null) {
            State.getState().tick();
        }
    }
    
    private void render() {
        bs = display.getCanvas().getBufferStrategy();
        if(bs == null) {
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();
        
        // Clear Screen
        g.clearRect(0, 0, width, height);
        
        // Draw        
        if(State.getState() != null) {
            State.getState().render(g);
        }
        
        // End Draw
        bs.show();
        g.dispose();
    }
    
    public void run() {
        
        init();
        
        int fps = 60;
        double timePerTick = 1000000000 / fps;
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();
        long timer = 0;
        int ticks = 0;
        
        while(running) {
            now = System.nanoTime();
            delta += (now - lastTime) / timePerTick;
            timer += now - lastTime;
            lastTime = now;
             
            if(delta >= 1) {
                tick();
                render();
                ticks++;
                delta--;
            }           
            
            if (timer >= 1000000000) {
                System.out.println("Ticks: " + ticks);
                ticks = 0;
                timer = 0;
            }
        }
        
        stop();
    }
    
    public KeyManager getKeyManager() {
        return keyManager;
    }
    
    public GameCamera getGameCamera() {
        return gameCamera;
    }
    
    public int getWidth() {
        return width;
    }
    
    public int getHeight() {
        return height;
    }
    
    public synchronized void start() {
        if (running) return;
        running = true;
        thread = new Thread(this);        
        thread.start(); // calls run()
    }
    
    public synchronized void stop() {
        if(!running) return;        
        running = false;
        try {
            thread.join();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }  
}
