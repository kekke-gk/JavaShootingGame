import java.awt.*;

public class EnemyT1 extends BaseEnemy {

    private final static int VY = 2;
    private final static int HP = 2;
    private final static int RATE = 50;
    private final static int SCORE = 10;

    private final static int R = 25;

    public EnemyT1(EnemyInfo info) {
        super(info.x, info.y, 0, VY, R, HP, RATE, SCORE);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        g2.setPaint(Color.pink);
        fillCircle(g2, R);
    }

    @Override
    protected void shoot() {
        getParent().add(new Bullet(_x, _y, -3, 3));
        getParent().add(new Bullet(_x, _y, 0, 3));
        getParent().add(new Bullet(_x, _y, 3, 3));
    }    
}
