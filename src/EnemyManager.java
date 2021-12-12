import java.io.*;
import java.util.*;

public class EnemyManager {

    private Map<Integer, EnemyInfo> _scenario;
    private GameState _gs;
    private int _curTime = 0;

    public EnemyManager(GameState gs) {
        _gs = gs;

        analyze(new File("stage_01.txt"));
    }

    public void popEnemys(int curTime) {
        _curTime = curTime;
        if (!_scenario.containsKey(curTime)) return;

        EnemyInfo info = _scenario.get(curTime);
        try {
            BaseEnemy enemy = (BaseEnemy)(info.enemyType.getConstructor(EnemyInfo.class).newInstance(info));
            _gs.add(enemy);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int remainEnemyNum() {
        int count = 0;
        for(var entry : _scenario.entrySet()) {
            if (entry.getKey() > _curTime) count++;
        }
        return count;
    }

    private void analyze(File f) {
        _scenario = new HashMap<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(f));
            String line;
            while ((line = br.readLine()) != null) {
                if (line.startsWith("//") || line.isBlank()) continue;
                String[] valStrs = line.split(",");
                int[] vals = new int[valStrs.length];
                for (int i = 0; i < valStrs.length; i++) {
                    vals[i] = Integer.parseInt(valStrs[i]);
                }
                _scenario.put(vals[0], new EnemyInfo(vals[1], vals[2], vals[3]));
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
