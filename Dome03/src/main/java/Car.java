import javax.swing.*;
import java.awt.*;

import java.awt.geom.Rectangle2D;


public class Car extends JComponent {

    protected void paintHouse(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;


        Rectangle2D rectangle2D = new Rectangle2D.Double(1, 1, 400, 130);
        g2.setColor(new Color(45, 235, 245));
        g2.fill(rectangle2D);

        /*Ellipse2D ellipse2D_1 = new Ellipse2D.Double(150, 230, 80, 80);
        Ellipse2D ellipse2D_2 = new Ellipse2D.Double(360, 230, 80, 80);
        g2.setColor(new Color(45, 235, 245));
        g2.fill(ellipse2D_1);
        g2.fill(ellipse2D_2);*/


        /*g2.setPaint(new Color(45, 235, 245));
        g2.setFont(new Font("宋体", Font.ITALIC, 20));
        String msg = "小汽车";
        g.drawString(msg, 250, 320);*/


    }

}