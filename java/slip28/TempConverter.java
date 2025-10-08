import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TempConverter extends JFrame implements ActionListener {
    private JTextField celsiusField, fahrenheitField;
    private JButton cToFButton, fToCButton;

    public TempConverter() {
        setTitle("Temperature Converter");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 2, 5, 5));

        add(new JLabel("Celsius-->"));
        celsiusField = new JTextField();
        add(celsiusField);

        add(new JLabel("Fahrenheit-->"));
        fahrenheitField = new JTextField();
        add(fahrenheitField);

        cToFButton = new JButton("C -> F");
        fToCButton = new JButton("F -> C");

        cToFButton.addActionListener(this);
        fToCButton.addActionListener(this);

        add(cToFButton);
        add(fToCButton);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == cToFButton) {
                double celsius = Double.parseDouble(celsiusField.getText());
                double fahrenheit = (celsius * 9 / 5) + 32;
                fahrenheitField.setText(String.format("%.1f", fahrenheit));
            } else if (e.getSource() == fToCButton) {
                double fahrenheit = Double.parseDouble(fahrenheitField.getText());
                double celsius = (fahrenheit - 32) * 5 / 9;
                celsiusField.setText(String.format("%.1f", celsius));
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Plz enter a valid number", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        new TempConverter();
    }
}
