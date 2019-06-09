import java.awt.*;

abstract public class Enemy extends Role{

    protected Hero hero;
    protected int power;
    protected float vx;
    protected float vy;
    //protected int tamaIntCount;
    //控制发射时间间隔，间隔之间只移动，不再发射
    protected int onlyMoveCount;
    //这是一个记录移动次数的变量
    protected int counter;
    protected int pattern = 0;

    public Enemy(Hero hero, Image enemyImage) {
        super(enemyImage);
        this.hero = hero;
        onlyMoveCount = 0;
        //记录移动的次数
        counter = 0;
    }

    public abstract void move();

    public void checkOutOfScreen() {
        if (y - 100F > (float) battlePanel.getHeight() || y + HEIGHT + 100F < 0.0F
                || x + WIDTH + 100F < 0.0F || x - 100F > (float) battlePanel.getWidth())

            dead();
    }


    protected boolean checkHit(Role chara) {
        if ((chara instanceof HeroBullet) && super.checkHit(chara)) {
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

}
