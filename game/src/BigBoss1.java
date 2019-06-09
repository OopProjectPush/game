import java.awt.*;

public class BigBoss1 extends BigBoss{

    public static float vx;
    public static float vy;

    public BigBoss1(Hero hero){
        super(hero,battlePanel.bigBoss1);
        this.hero = hero;
        x = 50F;
        y = -250F;
        power = 2000;
        vx = 1.0F;
        vy = 0.0F;
        powerMax = power;
    }

    public void move() {
        //counter 指的是移动的次数，一开始需要向下移动
        //移动到一定位置开始左右移动
        if (counter < 150)
            y += 10D;
        else if (counter >= 150) {
            x += vx;
            if (x + WIDTH > (float) battlePanel.getWidth())
                vx = -vx;
            if (x < 0.0F)
                vx = -vx;
        }

        checkOutOfScreen();

        //onlyMoveCount 控制发射子弹的间隔，在间隔之间只移动，不发射子弹
        if (onlyMoveCount > 0)
            onlyMoveCount--;
        if (counter % 2000 < 500) {
            if (onlyMoveCount <= 0 && counter % 2000 > 100) {
                battlePanel.addList(new FirstEnemyBullet(x + WIDTH / 2.0F,
                        y + HEIGHT, hero, battlePanel.FirstEnemyBulletImage));
                battlePanel.addList(new FirstEnemyBullet(x + WIDTH / 2.0F,
                        y + HEIGHT, hero, battlePanel.FirstEnemyBulletImage));
                battlePanel.addList(new FirstEnemyBullet(x + WIDTH / 2.0F,
                        y + HEIGHT, hero, battlePanel.FirstEnemyBulletImage));
                onlyMoveCount = 30;
            }
        } else if (counter % 2000 < 1000) {
            if (onlyMoveCount <= 0 && counter % 2000 > 600) {
                battlePanel.addList(new BeamEnemyBullet(x + WIDTH / 2.0F, y + HEIGHT,hero, this));
                battlePanel.addList(new BeamEnemyBullet(x + WIDTH / 2.0F, y + HEIGHT,hero, this));
                onlyMoveCount = 60;
            }
        } else if (counter % 2000 < 1500) {
            if (onlyMoveCount <= 0 && counter % 2000 > 1100) {
                battlePanel.addList(new SecondEnemyBullet(
                        (int) ((double) x + (double) WIDTH / 2D),
                        (int) (y + HEIGHT), hero, battlePanel.SecondEnemyBulletImage));
                battlePanel.addList(new SecondEnemyBullet(
                        (int) ((double) x + (double) WIDTH / 2D),
                        (int) (y + HEIGHT), hero, battlePanel.SecondEnemyBulletImage));
                onlyMoveCount = 80;
            }
        } else if (counter % 2000 < 2000 && onlyMoveCount <= 0
                && counter % 2000 > 1600) {
            battlePanel.addList(new ThirdEnemyBullet(
                    (int) ((double) x + (double) WIDTH / 2D),
                    (int) (y + HEIGHT), hero, battlePanel.ThirdEnemyBulletImage));
            battlePanel.addList(new BeamEnemyBullet(x + WIDTH / 2.0F, y + HEIGHT,hero, this));
            onlyMoveCount = 50;

        }
        /*
        if (onlyMoveCount <= 0) {
            battlePanel.addList(new FirstEnemyBullet(x + WIDTH / 2.0F, y
                    + HEIGHT, hero, battlePanel.FirstEnemyBulletImage));
            battlePanel.addList(new SecondEnemyBullet(x + WIDTH / 2.0F,
                    y + HEIGHT, hero, battlePanel.SecondEnemyBulletImage));
            onlyMoveCount = 50;
        }

         */
        counter++;
    }

    protected boolean checkHit(Role chara) {
        //boss被击中血量会下降，下降到0则出现爆炸图片，boss死亡。
        if (x - 20F > chara.x - WIDTH
                && x + 20F < chara.x + chara.WIDTH
                && y - 50F > chara.y - HEIGHT
                && y + 50F < chara.y + chara.HEIGHT) {
            chara.dead();
            power--;
            if (power <= 0) {
                dead();
            }
            return true;
        } else {
            return false;
        }
    }

    public Image getImage() {
        return img;
    }
}
