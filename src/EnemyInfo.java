public class EnemyInfo {
    public final int x, y;
    public final Class enemyType;

    private final Class[] ENEMY_TYPES = {
            EnemyT1.class
    };

    public EnemyInfo(int x, int y, int type) {
        this.x = x;
        this.y = y;
        this.enemyType = ENEMY_TYPES[type];
    }
}
