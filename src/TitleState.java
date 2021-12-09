public class TitleState extends BaseMenuState {

    private final static String TITLE = "Java Shooting Game";
    private final static String[] MENU_ITEMS = {
        "Game Start",
        "Quit"
    };

    public TitleState(GameManager gm) {
        super(gm, TITLE, MENU_ITEMS);
    }

    @Override
    protected void selectItem(int cursorPos) {
        switch (cursorPos) {
            case 0:
                _gm.setState(new GameState(_gm));
                break;

            case 1:
                System.exit(0);
                break;
        }
    }
}
