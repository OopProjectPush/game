import javax.swing.*;
import java.awt.*;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;

//WIDTH = 464 HEIGHT = 670

public class BattlePanel extends JPanel implements Runnable {

    public static int gameMode;
    static final int WIDTH = 464;
    static final int HEIGHT = 670;


    private Graphics graphics;
    private Image offImage;

    public static Image heroImage;
    public static Image FirstEnemyImage;
    public static Image SecondEnemyImage;
    public static Image ThirdEnemyImage;
    public static Image bigBoss1;
    public static Image bigBoss2;
    public static Image bigBoss3;
    public static Image LittleBulletImage;
    public static Image BigBulletImage;
    public static Image FirstEnemyBulletImage;
    public static Image SecondEnemyBulletImage;
    public static Image ThirdEnemyBulletImage;
    public static Image BeamEnemyBulletImage;
    public static Image BackgroundImage;

    //存放要加载到游戏面板上的对象
    public static LinkedList list;
    public static LinkedList listTmp;

    //创建游戏开始线程
    private Thread gameThread;

    Hero hero;
    int heroBlood;
    BigBoss bigBoss;

    private int stage;
    public FirstStage firstStage;
    public SecondStage secondStage;
    public ThirdStage thirdStage;

    //相当于一个循环的计数器
    int current;
    public static int time = 0;

    private float heroY;
    private float shotX;
    private float bossX;
    private float bossY;

    public BattlePanel(){

        

        gameMode = 0;
        stage = 1;
        current = 0;
        graphics = null;
        Role.battlePanel = this;
        list = new LinkedList();
        listTmp = new LinkedList();

        heroImage  = loadImage("hero.png");
        FirstEnemyImage = loadImage("FirstEnemyImage.png");
        SecondEnemyImage = loadImage("SecondEnemyImage.png");
        ThirdEnemyImage = loadImage("ThirdEnemyImage.png");
        bigBoss1 = loadImage("bigBoss1.png");
        bigBoss2 = loadImage("bigBoss2.png");
        bigBoss3 = loadImage("bigBoss3.png");
        LittleBulletImage = loadImage("LittleBulletImage.gif");
        BigBulletImage = loadImage("BigBulletImage.png");
        FirstEnemyBulletImage = loadImage("FirstEnemyBulletImage.gif");
        SecondEnemyBulletImage = loadImage("SecondEnemyBulletImage.gif");
        ThirdEnemyBulletImage = loadImage("ThirdEnemyBulletImage.gif");
        BeamEnemyBulletImage = loadImage("BeamEnemyBulletImage.png");

        BackgroundImage = loadImage("background.jpg");

        addKeyListener(new Key());
        setFocusable(true);
        requestFocus();
        //貌似暂时不用
        setBackground(Color.black);
        setForeground(Color.white);

        //设置玩儿家的血量
        String str = JOptionPane.showInputDialog(null,"你可以自定义血量（1000~999999），请输入：\n","快来拥有你的不死之身",JOptionPane.PLAIN_MESSAGE);
        heroBlood = Integer.parseInt(str);

        gameThread = new Thread(this);
        gameThread.start();
    }

    public void run() {
        while (gameThread == Thread.currentThread()) {
            iniGra();
            //if (graphics != null) {
            long RefreshTime = System.currentTimeMillis();
            try {
                Thread.sleep(2L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            switch (gameMode) {
                case 0:
                    title();
                    break;

                case 1:
                    stage1();
                    break;

                case 12:
                    ready();
                    break;

                case 14:
                    //boss死后调用让boss退出
                    crear();
                    break;

                case 13:
                    //被ready调用，显示第几关
                    displayStage();
                    break;

                case 2:
                    stage2();
                    break;
                case 3:
                    stage3();
                    break;

                case 10:
                    congratulation();
                    break;

                case 11:
                    gameOver();
                    break;

                case 15:
                    //显示进入下一关，调用ready
                    nextStage();
                    break;

                case 16:
                    bossDeath();
                    break;
            }
            refreshScreen();
            current++;
            while (System.currentTimeMillis() - RefreshTime < 15L) ;
        }
    }

    public void iniGra(){
        if (offImage == null) {
            offImage = createImage(464, 670);
            if (offImage == null){
                return;
            }
            graphics = offImage.getGraphics();
        }
    }
    //刷新画面，不然全是拖影
    public void refreshScreen() {
        try {

            Graphics g = getGraphics();

            if (g != null)
                g.drawImage(offImage, 0, 0, this);
            Toolkit.getDefaultToolkit().sync();



            //graphics.drawImage(BackgroundImage, 0,0, null);
            if (g != null)
                g.dispose();
            //update(graphics);
            paint(graphics);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    //绘制背景图片
    @Override
    public void paint(Graphics g) {
        if (g != null)
            g.drawImage(BackgroundImage, 0, 0, 464, 670, this);

    }


    //显示第一个画面,按回车后进入关卡开始准备界面
    private void title() {
        if (Key.enter) {
            gameMode = 12;
        } else {

            if (offImage == null) {
                offImage = createImage(464, 670);
                if (offImage == null) {
                    return;
                }
            }

            graphics = offImage.getGraphics();

            graphics.drawImage(BackgroundImage, 0,0, null);
            Font font = new Font("华文新魏",1, 45);
            graphics.setFont(font);
            FontMetrics fontMetrics = getFontMetrics(font);
            graphics.drawString("雷电--不死之身",
                    (464 - fontMetrics.stringWidth("雷电--不死之身")) / 2,
                    (670 + fontMetrics.getHeight()) / 2 - 50);



        }
    }

    //完蛋
    private void gameOver() {
        if (Key.enter) {
            gameMode = 12;
            stage = 1;
            hero.dead = false;
        } else {
            graphics.setColor(Color.white);
            Font font = new Font("黑体", 1, 35);
            graphics.setFont(font);
            FontMetrics fontMetrics = getFontMetrics(font);
            graphics.drawString("游戏结束", (464 - fontMetrics.stringWidth("游戏结束")) / 2,
                    (670 + fontMetrics.getHeight()) / 2 - 50);
        }
    }

    //闯关成功
    private void nextStage() {
        graphics.setColor(Color.white);
        Font font = new Font("黑体", 1, 35);
        graphics.setFont(font);
        graphics.drawString("NB，下一关", 100, 250);
        hero.setPower(hero.getPowerMax());

        //先让自己的战斗机退出页面在调用ready函数

        if (heroY + hero.getHeight() > 0.0F) {
            graphics.drawImage(hero.getImage(), (int) shotX, (int) heroY, null);
        } else {
            gameMode = 12;
            stage++;
        }
        //如果全部完成，那就恭喜
        if (stage == 4) {
            gameMode = 10;
        }
        heroY -= 2.0F;
    }

    //玩儿爆了
    private void congratulation() {
        graphics.setColor(Color.white);
        graphics.drawString("NB，老哥\n游戏被你玩儿爆了", 100, 250);
    }

    //准备每一次关卡的初始化，
    //每一个关卡开始的时候创建一幅图画
    private void stage1() {
        FirstStage.start();

        gameMain();
    }
    private void stage2() {
        SecondStage.start();
        gameMain();
    }
    private void stage3() {
        ThirdStage.start();
        gameMain();
    }

    //他会调用 bossDeath()
    private void crear() {
        if (stage == 1) {
            gameMode = 16;
        } else if (stage == 2) {
            gameMode = 16;
        } else if (stage == 3) {
            gameMode = 16;
        }
    }

    //boss死，调用闯关成功(可能有问题)
    private void bossDeath() {
        if (bossY + bigBoss.getHeight() > 0.0F) {
            graphics.drawImage(bigBoss.getImage(), (int) bossX, (int) bossY, null);
            graphics.drawImage(hero.getImage(), (int) shotX, (int) heroY, null);
            bossY--;
        } else {
            gameMode = 15;
        }
    }

    //关卡开始的准备工作，准备好之后调用显示关卡画面
    private void ready() {
        //new BloodPanel(graphics);

        //BloodPanel.getUniquebloodpanel().drawBloodPanel();

        time = 0;
        list.clear();
        listTmp.clear();
        hero = Hero.getUniqueHero();

        hero.setPower(heroBlood);
        Thread thread = new Thread(BloodPanel.getUniquebloodpanel());
        thread.start();

        shotX = hero.getX();
        heroY = hero.getY() + hero.getHeight() * 4F;
        switch (stage) {
            case 1:
                firstStage = new FirstStage(hero);
                break;

            case 2:
                secondStage = new SecondStage(hero);
                break;

            case 3:
                thirdStage = new ThirdStage(hero);
                break;
        }
        addList(hero);
        gameMode = 13;
    }

    //显示第几关
    private void displayStage() {
        graphics.setColor(Color.white);
        graphics.drawString("第" + stage + "关", 160, 250);
        if (heroY < 670F - hero.getHeight()) {
            gameMode = stage;
        } else {
            graphics.drawImage(hero.getImage(), (int) shotX, (int) heroY, null);
        }
        heroY -= 4.0F;
    }


    //绘制其余的图像
    private void gameMain() {
        hero.drawPower(graphics);
        //画主角的血量
        //画在了另一个面板上
        //BloodPanel b = new BloodPanel(graphics);
/*
        for (int i = 0; i < Start.num_Star; i++){
            //如果敌人死了随机产生一个
            if (star[i].death())
                star[i] = new Start((int) (450D * Math.random()),
                        (int) (500D * Math.random()),
                        (int) (4D * Math.random()) + 2,
                        (int) (5D * Math.random()) + 1, Color.white);
        }
        for (int i = 0; i < Start.num_Star; i++){
            star[i].move();
        }

        for (int i = 0; i < Start.num_Star; i++){
            star[i].draw(g_off);
        }
*/

        for (int i = 0; i < list.size(); i++) {
            Role chara1 = (Role) list.get(i);
            for (int j = 0; j < list.size(); j++) {
                Role chara2 = (Role) list.get(j);
                chara1.checkHit(chara2);
            }
        }

        //boss没死，画出来，死了，就退出
        for (int i = 0; i < list.size(); i++) {
            Role chara1 = (Role) list.get(i);
            if (chara1 instanceof BigBoss) {
                bigBoss = (BigBoss) chara1;
                if (!bigBoss.isDead()) {
                    bigBoss.drawPower(graphics);
                } else {
                    bossX = bigBoss.getX();
                    bossY = bigBoss.getY();
                    shotX = hero.getX();
                    heroY = hero.getY();
                    gameMode = 14;
                }
            }
        }


        for (int i = list.size() - 1; i >= 0; i--) {
            Role chara1 = (Role) list.get(i);
            chara1.move();
            
            //这里比较重要，是原来画屏幕的，之前丢掉老半天出不来
            chara1.draw(graphics);
        }

        for (int i = 0; i < list.size(); i++) {
            Role chara1 = (Role) list.get(i);
            if (chara1.isDead()) {
                list.remove(i);
            }
        }

        //临时数组数据添加到数组后清空
        for (int i = 0; i < listTmp.size(); i++){
            list.add(listTmp.get(i));
        }


        if (hero.isDead()) {
            gameMode = 11;
        }
        listTmp.clear();
        time++;

    }

    public int getWidth() {
        return 464;
    }

    public int getHeight() {
        return 670;
    }

    //添加对象到listTmp
    public static void addList(Role chara) {
        listTmp.add(chara);
    }

    //采用字节流加载图像的函数
    public Image loadImage(String str) {
        InputStream is = null;
        try {
            is = BattlePanel.class.getResourceAsStream(str);
        } catch (Exception e) {
            is = null;
        }

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] arrayByte = null;
        try {
            byte[] bytes = new byte[4096];
            bytes = new byte[is.available()];
            int read;
            while ((read = is.read(bytes)) >= 0) {
                byteArrayOutputStream.write(bytes, 0, read);
            }
            arrayByte = byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            System.err.println("Image Loader IQ Exception " + e.getMessage());
            return null;
        } finally {
            try {
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                    byteArrayOutputStream = null;
                }
                if (is != null) {
                    is.close();
                    is = null;
                }

            } catch (IOException e) {
                System.err.println("Image Close IQ Exception " + e.getMessage());
            }

        }
        Image result = Toolkit.getDefaultToolkit().createImage(arrayByte);
        if (result != null)
             waitImage(result);
        else
            System.out.println("File not found. ( " + str + " )");
        return result;
    }

    /**
     * 同步方法,使产生图像时间一致。
     *
     * @param image
     */
    private final static void waitImage(Image image) {
        try {
            Toolkit toolkit = Toolkit.getDefaultToolkit();
            for (int i = 0; i < 100; i++) {
                if (toolkit.prepareImage(image, -1, -1, null))
                    return;
                Thread.currentThread();
                Thread.sleep(100L);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
