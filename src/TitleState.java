import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TitleState extends ModeState {

    private int _cursorPos = 0;

    // メインタイトルの位置
	private final static int TITLEPOSX	= 50;
	private final static int TITLEPOSY	= 150;

	// メインメニュー表示位置。表示間隔。カーソル位置（x座標のみ）
	private final static int MENUPOSX		= 200;
	private final static int MENUPOSY		= 280;
	private final static int MENUINTVL	= 50;
	private final static int CURSOR		= 150;

    public TitleState(GameManager gm) {
        super(gm);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        g2.setFont(new Font("Arial", Font.BOLD, 28));

        g2.setPaint(Color.yellow);
        g2.drawString("Templete Shooting", TITLEPOSX, TITLEPOSY);

        if(_cursorPos == 0)
            g2.setPaint(Color.green);
        else
            g2.setPaint(Color.yellow);
    
        g2.drawString("Game Start", MENUPOSX, MENUPOSY);

        if(_cursorPos == 1)
            g2.setPaint(Color.green);
        else
            g2.setPaint(Color.yellow);

        g2.drawString("Quit", MENUPOSX, MENUPOSY + MENUINTVL);

        g2.setPaint(Color.green);
		switch(_cursorPos)
		{
			case 0:
			    g2.drawString("@", CURSOR, MENUPOSY);
				break;
			case 1:
			    g2.drawString("@", CURSOR, MENUPOSY + MENUINTVL);
				break;
		}
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println(e.getKeyCode());
        switch (e.getKeyCode()) {
            case KeyEvent.VK_Z:
                switch (_cursorPos) {
                    case 0:
                        System.out.println("Go to Main");
                        _gm.setState(new GameState(_gm));
                        break;
                
                    case 1:
                        System.out.println("Go to Exit");
                        // this.setFocusable(false);
                        _gm.setState(new ExitState(_gm));
                        break;
                }
                break;
        
            case KeyEvent.VK_UP:
                _cursorPos = Math.max(_cursorPos - 1, 0);
                break;

            case KeyEvent.VK_DOWN:
                _cursorPos = Math.min(_cursorPos + 1, 1);
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }
    
}
