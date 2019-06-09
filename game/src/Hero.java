import java.awt.*;

public class Hero extends Role {

    private float speed;
    public int power;
    public int powerMax;
    public static float vx;
    public static float vy;
    //发普通子弹的时候，循环发射，两个一组坐标，一次发射三个
    private float tv[] = { -1F, -7F, 0.0F, -8F, 1.0F, -7F };
    //控制发射间隔，如果恰好处于不为0的时候，即使按键也不会发射子弹的
    private int tamaIntCount;

    //单例模式获取Hero战斗机
    private static Hero uniqueHero;

    private Hero() {
        super(BattlePanel.heroImage);
        //起始位置的左上角坐标(相对于panel)
        x = ((float) battlePanel.getWidth() - WIDTH) / 2.0F;
        y = (float) battlePanel.getHeight() - HEIGHT;
        power = 10000;
        powerMax = power;
        speed = 3.0F;
    }

    public static Hero getUniqueHero() {
        if(uniqueHero == null){
            uniqueHero = new Hero();
        }
        return uniqueHero;
    }

    public void move() {
        vx = speed;
        vy = speed;

        //控制移动减去相应的坐标，保证不超过边框
        if (Key.left) {
            x -= speed;
            if (x <= 0.0F)
                x = 0.0F;
        }
        if (Key.right) {
            x += speed;
            if (x + WIDTH >= (float) battlePanel.getWidth())
                x = (float) battlePanel.getWidth() - WIDTH;
        }
        if (Key.down) {
            y += speed;
            if (y + HEIGHT >= (float) battlePanel.getHeight())
                y = (float) battlePanel.getHeight() - HEIGHT;
        }
        if (Key.up) {
            y -= speed;
            if (y <= 0.0F)
                y = 0.0F;
        }

        if (tamaIntCount > 0)
            tamaIntCount--;
        if (Key.zkey && tamaIntCount <= 0) {
            for (int i = 0; i < tv.length; i += 2) {
                battlePanel.addList(new LittleBullet(x + WIDTH / 2.0F, y, tv[i], tv[i + 1]));
                tamaIntCount = 8;
            }
        }
        if (Key.xkey && !Key.zkey && tamaIntCount <= 0) {
            battlePanel.addList(new BigBullet(x + WIDTH / 2.0F, y, 0.0F, -5F));
            tamaIntCount = 2;
        }

    }
    //与boss和普通enemy相撞区分开，boss相撞直接死
    public boolean checkHit(Role chara) {
        if ((chara instanceof FirstEnemy)
                || (chara instanceof SecondEnemy)
                || (chara instanceof ThirdEnemy)
                || (chara instanceof EnemyShot)) {

            if ((x + WIDTH) - 14F > chara.x && x + 14F < chara.x + chara.WIDTH
                    && (y + HEIGHT) - 12F > chara.y
                    && y + 12F < chara.y + chara.HEIGHT) {
                //敌人或者子弹死亡,自己血量减少50
                chara.dead();
                power -= 50;


                if (power <= 0) {
                    dead();
                }
                return true;
            }
        } else if ((chara instanceof BigBoss) && (x + WIDTH) - 14F > chara.x + 50F
                && x + 14F < (chara.x + chara.WIDTH) - 50F
                && (y + HEIGHT) - 12F > chara.y + 50F
                && y + 12F < (chara.y + chara.HEIGHT) - 80F) {
            dead();

            return true;
        }
        return false;
    }
    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getWidth() {
        return WIDTH;
    }

    public float getHeight() {
        return HEIGHT;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public Image getImage() {
        return img;
    }

    public int getPower() {
        return power;
    }

    public int getPowerMax() {
        return powerMax;
    }

    public void setPower(int power) {
        this.power = power;
        powerMax = power;
    }
/*
    public void drawPower(Graphics g) {
        g.setColor(Color.white);
        g.drawRect(480, 40, 50, 15);
        g.setColor(Color.red);
        g.fillRect(481, 41,
                (int) ((50D / (double) (float) powerMax) * (double) power) - 1,
                14);
    }

*/

public void drawPower(Graphics g) {
    g.setColor(Color.white);
    //g.drawRect(0, 740, 462, 29);
    g.drawRect(0, 640, 462, 29);
    g.setColor(Color.red);
    //    g.fillRect(1, 741,
    //            (int) ((461D / (double) (float) powerMax) * (double) power) - 1,
    //            28);
    g.fillRect(1, 641,
            (int) ((461D / (double) (float) powerMax) * (double) power) - 1,
            28);
}


}
