package app;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Component extends JComponent{
    private int x;
    private int y;
    private int with;
    private int high;
    private HashMap<String,Component> hashMap;
    public void add(Component component){

    }

    public void paintComponent(Graphics g) {
        /*Graphics2D g2 = (Graphics2D) g;
        g2.setPaint(Color.RED);
        g2.setFont(new Font("宋体", Font.PLAIN, 18));
        String msg = "汽车w";
        g.drawString(msg, 240, 320);

        Rectangle2D rectangle2D = new Rectangle2D.Double(10, 10, 10, 10);
        g2.setColor(new Color(45, 235, 245));
        g2.fill(rectangle2D);*/

        /*Ellipse2D ellipse2D_1 = new Ellipse2D.Double(150, 230, 80, 80);
        Ellipse2D ellipse2D_2 = new Ellipse2D.Double(360, 230, 80, 80);
        g2.setColor(new Color(45, 235, 245));
        g2.fill(ellipse2D_1);
        g2.fill(ellipse2D_2);*/

    }

}
