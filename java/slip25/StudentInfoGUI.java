import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class StudentInfoGUI extends JFrame implements ActionListener {
    JTextField nameField;
    JCheckBox classFY, classSY, classTY;
    JCheckBox hobbyMusic, hobbyDance, hobbySport;
    JTextArea output;
    JButton submit;

    public StudentInfoGUI() {
        setTitle("Student Information");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(3, 2));

        inputPanel.add(new JLabel("Name:"));
        nameField = new JTextField();
        inputPanel.add(nameField);

        inputPanel.add(new JLabel("Class:"));
        JPanel classPanel = new JPanel();
        classFY = new JCheckBox("FY");
        classSY = new JCheckBox("SY");
        classTY = new JCheckBox("TY");
        classPanel.add(classFY);
        classPanel.add(classSY);
        classPanel.add(classTY);
        inputPanel.add(classPanel);

        inputPanel.add(new JLabel("Hobbies:"));
        JPanel hobbyPanel = new JPanel();
        hobbyMusic = new JCheckBox("Music");
        hobbyDance = new JCheckBox("Dance");
        hobbySport = new JCheckBox("Sport");
        hobbyPanel.add(hobbyMusic);
        hobbyPanel.add(hobbyDance);
        hobbyPanel.add(hobbySport);
        inputPanel.add(hobbyPanel);

        add(inputPanel, BorderLayout.NORTH);

        output = new JTextArea(5, 30);
        output.setEditable(false);
        add(new JScrollPane(output), BorderLayout.CENTER);

        submit = new JButton("Submit");
        submit.addActionListener(this);
        add(submit, BorderLayout.SOUTH);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String name = nameField.getText();

        StringBuilder selectedClass = new StringBuilder();
        if (classFY.isSelected()) selectedClass.append("FY ");
        if (classSY.isSelected()) selectedClass.append("SY ");
        if (classTY.isSelected()) selectedClass.append("TY ");

        StringBuilder selectedHobbies = new StringBuilder();
        if (hobbyMusic.isSelected()) selectedHobbies.append("Music ");
        if (hobbyDance.isSelected()) selectedHobbies.append("Dance ");
        if (hobbySport.isSelected()) selectedHobbies.append("Sport ");

        output.setText("Name: " + name + " Class: " + selectedClass.toString() + " Hobbies: " + selectedHobbies.toString());
    }

    public static void main(String[] args) {
        new StudentInfoGUI();
    }
}
