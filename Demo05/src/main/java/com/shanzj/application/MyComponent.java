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

/**
 * A component with mouse operations for adding and removing squares.
 */
public class MyComponent extends JComponent
{
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;

    private static final int SIDELENGTH = 10;
    private ArrayList<Rectangle2D> squares;
    private Rectangle2D current; // the square containing the mouse cursor
    private Ellipse2D ellipse;
    private int start_x;
    private int start_y;


    private  MyComponent myComponent;

    public MyComponent(int a)
    {
        squares = new ArrayList<>();
        current = null;

        addMouseListener(new MouseHandler());
        addMouseMotionListener(new MouseMotionHandler());

        JButton ok = new JButton("OK");


    }




    public Dimension getPreferredSize() { return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT); }

    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;
        // draw all squares
        for (Rectangle2D r : squares)
            g2.draw(r);


    }

    /**
     * Finds the first square containing a point.
     * @param p a point
     * @return the first square that contains p
     */
    public Rectangle2D find(Point2D p)
    {
        for (Rectangle2D r : squares)
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

        current = new Rectangle2D.Double(x - SIDELENGTH / 2, y - SIDELENGTH / 2, SIDELENGTH, SIDELENGTH);
        squares.add(current);
        repaint();
    }

    /**
     * Removes a square from the collection.
     * @param s the square to remove
     */
    public void remove(Rectangle2D s)
    {
        if (s == null) return;
        if (s == current) current = null;
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
            current = find(event.getPoint());
            if (current == null) add(event.getPoint());
        }

        public void mouseClicked(MouseEvent event)
        {
            // remove the current square if double clicked
            current = find(event.getPoint());
            if (current != null && event.getClickCount() >= 2) remove(current);
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
            if (current != null)
            {
                int x = event.getX();
                int y = event.getY();

                // drag the current rectangle to center it at (x, y)
                //三目运算取绝对值
                current.setFrame(x-start_x>0?start_x:x, y-start_y>0?start_y:y, x-start_x>=0?x-start_x:start_x-x, y-start_y>=0?y-start_y:start_y-y);

                repaint();
            }
        }
    }
}
