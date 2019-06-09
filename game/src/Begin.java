import javax.swing.*;
import java.awt.*;

public class Begin {
    public static void main(String[] args) {
        EventQueue.invokeLater(()->
        {
            MainFrame test = new MainFrame();
            //分辨率问题，高度设置为700
            //test.setBounds(100, 100, 634, 800);
            test.setBounds(100, 100, 634, 700);
            test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            test.getContentPane().setLayout(null);
            test.setVisible(true);
        });
    }
}