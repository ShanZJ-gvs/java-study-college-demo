package model;

import app.Component;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Rectangle extends Component {
    private int r;
    private int g;
    private int b;

    public Rectangle(Map<String, String> stringStringMap) {
        setX(Integer.parseInt(stringStringMap.get("rectangle_x")));
        setY(Integer.parseInt(stringStringMap.get("rectangle_y")));
        setHigh(Integer.parseInt(stringStringMap.get("rectangle_high")));
        setWith(Integer.parseInt(stringStringMap.get("rectangle_with")));
        setR(Integer.parseInt(stringStringMap.get("r")));
        setG(Integer.parseInt(stringStringMap.get("g")));
        setB(Integer.parseInt(stringStringMap.get("b")));
    }
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        Rectangle2D rectangle2D = new Rectangle2D.Double(getX(), getY(), getWith(), getHigh());
        g2.setColor(new Color(getR(), getG(), getB()));
        g2.fill(rectangle2D);
    }
}
