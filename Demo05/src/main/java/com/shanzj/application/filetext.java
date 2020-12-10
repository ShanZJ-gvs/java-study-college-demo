package com.shanzj.application;

import lombok.val;

import java.awt.geom.RectangularShape;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class filetext {

    public static void writeObjectToFile(Object obj)
    {
        File file =new File("test.dat");
        FileOutputStream out;
        try {
            out = new FileOutputStream(file);
            ObjectOutputStream objOut=new ObjectOutputStream(out);
            objOut.writeObject(obj);
            objOut.flush();
            objOut.close();
            System.out.println("write object success!");
        } catch (IOException e) {
            System.out.println("write object failed");
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        test test1 = new test(35);
        writeObjectToFile(test1);
        test o = (test) readObjectFromFile();
        System.out.println(o.a);
    }

    static class test implements Serializable {
        private ArrayList<RectangularShape> squares;
        private int a;
        public test(int a) {

            this.a = a;
        }

    }


    public static Object readObjectFromFile()
    {
        Object temp=null;
        File file =new File("test.dat");
        FileInputStream in;
        try {
            in = new FileInputStream(file);
            ObjectInputStream objIn=new ObjectInputStream(in);
            temp=objIn.readObject();
            objIn.close();
            System.out.println("read object success!");
        } catch (IOException e) {
            System.out.println("read object failed");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return temp;
    }
}
