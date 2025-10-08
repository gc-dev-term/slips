import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CurrencyConverter extends JFrame implements ActionListener {
    JTextField tfSGD, tfUSD, tfEuro;
    JButton convert;

    public CurrencyConverter() {
        setTitle("currency converter");
        setSize(350, 200);
        setLayout(new GridLayout(4, 2, 5, 5));
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        tfSGD = new JTextField();
        tfUSD = new JTextField();
        tfEuro = new JTextField();

        convert = new JButton("Convert");
        convert.addActionListener(this);

        add(new JLabel("singapore dollars (sgd):"));
        add(tfSGD);
        add(new JLabel("us dollars (usd):"));
        add(tfUSD);
        add(new JLabel("euros (eur):"));
        add(tfEuro);
        add(convert);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            if (!tfSGD.getText().isEmpty()) {
                double sgd = Double.parseDouble(tfSGD.getText());
                double usd = sgd / 1.41;
                double euro = sgd * 0.65;
                tfUSD.setText(String.format("%.2f", usd));
                tfEuro.setText(String.format("%.2f", euro));
            } else if (!tfUSD.getText().isEmpty()) {
                double usd = Double.parseDouble(tfUSD.getText());
                double sgd = usd * 1.41;
                double euro = usd * 0.92;
                tfSGD.setText(String.format("%.2f", sgd));
                tfEuro.setText(String.format("%.2f", euro));
            } else if (!tfEuro.getText().isEmpty()) {
                double euro = Double.parseDouble(tfEuro.getText());
                double usd = euro / 0.92;
                double sgd = euro / 0.65;
                tfUSD.setText(String.format("%.2f", usd));
                tfSGD.setText(String.format("%.2f", sgd));
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "enter  valid number");
        }
    }

    public static void main(String arg[]) {
        new CurrencyConverter();
    }
}
