public class FirstEnemy extends Enemy {

    public FirstEnemy(float x, float y, Hero hero, int pattern) {
        super(hero, battlePanel.FirstEnemyImage);
        this.hero = hero;
        this.x = x;
        this.y = y;
        this.pattern = pattern;
        power = 1;
    }

    public void move() {
        //定义四种运动方式
        //先向右下，再左上返回
        if (pattern == 0) {
            if (counter < 100) {
                x++;
                y += 3D;
            } else if (counter > 200) {
                x--;
                y -= 3D;
            }
        } else if (pattern == 1) {
            if (counter < 100) {
                x--;
                y += 3D;
            } else if (counter > 100) {
                x++;
                y -= 3D;
                //**//--///loonframewrk提供
            }
        } else if (pattern == 2) {
            x += Math.sin((3.1415926535897931D * (double) counter) / 40D) * 5D;
            y += 1.5D;
        } else if (pattern == 3) {
            if (counter < 50)
                y += 2.5D;
            else if (counter >= 100) {
                x += Math
                        .sin((3.1415926535897931D * ((double) counter - 100D)) / 160D) * 2.5D;
                y += Math
                        .sin((3.1415926535897931D * ((double) counter - 20D)) / 160D) * 2.5D;
            }
        } else if (pattern == 4) {
            if (counter < 50)
                y += 2.5D;
            else if (counter >= 100) {
                x -= Math
                        .sin((3.1415926535897931D * ((double) counter - 100D)) / 160D) * 2.5D;
                y += Math
                        .sin((3.1415926535897931D * ((double) counter - 20D)) / 160D) * 2.5D;
            }
        } else if (pattern == 5) {
            if (counter < 100) {
                x += 3D;
                y -= 4D;
            } else if (counter >= 100) {
                x -= 3D;
                y += 4D;
            }
        } else if (pattern == 6)
            if (counter < 100) {
                x -= 3D;
                y -= 4D;
            } else if (counter >= 100) {
                x += 3D;
                y += 4D;
            }
        checkOutOfScreen();
        if (onlyMoveCount > 0)
            onlyMoveCount--;
        if (onlyMoveCount <= 0) {
            battlePanel.addList(new FirstEnemyBullet(x + WIDTH / 2.0F,
                    y + HEIGHT, hero, battlePanel.FirstEnemyBulletImage));
            onlyMoveCount = 25;
        }
        counter++;
    }
}
