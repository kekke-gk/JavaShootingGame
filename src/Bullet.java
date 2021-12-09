import java.awt.*;

public class Bullet extends DrawableObject {

    protected final static int SIZE = 10;

    public Bullet(float x, float y, float vx, float vy) {
        super(x, y, vx, vy);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        g2.setPaint(Color.red);
        fillCircle(g2, SIZE / 2);
    }

    @Override
    protected void update() {
        super.update();

        if (x - SIZE < 0 || Settings.WIDTH + SIZE < x ||
            y - SIZE < 0 || Settings.HEIGHT + SIZE < y) {
            this.getParent().remove(this);
        }
    }
}
