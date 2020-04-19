package oversight2d;

import oversight2d.display.Display;

/**
 *
 * @author Raphael Dalangin
 */
public class Launcher {
    private static String version = "Oversight Alpha 0.1.0";

    public static void main(String[] args) {
        Game game = new Game(version, 1280, 720);
        game.start();
    }
    
}
