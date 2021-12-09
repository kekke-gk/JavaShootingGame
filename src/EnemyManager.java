import java.util.*;

public class EnemyManager {

    private Map<Integer, EnemyInfo> _scenario;
    private GameState _gs;

    public EnemyManager(GameState gs) {
        _gs = gs;

        analyze();
    }

    public void popEnemys(int curTime) {
        if (!_scenario.containsKey(curTime)) return;

        EnemyInfo info = _scenario.get(curTime);
        try {
            BaseEnemy enemy = (BaseEnemy)(info.enemyType.getConstructor(EnemyInfo.class).newInstance(info));
            _gs.add(enemy);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void analyze() {
        _scenario = new HashMap<>();

        EnemyInfo info = new EnemyInfo(Settings.WIDTH / 2, 0, 0);

        _scenario.put(50, info);
    }
}
