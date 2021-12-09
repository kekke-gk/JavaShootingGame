import javax.swing.*;

public class STG extends JPanel {

    private GameManager _gmanager;

    public STG() {
        setLayout(null);

        _gmanager = new GameManager(this);

        setFocusable(true);
    }

    private void startGameLoop() {
        while (true) {
            try {
                Thread.sleep(20);
                repaint();
            } catch (InterruptedException e) {
                break;
            }
        }
    }

    public static void main(String args[]) {
        STG stg = new STG();

        JFrame frame = new JFrame("STG Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(Settings.WIDTH, Settings.HEIGHT);
        frame.add(stg);
        frame.setVisible(true);

        stg.startGameLoop();
    }
}
