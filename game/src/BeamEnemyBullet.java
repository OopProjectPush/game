public class BeamEnemyBullet extends EnemyShot {
    //红色长激光
    //enemy 指明哪一个敌人类调用

    public BeamEnemyBullet(float x, float y, Hero hero, Enemy enemy) {
        super(x, y, battlePanel.BeamEnemyBulletImage);

        this.hero = hero;
        this.enemy = enemy;
        vx = 0.0F;
        vy = 3F;
    }

    public void move() {
        //使得子弹像是从飞机里面发射出来的
        x += vx + enemy.vx;
        y += vy + enemy.vy;
        //越过边界消失
        if (x + WIDTH < 0.0F || x > (float) battlePanel.getWidth() || y + HEIGHT < 0.0F
                || y > (float) battlePanel.getHeight())
            dead();
    }
}
