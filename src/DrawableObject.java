import java.awt.*;
import javax.swing.*;

public abstract class DrawableObject extends JComponent {

    protected float x;
    protected float y;
    protected float vx;
    protected float vy;

    public DrawableObject() {
        this(0, 0, 0, 0);
    }

    public DrawableObject(float x, float y) {
        this(x, y, 0, 0);
    }

    public DrawableObject(float x, float y, float vx, float vy) {
        setBounds(0, 0, Settings.WIDTH, Settings.HEIGHT);
        this.x = x;
        this.y = y;
        this.vx = vx;
        this.vy = vy;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        update();
    }

    protected void update() {
        x = Math.max(0, Math.min(Settings.WIDTH, x + vx));
        y = Math.max(0, Math.min(Settings.HEIGHT, y + vy));
    }

    protected void fillCircle(Graphics2D g2, int r) {
        g2.fillOval((int) (x - r / 2), (int) (y - r / 2), r, r);
    }
}
