package oversight2d.input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import oversight2d.ui.UIManager;

/**
 *
 * @author Raphael Dalangin
 */
public class MouseManager implements MouseListener, MouseMotionListener {
    
	// Controls the mouse input of the user
	
    private boolean leftPressed, middlePressed, rightPressed;
    private int mouseX, mouseY;
    private UIManager uiManager;
    
    public MouseManager() {
        
    }
    
    public void setUIManager(UIManager uiManager) {
        this.uiManager = uiManager;
    }
    
    // Getters
    public boolean isLeftPressed() {
        return leftPressed;
    }
    
    public boolean isMiddlePressed() {
        return middlePressed;
    }
    
    public boolean isRightPressed() {
        return rightPressed;
    }
    
    public int getMouseX() {
        return mouseX;
    }
    
    public int getMouseY() {
        return mouseY;
    }
    
    // Implemented Methods
    @Override
    public void mouseDragged(MouseEvent e) {
        
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();
        
        if(uiManager != null) uiManager.onMouseMove(e);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(e.getButton() == MouseEvent.BUTTON1) leftPressed = true;
        else if(e.getButton() == MouseEvent.BUTTON2) middlePressed = true;
        else if(e.getButton() == MouseEvent.BUTTON3) rightPressed = true;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if(e.getButton() == MouseEvent.BUTTON1) leftPressed = false;
        else if(e.getButton() == MouseEvent.BUTTON2) middlePressed = false;
        else if(e.getButton() == MouseEvent.BUTTON3) rightPressed = false;
        
        if(uiManager != null) uiManager.onMouseRelease(e);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }
    
}
