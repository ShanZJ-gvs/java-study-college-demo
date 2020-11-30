package com.shanzj.application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RectangularShape;
import java.util.ArrayList;

public class MyComponent2 extends JComponent
{
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;

    private static final int SIDELENGTH = 10;
    private ArrayList<RectangularShape> squares;
    private Rectangle2D current; // the square containing the mouse cursor
    private Ellipse2D ellipse;
    private RectangularShape model;
    private int start_x;
    private int start_y;
    private int ff;


    private  MyComponent myComponent;

    public MyComponent2(int a)
    {
        squares = new ArrayList<>();
        ellipse = null;

        addMouseListener(new MouseHandler());
        addMouseMotionListener(new MouseMotionHandler());
        ff = a;

    }



    public Dimension getPreferredSize() { return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT); }

    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;
        // draw all squares
        for (RectangularShape r : squares)
            g2.draw(r);


    }

    /**
     * Finds the first square containing a point.
     * @param p a point
     * @return the first square that contains p
     */
    public RectangularShape find(Point2D p)
    {
        for (RectangularShape r : squares)
        {
            if (r.contains(p)) return r;
        }
        return null;
    }

    /**
     * Adds a square to the collection.
     * @param p the center of the square
     */
    public void add(Point2D p)
    {
        double x = p.getX();
        double y = p.getY();

        if(ff==1){
            ellipse = new Ellipse2D.Double(x - SIDELENGTH / 2, y - SIDELENGTH / 2, SIDELENGTH, SIDELENGTH);
            squares.add(ellipse);
        }
        if (ff==0){
            current = new Rectangle2D.Double(x - SIDELENGTH / 2, y - SIDELENGTH / 2, SIDELENGTH, SIDELENGTH);
            squares.add(current);
        }

        repaint();
    }

    /**
     * Removes a square from the collection.
     * @param s the square to remove
     */
    public void remove(RectangularShape s)
    {
        if (s == null) return;
        if(ff==1){
            if (s == ellipse) ellipse = null;
        }
        if (ff==0){
            if (s == current) current = null;
        }
        squares.remove(s);
        repaint();
    }

    private class MouseHandler extends MouseAdapter
    {
        public void mousePressed(MouseEvent event)
        {
            // add a new square if the cursor isn't inside a square
            start_x = event.getX();
            start_y = event.getY();
            if(ff==1){
                ellipse = (Ellipse2D) find(event.getPoint());
                if (ellipse == null) add(event.getPoint());
            }
            if (ff==0){
                current = (Rectangle2D) find(event.getPoint());
                if (current == null) add(event.getPoint());
            }

        }

        public void mouseClicked(MouseEvent event)
        {
            // remove the ellipse square if double clicked
            if(ff==1){
                ellipse = (Ellipse2D) find(event.getPoint());
                if (ellipse != null && event.getClickCount() >= 2) remove(ellipse);
            }
            if (ff==0){
                current = (Rectangle2D) find(event.getPoint());
                if (current != null && event.getClickCount() >= 2) remove(current);
            }

        }
    }

    private class MouseMotionHandler implements MouseMotionListener
    {
        public void mouseMoved(MouseEvent event)
        {
            // set the mouse cursor to cross hairs if it is inside
            // a rectangle

            if (find(event.getPoint()) == null) setCursor(Cursor.getDefaultCursor());
            else setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
        }

        public void mouseDragged(MouseEvent event)
        {

            if(ff==1){
                if (ellipse != null)
                {
                    int x = event.getX();
                    int y = event.getY();

                    // drag the ellipse rectangle to center it at (x, y)
                    //三目运算取绝对值
                    ellipse.setFrame(x-start_x>0?start_x:x, y-start_y>0?start_y:y, x-start_x>=0?x-start_x:start_x-x, y-start_y>=0?y-start_y:start_y-y);

                    repaint();
                }
            }
            if (ff==0){
                if (current != null)
                {
                    int x = event.getX();
                    int y = event.getY();

                    // drag the ellipse rectangle to center it at (x, y)
                    //三目运算取绝对值
                    current.setFrame(x-start_x>0?start_x:x, y-start_y>0?start_y:y, x-start_x>=0?x-start_x:start_x-x, y-start_y>=0?y-start_y:start_y-y);

                    repaint();
                }
            }


        }
    }
}
