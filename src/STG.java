import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class STG extends JPanel {

    private GameManager _gmanager;
    private CardLayout _cardLayout;

    public STG() {
        _cardLayout = new CardLayout();
        setLayout(_cardLayout);

        _gmanager = new GameManager(this);

        setFocusable(true);
    }

    public void last() {
        _cardLayout.last(this);
        // _cardLayout.show(this, "title");
    }

    private void startGameLoop() {
        while(true) {
            try {
                Thread.sleep(20);
                repaint();
            } catch(InterruptedException e) {
                break;
            }
        }
    }

    public static void main(String args[]) {
        STG stg = new STG();

        JFrame frame = new JFrame("STG Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(480, 640);
        frame.add(stg);
        frame.setVisible(true);

        stg.startGameLoop();
    }
}
