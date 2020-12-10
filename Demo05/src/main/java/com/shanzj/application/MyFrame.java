package com.shanzj.application;

import com.shanzj.tools.SaveReadFile;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RectangularShape;
import java.util.ArrayList;


public class MyFrame extends JFrame
{
    /*public MyFrame()
    {

        JPanel jPanel = new JPanel();
        jPanel.add(new JButton("wad"));
        add(jPanel,BorderLayout.NORTH);


        add(new MyComponent4());
        add(new MyComponent3());

        pack();
    }*/



    private JPanel buttonPanel;
    private JPanel buttonPanel2;
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;
    private MyComponent4 myComponent4;
    private JButton save;
    private JButton read;

    public void setMyComponent4(MyComponent4 myComponent4) {
        this.myComponent4 = myComponent4;
    }

    public MyFrame()
    {
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        // create buttons
        JButton yellowButton = new JButton("圆形");
        JButton blueButton = new JButton("矩形");
        save = new JButton("保存");
        read = new JButton("读取");


        buttonPanel = new JPanel();
        buttonPanel2 = new JPanel();

        // add buttons to panel
        buttonPanel.add(yellowButton);
        buttonPanel.add(blueButton);
        buttonPanel2.add(save);
        buttonPanel2.add(read);
        myComponent4= new MyComponent4();
        add(myComponent4);
        // add panel to frame
        add(buttonPanel,BorderLayout.NORTH);
        add(buttonPanel2,BorderLayout.SOUTH);

        // create button actions
        ColorAction yellowAction = new ColorAction(Color.YELLOW);
        ColorAction blueAction = new ColorAction(Color.BLUE);
        SaveRead action = new SaveRead("写");
        SaveRead action2 = new SaveRead("读");

        // associate actions with buttons
        yellowButton.addActionListener(yellowAction);
        blueButton.addActionListener(blueAction);
        save.addActionListener(action);
        read.addActionListener(action2);
    }





    private class ColorAction implements ActionListener
    {
        private Color backgroundColor;

        public ColorAction(Color c)
        {
            backgroundColor = c;
        }

        public void actionPerformed(ActionEvent event)
        {
            if(backgroundColor==Color.YELLOW){
                myComponent4.setFf("yuan");
            }
            if (backgroundColor==Color.BLUE){
                myComponent4.setFf("fang");
            }
            buttonPanel.setBackground(backgroundColor);

        }
    }


    private class SaveRead implements ActionListener
    {
        private String option;
        private SaveReadFile tool;

        public SaveRead(String option) {
            this.option = option;
        }



        public void actionPerformed(ActionEvent e) {


            if(option == "写"){
                System.out.println("写");
                tool.writeObjectToFile(myComponent4);
                System.out.println(myComponent4.getSquares());

            }
            if(option == "读"){
                System.out.println("读");
                MyComponent4 o = (MyComponent4) tool.readObjectFromFile();
                myComponent4.setSquares(o.getSquares());
                System.out.println(myComponent4.getSquares());

            }

        }

    }




}
