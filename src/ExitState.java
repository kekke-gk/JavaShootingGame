public class ExitState extends BaseMenuState {

    private final static String TITLE = "Finish";
    private final static String[] MENU_ITEMS = {
        "Play Again",
        "Back to Menu",
        "Quit"
    };

    public ExitState(GameManager gm) {
        super(gm, TITLE, MENU_ITEMS);
    }

    @Override
    protected void selectItem(int cursorPos) {
        switch (cursorPos) {
            case 0:
                _gm.setState(new GameState(_gm));
                break;

            case 1:
                _gm.setState(new TitleState(_gm));
                break;

            case 2:
                System.exit(0);
                break;
        }
    }
}
