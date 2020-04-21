package oversight2d;

import java.awt.Dimension;
import java.awt.Toolkit;
import oversight2d.display.Display;

/**
 *
 * @author Raphael Dalangin
 */
public class Launcher {
    private static String version = "Oversight Alpha 0.1.0";
    private static int width = 1280, height = 720;
    private static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    public static void main(String[] args) {
//        width = (int) screenSize.getWidth();
//        height = (int) screenSize.getHeight();
        Game game = new Game(version, width, height);
        game.start();        
    }
}
