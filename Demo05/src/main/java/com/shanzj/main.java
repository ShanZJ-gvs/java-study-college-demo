package com.shanzj;

import javax.swing.*;



public class main extends JFrame{
    private JPanel buttonPanel;
    private static final int DEFAULT_WIDTH=300;
    private static final int DEFAULT_HEIGHT=200;

    public main() {
        setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);

        //创建按钮
        JButton yellowButton = new JButton("Yellow");
        JButton blueButton = new JButton("Blue");
        JButton redButton = new JButton("Red");

        buttonPanel = new JPanel();

        //添加按钮到panel
        buttonPanel.add(yellowButton);
        buttonPanel.add(blueButton);
        buttonPanel.add(redButton);

        //添加panel到frame里
        add(buttonPanel);
        
        //创建一个按钮行为


    }


}


