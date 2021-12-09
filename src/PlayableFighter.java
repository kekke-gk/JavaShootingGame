import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PlayableFighter extends DrawableObject implements KeyListener {
    
    protected final static int SIZE = 30;
    protected final static int SPEED = 2;

    protected boolean keyLeft, keyRight, keyUp, keyDown;
    protected boolean keyZ;

    public PlayableFighter() {
        super(Settings.WIDTH / 2, Settings.HEIGHT - 100);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        if(keyZ) shoot();

        g2.setPaint(Color.blue);
        fillCircle(g2, SIZE / 2);
    }

    @Override
    protected void update() {
        super.update();
        
        vx = SPEED * (keyLeft ? -1 : keyRight ? 1 : 0);
        vy = SPEED * (keyUp ? -1 : keyDown ? 1 : 0);
    }

    private void shoot() {
        this.add(new Bullet(x, y, 0, -5));
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
