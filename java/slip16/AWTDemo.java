import java.awt.*;
import java.awt.event.*;

public class AWTDemo {
    public static void main(String[] args) {
        Frame f = new Frame(" awt examples");

        MenuBar mb = new MenuBar();

        Menu file = new Menu("File");
        Menu edit = new Menu("Edit");
        Menu about = new Menu("About");

        MenuItem newItem = new MenuItem("New");
        MenuItem openItem = new MenuItem("Open");
        MenuItem saveItem = new MenuItem("Save");
        MenuItem showAbout = new MenuItem("Show About");
        MenuItem exitItem = new MenuItem("Exit");

        file.add(newItem);
        file.add(openItem);
        file.add(saveItem);
        about.add(showAbout);
        file.add(exitItem);

        mb.add(file);
        mb.add(edit);
        mb.add(about);

        f.setMenuBar(mb);

        f.setSize(400, 300);
        f.setLayout(null);
        f.setVisible(true);

        exitItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                f.dispose();
            }
        });

        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                f.dispose();
            }
        });
    }
}
