import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Key extends KeyAdapter {

    static boolean left;
    static boolean right;
    static boolean up;
    static boolean down;
    static boolean zkey;
    static boolean xkey;
    static boolean enter;

    public Key() {
    }

    public void keyPressed(KeyEvent e) {
        /*
        public int getKeyCode()
        返回与此事件中的键相关联的整数keyCode。
        结果
            键盘上实际键的整数代码。 （对于KEY_TYPED事件，keyCode为VK_UNDEFINED ）
         */
        switch (e.getKeyCode()) {
            case 37:
                left = true;
                break;

            case 39:
                right = true;
                break;

            case 38:
                up = true;
                break;

            case 40:
                down = true;
                break;

            case 90:
                zkey = true;
                break;

            case 88:
                xkey = true;
                break;

            case 10:
                enter = true;
                break;
        }
    }

    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case 37:
                left = false;
                break;

            case 39:
                right = false;
                break;

            case 38:
                up = false;
                break;

            case 40:
                down = false;
                break;

            case 90:
                zkey = false;
                break;

            case 88:
                xkey = false;
                break;

            case 10:
                enter = false;
                break;
        }
    }

}
