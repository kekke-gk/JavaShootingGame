import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public abstract class ModeState extends JPanel implements KeyListener {
    public ModeState() {
        setPreferredSize(new Dimension(480, 640));
        // addKeyListener(this);
        // setFocusable(true);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        g2.setPaint(Color.black);
        g2.fillRect(0, 0, getWidth(), getHeight());
    }
}
