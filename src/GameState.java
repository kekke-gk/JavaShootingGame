import java.awt.*;

public class GameState extends ModeState {

    private int _curTime = 0;
    private PlayableFighter _fighter;

    public GameState(GameManager gm) {
        super(gm);

        _fighter = new PlayableFighter();
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
}
