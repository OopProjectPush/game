import java.awt.*;

public class EnemyShot extends Shot {

    protected Hero hero;
    protected Enemy enemy;

    public EnemyShot(float x, float y, Image image) {
        super(x, y, image);

    }
    public EnemyShot(float x, float y, float vx, float vy, Image image) {
        super(x, y, vx, vy, image);
    }
}
