import java.awt.*;

public class Bullet extends DrawableObject {

    protected final static int R = 5;

    public Bullet(float x, float y, float vx, float vy) {
        super(x, y, vx, vy, R);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        g2.setPaint(Color.red);
        fillCircle(g2, R);
    }

    @Override
    protected void update() {
        super.update();

        if (outOfScreen()) {
            this.getParent().remove(this);
        }
    }
}
