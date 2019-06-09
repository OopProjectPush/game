import java.awt.Image;
// 蓝色圆形子弹,一定步数之后散射为ThirdEnemyBullet
public class SecondEnemyBullet extends EnemyShot {

    //敌机与自己的距离
    private float distance;
    //子弹速度
    private float speed;
    //自己对象
    //private Hero hero;
    //子弹移动次数
    private int counter;

    public SecondEnemyBullet(float x, float y, Hero hero, Image img) {
        super(x, y, img);
        speed = 5F;
        counter = 0;

        //下面的计算使得蓝色圆形子弹飘向自己
        //勾股定理，直线距离
        distance = (float) Math.sqrt((((double) hero.x + (double) hero.WIDTH / 2D) - (double) x)
                * (((double) hero.x + (double) hero.WIDTH / 2D) - (double) x)
                + (double) ((hero.y - y) * (hero.y - y)));
        if (distance != 0.0F) {
            vx = (float) (((((double) hero.x + (double) hero.WIDTH / 2D) - (double) x) / (double) distance) * (double) speed);
            vy = ((hero.y - y) / distance) * speed;
        } else {
            //若敌机与自己距离为0，则子弹不移动就竖直往下移动
            vx = 0.0F;
            vy = speed;
        }

    }

    public void move() {
        //执行 移动
        x += vx;
        y += vy;

        if (counter == 50) {
            //移动了50步之后，散开圆圈小子弹，自己消失
            battlePanel.addList(new ThirdEnemyBullet(
                    (int) ((double) x + (double) WIDTH / 2D),
                    (int) (y + HEIGHT), hero, battlePanel.ThirdEnemyBulletImage));
            dead();
        }
        /*
            if (counter > 0)
                counter--;
            if (counter <= 0) {

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
                counter = 50;
            }


            if (counter == 1) {
                //移动了50步之后，散开圆圈小子弹，自己消失
                battlePanel.addList(new ThirdEnemyBullet(x, y, hero, battlePanel.ThirdEnemyBulletImage));
                dead();
            }
*/
            //子弹超出边界消失
            if (x + WIDTH < 0.0F || x > (float) battlePanel.getWidth() || y + HEIGHT < 0.0F || y > (float) battlePanel.getHeight())
                dead();
            counter++;
        }
    }

