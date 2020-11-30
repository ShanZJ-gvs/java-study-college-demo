package com.shanzj.button;

import javax.swing.*;
import java.awt.*;

/**
 * @version 1.34 2015-06-12
 * @author Cay Horstmann
 */
public class ButtonTest
{
   public static void main(String[] args)
   {
      EventQueue.invokeLater(() -> {
         JFrame frame = new ButtonFrame();
         frame.setTitle("ButtonTest");
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.setVisible(true);
      });
   }
}