import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SwingDemo extends JFrame implements ActionListener {
    JTextField t1, t2, t3;
    JButton b1, b2;

    public SwingDemo() {
        setTitle("String Operations");
        setSize(400, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        t1 = new JTextField(10);
        t2 = new JTextField(10);
        t3 = new JTextField(15);

        b1 = new JButton("Concatenate");
        b2 = new JButton("Reverse");

        add(new JLabel("First String:"));
        add(t1);
        add(new JLabel("Second String:"));
        add(t2);
        add(new JLabel("Result:"));
        add(t3);
        add(b1);
        add(b2);

        b1.addActionListener(this);
        b2.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            String s1 = t1.getText();
            String s2 = t2.getText();
            t3.setText(s1 + s2);
        } else if (e.getSource() == b2) {
            String s1 = t1.getText();
            StringBuilder sb = new StringBuilder(s1);
            t3.setText(sb.reverse().toString());
        }
    }

    public static void main(String args[]) {
        new SwingDemo();
    }
}
