package model;

import app.MyComponent;


import java.awt.*;
import java.util.Map;

public class Letter extends MyComponent {


    public Letter(Map<String, String> stringStringMap) {
        setX(Integer.parseInt(stringStringMap.get("let_x")));
        setY(Integer.parseInt(stringStringMap.get("let_y")));
        setHigh(Integer.parseInt(stringStringMap.get("let_high")));
        setWith(Integer.parseInt(stringStringMap.get("let_with")));

    }

    public void pt(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setPaint(Color.RED);
        g2.setFont(new Font("宋体", Font.PLAIN, 30));
        String msg = "gvssimux";
        g2.drawString(msg, getX(), getY());
    }


}
