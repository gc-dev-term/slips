import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ConcentricCircles extends JFrame {
    private int x = -1, y = -1;

    public ConcentricCircles() {
        setTitle("concentric circles on click");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                x = e.getX();
                y = e.getY();
                repaint();
            }
        });
    }

    public void paint(Graphics g) {
        super.paint(g);
        if (x != -1 && y != -1) {
            g.setColor(Color.RED);
            g.drawOval(x - 30, y - 30, 60, 60);

            g.setColor(Color.BLUE);
            g.drawOval(x - 20, y - 20, 40, 40);

            g.setColor(Color.GREEN);
            g.drawOval(x - 10, y - 10, 20, 20);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ConcentricCircles().setVisible(true);
        });
    }
}
