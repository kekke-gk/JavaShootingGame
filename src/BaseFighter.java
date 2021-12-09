import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class BaseFighter extends DrawableObject implements KeyListener {

    protected int w, h;

    protected boolean keyLeft, keyRight, keyUp, keyDown;
    protected boolean keyZ;

    public BaseFighter() {
        this(Settings.WIDTH / 2, Settings.HEIGHT - 100, 30, 30);
    }

    public BaseFighter(int w, int h) {
        this.w = w;
        this.h = h;
    }

    public BaseFighter(int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        update();

        System.out.println(this.getComponentCount());

        g2.setPaint(Color.blue);
        g2.fillOval((int)x, (int)y, w, h);
    }

    private void update() {
        if(keyZ) shoot();

        if(keyLeft) x = Math.max(x - vx, 0);
        if(keyRight) x = Math.min(x + vx, Settings.WIDTH);
        if(keyUp) y = Math.max(y - vy, 0);
        if(keyDown) y = Math.min(y + vy, Settings.HEIGHT);
    }

    private void shoot() {
        this.add(new Bullet(x, y));
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int c = e.getKeyCode();
        if(c == KeyEvent.VK_LEFT) keyLeft = true;
        if(c == KeyEvent.VK_RIGHT) keyRight = true;
        if(c == KeyEvent.VK_UP) keyUp = true;
        if(c == KeyEvent.VK_DOWN) keyDown = true;
        if(c == KeyEvent.VK_Z) keyZ = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int c = e.getKeyCode();
        if(c == KeyEvent.VK_LEFT) keyLeft = false;
        if(c == KeyEvent.VK_RIGHT) keyRight = false;
        if(c == KeyEvent.VK_UP) keyUp = false;
        if(c == KeyEvent.VK_DOWN) keyDown = false;
        if(c == KeyEvent.VK_Z) keyZ = false;
    }
}
