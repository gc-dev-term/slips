import java.awt.*;
import java.awt.event.*;

class InvalidLoginException extends Exception {
    public InvalidLoginException(String msg) {
        super(msg);
    }
}

public class LoginScreen extends Frame implements ActionListener {
    Label l1, l2, lmsg;
    TextField tuser, tpass;
    Button blogin, bclear;
    int attempts = 0;

    public LoginScreen() {
        setTitle("Login Screen");
        setSize(350, 200);
        setLayout(new GridLayout(4, 2, 10, 10));

        l1 = new Label("Username:");
        l2 = new Label("Password:");
        lmsg = new Label("");

        tuser = new TextField(20);
        tpass = new TextField(20);
         tpass.setEchoChar('*');

        blogin = new Button("Login");
        bclear = new Button("Clear");

        add(l1); add(tuser);
        add(l2); add(tpass);
        add(blogin); add(bclear);
        add(lmsg);

        blogin.addActionListener(this);
        bclear.addActionListener(this);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == blogin) {
            try {
                String user = tuser.getText();
                String pass = tpass.getText();

                if (!user.equals(pass)) {
                    attempts++;
                    throw new InvalidLoginException("Invalid Login! Username and Password must match.");
                } else {
                    lmsg.setText("Login Successful!");
                }
            } catch (InvalidLoginException e) {
                if (attempts >= 3) {
                    lmsg.setText("Max Attempts Reached. Access Denied!");
                    blogin.setEnabled(false);
                } else {
                    lmsg.setText(e.getMessage() + " Attempts left: " + (3 - attempts));
                }
            }
        } else if (ae.getSource() == bclear) {
            tuser.setText("");
            tpass.setText("");
            lmsg.setText("");
        }
    }

    public static void main(String[] args) {
        new LoginScreen();
    }
}
