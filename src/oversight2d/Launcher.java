package oversight2d;

import oversight2d.display.Display;

/**
 *
 * @author Raphael Dalangin
 */
public class Launcher {
    private static String version = "Oversight Alpha 0.1.0";
    private static int width = 1280, height = 720;

    public static void main(String[] args) {
        Game game = new Game(version, width, height);
        game.start();        
    }            
}
