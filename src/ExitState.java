import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ExitState extends ModeState {

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        setFocusable(true);

        g2.setFont(new Font("Arial", Font.BOLD, 28));

        g2.setPaint(Color.yellow);
        g2.drawString("Finish", 10, 100);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("ExitState:" + e.getKeyCode());        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }
    
}
