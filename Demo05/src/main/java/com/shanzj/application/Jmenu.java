package com.shanzj.application;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class Jmenu extends JFrame{
    private static final long serialVersionUID = 1L;

    private JMenuBar mBar;
    private JMenu fileMenu;
    private JMenu editMenu;
    private JMenuItem miOpen;
    private JMenuItem miExit;
    public Jmenu(){
        super("菜单演示");
        setBounds(200, 100, 300, 180);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container container = getContentPane();
        container.setLayout(new FlowLayout());

        //面板挂菜单栏
        mBar = new JMenuBar();
//		container.add(mBar);//awt的方式
        setJMenuBar(mBar);

        //菜单栏挂菜单
        fileMenu = new JMenu("文件");
        editMenu = new JMenu("编辑");
        mBar.add(fileMenu);
        mBar.add(editMenu);

        //菜单挂菜单项
        miOpen = new JMenuItem("打开");
        miExit = new JMenuItem("退出");

        fileMenu.add(miOpen);
        fileMenu.addSeparator();//分隔条
        fileMenu.add(miExit);

        //监听
        miOpen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser jFileChooser = new JFileChooser();
                jFileChooser.showDialog(Jmenu.this, "打开");
            }
        });
        miExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int judge = JOptionPane.showConfirmDialog(Jmenu.this, "确认退出？");
                if(judge == JOptionPane.OK_OPTION){
                    System.exit(0);
                }
            }
        });

        setVisible(true);
    }
    public static void main(String[] args) {
        new Jmenu();
    }
}