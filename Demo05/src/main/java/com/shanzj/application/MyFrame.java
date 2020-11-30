package com.shanzj.application;

import com.shanzj.action.ActionFrame;
import com.sun.javafx.geom.Ellipse2D;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RectangularShape;


public class MyFrame extends JFrame
{
    /*public MyFrame()
    {
        JButton ok = new JButton("OK");
        add(new MyComponent());
        pack();
    }*/

    private JPanel buttonPanel;
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;

    public MyFrame()
    {

        setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);

        buttonPanel = new JPanel();

        // define actions
        Action yellowAction = new MyFrame.ColorAction("Yellow", new ImageIcon("yellow-ball.gif"), Color.YELLOW);
        Action blueAction = new MyFrame.ColorAction("Blue", new ImageIcon("blue-ball.gif"), Color.BLUE);


        // add buttons for these actions
        buttonPanel.add(new JButton(yellowAction));
        buttonPanel.add(new JButton(blueAction));


        // add panel to frame

        add(buttonPanel);
        //add(new MyComponent());

        // associate the Y, B, and R keys with names
        InputMap imap = buttonPanel.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        imap.put(KeyStroke.getKeyStroke("ctrl Y"), "panel.yellow");
        imap.put(KeyStroke.getKeyStroke("ctrl B"), "panel.blue");


        // associate the names with actions
        ActionMap amap = buttonPanel.getActionMap();
        amap.put("panel.yellow", yellowAction);
        amap.put("panel.blue", blueAction);

        System.out.println(222);
    }

    public class ColorAction extends AbstractAction
    {

        public ColorAction(String name, Icon icon, Color c)
        {
            putValue(Action.NAME, name);
            putValue(Action.SMALL_ICON, icon);
            putValue(Action.SHORT_DESCRIPTION, "Set panel color to " + name.toLowerCase());
            putValue("color", c);
        }
        int ff = 0;

        public void actionPerformed(ActionEvent event)
        {
            Color c = (Color) getValue("color");
            buttonPanel.setBackground(c);

            if (c == Color.YELLOW){
                ff = 1;
                add(new MyComponent(ff));
            }
            if (c == Color.BLUE){
                ff = 0;
                add(new MyComponent(ff));
            }
        }
    }

}
