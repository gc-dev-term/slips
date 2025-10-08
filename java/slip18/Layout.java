import javax.swing.*;
import java.awt.*;

 class Layout {
      public static void main(String args[]) {
        JFrame frm = new JFrame("Border Layout");
        frm.setSize(400, 300);
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frm.setLayout(new BorderLayout());

        frm.add(new JButton("north"), BorderLayout.NORTH);
        frm.add(new JButton("south"), BorderLayout.SOUTH);
        frm.add(new JButton("east"), BorderLayout.EAST);
        frm.add(new JButton("west"), BorderLayout.WEST);
        frm.add(new JButton("center"), BorderLayout.CENTER);

        frm.setVisible(true);
    }
}
