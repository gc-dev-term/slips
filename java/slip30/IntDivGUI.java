import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class IntDivGUI extends JFrame implements ActionListener {
    private JTextField t1, t2, tres;
    private JButton divideBtn;

    public IntDivGUI() {
        setTitle("Integer Division");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 2, 5, 5));

        add(new JLabel("Num 1st:"));
        t1 = new JTextField();
        add(t1);

        add(new JLabel("Num 2:"));
        t2 = new JTextField();
        add(t2);

        add(new JLabel("Result:"));
        tres = new JTextField();
        tres.setEditable(false);
        add(tres);

        divideBtn = new JButton("Divide");
        divideBtn.addActionListener(this);
        add(divideBtn);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            int n1 = Integer.parseInt(t1.getText());
            int n2 = Integer.parseInt(t2.getText());

            int res = n1 / n2;
            tres.setText(String.valueOf(res));
        }
        catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "please enter integers.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        catch (ArithmeticException ex) {
            JOptionPane.showMessageDialog(this, "Division by 0 not allowed", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        new IntDivGUI();
    }
}
