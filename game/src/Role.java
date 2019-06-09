import java.awt.*;

public abstract class Role {
    //等待图像加载的对象。
    protected static BattlePanel battlePanel;
    protected Image img;
    protected float x;
    protected float y;
    protected float WIDTH;
    protected float HEIGHT;
    protected boolean dead;

    protected Role(Image img) {
        this.img = img;
        //public abstract int getWidth(ImageObserver observer)
        //确定图像的宽度。 如果宽度尚未知道，则此方法返回-1 ，稍后通知指定的ImageObserver对象。
        WIDTH = img.getWidth(battlePanel);
        HEIGHT = img.getHeight(battlePanel);
        dead = false;
    }

    abstract void move();

    protected boolean checkHit(Role chara) {
        return x > chara.x - WIDTH && x < chara.x + chara.WIDTH
                && y > chara.y - HEIGHT && y < chara.y + chara.HEIGHT;
    }

    public boolean isDead() {
        return dead;
    }

    public void dead() {
        dead = true;
    }

    public void draw(Graphics g) {
        g.drawImage(img, (int) x, (int) y, battlePanel);
    }

}
