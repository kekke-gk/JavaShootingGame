import java.awt.*;
import java.awt.event.*;

public abstract class BaseMenuState extends ModeState {
    
    private int _cursorPos = 0;

    private final static int TITLE_X = 50;
    private final static int TITLE_Y = 150;

    private final static int MENU_X = 200;
    private final static int MENU_Y = 280;
    private final static int MENU_INTVL = 50;

    private final static int CURSOR_X = 150;

    private final static Color TEXT_COLOR = Color.yellow;
    private final static Color HIGHLIGHT_COLOR = Color.green;

    private final String _title;
    private final String[] _menuItems;

    public BaseMenuState(GameManager gm, String title, String[] menuItems) {
        super(gm);
        _title = title;
        _menuItems = menuItems;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        g2.setFont(new Font("Arial", Font.BOLD, 28));

        g2.setPaint(TEXT_COLOR);
        g2.drawString(_title, TITLE_X, TITLE_Y);

        for (int i = 0; i < _menuItems.length; i++) {
            g2.setPaint((_cursorPos == i) ? HIGHLIGHT_COLOR : TEXT_COLOR);
            g2.drawString(_menuItems[i], MENU_X, MENU_Y + MENU_INTVL * i);
        }

        g2.setPaint(HIGHLIGHT_COLOR);
        g2.drawString("@", CURSOR_X, MENU_Y + MENU_INTVL * _cursorPos);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_Z:
                selectItem(_cursorPos);
                break;

            case KeyEvent.VK_UP:
                _cursorPos = Math.max(_cursorPos - 1, 0);
                break;

            case KeyEvent.VK_DOWN:
                _cursorPos = Math.min(_cursorPos + 1, _menuItems.length - 1);
                break;
        }
    }

    protected abstract void selectItem(int cursorPos);
}
