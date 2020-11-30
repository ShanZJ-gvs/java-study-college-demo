package com.shanzj.action;

import javax.swing.*;
import java.awt.*;

/**
 * @version 1.34 2015-06-12
 * @author Cay Horstmann
 */
public class ActionTest
{
   public static void main(String[] args)
   {
      EventQueue.invokeLater(() -> {
         JFrame frame = new ActionFrame();
         frame.setTitle("ActionTest");
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.setVisible(true);
      });
   }
}