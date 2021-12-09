public class GameManager {

    private STG _stg;
    private ModeState _modeState = null;

    public GameManager(STG stg) {
        _stg = stg;
        setState(new TitleState(this));
        // setState(new ExitState());
    }

    public ModeState getState() {
        return _modeState;
    }

    public void setState(ModeState state) {
        // if (_modeState != null) {
        //     _stg.remove(_modeState);
        // }
        // _stg.add(state);
        // _modeState = state;

        // _stg.removeAll();
        // _stg.add(state);
        // _modeState = state;

        // _stg.add(state);
        // _modeState = state;

        // _stg.getContentPane().add(state);
        // _stg.add(state, "title");
        // if (_modeState != null) {
        //     _modeState.setFocusable(false);
        // }

        if (_modeState != null) {
            _stg.removeKeyListener(_modeState);
        }
        _stg.addKeyListener(state);
        
        _stg.add(state);
        _stg.last();
        _modeState = state;
    }
}
