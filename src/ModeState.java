import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public abstract class ModeState extends JPanel implements KeyListener {
    
    protected GameManager _gm;

    public ModeState(GameManager gm) {
        _gm = gm;

        setLayout(null);
        setBounds(0, 0, Settings.WIDTH, Settings.HEIGHT);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        g2.setPaint(Color.black);
        g2.fillRect(0, 0, getWidth(), getHeight());
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
