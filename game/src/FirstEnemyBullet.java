import java.awt.Image;
//绿色圆形普通子弹
public class FirstEnemyBullet extends EnemyShot {

    private float speed;
    //子弹移动次数
    private int count;


    public FirstEnemyBullet(float x, float y, Hero hero, Image img) {
        super(x, y, img);
        speed = 6F;
        count = 0;
        this.hero = hero;
    }

    public void move() {
        if (count > 0)
            count--;
        if (count <= 0) {

            //count实现移动50次之后，重定位子弹的方向
            //勾股定理求出子弹距离自己的距离
            float distance = (float) Math.sqrt((((double) hero.x + (double) hero.WIDTH / 2D) - (double) x)
                    * (((double) hero.x + (double) hero.WIDTH / 2D) - (double) x)
                    + (double) ((hero.y - y) * (hero.y - y)));
            //距离不为0，则用对应的正余弦值求出速度横纵坐标的分量
            if (distance != 0.0F) {
                vx = (float) (((((double) hero.x + (double) hero.WIDTH / 2D) - (double) x) / (double) distance) * (double) speed);
                vy = ((hero.y - y) / distance) * speed;
            } else {
                //若接触，则纵向向下移动
                vx = 0.0F;
                vy = speed;
            }
            count = 50;
        }
        //执行 移动
        x += vx;
        y += vy;

        //子弹超出边界消失
        if (x + WIDTH < 0.0F || x > (float) battlePanel.getWidth() || y + HEIGHT < 0.0F || y > (float) battlePanel.getHeight())
            dead();
    }

}
