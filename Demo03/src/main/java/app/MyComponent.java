package app;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import model.Round;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.HashMap;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MyComponent extends JComponent{
    int number =0;
    private int x;
    private int y;
    private int with;
    private int high;
    private MyComponent[] array = new MyComponent[5];
    public void add(MyComponent myComponent){
        array[number] = myComponent;
        number = number +1;
    }


    public void paintComponent(Graphics g) {
        for(int i=0;i<array.length;i++){
            System.out.println(array[i].getClass().getName());
            if(array[i].getClass().getName()=="model.Round") {
                array[i].pt(g);
            }else if (array[i].getClass().getName()=="model.Letter"){
                array[i].pt(g);
            }else if (array[i].getClass().getName()=="model.Image"){
                array[i].pt(g);
            }else if (array[i].getClass().getName()=="model.Rectangle"){
                array[i].pt(g);
            }
        }


        System.out.println(number);
    }

    public void pt(Graphics g) {

    }


}
