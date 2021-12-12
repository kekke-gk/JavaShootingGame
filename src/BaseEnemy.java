import java.awt.*;

public abstract class BaseEnemy extends DrawableObject {
    
    protected int _hp;
    protected int _rate;
    protected int _score;

    private int _timer;
    

    public BaseEnemy(int x, int y, int vx, int vy, int r, int hp, int rate, int score) {
        super(x, y, vx, vy, r);

        _hp = hp;
        _rate = rate;
        _score = score;

        _timer = 0;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (_timer % _rate == 0) shoot();

        _timer++;
    }

    @Override
    protected void update() {
        super.update();

        if (outOfScreen()) {
            this.getParent().remove(this);
        }
    }

    protected abstract void shoot();
}
