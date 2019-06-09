public class ThirdEnemy extends Enemy {
    public ThirdEnemy(float x, float y, Hero hero, int pattern) {
        super(hero, battlePanel.ThirdEnemyImage);
        vx = 0.0F;
        vy = 4F;
        this.hero = hero;
        this.x = x;
        this.y = y;
        this.pattern = pattern;
        power = 25;
    }

    public void move() {
            if (pattern == 0) {
                if (counter < 60) {
                    x += vx;
                    y += vy;
                } else if (counter > 250) {
                    x += vx;
                    y -= vy;
                }
            } else if (pattern == 1)
                if (counter < 60) {
                    x -= vx;
                    y += vy;
                } else if (counter > 150) {
                    x += vx;
                    y -= vy;
                }

            checkOutOfScreen();
            if (onlyMoveCount > 0)
                onlyMoveCount--;
            if (onlyMoveCount <= 0) {
                BattlePanel.addList(new ThirdEnemyBullet(
                        (int) ((double) x + (double) WIDTH / 2D),
                        (int) (y + HEIGHT), hero, battlePanel.ThirdEnemyBulletImage));
                onlyMoveCount = 90;
            }
            counter++;
        }
        /*
        if (pattern == 0) {
            if (counter < 60) {
                x += vx;
                y += vy;
            } else if (counter > 100) {
                x += vx;
                y -= vy;
            }
        } else if (pattern == 1)
            if (counter < 60) {
                x -= vx;
                y += vy;
            } else if (counter > 120) {
                x += vx;
                y -= vy;
            }

        //checkOutOfScreen();
        if (onlyMoveCount > 0)
            onlyMoveCount--;
        if (onlyMoveCount <= 0) {
            battlePanel.addList(new ThirdEnemyBullet(
                    (int) ((double) x + (double) WIDTH / 2D),
                    (int) (y + HEIGHT), hero, battlePanel.ThirdEnemyBulletImage));
            onlyMoveCount = 90;
        }
        counter++;

         */
    }


