import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ComboBox extends JFrame implements ActionListener {
    JComboBox<String> comboBox;
    JTextField textField;

    public ComboBox() {
        setTitle("T.Y.B.Sc.(Comp. Sci) Subjects");
        setSize(400, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        String subjects[] = {
            "Java Programming",
            "Software Testing",
            "Computer Networks",
            "Data Science",
            "Operating Systems",
            "Web Technologies"
        };

        comboBox = new JComboBox<>(subjects);
        textField = new JTextField(20);

        add(new JLabel("Select Subject:"));
        add(comboBox);
        add(new JLabel("Selected Subject:"));
        add(textField);

        comboBox.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String subject = (String) comboBox.getSelectedItem();
        textField.setText(subject);
    }

    public static void main(String ar[]) {
        new ComboBox();
    }
}
