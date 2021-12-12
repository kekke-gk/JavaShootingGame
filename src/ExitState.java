public class ExitState extends BaseMenuState {

    private final static String[] MENU_ITEMS = {
        "Play Again",
        "Back to Menu",
        "Quit"
    };

    public ExitState(GameManager gm, GameResult result) {
        super(gm, getTitle(result), MENU_ITEMS);
    }

    private static String getTitle(GameResult result) {
        String title;
        if (result.isClear) {
            title = "Stage Clear";
        } else {
            title = "Game Over";
        }

        title += " Score: " + result.score;
        return title;
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
