import java.awt.Image;

public class Shot extends Role {

    protected float vx;
    protected float vy;

    public Shot(float x, float y, Image image) {
        super(image);
        //坐标原点是左上角，减去图片宽的一半，即显示在该位置
        this.x = x - WIDTH / 2.0F;
        this.y = y - HEIGHT / 2.0F;
    }

    public Shot(float x, float y, float vx, float vy, Image image) {
        super(image);
        this.x = x - WIDTH / 2.0F;
        this.y = y - HEIGHT / 2.0F;
        this.vx = vx;
        this.vy = vy;
    }

    public void move() {
        x += vx;
        y += vy;
        if (x + WIDTH < 0.0F || x > (float) battlePanel.getWidth()
                || y + HEIGHT < 0.0F || y > (float) battlePanel.getHeight())
            dead();
    }

    protected boolean checkHit(Role chara) {

        return (x > chara.x - WIDTH && x < chara.x + chara.WIDTH
                && y > chara.y - HEIGHT && y < chara.y + chara.HEIGHT);

    }

}
