import java.awt.*;
//半圆形散射子弹
public class ThirdEnemyBullet extends EnemyShot {
    //存放移动距离的数组，弧形子弹每一次移动的距离不一样，需要依次记录
    private float vxNWay[];
    private float vyNWay[];
    //子弹之间的角度
    private float theta;
    //子弹数
    private int n;


    public ThirdEnemyBullet(float x, float y, Hero hero, Image img) {

        super(x, y, img);
        //半圆形散射子弹，一共12颗，间隔11，180/11 == 16.36， 取15度为子弹间隔
        theta = 15F;
        n = 12;

        vxNWay = new float[n];
        vyNWay = new float[n];

        //初始化横纵坐标位移数组
        //1度是0.017453292519943295弧度，15度对应的弧度，之后叠加用到
        float rad_step = (float) (0.017453292519943295D * (double) theta);
        //这是初始化子弹角度，15颗子弹对半，左右两边，从负的弧度加到正的弧度停止，初始rad为
        float rad = (float) (((double) (-n / 2) + 0.5D) * (double) rad_step);

        for (int i = 0; i < n;) {
            //一共发射12颗子弹
            float c = (float) Math.cos(rad);
            float s = (float) Math.sin(rad);
            vxNWay[i] = 0.0F * c - 2.0F * s;
            vyNWay[i] = 0.0F * s + 2.0F * c;
            //参数：xy子弹的初始位置，vxNWay[i], vyNWay[i]移动速度
            //这里构造使用的子弹是battlePanel.FirstEnemyBulletImage
            battlePanel.addList(new EnemyShot(x, y, vxNWay[i], vyNWay[i], battlePanel.SecondEnemyBulletImage));
            i++;
            //以15度为间隔发射子弹，因为15*12正好180度
            rad += rad_step;
        }
        vx = vxNWay[0];
        vy = vyNWay[0];
    }
}
