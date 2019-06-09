public class BigBullet extends HeroBullet{
    Hero hero;
    public BigBullet(float x, float y, float vx, float vy) {
        super(x, y, vx, vy, battlePanel.BigBulletImage);
    }
    public void move() {
        if (Key.xkey && (Key.right)) {
            x += vx + hero.vx;
            y += vy + hero.vy;
        } else if(Key.xkey && (Key.left)){
            x += vx - hero.vx;
            y += vy - hero.vy;
        }else {
            x += vx;
            y += vy;
        }
        if (x + WIDTH < 0.0F || x > (float) battlePanel.getWidth() || y + HEIGHT < 0.0F
                || y > (float) battlePanel.getHeight())
            dead();
    }
}
