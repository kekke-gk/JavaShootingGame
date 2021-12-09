import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ExitState extends ModeState {

    private int _cursorPos = 0;

    // メインタイトルの位置
	private final static int TITLEPOSX	= 50;
	private final static int TITLEPOSY	= 150;

    // メインメニュー表示位置。表示間隔。カーソル位置（x座標のみ）
	private final static int MENUPOSX		= 200;
	private final static int MENUPOSY		= 280;
	private final static int MENUINTVL	= 50;
	private final static int CURSOR		= 150;

    public ExitState(GameManager gm) {
        super(gm);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        g2.setFont(new Font("Arial", Font.BOLD, 28));

        g2.setPaint(Color.yellow);
        g2.drawString("Finish", TITLEPOSX, TITLEPOSY);

        g2.setPaint((_cursorPos == 0) ? Color.green : Color.yellow);
        g2.drawString("Play Again", MENUPOSX, MENUPOSY);

        g2.setPaint((_cursorPos == 1) ? Color.green : Color.yellow);
        g2.drawString("Back to Menu", MENUPOSX, MENUPOSY + MENUINTVL);

        g2.setPaint((_cursorPos == 2) ? Color.green : Color.yellow);
        g2.drawString("Quit", MENUPOSX, MENUPOSY + MENUINTVL * 2);

        g2.setPaint(Color.green);
        g2.drawString("@", CURSOR, MENUPOSY + MENUINTVL * _cursorPos);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("ExitState:" + e.getKeyCode());        
        switch (e.getKeyCode()) {
            case KeyEvent.VK_Z:
                switch (_cursorPos) {
                    case 0:
                        System.out.println("Play again");
                        break;
                
                    case 1:
                        System.out.println("Back to Menu");
                        _gm.setState(new TitleState(_gm));
                        break;

                    case 2:
                        System.out.println("Quit");
                        System.exit(0);
                        break;
                }
                break;
        
            case KeyEvent.VK_UP:
                _cursorPos = Math.max(_cursorPos - 1, 0);
                break;

            case KeyEvent.VK_DOWN:
                _cursorPos = Math.min(_cursorPos + 1, 2);
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }
    
}
