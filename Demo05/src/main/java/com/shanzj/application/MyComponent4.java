package com.shanzj.application;


import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RectangularShape;
import java.io.Serializable;
import java.util.ArrayList;


public class MyComponent4 extends JComponent implements Serializable
{
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;

    private static final int SIDELENGTH = 10;
    private ArrayList<RectangularShape> squares;
    private Rectangle2D current;
    private Ellipse2D ellipse ;
    private int start_x;
    private int start_y;
    private String ff;
    private int havaShep = 0;

    public void setFf(String ff) {
        this.ff = ff;
    }

    public ArrayList<RectangularShape> getSquares() {
        return squares;
    }

    public void setSquares(ArrayList<RectangularShape> squares) {
        this.squares = squares;
    }

    public MyComponent4()
    {
        squares = new ArrayList<>();
        current = null;
        ellipse = null;

        addMouseListener(new MouseHandler());
        addMouseMotionListener(new MouseMotionHandler());


    }


    public Dimension getPreferredSize() { return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT); }

    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;

        for (RectangularShape r : squares)
            g2.draw(r);
        System.out.println(squares);

    }


    public RectangularShape find(Point2D p)
    {
        for (RectangularShape r : squares)
        {
            if (r.contains(p)) {
                havaShep = 1;
                System.out.println(havaShep);
                return r;
            }
        }
        havaShep = 0;
        System.out.println(havaShep);
        return null;
    }


    public void add(Point2D p)
    {
        double x = p.getX();
        double y = p.getY();

        if (ff == "fang"){
            current = new Rectangle2D.Double(x - SIDELENGTH / 2, y - SIDELENGTH / 2, SIDELENGTH, SIDELENGTH);
            squares.add(current);
        }
        if (ff == "yuan"){
            ellipse = new Ellipse2D.Double(x - SIDELENGTH / 2, y - SIDELENGTH / 2, SIDELENGTH, SIDELENGTH);
            squares.add(ellipse);
        }

        System.out.println("add");
        repaint();
    }


    public void remove(RectangularShape s)
    {
        if (s == null) return;
        if (ff == "fang"){
            if (s == current) current = null;
            squares.remove(s);
        }
        if (ff == "yuan"){
            if (s == ellipse) ellipse = null;
            squares.remove(s);
        }
        System.out.println("remove");
        repaint();
    }

    private class MouseHandler extends MouseAdapter
    {
        public void mousePressed(MouseEvent event)
        {
            find(event.getPoint());
            //鼠标没有找到了图形
            if(find(event.getPoint()) == null){
                if (ff == "fang"){
                    current = (Rectangle2D) find(event.getPoint());
                    start_x = event.getX();
                    start_y = event.getY();
                    if (current == null) add(event.getPoint());
                }
                if (ff == "yuan"){
                    ellipse = (Ellipse2D) find(event.getPoint());
                    start_x = event.getX();
                    start_y = event.getY();
                    if (ellipse == null) add(event.getPoint());
                }

                System.out.println("mousePressed");
            }else {//鼠标找到了图形
                if (ff == "fang"){
                    current= (Rectangle2D) find(event.getPoint());
                }
                if (ff == "yuan"){
                    ellipse = (Ellipse2D) find(event.getPoint());
                }
                System.out.println("mousePressed");
            }

        }

        public void mouseClicked(MouseEvent event)
        {

            if (ff == "fang"){
                current = (Rectangle2D) find(event.getPoint());
                if (current != null && event.getClickCount() >= 2) remove(current);
            }
            if (ff == "yuan"){
                ellipse = (Ellipse2D) find(event.getPoint());
                if (ellipse != null && event.getClickCount() >= 2) remove(ellipse);

            }
            System.out.println("mouseClicked");
        }


    }

    private class MouseMotionHandler implements MouseMotionListener
    {
        public void mouseMoved(MouseEvent event)
        {
            if (find(event.getPoint()) == null) setCursor(Cursor.getDefaultCursor());
            else setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
        }



        public void mouseDragged(MouseEvent event)
        {

            if (ff == "fang"){
                //鼠标找到了图形
                if(havaShep==1){
                    if (current != null)
                    {
                        int x = event.getX();
                        int y = event.getY();

                        current.setFrame(x-current.getX()/2, y-current.getY()/2,current.getWidth(),current.getHeight() );
                        System.out.println(1111111111);
                        repaint();
                    }
                    System.out.println("mouseDragged");
                }else {//鼠标没有找到图形
                    if (current != null)
                    {
                        int x = event.getX();
                        int y = event.getY();

                        // drag the current rectangle to center it at (x, y)
                        //三目运算取绝对值
                        current.setFrame(x-start_x>0?start_x:x, y-start_y>0?start_y:y, x-start_x>=0?x-start_x:start_x-x, y-start_y>=0?y-start_y:start_y-y);

                        repaint();
                    }
                    System.out.println("mouseDragged");
                }
            }
            if (ff == "yuan"){
                //鼠标找到了图形
                if(havaShep==1){
                    if (ellipse != null)
                    {
                        int x = event.getX();
                        int y = event.getY();

                        ellipse.setFrame(x-ellipse.getX()/2, y-ellipse.getY()/2,ellipse.getWidth(),ellipse.getHeight() );
                        System.out.println(1111111111);
                        repaint();
                    }
                    System.out.println("mouseDragged");
                }else {//鼠标没有找到图形
                    if (ellipse != null)
                    {
                        int x = event.getX();
                        int y = event.getY();

                        // drag the current rectangle to center it at (x, y)
                        //三目运算取绝对值
                        ellipse.setFrame(x-start_x>0?start_x:x, y-start_y>0?start_y:y, x-start_x>=0?x-start_x:start_x-x, y-start_y>=0?y-start_y:start_y-y);

                        repaint();
                    }
                    System.out.println("mouseDragged");
                }

            }


        }
    }
}



