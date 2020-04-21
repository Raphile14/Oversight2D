package oversight2d.display;

import java.awt.Canvas;
import java.awt.Dimension;
import javax.swing.JFrame;

/**
 *
 * @author Raphael Dalangin
 */
public class Display {
	
	// The Display window of the software
    
    private JFrame frame;
    private Canvas canvas;
    
    private String title;
    private static int width, height;
    
    public Display(String title, int width, int height) {
        this.title = title;
        this.width = width;
        this.height = height;
        
        createDisplay();
    }

    private void createDisplay() {
    	// Initiates Display Window
        frame = new JFrame(title);
        
        // Sets window size
        frame.setSize(width, height);
        
        // Makes the close button fully terminate the program
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Makes it so the program cannot be resized by the user
        frame.setResizable(false);
        
        // Centers the program
        frame.setLocationRelativeTo(null);
        
        // For fullscreen
//        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        // Removes side bars (for fullscreen)
//        frame.setUndecorated(true);
        
        // Makes the frame visible
        frame.setVisible(true);   
        
        // Area where the game is drawn
        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(width, height));
        canvas.setMaximumSize(new Dimension(width, height));
        canvas.setMinimumSize(new Dimension(width, height));   
        canvas.setFocusable(false);
        frame.add(canvas);
        frame.pack();
    }
    
    
    // Getters
    public Canvas getCanvas() {
        return canvas;
    }
    
    public JFrame getFrame() {
        return frame;
    }
    
    public static int getWidth() {
        return width;
    }

    public static int getHeight() {
        return height;
    }
}
