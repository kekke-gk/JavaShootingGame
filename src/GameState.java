import java.util.*;
import java.util.List;
import java.awt.*;

public class GameState extends ModeState {

    private int _curTime = 0;
    private int _score = 0;
    private Fighter _fighter;
    private EnemyManager _em;

    public GameState(GameManager gm) {
        super(gm);

        _fighter = new Fighter();
        this.add(_fighter);
        gm.addKeyListener(_fighter);

        _em = new EnemyManager(this);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        if (collisionDetection()) {
            var result = new GameResult(false, _score);
            _gm.setState(new ExitState(_gm, result));
        }

        if (isStageClear()) {
            var result = new GameResult(true, _score);
            _gm.setState(new ExitState(_gm, result));
        }

        g2.setPaint(Color.white);
        g2.drawString("Time: " + _curTime, 10, 30);
        g2.drawString("Score: " + _score, 10, 50);

        _em.popEnemys(_curTime);

        _curTime++;
    }

    private boolean isStageClear() {
        return _em.remainEnemyNum() == 0 &&
               getEnemys().size() == 0 &&
               getEnemysBullets().size() == 0;
    }

    private boolean collisionDetection() {
        enemyCD();
        return fighterCD();
    }

    private void enemyCD() {
        for (BaseEnemy enemy : getEnemys()) {
            for (Bullet bullet : getMyBullets()) {
                if (!enemy.collide(bullet)) continue;

                if (--enemy._hp == 0) {
                    remove(enemy);
                    _score += enemy._score;
                }
                _fighter.remove(bullet);
            }
        }
    }

    private boolean fighterCD() {
        return fighterEnemyCD() || fighterBulletCD();
    }

    private boolean fighterEnemyCD() {
        for (BaseEnemy enemy : getEnemys()) {
            if (enemy.collide(_fighter)) return true;
        }
        return false;
    }

    private boolean fighterBulletCD() {
        for (Bullet bullet : getEnemysBullets()) {
            if (bullet.collide(_fighter)) return true;
        }
        return false;
    }

    private List<BaseEnemy> getEnemys() {
        List<BaseEnemy> enemys = new ArrayList<>();
        for (Component c : getComponents()) {
            if (!(c instanceof BaseEnemy)) continue;
            enemys.add((BaseEnemy) c);
        }
        return enemys;
    }

    private List<Bullet> getEnemysBullets() {
        List<Bullet> bullets = new ArrayList<>();
        for (Component c : getComponents()) {
            if (!(c instanceof Bullet)) continue;
            bullets.add((Bullet) c);
        }
        return bullets;
    }

    private List<Bullet> getMyBullets() {
        List<Bullet> bullets = new ArrayList<>();
        for (Component c : getComponents()) {
            if (!(c instanceof Fighter)) continue;

            Fighter f = (Fighter) c;
            for (Component c2 : f.getComponents()) {
                bullets.add((Bullet) c2);
            }
        }
        return bullets;
    }
}
