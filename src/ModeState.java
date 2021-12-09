import java.util.*;
import java.util.List;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public abstract class ModeState extends JPanel implements KeyListener {

    protected GameManager _gm;
    // protected List<DrawableObject> _drawables;
    // protected List<KeyListener> _keyListeners;

    public ModeState(GameManager gm) {
        _gm = gm;
        // _drawables = new ArrayList<>();
        // _keyListeners = new ArrayList<>();

        setLayout(null);
        setBounds(0, 0, Settings.WIDTH, Settings.HEIGHT);
        // setPreferredSize(new Dimension(Settings.WIDTH, Settings.HEIGHT));
        // addKeyListener(this);
        // setFocusable(true);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        g2.setPaint(Color.black);
        g2.fillRect(0, 0, getWidth(), getHeight());

        // for (DrawableObject drawable : _drawables) {
        //     drawable.draw(g2);
        // }
    }

    // @Override
    // public void keyTyped(KeyEvent e) {
    //     for (KeyListener keyListener : _keyListeners) {
    //         keyListener.keyTyped(e);
    //     }
    // }

    // @Override
    // public void keyPressed(KeyEvent e) {
    //     for (KeyListener keyListener : _keyListeners) {
    //         keyListener.keyPressed(e);
    //     }
    // }

    // @Override
    // public void keyReleased(KeyEvent e) {
    //     for (KeyListener keyListener : _keyListeners) {
    //         keyListener.keyReleased(e);
    //     }
    // }
}
