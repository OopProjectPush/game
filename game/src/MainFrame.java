import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    public MainFrame(){
        setTitle("减压雷电游戏之--不死之身");
        setResizable(false);

        //说明面板
        JTextPane textPane = new JTextPane();
        textPane.setForeground(Color.BLACK);
        textPane.setBackground(Color.BLACK);
        textPane.setEnabled(false);
        textPane.setEditable(false);
        textPane.setFont(new Font("微软雅黑", Font.BOLD, 16));
        textPane.setText("\n\u6E38\u620F\u8BF4\u660E\uFF1A\r\n  \u672C\u6E38\u620F\u53EF\u4EE5\u8BBE\u7F6E\u81EA\r\n  \u5DF1\u7684\u8840\u91CF\uFF0C\u53EA\u8981\u4F60\r\n  \u6562\u60F3\uFF0C\u4F60\u5C31\u6709\u591A\u5F3A\r\n  \u5927\uFF0C\u6E38\u620F\u5171\u6709\u4E09\u4E2A\r\n  \u5173\u5361\uFF0C\u6BCF\u4E00\u5C40\u654C\u4EBA\r\n  \u6784\u6210\u4E3A\u4E09\u79CD\u666E\u901A\u654C\r\n  \u4EBA\u548C\u4E00\u4E2ABoss\uFF0C\u4F60\r\n  \u9700\u8981\u907F\u514D\u4E0E\u654C\u673A\u4EE5\r\n  \u53CA\u5B50\u5F39\u78B0\u649E\r\n\r\n\u6E38\u620F\u5E2E\u52A9\uFF1A\r\n  Enter: \u5F00\u59CB\u6E38\u620F\r\n  z: \u53D1\u5C04\u6563\u5C04\u5B50\u5F39\r\n  x: \u53D1\u5C04\u6FC0\u5149\u675F");
        //textPane.setBounds(470, 218, 156, 380);
        textPane.setBounds(470, 168, 156, 380);

        getContentPane().add(textPane);

        //名字面板
        JTextPane textPane_1 = new JTextPane();
        textPane_1.setBackground(Color.BLACK);
        textPane_1.setFont(new Font("微软雅黑", Font.BOLD, 19));
        textPane_1.setForeground(Color.BLACK);
        textPane_1.setEnabled(false);
        textPane_1.setText("  \u8BBE\u8BA1\u8005\uFF1A\r\n      秦泽涛\r\n      杜承贤\r\n");
        //此处缩小50，还有血量的地方缩小50

        //textPane_1.setBounds(470, 609, 156, 161);
        textPane_1.setBounds(470, 559, 156, 111);
        getContentPane().add(textPane_1);

        //血量面板
        BloodPanel panel_1 = BloodPanel.getUniquebloodpanel();
        panel_1.setBackground(UIManager.getColor("SplitPane.shadow"));
        //此处缩小50，还有小组成员的地方缩小50
        panel_1.setBounds(470, 0, 156, 163);
        getContentPane().add(panel_1);

        //主面板
        BattlePanel panel = new BattlePanel();
        panel.setBounds(0, 0, 464, 770);
        getContentPane().add(panel);

        //设置游戏左上角图标，暂时失败，不知道为什么不显示
        this.setIconImage(new ImageIcon("ico.png").getImage());
        //Toolkit toolkit=Toolkit.getDefaultToolkit(); // 获取Toolkit对象
        //Image icon = toolkit.getImage("ico.png"); // 获取图片对象
        //this.setIconImage(icon); // 设置图标
    }
}
