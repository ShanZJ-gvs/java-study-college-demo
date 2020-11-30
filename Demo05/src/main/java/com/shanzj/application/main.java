package com.shanzj.application;

import javax.swing.*;
import java.awt.*;


public class main extends JFrame
{
    public static void main(String[] args)
    {
        EventQueue.invokeLater(() -> {
            JFrame frame = new MyFrame();
            frame.setTitle("Gvssimux");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}


