package model;


import app.MyComponent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Image extends MyComponent {

    private String image;

    public Image(Map<String, String> stringStringMap) {
        setX(Integer.parseInt(stringStringMap.get("img_x")));
        setY(Integer.parseInt(stringStringMap.get("img_y")));
        setHigh(Integer.parseInt(stringStringMap.get("img_high")));
        setWith(Integer.parseInt(stringStringMap.get("img_with")));
        setImage(stringStringMap.get("image"));
    }


    public void pt(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        System.out.println(getImage());
        java.awt.Image image = new ImageIcon(getImage()).getImage();
        int imageWidth = image.getWidth(this);
        int imageHeight = image.getHeight(this);
        g2.drawImage(image, getX(), getY(), 100,100,null);
    }

}
