import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MouseEventDemo extends JFrame {
    String message = "";

    public MouseEventDemo() {
        setTitle("Mouse Event");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                message = "mouse clicked";
                repaint();
            }

            public void mousePressed(MouseEvent e) {
                message = "mouse pressed";
                repaint();
            }

            public void mouseReleased(MouseEvent e) {
                message = "mouse released";
                repaint();
            }

            public void mouseEntered(MouseEvent e) {
                message = "mouse entered";
                repaint();
            }

            public void mouseExited(MouseEvent e) {
                message = "mouse exited";
                repaint();
            }
        });

        addMouseMotionListener(new MouseAdapter() {
            public void mouseDragged(MouseEvent e) {
                message = "mouse dragged";
                repaint();
            }

            public void mouseMoved(MouseEvent e) {
                message = "mouse moved";
                repaint();
            }
        });

        setVisible(true);
    }

    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.RED);
        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.drawString(message, getWidth()/2 - 70, getHeight()/2);
    }

    public static void main(String arg[]) {
        new MouseEventDemo();
    }
}
