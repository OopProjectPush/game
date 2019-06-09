import javax.swing.*;
import java.awt.*;

public class BloodPanel extends JPanel implements Runnable{
    private JButton display;
    Hero hero;

    //单例模式获取血量，因为frame需要创建，battlepanel需要实时显示，都要调用
    private static BloodPanel uniquebloodpanel;
    private Image offImage;
    public Graphics gr;
    static JLabel label = new JLabel("0.00");
    static JLabel label1 = new JLabel("0.00");

    private BloodPanel() {
    }

    public static BloodPanel getUniquebloodpanel() {
        if (uniquebloodpanel == null) {
            uniquebloodpanel = new BloodPanel();
        }
        return uniquebloodpanel;
    }

    public void run() {
        /*
        if (offImage == null) {
            offImage = createImage(156, 213);
            if (offImage == null) {
                return;
            }
        }

        gr = offImage.getGraphics();
        //画主角的血量
        hero.drawPower(gr);
*/
        setLayout(new BorderLayout());
        /*
        add(label, BorderLayout.SOUTH);
        add(label1, BorderLayout.CENTER);
        setVisible(true);
        hero = Hero.getUniqueHero();
        int max = hero.getPower();

        while (true) {

            label.setText("你的实时血量：\n" + hero.getPower());
            label1.setText("你的最大血量：\n" + max);
            if (Integer.parseInt(label.getText()) < 500)
                label.setForeground(Color.red);
            else
                label.setForeground(Color.black);


            label1.setForeground(Color.black);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

         */


        display = new JButton("fsdfsdsdf");
        display.setEnabled(false);
        add(display, BorderLayout.CENTER);
        hero = Hero.getUniqueHero();
        Font f = new Font("宋体",Font.BOLD,33);
        display.setForeground(Color.cyan);
        display.setFont(f);
        display.setText("" + hero.getPower());


        display = new JButton("你的最大血量：");
        display.setEnabled(false);
        add(display, BorderLayout.NORTH);
        //Font f = new Font("宋体",Font.BOLD,33);
        display.setText("你的最大血量：\n");

    }
}
