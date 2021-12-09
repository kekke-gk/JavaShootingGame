import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Bullet extends DrawableObject {

    public Bullet(float x, float y) {
        super(x, y, 0, -4);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        x += vx;
        y += vy;

        if (x < 0 || Settings.WIDTH < x ||
            y < 0 || Settings.HEIGHT < y) {
            this.getParent().remove(this);
        }

        g2.setPaint(Color.red);
        g2.fillOval((int)x, (int)y, 30, 30);
    }
    
}
