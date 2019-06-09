import java.awt.*;

public abstract class BigBoss extends Enemy {
    protected int powerMax;

    public BigBoss(Hero hero, Image enemyImage) {
        super(hero, enemyImage);
        dead = false;
    }

    public abstract void move();

    public float getX() {//获取X坐标
        return x;
    }

    public float getY() {//获取Y坐标
        return y;
    }

    public float getWidth() {//图片宽度
        return WIDTH;
    }

    public float getHeight() {//图片高度
        return HEIGHT;
    }

    public int getPower() {//当前血量
        return power;
    }

    public Image getImage() {//获取图片
        return img;
    }

    public void drawPower(Graphics g) {
        g.setColor(Color.white);
        g.drawRect(0, 0, 150, 15);//血量边框颜色和大小
        g.setColor(Color.blue);//当前血量颜色
        g.fillRect(1,1,(int) (((double) power/ (double) powerMax) * 150D ) - 1,14);
        //实际血量在边框内部，且受伤后实际血量会降低表现为矩形右侧向左移。
    }

    public int getPowerMax() {
        return powerMax;
    }

}
