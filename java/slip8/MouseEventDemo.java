import java.awt.*;
import java.awt.event.*;

public class MouseEventDemo extends Frame implements MouseListener, MouseMotionListener {
    TextField tf;

    public MouseEventDemo() {
        setTitle("mouse event");
        setSize(400, 300);
        setLayout(new FlowLayout());

        tf = new TextField(30);
        tf.setEditable(false);
        add(tf);

        addMouseListener(this);
        addMouseMotionListener(this);

        setVisible(true);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }

    public void mouseClicked(MouseEvent e) {
        tf.setText("mouse clicked at: x=" + e.getX() + ", y=" + e.getY());
    }

    public void mouseMoved(MouseEvent e) {
        setTitle("mouse moved at: x=" + e.getX() + ", y=" + e.getY());
    }

    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
    public void mouseDragged(MouseEvent e) {}

    public static void main(String[] args) {
        new MouseEventDemo();
    }
}
