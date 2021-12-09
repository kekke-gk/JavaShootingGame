import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GameState extends ModeState {

    private int _curTime = 0;

    private BaseFighter _fighter;

    public GameState(GameManager gm) {
        super(gm);

        _fighter = new BaseFighter();
        // _drawables.add(_fighter);
        // _keyListeners.add(_fighter);
        this.add(_fighter);
        _gm.addKeyListener(_fighter);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        g2.setPaint(Color.white);
        g2.drawString("Time: " + _curTime, 10, 30);

        _curTime++;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // super.keyTyped(e);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // super.keyPressed(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // super.keyReleased(e);
    }
    
}
