package app;

import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {

    public Container getContainer(String title) {
        super.setTitle(title);
        Container container = this.getContentPane();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 700);
        setLocation(100, 50);
        setVisible(true);
        //JComponent jComponent = new JComponent();
        //container.add(jComponent);
        return container;
    }
}
