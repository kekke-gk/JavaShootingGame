import java.awt.*;
import javax.swing.*;
import java.awt.geom.Point2D;

public abstract class DrawableObject extends JComponent {

    protected float _x;
    protected float _y;
    protected float _vx;
    protected float _vy;
    protected float _r;

    public DrawableObject() {
        this(0, 0, 0, 0);
    }

    public DrawableObject(float x, float y) {
        this(x, y, 0, 0);
    }

    public DrawableObject(float x, float y, float r) {
        this(x, y, 0, 0, r);
    }

    public DrawableObject(float x, float y, float vx, float vy) {
        this(x, y, vx, vy, 0);
    }

    public DrawableObject(float x, float y, float vx, float vy, float r) {
        setBounds(0, 0, Settings.WIDTH, Settings.HEIGHT);
        this._x = x;
        this._y = y;
        this._vx = vx;
        this._vy = vy;
        this._r = r;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        update();
    }

    protected void update() {
        _x += _vx;
        _y += _vy;
    }

    protected void fillCircle(Graphics2D g2, int r) {
        g2.fillOval((int) (_x - r), (int) (_y - r), r * 2, r * 2);
    }

    protected double dist(DrawableObject obj) {
        return Point2D.distance(_x, _y, obj._x, obj._y);
    }

    protected boolean collide(DrawableObject obj) {
        return dist(obj) <= _r + obj._r;
    }

    protected boolean outOfScreen() {
        return _x + _r < 0 || Settings.WIDTH - _r < _x ||
               _y + _r < 0 || Settings.HEIGHT - _r < _y;
    }

    protected void stopAtEdge() {
        _x = Math.max(0, Math.min(Settings.WIDTH, _x));
        _y = Math.max(0, Math.min(Settings.HEIGHT, _y));
    }
}
