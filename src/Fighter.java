import java.awt.*;
import java.awt.event.*;

public class Fighter extends DrawableObject implements KeyListener {
    
    protected final static int R = 15;
    protected final static int SPEED = 2;
    protected final static int FIRE_INTVL = 20;

    protected boolean keyLeft, keyRight, keyUp, keyDown;
    protected boolean keyZ;

    protected int fire_intvl = 0;

    public Fighter() {
        super(Settings.WIDTH / 2, Settings.HEIGHT - 100, R);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        if (fire_intvl > 0) fire_intvl--;

        if (keyZ && fire_intvl == 0) shoot();

        g2.setPaint(Color.blue);
        fillCircle(g2, R);
    }

    @Override
    protected void update() {
        super.update();
        
        _vx = SPEED * (keyLeft ? -1 : keyRight ? 1 : 0);
        _vy = SPEED * (keyUp ? -1 : keyDown ? 1 : 0);

        stopAtEdge();
    }

    private void shoot() {
        fire_intvl = FIRE_INTVL;
        this.add(new Bullet(_x, _y, 0, -5));
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
