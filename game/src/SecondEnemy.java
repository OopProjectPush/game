public class SecondEnemy extends Enemy {
    public SecondEnemy(float x, float y, Hero hero, int pattern) {
        super(hero, battlePanel.SecondEnemyImage);
        this.hero = hero;
        this.x = x;
        this.y = y;
        vx = 0.0F;
        vy = 2.0F;
        this.pattern = pattern;
        power = 60;
    }

    public void move() {
        if (pattern == 0)
            if (counter < 100)
                y += vy;
            else if (counter > 300)
                y -= vy;
        checkOutOfScreen();
        if (onlyMoveCount > 0)
            onlyMoveCount--;
        if (counter > 100 && counter < 280 && onlyMoveCount <= 0) {
            battlePanel.addList(new BeamEnemyBullet(x + WIDTH / 2.0F, y + HEIGHT,hero, this));
            onlyMoveCount = 2;
        }
        counter++;
    }
        /*
        if (counter < 100)
            y += 2.0F;
        else
            y -= 2.0F;
       // checkOutOfScreen();
        if (onlyMoveCount > 0)
            onlyMoveCount--;
        if (counter > 100 && counter < 280 && onlyMoveCount <= 0) {
            battlePanel.addList(new SecondEnemyBullet(x + WIDTH / 2.0F, y + HEIGHT,
                    hero, battlePanel.SecondEnemyBulletImage));
            onlyMoveCount = 2;
        }
        counter++;

         */

}
