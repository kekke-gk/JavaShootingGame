import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public abstract class DrawableObject extends JComponent {

    protected float x;
    protected float y;
    protected float vx;
    protected float vy;

    public DrawableObject() {
        this(0, 0, 1, 1);
    }

    public DrawableObject(float x, float y, float vx, float vy) {
        setBounds(0, 0, Settings.WIDTH, Settings.HEIGHT);
        // setPreferredSize(new Dimension(Settings.WIDTH, Settings.HEIGHT));
        this.x = x;
        this.y = y;
        this.vx = vx;
        this.vy = vy;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}
