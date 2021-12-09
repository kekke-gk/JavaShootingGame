import java.util.*;
import java.util.List;
import java.awt.event.*;

public class GameManager {

    private STG _stg;
    private ModeState _modeState = null;
    private List<KeyListener> _keyListeners;

    public GameManager(STG stg) {
        _stg = stg;
        _keyListeners = new ArrayList<>();
        setState(new TitleState(this));
    }

    public ModeState getState() {
        return _modeState;
    }

    public void setState(ModeState state) {
        if (_modeState != null) {
            _stg.removeKeyListener(_modeState);
            _stg.remove(_modeState);
        }
        _keyListeners.clear();

        _stg.addKeyListener(state);

        _stg.add(state);
        _modeState = state;
    }

    public void addKeyListener(KeyListener keyListener) {
        _keyListeners.add(keyListener);
        _stg.addKeyListener(keyListener);
    }
}
