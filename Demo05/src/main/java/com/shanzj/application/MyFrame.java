package com.shanzj.application;

import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {

    public Container getContainer(String title) {
        //设置窗体标题
        super.setTitle(title);
        //获取显示器的尺寸
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        double width = screenSize.getWidth();
        double height = screenSize.getHeight();
        //设置窗体的一些属性
        Container container = this.getContentPane();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize((int) (width/2), (int) (height/2));
        setLocation(0, 0);
        setVisible(true);

        //JComponent jComponent = new JComponent();
        //container.add(jComponent);
        //pack();
        return container;
    }
}
