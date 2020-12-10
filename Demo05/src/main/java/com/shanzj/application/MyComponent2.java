package com.shanzj.application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RectangularShape;
import java.util.ArrayList;

public class MyComponent2 extends AbstractButton
{
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;

    private static final int SIDELENGTH = 2;
    private ArrayList<RectangularShape> squares;
    private Rectangle2D current; // the square containing the mouse cursor
    private Ellipse2D ellipse ;
    private RectangularShape model;
    private int start_x;
    private int start_y;
    private int ff;



    public MyComponent2()
    {
        squares = new ArrayList<>();

        addMouseListener(new MouseHandler());
        addMouseMotionListener(new MouseMotionHandler());



        //JButton fang = new JButton("wda");
        //add(fang);


    }

    public void setFf(int ff) {
        this.ff = ff;
    }

    public Dimension getPreferredSize() { return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT); }

    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;

        // draw all squares
        for (RectangularShape r : squares)
            g2.draw(r);

        System.out.println(ff);
        System.out.println(squares.toString());

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
            if (r.contains(p)) {
                return r;
            }
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
        if (s == null) {
            return;
        }
        if(ff==1){
            if (s == ellipse) {
                ellipse = null;
            }
        }
        if (ff==0){
            if (s == current){
                current = null;
            }
        }
        squares.remove(s);
        repaint();
    }




    private class MouseHandler extends MouseAdapter
    {
        //鼠标按下
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

            System.out.println("鼠标按下");

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
            System.out.println("鼠标点击");
        }

        public void mouseReleased(MouseEvent event){
            System.out.println("鼠标松开mouseReleased");



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
            //System.out.println("鼠标Move");
        }

        public void mouseDragged(MouseEvent event)
        {

            start_x = event.getX();
            start_y = event.getY();


            if(ff==1){
                if (ellipse != null)
                {
                    int x = event.getX();
                    int y = event.getY();
                    ellipse.setFrame(x-start_x>0?start_x:x, y-start_y>0?start_y:y, x-start_x>=0?x-start_x:start_x-x, y-start_y>=0?y-start_y:start_y-y);
                }
            }
            if (ff==0){
                if (current != null)
                {
                    int x = event.getX();
                    int y = event.getY();
                    current.setFrame(x-start_x>0?start_x:x, y-start_y>0?start_y:y, x-start_x>=0?x-start_x:start_x-x, y-start_y>=0?y-start_y:start_y-y);
                }
            }
            repaint();
            System.out.println("鼠标Dragged");



        }
    }
}
