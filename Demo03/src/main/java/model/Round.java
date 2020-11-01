package model;

import app.Component;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Round extends Component{
    private int r;
    private int g;
    private int b;
    public Round(Map<String, String> stringStringMap) {
        setX(Integer.parseInt(stringStringMap.get("round_x")));
        setY(Integer.parseInt(stringStringMap.get("round_y")));
        setHigh(Integer.parseInt(stringStringMap.get("round_high")));
        setWith(Integer.parseInt(stringStringMap.get("round_with")));
        setR(Integer.parseInt(stringStringMap.get("r")));
        setG(Integer.parseInt(stringStringMap.get("g")));
        setB(Integer.parseInt(stringStringMap.get("b")));
    }

    public void print(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        //Graphics2D g2 = (Graphics2D)super.getGraphics();
        Ellipse2D ellipse2D_1 = new Ellipse2D.Double(getX(), getY(), getWith(), getHigh());
        g2.setColor(new Color(getR(), getG(), getB()));
        g2.fill(ellipse2D_1);
    }
}
