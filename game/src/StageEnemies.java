public class StageEnemies {
    public int time;

    public float x;
    public float y;

    public int enemyKind;
    public int pattern;

    public StageEnemies(int enemyKind, int time, float x, float y, int pattern) {
        this.enemyKind = enemyKind;
        this.time = time;
        this.x = x;
        this.y = y;
        this.pattern = pattern;
    }

}
